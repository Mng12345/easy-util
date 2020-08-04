package com.zhangm.easyutil;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhangming
 * @Date 2020/8/3 15:22
 */
public class ProxyUtil {

    static Map<String, Class<?>> proxyClassMap = new HashMap<>();

    public static  <T, TAspect> Class<? extends T> proxyClass(Class<T> clazz, Class<TAspect> aspectClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String composeName = Strings.f("{}-{}", clazz.getName(), aspectClass.getName());
        Class<? extends T> proxyClass = (Class<? extends T>) proxyClassMap.get(composeName);
        if (proxyClass != null) {
            return proxyClass;
        }
        proxyClass = new ByteBuddy()
                .subclass(clazz)
                .method(ElementMatchers.any())
                .intercept(Advice.to(aspectClass))
                .make()
                .load(clazz.getClassLoader())
                .getLoaded();
        proxyClassMap.put(composeName, proxyClass);
        return proxyClass;
    }
}
