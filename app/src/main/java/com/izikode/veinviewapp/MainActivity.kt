package com.izikode.veinviewapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.izikode.izilib.veinview.VeinView
import com.izikode.izilib.veinview.defaultClient

class MainActivity : AppCompatActivity() {

    private val veinView: VeinView by lazy { findViewById<VeinView>(R.id.veinview) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WebView.setWebContentsDebuggingEnabled(true)

        veinView.setVeinViewClient(defaultClient { injector, page ->
            injector.injectCSS(R.raw.dark_google_style)
        })

        veinView.setInitialScale(1)

        veinView.settings.apply {
            loadWithOverviewMode = true
            useWideViewPort = true
        }

        veinView.loadUrl("https://google.com//")
    }
}
