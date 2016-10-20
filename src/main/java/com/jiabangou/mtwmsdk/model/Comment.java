package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-9-29.
 */
public class Comment implements Serializable {

    private String add_comment;
    private Long add_comment_time; //评价时间
    private String comment_content; //评价内容
    private Long comment_id; //评价id
    private Long delivery_comment_score; //配送评分
    private Long food_comment_score; //商品评分
    private Long order_comment_score; //订单评分

    public String getAdd_comment() {
        return add_comment;
    }

    public void setAdd_comment(String add_comment) {
        this.add_comment = add_comment;
    }

    public Long getAdd_comment_time() {
        return add_comment_time;
    }

    public void setAdd_comment_time(Long add_comment_time) {
        this.add_comment_time = add_comment_time;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }

    public Long getDelivery_comment_score() {
        return delivery_comment_score;
    }

    public void setDelivery_comment_score(Long delivery_comment_score) {
        this.delivery_comment_score = delivery_comment_score;
    }

    public Long getFood_comment_score() {
        return food_comment_score;
    }

    public void setFood_comment_score(Long food_comment_score) {
        this.food_comment_score = food_comment_score;
    }

    public Long getOrder_comment_score() {
        return order_comment_score;
    }

    public void setOrder_comment_score(Long order_comment_score) {
        this.order_comment_score = order_comment_score;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "add_comment='" + add_comment + '\'' +
                ", add_comment_time=" + add_comment_time +
                ", comment_content='" + comment_content + '\'' +
                ", comment_id=" + comment_id +
                ", delivery_comment_score=" + delivery_comment_score +
                ", food_comment_score=" + food_comment_score +
                ", order_comment_score=" + order_comment_score +
                '}';
    }
}
