package com.dingtalk.robot.model;

import com.dingtalk.robot.annotation.MessageType;
import lombok.Data;

/**
 * Created by: qiliu
 * Date: 2018/12/27
 * Description:
 */
@MessageType(type = Message.ACTION_CARD_TYPE)
@Data
public class ActionCardMessage extends Message{

    public ActionCardMessage() {
        super();
        this.setMsgType(ACTION_CARD_TYPE);
    }

    private ActionCardText actionCard;
}
