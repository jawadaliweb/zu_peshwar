package com.google.firebase.components;

import java.util.List;

public interface ComponentRegistrarProcessor {
    public static final ComponentRegistrarProcessor NOOP = $$Lambda$i_xPJ76F5Q6JHbqhy05UyyZb8k4.INSTANCE;

    List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar);
}
