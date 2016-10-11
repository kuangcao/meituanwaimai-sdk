package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-9-29.
 */
public class OrderDetail implements Serializable {

    private Long order_id; //25217, 订单ID

    private String wm_order_id_view; //订单展示ID

    private String app_poi_code; //APP方商家ID

    private String wm_poi_name; //美团商家名称

    private String wm_poi_address; //美团商家地址

    private String wm_poi_phone; //美团商家电话

    private String recipient_address; //收件人地址

    private String recipient_phone; //收件人电话

    private String recipient_name; //收件人姓名

    private Double shipping_fee; //门店配送费

    private Double total; //总价

    private Double original_price; //原价

    private String caution; //忌口或备注

    private String shipper_phone; //送餐员电话

    private Integer status; //订单状态 订单当前状态code，详情请参考13.1节

    private Long city_id; //城市ID(目前暂时用不到此信息)

    private Integer has_invoiced; //是否开发票

    private String invoice_title; //发票抬头

    private Long ctime; //创建时间

    private Long utime; //更新时间

    private Long delivery_time; //用户预计送达时间，“立即送达”时为0

    private Integer is_third_shipping; //是否是第三方配送平台配送（0：否；1：是） private String pay_type; //支付类型（1：货到付款；2：在线支付）

    private Double latitude; //实际送餐地址纬度

    private Double longitude; //实际送餐地址经度

    private List<Detail> detail; //菜品详情

    private List<Extra> extras; //优惠信息

    private Long order_send_time; //143254562350, 用户下单时间

    private Long order_receive_time; //143254561110 , 商户收到时间

    private Long order_confirm_time; //143254561110 , 商户确认时间

    private Long order_cancel_time; //143254562340, 订单取消时间

    private Long order_completed_time; //143254562340, 订单完成时间

    private Integer logistics_status; //20, 配送订单状态code，若is_mt_logistics不为1则此字段为空，详情请参考13.5.1节

    private Long logistics_id; //7, 配送方ID，若is_mt_logistics不为1则此字段为空

    private String logistics_name; //private String 斑马快送private String , 配送方名称，若is_mt_logistics不为1则此字段为空

    private Long logistics_send_time; //143254562350, 配送单下单时间，若is_mt_logistics不为1则此字段为空

    private Long logistics_confirm_time; //143254561110 , 配送单确认时间，若is_mt_logistics不为1则此字段为空

    private Long logistics_cancel_time; //143254562340, 配送单取消时间，若is_mt_logistics不为1则此字段为空

    private Long logistics_fetch_time; //143254562340, 骑手取单时间，若is_mt_logistics不为1则此字段为空

    private Long logistics_completed_time; //143254562340, 配送单完成时间，若is_mt_logistics不为1则此字段为空

    private String logistics_dispatcher_name; //143254562340, 骑手姓名，若is_mt_logistics不为1则此字段为空

    private String logistics_dispatcher_mobile; //143254562340, 骑手电话，若is_mt_logistics不为1则此字段为空

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

    public Long getOrder_send_time() {
        return order_send_time;
    }

    public void setOrder_send_time(Long order_send_time) {
        this.order_send_time = order_send_time;
    }

    public Long getOrder_receive_time() {
        return order_receive_time;
    }

    public void setOrder_receive_time(Long order_receive_time) {
        this.order_receive_time = order_receive_time;
    }

    public Long getOrder_confirm_time() {
        return order_confirm_time;
    }

    public void setOrder_confirm_time(Long order_confirm_time) {
        this.order_confirm_time = order_confirm_time;
    }

    public Long getOrder_cancel_time() {
        return order_cancel_time;
    }

    public void setOrder_cancel_time(Long order_cancel_time) {
        this.order_cancel_time = order_cancel_time;
    }

    public Long getOrder_completed_time() {
        return order_completed_time;
    }

    public void setOrder_completed_time(Long order_completed_time) {
        this.order_completed_time = order_completed_time;
    }

    public Integer getLogistics_status() {
        return logistics_status;
    }

    public void setLogistics_status(Integer logistics_status) {
        this.logistics_status = logistics_status;
    }

    public Long getLogistics_id() {
        return logistics_id;
    }

    public void setLogistics_id(Long logistics_id) {
        this.logistics_id = logistics_id;
    }

    public String getLogistics_name() {
        return logistics_name;
    }

    public void setLogistics_name(String logistics_name) {
        this.logistics_name = logistics_name;
    }

    public Long getLogistics_send_time() {
        return logistics_send_time;
    }

    public void setLogistics_send_time(Long logistics_send_time) {
        this.logistics_send_time = logistics_send_time;
    }

    public Long getLogistics_confirm_time() {
        return logistics_confirm_time;
    }

    public void setLogistics_confirm_time(Long logistics_confirm_time) {
        this.logistics_confirm_time = logistics_confirm_time;
    }

    public Long getLogistics_cancel_time() {
        return logistics_cancel_time;
    }

    public void setLogistics_cancel_time(Long logistics_cancel_time) {
        this.logistics_cancel_time = logistics_cancel_time;
    }

    public Long getLogistics_fetch_time() {
        return logistics_fetch_time;
    }

    public void setLogistics_fetch_time(Long logistics_fetch_time) {
        this.logistics_fetch_time = logistics_fetch_time;
    }

    public Long getLogistics_completed_time() {
        return logistics_completed_time;
    }

    public void setLogistics_completed_time(Long logistics_completed_time) {
        this.logistics_completed_time = logistics_completed_time;
    }

    public String getLogistics_dispatcher_name() {
        return logistics_dispatcher_name;
    }

    public void setLogistics_dispatcher_name(String logistics_dispatcher_name) {
        this.logistics_dispatcher_name = logistics_dispatcher_name;
    }

    public String getLogistics_dispatcher_mobile() {
        return logistics_dispatcher_mobile;
    }

    public void setLogistics_dispatcher_mobile(String logistics_dispatcher_mobile) {
        this.logistics_dispatcher_mobile = logistics_dispatcher_mobile;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
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
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", detail=" + detail +
                ", extras=" + extras +
                ", order_send_time=" + order_send_time +
                ", order_receive_time=" + order_receive_time +
                ", order_confirm_time=" + order_confirm_time +
                ", order_cancel_time=" + order_cancel_time +
                ", order_completed_time=" + order_completed_time +
                ", logistics_status=" + logistics_status +
                ", logistics_id=" + logistics_id +
                ", logistics_name='" + logistics_name + '\'' +
                ", logistics_send_time=" + logistics_send_time +
                ", logistics_confirm_time=" + logistics_confirm_time +
                ", logistics_cancel_time=" + logistics_cancel_time +
                ", logistics_fetch_time=" + logistics_fetch_time +
                ", logistics_completed_time=" + logistics_completed_time +
                ", logistics_dispatcher_name='" + logistics_dispatcher_name + '\'' +
                ", logistics_dispatcher_mobile='" + logistics_dispatcher_mobile + '\'' +
                '}';
    }

    public class Detail implements Serializable {
        private String app_food_code; //菜品code
        private String food_name; //菜品名
        private Integer quantity; //菜品数量
        private Double price; //菜品价格
        private Integer box_num; //餐盒数量
        private Double box_price; //餐盒单价
        private String unit; //菜品单位
        private Float food_discount; //0.8 (菜品折扣，只是美团商家、APP方配送的门店才会设置，默认为1。折扣值不参与总价计算。开放平台1.0.3 新增)

        public String getApp_food_code() {
            return app_food_code;
        }

        public void setApp_food_code(String app_food_code) {
            this.app_food_code = app_food_code;
        }

        public String getFood_name() {
            return food_name;
        }

        public void setFood_name(String food_name) {
            this.food_name = food_name;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Integer getBox_num() {
            return box_num;
        }

        public void setBox_num(Integer box_num) {
            this.box_num = box_num;
        }

        public Double getBox_price() {
            return box_price;
        }

        public void setBox_price(Double box_price) {
            this.box_price = box_price;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public Float getFood_discount() {
            return food_discount;
        }

        public void setFood_discount(Float food_discount) {
            this.food_discount = food_discount;
        }

        @Override
        public String toString() {
            return "Detail{" +
                    "app_food_code='" + app_food_code + '\'' +
                    ", food_name='" + food_name + '\'' +
                    ", quantity=" + quantity +
                    ", price=" + price +
                    ", box_num=" + box_num +
                    ", box_price=" + box_price +
                    ", unit='" + unit + '\'' +
                    ", food_discount=" + food_discount +
                    '}';
        }
    }

    public class Extra implements Serializable {
        private Long act_detail_id; //10,(活动id)
        private Double reduce_fee; //2.5, (活动优惠金额，是美团承担活动费用和商户承担活动费用的总和)
        private String remark; //private String 满10元减2.5元private String ,（优惠说明）
        private Integer type; //1,活动类型）private String
        private Float avg_send_time; //5.5(餐厅平均送餐时间，单位为分钟)

        public Long getAct_detail_id() {
            return act_detail_id;
        }

        public void setAct_detail_id(Long act_detail_id) {
            this.act_detail_id = act_detail_id;
        }

        public Double getReduce_fee() {
            return reduce_fee;
        }

        public void setReduce_fee(Double reduce_fee) {
            this.reduce_fee = reduce_fee;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Float getAvg_send_time() {
            return avg_send_time;
        }

        public void setAvg_send_time(Float avg_send_time) {
            this.avg_send_time = avg_send_time;
        }

        @Override
        public String toString() {
            return "Extra{" +
                    "act_detail_id=" + act_detail_id +
                    ", reduce_fee=" + reduce_fee +
                    ", remark='" + remark + '\'' +
                    ", type=" + type +
                    ", avg_send_time=" + avg_send_time +
                    '}';
        }
    }

}
