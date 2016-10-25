package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

/**
 * Created by freeway on 16/7/19.
 */
public class ResultMessage implements Serializable {

    private String data;

    public ResultMessage(String data)  {
        this.data = data;
    }

    public static ResultMessage buildOk() {
        return new ResultMessage("ok");
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultMessage{" +
                "data='" + data + '\'' +
                '}';
    }
}
