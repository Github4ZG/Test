package com.tencent.test;

import android.databinding.ObservableField;

/**
 * Created by Greyzhou on 2018/4/27.
 */

public class SquareRect extends BaseRect{
    public final ObservableField<String> title = new ObservableField<>();
    public void onClick(SquareRect rect){
        title.set("厉害厉害");
    }

}
