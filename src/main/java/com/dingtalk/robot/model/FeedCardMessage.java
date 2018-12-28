package com.dingtalk.robot.model;

import com.dingtalk.robot.annotation.MessageType;
import lombok.Data;

/**
 * Created by: qiliu
 * Date: 2018/12/27
 * Description:
 */
@MessageType(type = Message.FEED_CARD_TYPE)
@Data
public class FeedCardMessage extends Message{
    public FeedCardMessage() {
        super();
        this.setMsgType(FEED_CARD_TYPE);
    }

    private FeedCardText feedCard;
}
