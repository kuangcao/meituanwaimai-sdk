package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-9-29.
 */
public class Order implements Serializable {

    private String order_id; //订单ID
    private String wm_order_id_view; //订单展示ID
    private String app_poi_code; //APP方商家ID
    private String wm_poi_name; //美团商家名称
    private String wm_poi_address; //美团商家地址
    private String wm_poi_phone; //美团商家电话
    private String recipient_address; //收件人地址(此字段为用户填写的收货地址，可在开发者中心订阅是否根据经纬度反查地址，若订阅则会在此字段后追加反查结果，并用“@#”符号分割，如：用户填写地址@#反查结果)
    private String recipient_phone; //收件人电话
    private String recipient_name; //收件人姓名（若用户没有填写姓名，此字段默认为空。可在开发者中心订阅是否用“美团客人”填充此字段）
    private String shipping_fee; //门店配送费
    private String total; //总价
    private String original_price; //原价
    private String caution; //忌口或备注
    private String shipper_phone; //送餐员电话
    private String status; //订单状态
    private String city_id; //城市ID（目前暂时用不到此信息）
    private String has_invoiced; //是否开发票
    private String invoice_title; //发票抬头
    private String ctime; //创建时间
    private String utime; //更新时间
    private String delivery_time; //用户预计送达时间，“立即送达”时为0
    private String is_third_shipping; //是否是第三方配送平台配送（0：否；1：是）
    private String pay_type; //支付类型（1：货到付款；2：在线支付）
    private String latitude; //实际送餐地址纬度
    private String longitude; //实际送餐地址经度
    private String day_seq; //门店当天的推单流水号，该信息默认不推送，如有需求请联系美团
    private String is_favorites; //用户是否收藏此门店（true, false），该信息默认不推送，如有需求可在开发者中心订阅
    private String is_poi_first_order; //用户是否第一次在此门店点餐（true, false），该信息默认不推送，如有需求可在开发者中心订阅
    private String dinners_number; //用餐人数，该信息默认不推送，如有需求可在开发者中心订阅
    private String logistics_code; //订单配送方式，该信息默认不推送，如有需求可在开发者中心订阅
    private PoiReceiveDetail poi_receive_detail; //商家对账信息，该信息默认不推送，如有需求可在开发者中心订阅
    private List<Detail> detail; //订单菜品信息
    private List<Extra> extras; //优惠信息

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
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

    public String getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(String shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(String original_price) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getHas_invoiced() {
        return has_invoiced;
    }

    public void setHas_invoiced(String has_invoiced) {
        this.has_invoiced = has_invoiced;
    }

    public String getInvoice_title() {
        return invoice_title;
    }

    public void setInvoice_title(String invoice_title) {
        this.invoice_title = invoice_title;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getUtime() {
        return utime;
    }

    public void setUtime(String utime) {
        this.utime = utime;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(String delivery_time) {
        this.delivery_time = delivery_time;
    }

    public String getIs_third_shipping() {
        return is_third_shipping;
    }

    public void setIs_third_shipping(String is_third_shipping) {
        this.is_third_shipping = is_third_shipping;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDay_seq() {
        return day_seq;
    }

    public void setDay_seq(String day_seq) {
        this.day_seq = day_seq;
    }

    public String getIs_favorites() {
        return is_favorites;
    }

    public void setIs_favorites(String is_favorites) {
        this.is_favorites = is_favorites;
    }

    public String getIs_poi_first_order() {
        return is_poi_first_order;
    }

    public void setIs_poi_first_order(String is_poi_first_order) {
        this.is_poi_first_order = is_poi_first_order;
    }

    public String getDinners_number() {
        return dinners_number;
    }

    public void setDinners_number(String dinners_number) {
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
                "order_id='" + order_id + '\'' +
                ", wm_order_id_view='" + wm_order_id_view + '\'' +
                ", app_poi_code='" + app_poi_code + '\'' +
                ", wm_poi_name='" + wm_poi_name + '\'' +
                ", wm_poi_address='" + wm_poi_address + '\'' +
                ", wm_poi_phone='" + wm_poi_phone + '\'' +
                ", recipient_address='" + recipient_address + '\'' +
                ", recipient_phone='" + recipient_phone + '\'' +
                ", recipient_name='" + recipient_name + '\'' +
                ", shipping_fee='" + shipping_fee + '\'' +
                ", total='" + total + '\'' +
                ", original_price='" + original_price + '\'' +
                ", caution='" + caution + '\'' +
                ", shipper_phone='" + shipper_phone + '\'' +
                ", status='" + status + '\'' +
                ", city_id='" + city_id + '\'' +
                ", has_invoiced='" + has_invoiced + '\'' +
                ", invoice_title='" + invoice_title + '\'' +
                ", ctime='" + ctime + '\'' +
                ", utime='" + utime + '\'' +
                ", delivery_time='" + delivery_time + '\'' +
                ", is_third_shipping='" + is_third_shipping + '\'' +
                ", pay_type='" + pay_type + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", day_seq='" + day_seq + '\'' +
                ", is_favorites='" + is_favorites + '\'' +
                ", is_poi_first_order='" + is_poi_first_order + '\'' +
                ", dinners_number='" + dinners_number + '\'' +
                ", logistics_code='" + logistics_code + '\'' +
                ", poi_receive_detail=" + poi_receive_detail +
                ", detail=" + detail +
                ", extras=" + extras +
                '}';
    }

    public class PoiReceiveDetail implements Serializable {

        private List<ActOrderCharge> actOrderChargeByMt; //美团承担明细
        private List<ActOrderCharge> actOrderChargeByPoi; //商家承担明细
        private Integer foodShareFeeChargeByPoi; //390 (菜品分成 (分)),
        private Integer logisticsFee; //300 (配送费 (分)),
        private Integer onlinePayment; //2000 (在线支付款 (分)),
        private Integer wmPoiReceiveCent; //1610 (商家应收款（分）)

        public List<ActOrderCharge> getActOrderChargeByMt() {
            return actOrderChargeByMt;
        }

        public void setActOrderChargeByMt(List<ActOrderCharge> actOrderChargeByMt) {
            this.actOrderChargeByMt = actOrderChargeByMt;
        }

        public List<ActOrderCharge> getActOrderChargeByPoi() {
            return actOrderChargeByPoi;
        }

        public void setActOrderChargeByPoi(List<ActOrderCharge> actOrderChargeByPoi) {
            this.actOrderChargeByPoi = actOrderChargeByPoi;
        }

        public Integer getFoodShareFeeChargeByPoi() {
            return foodShareFeeChargeByPoi;
        }

        public void setFoodShareFeeChargeByPoi(Integer foodShareFeeChargeByPoi) {
            this.foodShareFeeChargeByPoi = foodShareFeeChargeByPoi;
        }

        public Integer getLogisticsFee() {
            return logisticsFee;
        }

        public void setLogisticsFee(Integer logisticsFee) {
            this.logisticsFee = logisticsFee;
        }

        public Integer getOnlinePayment() {
            return onlinePayment;
        }

        public void setOnlinePayment(Integer onlinePayment) {
            this.onlinePayment = onlinePayment;
        }

        public Integer getWmPoiReceiveCent() {
            return wmPoiReceiveCent;
        }

        public void setWmPoiReceiveCent(Integer wmPoiReceiveCent) {
            this.wmPoiReceiveCent = wmPoiReceiveCent;
        }

        @Override
        public String toString() {
            return "PoiReceiveDetail{" +
                    "actOrderChargeByMt=" + actOrderChargeByMt +
                    ", actOrderChargeByPoi=" + actOrderChargeByPoi +
                    ", foodShareFeeChargeByPoi=" + foodShareFeeChargeByPoi +
                    ", logisticsFee=" + logisticsFee +
                    ", onlinePayment=" + onlinePayment +
                    ", wmPoiReceiveCent=" + wmPoiReceiveCent +
                    '}';
        }

        public class ActOrderCharge implements Serializable {
            private String comment; //private String 美团配送减3.0元private String  (备注),
            private String feeTypeDesc; //private String 活动款private String  (明细费用类型描述),
            private String feeTypeId; //10019 (明细费用类型Id),
            private String moneyCent; //300 (明细金额（分）)

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getFeeTypeDesc() {
                return feeTypeDesc;
            }

            public void setFeeTypeDesc(String feeTypeDesc) {
                this.feeTypeDesc = feeTypeDesc;
            }

            public String getFeeTypeId() {
                return feeTypeId;
            }

            public void setFeeTypeId(String feeTypeId) {
                this.feeTypeId = feeTypeId;
            }

            public String getMoneyCent() {
                return moneyCent;
            }

            public void setMoneyCent(String moneyCent) {
                this.moneyCent = moneyCent;
            }

            @Override
            public String toString() {
                return "OrderChargeByMt{" +
                        "comment='" + comment + '\'' +
                        ", feeTypeDesc='" + feeTypeDesc + '\'' +
                        ", feeTypeId='" + feeTypeId + '\'' +
                        ", moneyCent='" + moneyCent + '\'' +
                        '}';
            }
        }

    }

    public class Detail implements Serializable {
        private String app_food_code; //菜品code
        private String food_name; //菜品名
        private String sku_id;
        private String quantity; //菜品数量
        private String price; //菜品价格 （此字段默认为活动折扣后价格，可在开发者中心订阅是否替换为原价）
        private String box_num; //餐盒数量
        private String box_price; //餐盒单价
        private String unit; //菜品单位
        private String food_discount; //0.8 (菜品折扣，只是美团商家、APP方配送的门店才会设置，默认为1。折扣值不参与总价计算。开放平台1.0.3 新增)
        private String food_property; //"中辣,微甜" (菜品属性，多个属性用英文逗号隔开，该信息默认不推送，如有需求可在开发者中心订阅)

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

        public String getSku_id() {
            return sku_id;
        }

        public void setSku_id(String sku_id) {
            this.sku_id = sku_id;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getBox_num() {
            return box_num;
        }

        public void setBox_num(String box_num) {
            this.box_num = box_num;
        }

        public String getBox_price() {
            return box_price;
        }

        public void setBox_price(String box_price) {
            this.box_price = box_price;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getFood_discount() {
            return food_discount;
        }

        public void setFood_discount(String food_discount) {
            this.food_discount = food_discount;
        }

        public String getFood_property() {
            return food_property;
        }

        public void setFood_property(String food_property) {
            this.food_property = food_property;
        }

        @Override
        public String toString() {
            return "Detail{" +
                    "app_food_code='" + app_food_code + '\'' +
                    ", food_name='" + food_name + '\'' +
                    ", sku_id='" + sku_id + '\'' +
                    ", quantity='" + quantity + '\'' +
                    ", price='" + price + '\'' +
                    ", box_num='" + box_num + '\'' +
                    ", box_price='" + box_price + '\'' +
                    ", unit='" + unit + '\'' +
                    ", food_discount='" + food_discount + '\'' +
                    ", food_property='" + food_property + '\'' +
                    '}';
        }
    }

    public class Extra implements Serializable {
        private String act_detail_id; //10,(活动id)
        private String reduce_fee; //2.5, (活动优惠金额，是美团承担活动费用和商户承担活动费用的总和)
        private String mt_charge; //1.5, (优惠金额中美团承担的部分，可在开发者中心订阅，不订阅则不会推送)
        private String poi_charge; //1.5, (优惠金额中商家承担的部分，可在开发者中心订阅，不订阅则不会推送)
        private String remark; //private String 满10元减2.5元private String ,（优惠说明）
        private String type; //1,活动类型）private String
        private String avg_send_time; //5.5(餐厅平均送餐时间，单位为分钟)

        public String getAct_detail_id() {
            return act_detail_id;
        }

        public void setAct_detail_id(String act_detail_id) {
            this.act_detail_id = act_detail_id;
        }

        public String getReduce_fee() {
            return reduce_fee;
        }

        public void setReduce_fee(String reduce_fee) {
            this.reduce_fee = reduce_fee;
        }

        public String getMt_charge() {
            return mt_charge;
        }

        public void setMt_charge(String mt_charge) {
            this.mt_charge = mt_charge;
        }

        public String getPoi_charge() {
            return poi_charge;
        }

        public void setPoi_charge(String poi_charge) {
            this.poi_charge = poi_charge;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAvg_send_time() {
            return avg_send_time;
        }

        public void setAvg_send_time(String avg_send_time) {
            this.avg_send_time = avg_send_time;
        }

        @Override
        public String toString() {
            return "Extra{" +
                    "act_detail_id='" + act_detail_id + '\'' +
                    ", reduce_fee='" + reduce_fee + '\'' +
                    ", mt_charge='" + mt_charge + '\'' +
                    ", poi_charge='" + poi_charge + '\'' +
                    ", remark='" + remark + '\'' +
                    ", type='" + type + '\'' +
                    ", avg_send_time='" + avg_send_time + '\'' +
                    '}';
        }
    }

}