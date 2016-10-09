package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-9-29.
 */
public class OrderSubsidy implements Serializable {

    private String order_id;
    private String order_total;
    private String subsidy;
    private List<Extra> extras;

    public class Extra implements Serializable {
        private String reduce_fee;
        private String remark;

        public String getReduce_fee() {
            return reduce_fee;
        }

        public void setReduce_fee(String reduce_fee) {
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
            return "Extras{" +
                    "reduce_fee='" + reduce_fee + '\'' +
                    ", remark='" + remark + '\'' +
                    '}';
        }
    }
}
