package com.izikode.izilib.veinview

import android.annotation.SuppressLint
import android.content.Context
import android.support.annotation.RawRes
import android.util.AttributeSet
import android.webkit.WebView
import android.webkit.WebViewClient
import java.io.ByteArrayOutputStream
import java.io.IOException

@SuppressLint("SetJavaScriptEnabled")
class VeinView : WebView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val injectCSS: String by lazy { resource(R.raw.inject_css) }
    private val injectJS: String by lazy { resource(R.raw.inject_js) }

    private val injector: VeinViewInjector by lazy {

        VeinViewInjector(object : VeinViewInjections {

            override fun css(code: String) {
                injectCSS(code)
            }

            override fun css(codeResource: Int) {
                injectCSS(codeResource)
            }

            override fun js(code: String) {
                injectJS(code)
            }

            override fun js(codeResource: Int) {
                injectJS(codeResource)
            }

        })
    }

    init {
        settings.javaScriptEnabled = true
    }

    @Deprecated("Use setVeinViewClient to get injection functionality",
            ReplaceWith("setVeinViewClient(client)", "android.webkit.WebView"))
    override fun setWebViewClient(client: WebViewClient) {
        super.setWebViewClient(client)
    }

    fun setVeinViewClient(client: VeinViewClient) {
        client.injector = injector
        super.setWebViewClient(client)
    }

    private fun injectCSS(css: String) {
        run(String.format(injectCSS, css.trim { it <= ' ' }))
    }

    private fun injectCSS(@RawRes cssResource: Int) {
        injectCSS(resource(cssResource))
    }

    private fun injectJS(js: String) {
        run(String.format(injectJS, js.trim { it <= ' ' }))
    }

    private fun injectJS(@RawRes jsResource: Int) {
        injectJS(resource(jsResource))
    }

    private fun run(javascript: String) {
        val code = "javascript:(function() { $javascript })()"
        loadUrl(code)
    }

    private fun resource(@RawRes resource: Int): String {
        val raw = resources.openRawResource(resource)
        val out = ByteArrayOutputStream()

        try {

            var chunk = raw.read()

            while (chunk != -1) {
                out.write(chunk)
                chunk = raw.read()
            }

            raw.close()

        } catch (e: IOException) {
            e.printStackTrace()
        }

        return out.toString()
    }

}
