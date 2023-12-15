package br.com.sapereaude.maskedEditText;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;

public class MaskedEditText extends AppCompatEditText implements TextWatcher {
    public static final String SPACE = " ";
    private String allowedChars;
    private char charRepresentation;
    private String deniedChars;
    private boolean editingAfter;
    private boolean editingBefore;
    private boolean editingOnChanged;
    /* access modifiers changed from: private */
    public View.OnFocusChangeListener focusChangeListener;
    private boolean ignore;
    private boolean initialized;
    private boolean keepHint;
    private int lastValidMaskPosition;
    private String mask;
    private int[] maskToRaw;
    protected int maxRawLength;
    private RawText rawText;
    private int[] rawToMask;
    private int selection;
    /* access modifiers changed from: private */
    public boolean selectionChanged;

    public MaskedEditText(Context context) {
        super(context);
        init();
    }

    public MaskedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaskedEditText);
        this.mask = obtainStyledAttributes.getString(R.styleable.MaskedEditText_mask);
        this.allowedChars = obtainStyledAttributes.getString(R.styleable.MaskedEditText_allowed_chars);
        this.deniedChars = obtainStyledAttributes.getString(R.styleable.MaskedEditText_denied_chars);
        String string = obtainStyledAttributes.getString(R.styleable.MaskedEditText_char_representation);
        if (string == null) {
            this.charRepresentation = '#';
        } else {
            this.charRepresentation = string.charAt(0);
        }
        this.keepHint = obtainStyledAttributes.getBoolean(R.styleable.MaskedEditText_keep_hint, false);
        cleanUp();
        setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return true;
            }
        });
        obtainStyledAttributes.recycle();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", onSaveInstanceState);
        bundle.putString("text", getRawText());
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        String string = bundle.getString("text");
        Log.d("ContentValues", "onRestoreInstanceState: " + string);
        setText(string);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    public void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.focusChangeListener = onFocusChangeListener;
    }

    private void cleanUp() {
        this.initialized = false;
        generatePositionArrays();
        this.rawText = new RawText();
        this.selection = this.rawToMask[0];
        this.editingBefore = true;
        this.editingOnChanged = true;
        this.editingAfter = true;
        if (!hasHint() || this.rawText.length() != 0) {
            setText(makeMaskedText());
        } else {
            setText(makeMaskedTextWithHint());
        }
        this.editingBefore = false;
        this.editingOnChanged = false;
        this.editingAfter = false;
        this.maxRawLength = this.maskToRaw[previousValidPosition(this.mask.length() - 1)] + 1;
        this.lastValidMaskPosition = findLastValidMaskPosition();
        this.initialized = true;
        super.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (MaskedEditText.this.focusChangeListener != null) {
                    MaskedEditText.this.focusChangeListener.onFocusChange(view, z);
                }
                if (MaskedEditText.this.hasFocus()) {
                    boolean unused = MaskedEditText.this.selectionChanged = false;
                    MaskedEditText maskedEditText = MaskedEditText.this;
                    maskedEditText.setSelection(maskedEditText.lastValidPosition());
                }
            }
        });
    }

    private int findLastValidMaskPosition() {
        for (int length = this.maskToRaw.length - 1; length >= 0; length--) {
            if (this.maskToRaw[length] != -1) {
                return length;
            }
        }
        throw new RuntimeException("Mask must contain at least one representation char");
    }

    private boolean hasHint() {
        return getHint() != null;
    }

    public MaskedEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setMask(String str) {
        this.mask = str;
        cleanUp();
    }

    public String getMask() {
        return this.mask;
    }

    public String getRawText() {
        return this.rawText.getText();
    }

    public void setCharRepresentation(char c) {
        this.charRepresentation = c;
        cleanUp();
    }

    public char getCharRepresentation() {
        return this.charRepresentation;
    }

    private void generatePositionArrays() {
        int[] iArr = new int[this.mask.length()];
        this.maskToRaw = new int[this.mask.length()];
        String str = "";
        int i = 0;
        for (int i2 = 0; i2 < this.mask.length(); i2++) {
            char charAt = this.mask.charAt(i2);
            if (charAt == this.charRepresentation) {
                iArr[i] = i2;
                this.maskToRaw[i2] = i;
                i++;
            } else {
                String ch = Character.toString(charAt);
                if (!str.contains(ch)) {
                    str = str.concat(ch);
                }
                this.maskToRaw[i2] = -1;
            }
        }
        if (str.indexOf(32) < 0) {
            str = str + SPACE;
        }
        str.toCharArray();
        this.rawToMask = new int[i];
        for (int i3 = 0; i3 < i; i3++) {
            this.rawToMask[i3] = iArr[i3];
        }
    }

    private void init() {
        addTextChangedListener(this);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.editingBefore) {
            this.editingBefore = true;
            if (i > this.lastValidMaskPosition) {
                this.ignore = true;
            }
            Range calculateRange = calculateRange(i3 == 0 ? erasingStart(i) : i, i + i2);
            if (calculateRange.getStart() != -1) {
                this.rawText.subtractFromString(calculateRange);
            }
            if (i2 > 0) {
                this.selection = previousValidPosition(i);
            }
        }
    }

    private int erasingStart(int i) {
        while (i > 0 && this.maskToRaw[i] == -1) {
            i--;
        }
        return i;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        if (!this.editingOnChanged && this.editingBefore) {
            this.editingOnChanged = true;
            if (!this.ignore && i3 > 0) {
                int i5 = this.maskToRaw[nextValidPosition(i)];
                int addToString = this.rawText.addToString(clear(charSequence.subSequence(i, i3 + i).toString()), i5, this.maxRawLength);
                if (this.initialized) {
                    int i6 = i5 + addToString;
                    int[] iArr = this.rawToMask;
                    if (i6 < iArr.length) {
                        i4 = iArr[i6];
                    } else {
                        i4 = this.lastValidMaskPosition + 1;
                    }
                    this.selection = nextValidPosition(i4);
                }
            }
        }
    }

    public void afterTextChanged(Editable editable) {
        if (!this.editingAfter && this.editingBefore && this.editingOnChanged) {
            this.editingAfter = true;
            if (!hasHint() || (!this.keepHint && this.rawText.length() != 0)) {
                setText(makeMaskedText());
            } else {
                setText(makeMaskedTextWithHint());
            }
            this.selectionChanged = false;
            setSelection(this.selection);
            this.editingBefore = false;
            this.editingOnChanged = false;
            this.editingAfter = false;
            this.ignore = false;
        }
    }

    public boolean isKeepHint() {
        return this.keepHint;
    }

    public void setKeepHint(boolean z) {
        this.keepHint = z;
        setText(getRawText());
    }

    /* access modifiers changed from: protected */
    public void onSelectionChanged(int i, int i2) {
        if (this.initialized) {
            if (!this.selectionChanged) {
                i = fixSelection(i);
                i2 = fixSelection(i2);
                if (i > getText().length()) {
                    i = getText().length();
                }
                if (i < 0) {
                    i = 0;
                }
                if (i2 > getText().length()) {
                    i2 = getText().length();
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                setSelection(i, i2);
                this.selectionChanged = true;
            } else if (i > this.rawText.length() - 1) {
                int fixSelection = fixSelection(i);
                int fixSelection2 = fixSelection(i2);
                if (fixSelection >= 0 && fixSelection2 < getText().length()) {
                    setSelection(fixSelection, fixSelection2);
                }
            }
        }
        super.onSelectionChanged(i, i2);
    }

    private int fixSelection(int i) {
        if (i > lastValidPosition()) {
            return lastValidPosition();
        }
        return nextValidPosition(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0010  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0013 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int nextValidPosition(int r4) {
        /*
            r3 = this;
        L_0x0000:
            int r0 = r3.lastValidMaskPosition
            if (r4 >= r0) goto L_0x000e
            int[] r1 = r3.maskToRaw
            r1 = r1[r4]
            r2 = -1
            if (r1 != r2) goto L_0x000e
            int r4 = r4 + 1
            goto L_0x0000
        L_0x000e:
            if (r4 <= r0) goto L_0x0013
            int r0 = r0 + 1
            return r0
        L_0x0013:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: br.com.sapereaude.maskedEditText.MaskedEditText.nextValidPosition(int):int");
    }

    private int previousValidPosition(int i) {
        while (i >= 0 && this.maskToRaw[i] == -1) {
            i--;
            if (i < 0) {
                return nextValidPosition(0);
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    public int lastValidPosition() {
        if (this.rawText.length() == this.maxRawLength) {
            return this.rawToMask[this.rawText.length() - 1] + 1;
        }
        return nextValidPosition(this.rawToMask[this.rawText.length()]);
    }

    private String makeMaskedText() {
        int i;
        int length = this.rawText.length();
        int[] iArr = this.rawToMask;
        if (length < iArr.length) {
            i = iArr[this.rawText.length()];
        } else {
            i = this.mask.length();
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.maskToRaw[i2];
            if (i3 == -1) {
                cArr[i2] = this.mask.charAt(i2);
            } else {
                cArr[i2] = this.rawText.charAt(i3);
            }
        }
        return new String(cArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        if (r3 >= r5[r7.rawText.length()]) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.CharSequence makeMaskedTextWithHint() {
        /*
            r7 = this;
            android.text.SpannableStringBuilder r0 = new android.text.SpannableStringBuilder
            r0.<init>()
            int[] r1 = r7.rawToMask
            r2 = 0
            r1 = r1[r2]
            r3 = 0
        L_0x000b:
            java.lang.String r4 = r7.mask
            int r4 = r4.length()
            if (r3 >= r4) goto L_0x0075
            int[] r4 = r7.maskToRaw
            r4 = r4[r3]
            r5 = -1
            if (r4 == r5) goto L_0x003c
            br.com.sapereaude.maskedEditText.RawText r5 = r7.rawText
            int r5 = r5.length()
            if (r4 >= r5) goto L_0x002c
            br.com.sapereaude.maskedEditText.RawText r5 = r7.rawText
            char r4 = r5.charAt(r4)
            r0.append(r4)
            goto L_0x0045
        L_0x002c:
            java.lang.CharSequence r4 = r7.getHint()
            int[] r5 = r7.maskToRaw
            r5 = r5[r3]
            char r4 = r4.charAt(r5)
            r0.append(r4)
            goto L_0x0045
        L_0x003c:
            java.lang.String r4 = r7.mask
            char r4 = r4.charAt(r3)
            r0.append(r4)
        L_0x0045:
            boolean r4 = r7.keepHint
            if (r4 == 0) goto L_0x005e
            br.com.sapereaude.maskedEditText.RawText r4 = r7.rawText
            int r4 = r4.length()
            int[] r5 = r7.rawToMask
            int r6 = r5.length
            if (r4 >= r6) goto L_0x005e
            br.com.sapereaude.maskedEditText.RawText r4 = r7.rawText
            int r4 = r4.length()
            r4 = r5[r4]
            if (r3 >= r4) goto L_0x0064
        L_0x005e:
            boolean r4 = r7.keepHint
            if (r4 != 0) goto L_0x0072
            if (r3 < r1) goto L_0x0072
        L_0x0064:
            android.text.style.ForegroundColorSpan r4 = new android.text.style.ForegroundColorSpan
            int r5 = r7.getCurrentHintTextColor()
            r4.<init>(r5)
            int r5 = r3 + 1
            r0.setSpan(r4, r3, r5, r2)
        L_0x0072:
            int r3 = r3 + 1
            goto L_0x000b
        L_0x0075:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: br.com.sapereaude.maskedEditText.MaskedEditText.makeMaskedTextWithHint():java.lang.CharSequence");
    }

    private Range calculateRange(int i, int i2) {
        int previousValidPosition;
        Range range = new Range();
        int i3 = i;
        while (i3 <= i2 && i3 < this.mask.length()) {
            if (this.maskToRaw[i3] != -1) {
                if (range.getStart() == -1) {
                    range.setStart(this.maskToRaw[i3]);
                }
                range.setEnd(this.maskToRaw[i3]);
            }
            i3++;
        }
        if (i2 == this.mask.length()) {
            range.setEnd(this.rawText.length());
        }
        if (range.getStart() == range.getEnd() && i < i2 && (previousValidPosition = previousValidPosition(range.getStart() - 1)) < range.getStart()) {
            range.setStart(previousValidPosition);
        }
        return range;
    }

    private String clear(String str) {
        String str2 = this.deniedChars;
        if (str2 != null) {
            for (char ch : str2.toCharArray()) {
                str = str.replace(Character.toString(ch), "");
            }
        }
        if (this.allowedChars == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (this.allowedChars.contains(String.valueOf(c))) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
