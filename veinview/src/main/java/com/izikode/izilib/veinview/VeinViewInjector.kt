package com.izikode.izilib.veinview

import android.support.annotation.RawRes

class VeinViewInjector(private val injections: VeinViewInjections) {

    /**
     * Injects a custom style from a string object.
     *
     * @param code  The custom style string.
     */
    fun injectCSS(code: String) {
        injections.css(code)
    }

    /**
     * Injects a custom style from a raw resource.
     *
     * @param codeResource  The custom style raw resource.
     */
    fun injectCSS(@RawRes codeResource: Int) {
        injections.css(codeResource)
    }

    /**
     * Injects a custom script from a string object.
     *
     * @param code  The custom script string.
     */
    fun injectJS(code: String) {
        injections.js(code)
    }

    /**
     * Injects a custom script from a raw resource.
     *
     * @param codeResource  The custom script raw resource.
     */
    fun injectJS(@RawRes codeResource: Int) {
        injections.js(codeResource)
    }

}
