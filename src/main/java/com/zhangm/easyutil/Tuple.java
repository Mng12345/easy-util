package com.zhangm.easyutil;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author zhangming
 * @Date 2020/6/17 12:24
 */
@Getter
@Setter
@AllArgsConstructor
public class Tuple<T1, T2> {

    private T1 v1;
    private T2 v2;

}
