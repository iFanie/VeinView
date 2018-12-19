package com.izikode.izilib.veinview

import android.support.annotation.RawRes

interface VeinViewInjections {

    /**
     * Injects a custom style from a string object.
     *
     * @param code  The custom style string.
     */
    fun css(code: String)

    /**
     * Injects a custom style from a raw resource.
     *
     * @param codeResource  The custom style raw resource.
     */
    fun css(@RawRes codeResource: Int)

    /**
     * Injects a custom script from a string object.
     *
     * @param code  The custom script string.
     */
    fun js(code: String)

    /**
     * Injects a custom script from a raw resource.
     *
     * @param codeResource  The custom script raw resource.
     */
    fun js(@RawRes codeResource: Int)

}
