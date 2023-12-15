package com.irozon.alertview.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.irozon.alertview.AlertActionStyle;
import com.irozon.alertview.AlertTheme;
import com.irozon.alertview.R;
import com.irozon.alertview.objects.AlertAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/irozon/alertview/fragments/DialogFragment;", "Landroidx/fragment/app/DialogFragment;", "title", "", "message", "actions", "Ljava/util/ArrayList;", "Lcom/irozon/alertview/objects/AlertAction;", "theme", "Lcom/irozon/alertview/AlertTheme;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Lcom/irozon/alertview/AlertTheme;)V", "inflateActionsView", "", "actionsLayout", "Landroid/widget/LinearLayout;", "initView", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "alertview_release"}, k = 1, mv = {1, 1, 9})
/* compiled from: DialogFragment.kt */
public final class DialogFragment extends androidx.fragment.app.DialogFragment {
    private HashMap _$_findViewCache;
    private final ArrayList<AlertAction> actions;
    private final String message;
    private final AlertTheme theme;
    private final String title;

    @Metadata(bv = {1, 0, 2}, k = 3, mv = {1, 1, 9})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AlertActionStyle.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AlertActionStyle.POSITIVE.ordinal()] = 1;
            iArr[AlertActionStyle.NEGATIVE.ordinal()] = 2;
            iArr[AlertActionStyle.DEFAULT.ordinal()] = 3;
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public DialogFragment(String str, String str2, ArrayList<AlertAction> arrayList, AlertTheme alertTheme) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(str2, "message");
        Intrinsics.checkParameterIsNotNull(arrayList, "actions");
        Intrinsics.checkParameterIsNotNull(alertTheme, "theme");
        this.title = str;
        this.message = str2;
        this.actions = arrayList;
        this.theme = alertTheme;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomBottomSheetDialogTheme);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        View view = null;
        if (Intrinsics.areEqual((Object) this.theme, (Object) AlertTheme.LIGHT)) {
            view = layoutInflater.inflate(R.layout.alert_layout_light, viewGroup, false);
        } else if (Intrinsics.areEqual((Object) this.theme, (Object) AlertTheme.DARK)) {
            view = layoutInflater.inflate(R.layout.alert_layout_dark, viewGroup, false);
        }
        initView(view);
        return view;
    }

    private final void initView(View view) {
        if (view == null) {
            Intrinsics.throwNpe();
        }
        TextView textView = (TextView) view.findViewById(R.id.tvTitle);
        Intrinsics.checkExpressionValueIsNotNull(textView, "view!!.tvTitle");
        textView.setText(this.title);
        TextView textView2 = (TextView) view.findViewById(R.id.tvMessage);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "view.tvMessage");
        textView2.setText(this.message);
        boolean z = true;
        if (this.title.length() == 0) {
            TextView textView3 = (TextView) view.findViewById(R.id.tvTitle);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "view.tvTitle");
            textView3.setVisibility(8);
        }
        if (this.message.length() != 0) {
            z = false;
        }
        if (z) {
            TextView textView4 = (TextView) view.findViewById(R.id.tvMessage);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "view.tvMessage");
            textView4.setVisibility(8);
        }
        TextView textView5 = (TextView) view.findViewById(R.id.tvCancel);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "view.tvCancel");
        textView5.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.actionsLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "view.actionsLayout");
        inflateActionsView(linearLayout, this.actions);
    }

    private final void inflateActionsView(LinearLayout linearLayout, ArrayList<AlertAction> arrayList) {
        Iterator<AlertAction> it = arrayList.iterator();
        while (it.hasNext()) {
            AlertAction next = it.next();
            View view = null;
            if (Intrinsics.areEqual((Object) this.theme, (Object) AlertTheme.LIGHT)) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.action_layout_light, (ViewGroup) null);
            } else if (Intrinsics.areEqual((Object) this.theme, (Object) AlertTheme.DARK)) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.action_layout_dark, (ViewGroup) null);
            }
            if (view == null) {
                Intrinsics.throwNpe();
            }
            TextView textView = (TextView) view.findViewById(R.id.tvAction);
            Intrinsics.checkExpressionValueIsNotNull(textView, "view!!.tvAction");
            textView.setText(next.getTitle());
            ((TextView) view.findViewById(R.id.tvAction)).setOnClickListener(new DialogFragment$inflateActionsView$1(this, next));
            if (getContext() != null) {
                int i = WhenMappings.$EnumSwitchMapping$0[next.getStyle().ordinal()];
                if (i == 1) {
                    TextView textView2 = (TextView) view.findViewById(R.id.tvAction);
                    Context context = getContext();
                    if (context == null) {
                        Intrinsics.throwNpe();
                    }
                    textView2.setTextColor(ContextCompat.getColor(context, R.color.green));
                } else if (i == 2) {
                    TextView textView3 = (TextView) view.findViewById(R.id.tvAction);
                    Context context2 = getContext();
                    if (context2 == null) {
                        Intrinsics.throwNpe();
                    }
                    textView3.setTextColor(ContextCompat.getColor(context2, R.color.red));
                } else if (i == 3) {
                    if (Intrinsics.areEqual((Object) this.theme, (Object) AlertTheme.LIGHT)) {
                        TextView textView4 = (TextView) view.findViewById(R.id.tvAction);
                        Context context3 = getContext();
                        if (context3 == null) {
                            Intrinsics.throwNpe();
                        }
                        textView4.setTextColor(ContextCompat.getColor(context3, R.color.darkGray));
                    } else if (Intrinsics.areEqual((Object) this.theme, (Object) AlertTheme.DARK)) {
                        TextView textView5 = (TextView) view.findViewById(R.id.tvAction);
                        Context context4 = getContext();
                        if (context4 == null) {
                            Intrinsics.throwNpe();
                        }
                        textView5.setTextColor(ContextCompat.getColor(context4, R.color.lightWhite));
                    }
                }
            }
            linearLayout.addView(view);
        }
    }
}
