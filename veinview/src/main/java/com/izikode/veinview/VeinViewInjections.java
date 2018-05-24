package com.izikode.veinview;

import android.support.annotation.NonNull;
import android.support.annotation.RawRes;

public interface VeinViewInjections {

    void css(@NonNull String code);
    void css(@RawRes int codeResource);
    void js(@NonNull String code);
    void js(@RawRes int codeResource);

}
