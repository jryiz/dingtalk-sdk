package com.dingtalk.robot.model;

import lombok.Data;

import java.util.List;

/**
 * Created by: qiliu
 * Date: 2018/12/27
 * Description:
 */
@Data
public class FeedCardText extends BaseText {
    private List<LinkText> links;
}
