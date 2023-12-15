package com.github.pinball83.maskededittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.graphics.drawable.DrawableCompat;
import com.thrd.maskededittext.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskedEditText extends AppCompatEditText implements View.OnTouchListener, View.OnFocusChangeListener {
    private Context context;
    /* access modifiers changed from: private */
    public String deleteChar;
    private String filteredMask;
    /* access modifiers changed from: private */
    public Integer firstAllowedPosition;
    private String format;
    private IconCallback iconCallback;
    /* access modifiers changed from: private */
    public Integer lastAllowedPosition;
    /* access modifiers changed from: private */
    public ArrayList<Integer> listValidCursorPositions;
    /* access modifiers changed from: private */
    public String mask;
    private Drawable maskIcon;
    private MaskIconCallback maskIconCallback;
    private MaskedInputFilter maskedInputFilter;
    /* access modifiers changed from: private */
    public String notMaskedSymbol;
    private View.OnFocusChangeListener onFocusChangeListener;
    private String replacementChar;
    private boolean required;

    public interface IconCallback {
        void onIconPushed(String str);
    }

    @Deprecated
    public interface MaskIconCallback {
        void onIconPushed();
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
    }

    public MaskedEditText(Context context2) {
        super(context2);
        this.listValidCursorPositions = new ArrayList<>();
        this.firstAllowedPosition = 0;
        this.lastAllowedPosition = 0;
        init(context2, "", "", (AttributeSet) null, (String) null, (Drawable) null, (MaskIconCallback) null, (IconCallback) null);
    }

    private MaskedEditText(Context context2, String str, String str2, String str3, int i, IconCallback iconCallback2) {
        super(context2);
        this.listValidCursorPositions = new ArrayList<>();
        this.firstAllowedPosition = 0;
        this.lastAllowedPosition = 0;
        init(context2, str, str2, (AttributeSet) null, str3, i != -1 ? getResources().getDrawable(i) : null, (MaskIconCallback) null, iconCallback2);
    }

    public MaskedEditText(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.listValidCursorPositions = new ArrayList<>();
        this.firstAllowedPosition = 0;
        this.lastAllowedPosition = 0;
        init(context2, attributeSet);
    }

    public MaskedEditText(Context context2, AttributeSet attributeSet, int i) {
        super(context2, attributeSet, i);
        this.listValidCursorPositions = new ArrayList<>();
        this.firstAllowedPosition = 0;
        this.lastAllowedPosition = 0;
        init(context2, attributeSet);
    }

    private void init(Context context2, AttributeSet attributeSet) {
        init(context2, "", "", attributeSet, (String) null, (Drawable) null, (MaskIconCallback) null, (IconCallback) null);
    }

    private void init(Context context2, String str, String str2, AttributeSet attributeSet, String str3, Drawable drawable, MaskIconCallback maskIconCallback2, IconCallback iconCallback2) {
        this.context = context2;
        this.mask = str;
        this.notMaskedSymbol = str2;
        this.maskIcon = drawable;
        this.maskIconCallback = maskIconCallback2;
        this.iconCallback = iconCallback2;
        this.format = str3;
        initByAttributes(context2, attributeSet);
        initMaskIcon();
        setLongClickable(false);
        setSingleLine(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    private void initByAttributes(Context context2, AttributeSet attributeSet) {
        Drawable drawable;
        TypedArray obtainStyledAttributes = context2.getTheme().obtainStyledAttributes(attributeSet, R.styleable.MaskedEditText, 0, 0);
        if (TextUtils.isEmpty(this.mask) && TextUtils.isEmpty(this.notMaskedSymbol)) {
            this.notMaskedSymbol = obtainStyledAttributes.getString(R.styleable.MaskedEditText_notMaskedSymbol);
            this.mask = obtainStyledAttributes.getString(R.styleable.MaskedEditText_mask);
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaskedEditText_maskIcon, 0);
            if (resourceId > 0 && (drawable = AppCompatDrawableManager.get().getDrawable(context2, resourceId)) != null) {
                Drawable wrap = DrawableCompat.wrap(drawable);
                DrawableCompat.setTint(wrap, obtainStyledAttributes.getColor(R.styleable.MaskedEditText_maskIconColor, getCurrentHintTextColor()));
                this.maskIcon = wrap;
            }
        }
        if (!TextUtils.isEmpty(this.mask) && !TextUtils.isEmpty(this.notMaskedSymbol)) {
            String string = obtainStyledAttributes.getString(R.styleable.MaskedEditText_deleteChar);
            this.deleteChar = string;
            if (string == null) {
                this.deleteChar = br.com.sapereaude.maskedEditText.MaskedEditText.SPACE;
            }
            String string2 = obtainStyledAttributes.getString(R.styleable.MaskedEditText_replacementChar);
            this.replacementChar = string2;
            if (string2 == null) {
                this.replacementChar = br.com.sapereaude.maskedEditText.MaskedEditText.SPACE;
            }
            String string3 = obtainStyledAttributes.getString(R.styleable.MaskedEditText_format);
            if (string3 == null && this.format == null) {
                this.format = "";
            } else if (!TextUtils.isEmpty(string3) && this.format == null) {
                this.format = string3;
            }
            initListValidCursorPositions(this.mask, this.notMaskedSymbol);
            String replace = this.mask.replace(this.notMaskedSymbol, this.replacementChar);
            this.filteredMask = replace;
            setText(replace, TextView.BufferType.NORMAL);
            MaskedInputFilter maskedInputFilter2 = new MaskedInputFilter();
            this.maskedInputFilter = maskedInputFilter2;
            setFilters(new InputFilter[]{maskedInputFilter2});
        }
        setInputType(obtainStyledAttributes.getInteger(R.styleable.MaskedEditText_android_inputType, -1));
    }

    private void initMaskIcon() {
        Drawable drawable = this.maskIcon;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicHeight(), this.maskIcon.getIntrinsicHeight());
            Drawable[] compoundDrawables = getCompoundDrawables();
            setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], this.maskIcon, compoundDrawables[3]);
        }
        super.setOnFocusChangeListener(this);
        super.setOnTouchListener(this);
    }

    private void initListValidCursorPositions(String str, String str2) {
        char[] charArray = str.toCharArray();
        char charAt = str2.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (charArray[i] == charAt) {
                this.listValidCursorPositions.add(Integer.valueOf(i));
            }
        }
        this.firstAllowedPosition = this.listValidCursorPositions.get(0);
        ArrayList<Integer> arrayList = this.listValidCursorPositions;
        this.lastAllowedPosition = arrayList.get(arrayList.size() - 1);
    }

    public void setInputType(int i) {
        if (i == -1) {
            i = 524416;
        }
        if (i == 2 || i == 4096 || i == 8192 || i == 3) {
            String symbolExceptions = getSymbolExceptions();
            setKeyListener(DigitsKeyListener.getInstance("0123456789." + symbolExceptions));
            return;
        }
        super.setInputType(i);
    }

    private String getSymbolExceptions() {
        if (TextUtils.isEmpty(this.filteredMask)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : this.filteredMask.toCharArray()) {
            if (!Character.isDigit(c) && sb.indexOf(String.valueOf(c)) == -1) {
                sb.append(c);
            }
        }
        sb.append(this.replacementChar);
        return sb.toString();
    }

    public String getUnmaskedText() {
        Editable text = super.getText();
        String str = this.mask;
        if (str == null || str.isEmpty()) {
            return text.toString().trim();
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<Integer> it = this.listValidCursorPositions.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (text != null) {
                spannableStringBuilder.append(text.charAt(next.intValue()));
            }
        }
        String str2 = this.format;
        if (str2 == null || str2.isEmpty()) {
            return spannableStringBuilder.toString().trim();
        }
        return formatText(spannableStringBuilder.toString(), this.format);
    }

    public void setMaskedText(String str) {
        if (str != null) {
            StringBuilder sb = new StringBuilder(str);
            if (sb.length() < this.listValidCursorPositions.size()) {
                while (sb.length() < this.listValidCursorPositions.size()) {
                    sb.append(this.deleteChar);
                }
            } else if (sb.length() > this.listValidCursorPositions.size()) {
                sb.replace(this.listValidCursorPositions.size(), sb.length(), "");
            }
            StringBuilder sb2 = new StringBuilder(sb);
            if (getText() != null) {
                for (int i = 0; i < this.mask.length(); i++) {
                    if (!this.listValidCursorPositions.contains(Integer.valueOf(i))) {
                        sb2.insert(i, String.valueOf(this.mask.charAt(i)));
                    }
                }
                this.maskedInputFilter.setTextSetup(true);
                setText(sb2.toString());
                this.maskedInputFilter.setTextSetup(false);
            }
        }
    }

    private String formatText(String str, String str2) {
        Matcher matcher = Pattern.compile("(\\[[\\d]+])").matcher(str2);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, getSymbol(str, matcher.group()));
        }
        return stringBuffer.toString();
    }

    private String getSymbol(String str, String str2) {
        return String.valueOf(str.toCharArray()[Integer.valueOf(str2.replace("[", "").replace("]", "")).intValue() - 1]);
    }

    @Deprecated
    public void setFormat(String str) {
        this.format = str;
    }

    public boolean isRequired() {
        return this.required;
    }

    public void setRequired(boolean z) {
        this.required = z;
    }

    @Deprecated
    public void setMask(String str) {
        this.mask = str;
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener2) {
        this.onFocusChangeListener = onFocusChangeListener2;
    }

    public void onFocusChange(View view, boolean z) {
        View.OnFocusChangeListener onFocusChangeListener2 = this.onFocusChangeListener;
        if (onFocusChangeListener2 != null) {
            onFocusChangeListener2.onFocusChange(view, z);
        }
        if (z) {
            setSelection(this.firstAllowedPosition.intValue());
            requestFocus();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        Drawable drawable = this.maskIcon;
        if (drawable != null && drawable.isVisible() && x > (getWidth() - getPaddingRight()) - this.maskIcon.getIntrinsicWidth()) {
            if (motionEvent.getAction() == 1) {
                MaskIconCallback maskIconCallback2 = this.maskIconCallback;
                if (maskIconCallback2 != null) {
                    maskIconCallback2.onIconPushed();
                }
                IconCallback iconCallback2 = this.iconCallback;
                if (iconCallback2 != null) {
                    iconCallback2.onIconPushed(getUnmaskedText());
                }
            }
            return true;
        } else if ((motionEvent.getAction() != 1 && motionEvent.getAction() != 0) || !TextUtils.isEmpty(getUnmaskedText())) {
            return false;
        } else {
            setSelection(this.firstAllowedPosition.intValue());
            requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.context.getSystemService("input_method");
            if (inputMethodManager == null) {
                return false;
            }
            inputMethodManager.showSoftInput(this, 1);
            return true;
        }
    }

    @Deprecated
    public void setMaskIconCallback(MaskIconCallback maskIconCallback2) {
        this.maskIconCallback = maskIconCallback2;
    }

    public void setIconCallback(IconCallback iconCallback2) {
        this.iconCallback = iconCallback2;
    }

    private class MaskedInputFilter implements InputFilter {
        private boolean isUserInput;
        private boolean textSetup;

        private MaskedInputFilter() {
            this.isUserInput = true;
            this.textSetup = false;
        }

        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (this.textSetup || (charSequence instanceof SpannableStringBuilder)) {
                return charSequence;
            }
            StringBuilder sb = new StringBuilder();
            int i5 = i4 - i3;
            boolean[] zArr = new boolean[(i5 + 1)];
            for (int i6 = 0; i6 <= i5; i6++) {
                zArr[i6] = isCharAllowed(i3 + i6);
            }
            while (i < i2) {
                char charAt = charSequence.charAt(i);
                if (zArr[0]) {
                    this.isUserInput = false;
                    int i7 = i3 + 1;
                    MaskedEditText.this.getText().replace(i3, i7, "");
                    this.isUserInput = true;
                    sb.append(charAt);
                    if (isCharAllowed(i7)) {
                        i7 = i3;
                    }
                    skipSymbol(i7);
                } else if (i3 != MaskedEditText.this.mask.length()) {
                    int skipSymbol = skipSymbol(!isCharAllowed(i3) ? i3 + 1 : i3);
                    MaskedEditText.this.getText().replace(skipSymbol, skipSymbol, Character.toString(charAt));
                }
                i++;
            }
            if (this.isUserInput && TextUtils.isEmpty(charSequence) && i4 != 0) {
                for (int i8 = 0; i8 < i5; i8++) {
                    if (zArr[i8]) {
                        sb.append(MaskedEditText.this.deleteChar);
                    } else {
                        sb.append(MaskedEditText.this.mask.charAt(i3 + i8));
                    }
                }
                skipSymbolAfterDeletion(i3);
            }
            return sb.toString();
        }

        private int skipSymbol(int i) {
            int nextAvailablePosition = getNextAvailablePosition(i, false);
            if (nextAvailablePosition > MaskedEditText.this.lastAllowedPosition.intValue()) {
                nextAvailablePosition = MaskedEditText.this.lastAllowedPosition.intValue();
            }
            MaskedEditText.this.setSelection(nextAvailablePosition);
            return nextAvailablePosition;
        }

        private void skipSymbolAfterDeletion(int i) {
            MaskedEditText.this.setSelection(getNextAvailablePosition(i, true));
        }

        private int getNextAvailablePosition(int i, boolean z) {
            if (!MaskedEditText.this.listValidCursorPositions.contains(Integer.valueOf(i))) {
                return findCloserIndex(i, z);
            }
            ListIterator listIterator = MaskedEditText.this.listValidCursorPositions.listIterator(MaskedEditText.this.listValidCursorPositions.indexOf(Integer.valueOf(i)));
            if (!z) {
                return listIterator.hasNext() ? ((Integer) listIterator.next()).intValue() : i;
            }
            if (listIterator.hasPrevious()) {
                return ((Integer) listIterator.previous()).intValue() + 1;
            }
            return i;
        }

        private int findCloserIndex(int i, boolean z) {
            if (z) {
                ListIterator listIterator = MaskedEditText.this.listValidCursorPositions.listIterator(MaskedEditText.this.listValidCursorPositions.size() - 1);
                while (listIterator.hasPrevious()) {
                    Integer num = (Integer) listIterator.previous();
                    if (num.intValue() <= i) {
                        return num.intValue() + 1;
                    }
                }
                return MaskedEditText.this.firstAllowedPosition.intValue();
            } else if (i <= MaskedEditText.this.firstAllowedPosition.intValue()) {
                return MaskedEditText.this.firstAllowedPosition.intValue();
            } else {
                ListIterator listIterator2 = MaskedEditText.this.listValidCursorPositions.listIterator();
                while (listIterator2.hasNext()) {
                    Integer num2 = (Integer) listIterator2.next();
                    if (num2.intValue() >= i) {
                        return num2.intValue() - 1;
                    }
                }
                return MaskedEditText.this.lastAllowedPosition.intValue();
            }
        }

        private boolean isCharAllowed(int i) {
            return i < MaskedEditText.this.mask.length() && MaskedEditText.this.mask.charAt(i) == MaskedEditText.this.notMaskedSymbol.toCharArray()[0];
        }

        /* access modifiers changed from: private */
        public void setTextSetup(boolean z) {
            this.textSetup = z;
        }
    }

    public static class Builder {
        private Context context;
        private String format = null;
        private int icon = -1;
        private IconCallback iconCallback = null;
        private String mask = null;
        private String notMaskedSymbol = null;

        public Builder(Context context2) {
            this.context = context2;
        }

        public Builder mask(String str) {
            this.mask = str;
            return this;
        }

        public Builder notMaskedSymbol(String str) {
            this.notMaskedSymbol = str;
            return this;
        }

        public Builder icon(int i) {
            this.icon = i;
            return this;
        }

        public Builder iconCallback(IconCallback iconCallback2) {
            this.iconCallback = iconCallback2;
            return this;
        }

        public Builder format(String str) {
            this.format = str;
            return this;
        }

        public MaskedEditText build() {
            return new MaskedEditText(this.context, this.mask, this.notMaskedSymbol, this.format, this.icon, this.iconCallback);
        }
    }
}
