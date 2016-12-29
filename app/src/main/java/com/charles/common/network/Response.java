package com.charles.common.network;

/**
 * com.charles.common.network.Response
 *
 * @author Just.T
 * @since 16/12/26
 */
public class Response<T> {
    public int code;
    public String msg;
    public String showMsg;
    public T data;

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", showMsg='" + showMsg + '\'' +
                ", data=" + data +
                '}';
    }
}

