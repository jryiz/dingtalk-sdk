package com.dingtalk.robot.model;

import com.dingtalk.robot.annotation.MessageType;
import lombok.Data;

/**
 * Created by: qiliu
 * Date: 2018/12/27
 * Description:
 */
@MessageType(type = Message.LINK_TYPE)
@Data
public class LinkMessage extends Message{
    public LinkMessage() {
        super();
        this.setMsgType(LINK_TYPE);
    }

    private LinkText link;
}
