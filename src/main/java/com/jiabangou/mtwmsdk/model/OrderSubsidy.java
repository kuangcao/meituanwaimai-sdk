package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-9-29.
 */
public class OrderSubsidy implements Serializable {

    private long order_id;
    private double order_total;
    private double subsidy;
    private List<Extra> extras;

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public double getOrder_total() {
        return order_total;
    }

    public void setOrder_total(double order_total) {
        this.order_total = order_total;
    }

    public double getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(double subsidy) {
        this.subsidy = subsidy;
    }

    public List<Extra> getExtras() {
        return extras;
    }

    public void setExtras(List<Extra> extras) {
        this.extras = extras;
    }

    @Override
    public String toString() {
        return "OrderSubsidy{" +
                "order_id=" + order_id +
                ", order_total=" + order_total +
                ", subsidy=" + subsidy +
                ", extras=" + extras +
                '}';
    }

    public class Extra implements Serializable {
        private double reduce_fee;
        private String remark;

        public double getReduce_fee() {
            return reduce_fee;
        }

        public void setReduce_fee(double reduce_fee) {
            this.reduce_fee = reduce_fee;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        @Override
        public String toString() {
            return "Extra{" +
                    "reduce_fee=" + reduce_fee +
                    ", remark='" + remark + '\'' +
                    '}';
        }
    }
}
