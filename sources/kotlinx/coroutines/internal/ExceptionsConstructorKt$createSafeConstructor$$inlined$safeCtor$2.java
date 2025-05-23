package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstructorKt$safeCtor$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExceptionsConstructor.kt */
public final class ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$2 extends Lambda implements Function1<Throwable, Throwable> {
    final /* synthetic */ Constructor $constructor$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$2(Constructor constructor) {
        super(1);
        this.$constructor$inlined = constructor;
    }

    public final Throwable invoke(Throwable th) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Object newInstance = this.$constructor$inlined.newInstance(new Object[]{th});
            if (newInstance != null) {
                obj = Result.m58constructorimpl((Throwable) newInstance);
                if (Result.m64isFailureimpl(obj)) {
                    obj = null;
                }
                return (Throwable) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m58constructorimpl(ResultKt.createFailure(th2));
        }
    }
}
