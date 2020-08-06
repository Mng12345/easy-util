package com.test;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import java.lang.reflect.Method;

/**
 * @Author zhangming
 * @Date 2020/8/4 17:22
 */
public class ProxyUtilTest {

    @Getter
    @Setter
    static class Point {
        private int x;
        private int y;
    }

    static class SetAspect {

        @Advice.OnMethodEnter
        public void setX(@Advice.Origin Method method, @Advice.AllArguments Object[] arguments) {
            if (!method.getName().contains("setX")) {
                return;
            }
        }
    }
}
