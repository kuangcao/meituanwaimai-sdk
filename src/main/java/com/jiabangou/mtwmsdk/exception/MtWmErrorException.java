package com.jiabangou.mtwmsdk.exception;

/**
 * 美团外卖错误
 */
public class MtWmErrorException extends Exception {

    protected int code;

    public MtWmErrorException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "BdWmErrorException{" +
                "code=" + code +
                ", message=" + getMessage() +
                "} " + super.toString();
    }

}
