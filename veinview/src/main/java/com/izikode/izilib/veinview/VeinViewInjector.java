package com.izikode.izilib.veinview;

import android.support.annotation.NonNull;
import android.support.annotation.RawRes;

public class VeinViewInjector {

    private final VeinViewInjections injections;

    public VeinViewInjector(@NonNull VeinViewInjections injections) {
        this.injections = injections;
    }

    public void injectCSS(@NonNull String code) {
        injections.css(code);
    }

    public void injectCSS(@RawRes int codeResource) {
        injections.css(codeResource);
    }

    public void injectJS(@NonNull String code) {
        injections.js(code);
    }

    public void injectJS(@RawRes int codeResource) {
        injections.js(codeResource);
    }

}
