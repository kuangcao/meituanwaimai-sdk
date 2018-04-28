package com.jiabangou.mtwmsdk.model;

/***
 *
 * @author xiongchuang
 * @date 2018-01-15
 */
public class OrderRealPhoneNumber {
    private Long order_id;
    private String wm_order_id_view;
    private Integer day_seq;
    private String real_phone_number;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getWm_order_id_view() {
        return wm_order_id_view;
    }

    public void setWm_order_id_view(String wm_order_id_view) {
        this.wm_order_id_view = wm_order_id_view;
    }

    public Integer getDay_seq() {
        return day_seq;
    }

    public void setDay_seq(Integer day_seq) {
        this.day_seq = day_seq;
    }

    public String getReal_phone_number() {
        return real_phone_number;
    }

    public void setReal_phone_number(String real_phone_number) {
        this.real_phone_number = real_phone_number;
    }
}
