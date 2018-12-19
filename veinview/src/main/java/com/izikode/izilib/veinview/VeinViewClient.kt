package com.izikode.izilib.veinview

import android.support.annotation.CallSuper
import android.webkit.WebView
import android.webkit.WebViewClient

abstract class VeinViewClient : WebViewClient(), VeinViewClientCallbacks {

    var injector: VeinViewInjector? = null

    @CallSuper
    override fun onPageFinished(view: WebView, url: String) {
        injector?.let {
            onReadyToInject(it, url)
        }
    }

}
