package com.lmkt.zupeshawar.Utilities.Map.subscaleview.decoder;

import java.lang.reflect.InvocationTargetException;

public interface DecoderFactory<T> {
    T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
