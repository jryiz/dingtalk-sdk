package com.dingtalk.robot.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by: qiliu
 * Date: 2018/12/27
 * Description:
 */
@Data
public class Message {
    public static final String TEXT_TYPE = "text";
    public static final String LINK_TYPE = "link";
    public static final String MARKDOWN_TYPE = "markdown";
    public static final String ACTION_CARD_TYPE = "actionCard";
    public static final String FEED_CARD_TYPE= "feedCard";

    @JSONField(name = "msgtype")
    private String msgType;
    private boolean isAtAll;
    private Set<String> atMobiles;

    public Message(){
        atMobiles = new HashSet<>();
    }

    public Message(Set<String> atMobiles){
        this.atMobiles = atMobiles;
    }
}
