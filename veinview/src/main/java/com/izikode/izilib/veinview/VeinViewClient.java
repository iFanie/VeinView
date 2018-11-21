package com.izikode.izilib.veinview;

import android.support.annotation.CallSuper;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public abstract class VeinViewClient extends WebViewClient implements VeinViewClientCallbacks {

    private VeinViewInjector injector;

    public void setInjector(VeinViewInjector injector) {
        this.injector = injector;
    }

    @CallSuper
    @Override
    public void onPageFinished(WebView view, String url) {
        if (injector != null) {
            onReadyToInject(injector, url);
        }
    }

}
