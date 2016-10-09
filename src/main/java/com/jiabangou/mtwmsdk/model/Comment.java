package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-9-29.
 */
public class Comment implements Serializable {

    private String add_comment;
    private String add_comment_time;
    private String comment_content;
    private String comment_id;
    private String delivery_comment_score;
    private String food_comment_score;
    private String order_comment_score;

    public String getAdd_comment() {
        return add_comment;
    }

    public void setAdd_comment(String add_comment) {
        this.add_comment = add_comment;
    }

    public String getAdd_comment_time() {
        return add_comment_time;
    }

    public void setAdd_comment_time(String add_comment_time) {
        this.add_comment_time = add_comment_time;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getDelivery_comment_score() {
        return delivery_comment_score;
    }

    public void setDelivery_comment_score(String delivery_comment_score) {
        this.delivery_comment_score = delivery_comment_score;
    }

    public String getFood_comment_score() {
        return food_comment_score;
    }

    public void setFood_comment_score(String food_comment_score) {
        this.food_comment_score = food_comment_score;
    }

    public String getOrder_comment_score() {
        return order_comment_score;
    }

    public void setOrder_comment_score(String order_comment_score) {
        this.order_comment_score = order_comment_score;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "add_comment='" + add_comment + '\'' +
                ", add_comment_time='" + add_comment_time + '\'' +
                ", comment_content='" + comment_content + '\'' +
                ", comment_id='" + comment_id + '\'' +
                ", delivery_comment_score='" + delivery_comment_score + '\'' +
                ", food_comment_score='" + food_comment_score + '\'' +
                ", order_comment_score='" + order_comment_score + '\'' +
                '}';
    }
}
