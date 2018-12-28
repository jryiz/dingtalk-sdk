package com.dingtalk.robot.model;

import com.dingtalk.robot.annotation.MessageType;
import lombok.Data;

/**
 * Created by: qiliu
 * Date: 2018/12/27
 * Description:
 */
@MessageType(type = Message.MARKDOWN_TYPE)
@Data
public class MarkdownMessage extends Message {
    public MarkdownMessage() {
        super();
        this.setMsgType(MARKDOWN_TYPE);
    }

    private BaseText markdown;
}
