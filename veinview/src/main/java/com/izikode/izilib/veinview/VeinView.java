package com.izikode.izilib.veinview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.RawRes;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class VeinView extends WebView {

    public VeinView(Context context) {
        super(context);
        init();
    }

    public VeinView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VeinView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * @deprecated Use setVeinViewClient to get injection functionality
     */
    @Deprecated
    @Override
    public void setWebViewClient(WebViewClient client) {
        super.setWebViewClient(client);
    }

    public void setVeinViewClient(@NonNull VeinViewClient client) {
        client.setInjector(injector);
        super.setWebViewClient(client);
    }

    private String injectCSS, injectJS;
    private VeinViewInjector injector;

    @SuppressLint("SetJavaScriptEnabled")
    private void init() {
        injectCSS = resource(R.raw.inject_css);
        injectJS = resource(R.raw.inject_js);

        injector = new VeinViewInjector(new VeinViewInjections() {

            @Override
            public void css(@NonNull String code) {
                injectCSS(code);
            }

            @Override
            public void css(int codeResource) {
                injectCSS(codeResource);
            }

            @Override
            public void js(@NonNull String code) {
                injectJS(code);
            }

            @Override
            public void js(int codeResource) {
                injectJS(codeResource);
            }

        });

        getSettings().setJavaScriptEnabled(true);
    }

    private void injectCSS(@NonNull String css) {
        run(String.format(injectCSS, css.trim()));
    }

    private void injectCSS(@RawRes int cssResource) {
        injectCSS(resource(cssResource));
    }

    private void injectJS(@NonNull String js) {
        run(String.format(injectJS, js.trim()));
    }

    private void injectJS(@RawRes int jsResource) {
        injectJS(resource(jsResource));
    }

    private void run(@NonNull String javascript) {
        String code = String.format("javascript:(function() { %1$s })()", javascript);
        loadUrl(code);
    }

    private String resource(@RawRes int resource) {
        InputStream raw = getResources().openRawResource(resource);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            int chunk = raw.read();

            while (chunk != -1) {
                out.write(chunk);
                chunk = raw.read();
            }

            raw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toString();
    }

}
