package com.dingtalk.robot.model;

import lombok.Data;

/**
 * Created by: qiliu
 * Date: 2018/12/27
 * Description:
 */
@Data
public class Text {
    public Text(){}
    public Text(String content) {
        this.content = content;
    }

    private String content;
}
