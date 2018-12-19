package com.izikode.izilib.veinview

/**
 * Creates a simple VeinViewClient implementation.
 *
 * @param block  The Unit to be invoked upon reaching the injection-ready stage.
 */
fun defaultClient(block: VeinViewClient.(VeinViewInjector, String) -> Unit)
        = (object : VeinViewClient() {

            override fun onReadyToInject(injector: VeinViewInjector, page: String) {
                block(injector, page)
            }

        })