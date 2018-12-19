package com.izikode.izilib.veinview

interface VeinViewClientCallbacks {

    /**
     * Invoked when the client has loaded the content and is ready to inject custom code.
     *
     * @param injector  The custom code injector.
     * @param page  The url of the loaded content.
     */
    fun onReadyToInject(injector: VeinViewInjector, page: String)

}
