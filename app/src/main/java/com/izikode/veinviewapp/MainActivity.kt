package com.izikode.veinviewapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.izikode.veinview.VeinView
import com.izikode.veinview.VeinViewClient
import com.izikode.veinview.VeinViewInjector

class MainActivity : AppCompatActivity() {

    lateinit var veinView: VeinView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WebView.setWebContentsDebuggingEnabled(true)

        veinView = findViewById(R.id.veinview)
        veinView.setVeinViewClient(object: VeinViewClient() {
            override fun onReadyToInject(injector: VeinViewInjector, page: String) {

                injector.injectCSS(R.raw.style)

            }
        })

        veinView.setInitialScale(1)

        val settings = veinView.getSettings()

        settings.setLoadWithOverviewMode(true)
        settings.setUseWideViewPort(true)

        veinView.loadUrl("https://www.google.com/")
    }
}
