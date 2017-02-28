package com.yd.guava.bean;

import com.sun.istack.internal.Nullable;
import lombok.Data;

/**
 * Created by Administrator on 2016/12/30.
 */
@Data
public class Foo {

    @Nullable
    String sortedBy;

    int notSortedBy;


}
