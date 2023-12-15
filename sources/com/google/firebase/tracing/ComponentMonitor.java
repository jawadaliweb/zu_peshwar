package com.google.firebase.tracing;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRegistrarProcessor;
import java.util.ArrayList;
import java.util.List;

public class ComponentMonitor implements ComponentRegistrarProcessor {
    public List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (Component next : componentRegistrar.getComponents()) {
            String name = next.getName();
            if (name != null) {
                next = next.withFactory(new ComponentFactory(name, next) {
                    public final /* synthetic */ String f$0;
                    public final /* synthetic */ Component f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final Object create(ComponentContainer componentContainer) {
                        return ComponentMonitor.lambda$processRegistrar$0(this.f$0, this.f$1, componentContainer);
                    }
                });
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    static /* synthetic */ Object lambda$processRegistrar$0(String str, Component component, ComponentContainer componentContainer) {
        try {
            FirebaseTrace.pushTrace(str);
            return component.getFactory().create(componentContainer);
        } finally {
            FirebaseTrace.popTrace();
        }
    }
}
