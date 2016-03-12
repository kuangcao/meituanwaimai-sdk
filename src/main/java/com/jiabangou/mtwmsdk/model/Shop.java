package com.jiabangou.mtwmsdk.model;

public class Shop {

    private String app_poi_code; //	string	是	12233	APP方门店ID
    private String name; //	string	是	丽华快餐	门店名字
    private String address; //	string	是	北苑路北站K酷时代广场4层	门店地址
    private String latitude; //	float	是	38.693203	门店纬度 （美团使用的是高德坐标系，也就是火星坐标系，如果是百度坐标系需要转换）(门店坐标不需要乘以一百万)
    private float longitude; //	float	是	115.281708	门店经度 （美团使用的是高德坐标系，也就是火星坐标系，如果是百度坐标系需要转换）(门店坐标不需要乘以一百万)
    private String pic_url; //	string	否	http://p1.meituan.net/crm/__37375183__1582979.jpg	门店图片地址（默认图片为：http://p1.meituan.net/crm/__37375183__1582979.jpg）图片比例1:1，需要为Jpg/JPEG格式，大于256x256
    private String pic_url_large; //	string	否	http://p1.meituan.net/crm/__37375183__1582979.jpg	门店图片地址（默认图片为：http://p1.meituan.net/crm/__37375183__1582979.jpg ）图片比例4:3，需要为Jpg/JPEG格式，大于400x300
    private String phone; //	string	是	010-10101010	客服电话号码 （注意：此号码留客服号码）
    private String standby_tel; //	string	否	￼133232222	门店电话号码 （注意：此号码留商家电话）
    private float shipping_fee; //	float	是	1.0	每个订单的配送费
    private String shipping_time; //	string	是	7:00-9:00,11:30-19:00	门店营业时间 （注意格式，且保证不同时间段之间不存在交集）
    private String promotion_info; //	string	否	推广信息范例	门店推广信息
    private int open_level; //	int	是	1	门店的营业状态 ： 1可配送 3休息中
    private int is_online; //	int	是	1	门店上下线状态 ：1表上线,0表下线，必须菜品、配送范围和门店信息都齐全后才能提交上线 （注意：此字段不为1时门店不会提交审核）
    private int invoice_support; //	int	否	1	门店是否支持发票
    private float invoice_min_price; //	float	否	1	门店支持开发票的最小订单价（invoice_suport为1时可用）
    private String invoice_description; //	string	否	发票特殊说明，如只有定额发票，不支持开抬头等	发票相关说明（invoice_suport为1时可用）
    private String third_tag_name; //	string	是	APP方品类名称需要根据接口“list 获取门店品类列表”获取门店品类列表接口获得，如果一个门店包含多个品类须以英文逗号隔开，如中餐,西餐	目前最多支持上传两个门店品类：一个主营品类（上传的第一个品类为主营品类），一个辅营品类；部分门店品类只支持上传一个品类（例如：火锅，特色菜，地方菜，东南亚菜，日韩料理，生活超市）
    private int pre_book; //	int	否	1	是否支持营业时间范围外预下单，1表支持，0表不支持
    private int time_select; //	int	否	1	是否支持营业时间范围内预下单，1表支持，0表不支持 此字段开启后不可关闭，新建门店自动开启
    private String app_brand_code; //	string	否	kfc	第三方品牌code值（对接的三方需要提前将该值告诉美团开发人员）
    private int mt_type_id; //	int	否	23	美团品类id，输入该字段可以加快门店审核速度（美团合法品类表请联系美团运营获取）

    public String getApp_poi_code() {
        return app_poi_code;
    }

    public void setApp_poi_code(String app_poi_code) {
        this.app_poi_code = app_poi_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getPic_url_large() {
        return pic_url_large;
    }

    public void setPic_url_large(String pic_url_large) {
        this.pic_url_large = pic_url_large;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStandby_tel() {
        return standby_tel;
    }

    public void setStandby_tel(String standby_tel) {
        this.standby_tel = standby_tel;
    }

    public float getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(float shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    public String getShipping_time() {
        return shipping_time;
    }

    public void setShipping_time(String shipping_time) {
        this.shipping_time = shipping_time;
    }

    public String getPromotion_info() {
        return promotion_info;
    }

    public void setPromotion_info(String promotion_info) {
        this.promotion_info = promotion_info;
    }

    public int getOpen_level() {
        return open_level;
    }

    public void setOpen_level(int open_level) {
        this.open_level = open_level;
    }

    public int getIs_online() {
        return is_online;
    }

    public void setIs_online(int is_online) {
        this.is_online = is_online;
    }

    public int getInvoice_support() {
        return invoice_support;
    }

    public void setInvoice_support(int invoice_support) {
        this.invoice_support = invoice_support;
    }

    public float getInvoice_min_price() {
        return invoice_min_price;
    }

    public void setInvoice_min_price(float invoice_min_price) {
        this.invoice_min_price = invoice_min_price;
    }

    public String getInvoice_description() {
        return invoice_description;
    }

    public void setInvoice_description(String invoice_description) {
        this.invoice_description = invoice_description;
    }

    public String getThird_tag_name() {
        return third_tag_name;
    }

    public void setThird_tag_name(String third_tag_name) {
        this.third_tag_name = third_tag_name;
    }

    public int getPre_book() {
        return pre_book;
    }

    public void setPre_book(int pre_book) {
        this.pre_book = pre_book;
    }

    public int getTime_select() {
        return time_select;
    }

    public void setTime_select(int time_select) {
        this.time_select = time_select;
    }

    public String getApp_brand_code() {
        return app_brand_code;
    }

    public void setApp_brand_code(String app_brand_code) {
        this.app_brand_code = app_brand_code;
    }

    public int getMt_type_id() {
        return mt_type_id;
    }

    public void setMt_type_id(int mt_type_id) {
        this.mt_type_id = mt_type_id;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "app_poi_code='" + app_poi_code + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude=" + longitude +
                ", pic_url='" + pic_url + '\'' +
                ", pic_url_large='" + pic_url_large + '\'' +
                ", phone='" + phone + '\'' +
                ", standby_tel='" + standby_tel + '\'' +
                ", shipping_fee=" + shipping_fee +
                ", shipping_time='" + shipping_time + '\'' +
                ", promotion_info='" + promotion_info + '\'' +
                ", open_level=" + open_level +
                ", is_online=" + is_online +
                ", invoice_support=" + invoice_support +
                ", invoice_min_price=" + invoice_min_price +
                ", invoice_description='" + invoice_description + '\'' +
                ", third_tag_name='" + third_tag_name + '\'' +
                ", pre_book=" + pre_book +
                ", time_select=" + time_select +
                ", app_brand_code='" + app_brand_code + '\'' +
                ", mt_type_id=" + mt_type_id +
                '}';
    }

}
