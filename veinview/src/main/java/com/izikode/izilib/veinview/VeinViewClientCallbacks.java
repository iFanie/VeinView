package com.izikode.izilib.veinview;

import android.support.annotation.NonNull;

public interface VeinViewClientCallbacks {

    void onReadyToInject(@NonNull VeinViewInjector injector, @NonNull String page);

}
