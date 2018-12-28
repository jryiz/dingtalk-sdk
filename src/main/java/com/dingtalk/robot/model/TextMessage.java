package com.dingtalk.robot.model;

import com.dingtalk.robot.annotation.MessageType;
import lombok.Data;

/**
 * Created by: qiliu
 * Date: 2018/12/27
 * Description:
 */

@Data
@MessageType(type = Message.TEXT_TYPE)
public class TextMessage extends Message {
    public TextMessage(){
        super();
        this.setMsgType(TEXT_TYPE);
    }
    private Text text;
}
