package com.jiabangou.mtwmsdk.api.impl;

import com.jiabangou.mtwmsdk.api.MtWmConfigStorage;

public class MtWmInMemoryConfigStorage implements MtWmConfigStorage {

    protected volatile String appId;
    protected volatile String secret;

    protected volatile String http_proxy_host;
    protected volatile int http_proxy_port;
    protected volatile String http_proxy_username;
    protected volatile String http_proxy_password;


    @Override
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String getHttp_proxy_host() {
        return http_proxy_host;
    }

    public void setHttp_proxy_host(String http_proxy_host) {
        this.http_proxy_host = http_proxy_host;
    }

    @Override
    public int getHttp_proxy_port() {
        return http_proxy_port;
    }

    public void setHttp_proxy_port(int http_proxy_port) {
        this.http_proxy_port = http_proxy_port;
    }

    @Override
    public String getHttp_proxy_username() {
        return http_proxy_username;
    }

    public void setHttp_proxy_username(String http_proxy_username) {
        this.http_proxy_username = http_proxy_username;
    }

    @Override
    public String getHttp_proxy_password() {
        return http_proxy_password;
    }

    public void setHttp_proxy_password(String http_proxy_password) {
        this.http_proxy_password = http_proxy_password;
    }
}
