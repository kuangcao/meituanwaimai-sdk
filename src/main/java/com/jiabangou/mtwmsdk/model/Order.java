package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-9-29.
 */
public class Order implements Serializable {

    private Long order_id; //订单ID
    private Long wm_order_id_view; //订单展示ID
    private String app_poi_code; //APP方商家ID
    private String wm_poi_name; //美团商家名称
    private String wm_poi_address; //美团商家地址
    private String wm_poi_phone; //美团商家电话
    private String recipient_address; //收件人地址(此字段为用户填写的收货地址，可在开发者中心订阅是否根据经纬度反查地址，若订阅则会在此字段后追加反查结果，并用“@#”符号分割，如：用户填写地址@#反查结果)
    private String recipient_phone; //收件人电话
    private String recipient_name; //收件人姓名（若用户没有填写姓名，此字段默认为空。可在开发者中心订阅是否用“美团客人”填充此字段）
    private Double shipping_fee; //门店配送费
    private Double total; //总价
    private Double original_price; //原价
    private String caution; //忌口或备注
    private String shipper_phone; //送餐员电话
    private Integer status; //订单状态
    private Long city_id; //城市ID（目前暂时用不到此信息）
    private Integer has_invoiced; //是否开发票
    private String invoice_title; //发票抬头
    private Long ctime; //创建时间
    private Long utime; //更新时间
    private Long delivery_time; //用户预计送达时间，“立即送达”时为0
    private Integer is_third_shipping; //是否是第三方配送平台配送（0：否；1：是）
    private Integer pay_type; //支付类型（1：货到付款；2：在线支付）
    private Double latitude; //实际送餐地址纬度
    private Double longitude; //实际送餐地址经度
    private Integer day_seq; //门店当天的推单流水号，该信息默认不推送，如有需求请联系美团
    private Boolean is_favorites; //用户是否收藏此门店（true, false），该信息默认不推送，如有需求可在开发者中心订阅
    private Boolean is_poi_first_order; //用户是否第一次在此门店点餐（true, false），该信息默认不推送，如有需求可在开发者中心订阅
    private Integer dinners_number; //用餐人数，该信息默认不推送，如有需求可在开发者中心订阅
    private String logistics_code; //订单配送方式，该信息默认不推送，如有需求可在开发者中心订阅
    private PoiReceiveDetail poi_receive_detail; //商家对账信息，该信息默认不推送，如有需求可在开发者中心订阅
    private List<Detail> detail; //订单菜品信息
    private List<Extra> extras; //优惠信息

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getWm_order_id_view() {
        return wm_order_id_view;
    }

    public void setWm_order_id_view(Long wm_order_id_view) {
        this.wm_order_id_view = wm_order_id_view;
    }

    public String getApp_poi_code() {
        return app_poi_code;
    }

    public void setApp_poi_code(String app_poi_code) {
        this.app_poi_code = app_poi_code;
    }

    public String getWm_poi_name() {
        return wm_poi_name;
    }

    public void setWm_poi_name(String wm_poi_name) {
        this.wm_poi_name = wm_poi_name;
    }

    public String getWm_poi_address() {
        return wm_poi_address;
    }

    public void setWm_poi_address(String wm_poi_address) {
        this.wm_poi_address = wm_poi_address;
    }

    public String getWm_poi_phone() {
        return wm_poi_phone;
    }

    public void setWm_poi_phone(String wm_poi_phone) {
        this.wm_poi_phone = wm_poi_phone;
    }

    public String getRecipient_address() {
        return recipient_address;
    }

    public void setRecipient_address(String recipient_address) {
        this.recipient_address = recipient_address;
    }

    public String getRecipient_phone() {
        return recipient_phone;
    }

    public void setRecipient_phone(String recipient_phone) {
        this.recipient_phone = recipient_phone;
    }

    public String getRecipient_name() {
        return recipient_name;
    }

    public void setRecipient_name(String recipient_name) {
        this.recipient_name = recipient_name;
    }

    public Double getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(Double shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(Double original_price) {
        this.original_price = original_price;
    }

    public String getCaution() {
        return caution;
    }

    public void setCaution(String caution) {
        this.caution = caution;
    }

    public String getShipper_phone() {
        return shipper_phone;
    }

    public void setShipper_phone(String shipper_phone) {
        this.shipper_phone = shipper_phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }

    public Integer getHas_invoiced() {
        return has_invoiced;
    }

    public void setHas_invoiced(Integer has_invoiced) {
        this.has_invoiced = has_invoiced;
    }

    public String getInvoice_title() {
        return invoice_title;
    }

    public void setInvoice_title(String invoice_title) {
        this.invoice_title = invoice_title;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getUtime() {
        return utime;
    }

    public void setUtime(Long utime) {
        this.utime = utime;
    }

    public Long getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(Long delivery_time) {
        this.delivery_time = delivery_time;
    }

    public Integer getIs_third_shipping() {
        return is_third_shipping;
    }

    public void setIs_third_shipping(Integer is_third_shipping) {
        this.is_third_shipping = is_third_shipping;
    }

    public Integer getPay_type() {
        return pay_type;
    }

    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getDay_seq() {
        return day_seq;
    }

    public void setDay_seq(Integer day_seq) {
        this.day_seq = day_seq;
    }

    public Boolean getIs_favorites() {
        return is_favorites;
    }

    public void setIs_favorites(Boolean is_favorites) {
        this.is_favorites = is_favorites;
    }

    public Boolean getIs_poi_first_order() {
        return is_poi_first_order;
    }

    public void setIs_poi_first_order(Boolean is_poi_first_order) {
        this.is_poi_first_order = is_poi_first_order;
    }

    public Integer getDinners_number() {
        return dinners_number;
    }

    public void setDinners_number(Integer dinners_number) {
        this.dinners_number = dinners_number;
    }

    public String getLogistics_code() {
        return logistics_code;
    }

    public void setLogistics_code(String logistics_code) {
        this.logistics_code = logistics_code;
    }

    public PoiReceiveDetail getPoi_receive_detail() {
        return poi_receive_detail;
    }

    public void setPoi_receive_detail(PoiReceiveDetail poi_receive_detail) {
        this.poi_receive_detail = poi_receive_detail;
    }

    public List<Detail> getDetail() {
        return detail;
    }

    public void setDetail(List<Detail> detail) {
        this.detail = detail;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", wm_order_id_view='" + wm_order_id_view + '\'' +
                ", app_poi_code='" + app_poi_code + '\'' +
                ", wm_poi_name='" + wm_poi_name + '\'' +
                ", wm_poi_address='" + wm_poi_address + '\'' +
                ", wm_poi_phone='" + wm_poi_phone + '\'' +
                ", recipient_address='" + recipient_address + '\'' +
                ", recipient_phone='" + recipient_phone + '\'' +
                ", recipient_name='" + recipient_name + '\'' +
                ", shipping_fee=" + shipping_fee +
                ", total=" + total +
                ", original_price=" + original_price +
                ", caution='" + caution + '\'' +
                ", shipper_phone='" + shipper_phone + '\'' +
                ", status=" + status +
                ", city_id='" + city_id + '\'' +
                ", has_invoiced=" + has_invoiced +
                ", invoice_title='" + invoice_title + '\'' +
                ", ctime=" + ctime +
                ", utime=" + utime +
                ", delivery_time='" + delivery_time + '\'' +
                ", is_third_shipping=" + is_third_shipping +
                ", pay_type=" + pay_type +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", day_seq='" + day_seq + '\'' +
                ", is_favorites=" + is_favorites +
                ", is_poi_first_order=" + is_poi_first_order +
                ", dinners_number=" + dinners_number +
                ", logistics_code='" + logistics_code + '\'' +
                ", poi_receive_detail=" + poi_receive_detail +
                ", detail=" + detail +
                ", extras=" + extras +
                '}';
    }

}
