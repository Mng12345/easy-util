package com.zhangm.easyutil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author zhangming
 * @Date 2020/6/17 12:25
 */
@Getter
@Setter
@AllArgsConstructor
public class Tripple<T1, T2, T3> {

    private T1 v1;
    private T2 v2;
    private T3 v3;

}
