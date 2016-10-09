package com.jiabangou.mtwmsdk.api;

/**
 * Created by freeway on 16/7/23.
 */
public interface LogListener {

    void requestEvent(String cmd, String method, boolean isSuccess, String request, String response);

}
