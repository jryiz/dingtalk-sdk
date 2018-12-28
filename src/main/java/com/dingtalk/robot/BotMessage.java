package com.dingtalk.robot;

import com.alibaba.fastjson.JSON;
import com.dingtalk.robot.model.BotResponse;
import com.dingtalk.robot.model.IMessage;
import com.dingtalk.robot.model.Message;
import com.dingtalk.robot.utils.HttpClientUtils;
import lombok.Data;

import java.io.IOException;

/**
 * Created by: qiliu
 * Date: 2018/12/28
 * Description:
 */
@Data
public class BotMessage implements IMessage {
    public static final String DING_TALK_BOT_URL = "https://oapi.dingtalk.com/robot/send?access_token=cce66b68c57bf4021c5d1589987e9f9a70855ae16a606e5f4839736e86dba822";
    private String botUrl;

    public BotMessage() {
    }

    public BotMessage(String botUrl) {
        this.botUrl = botUrl;
    }

    @Override
    public boolean send(Message message) {
        try {
            String returnStr = HttpClientUtils.httpPost(botUrl, JSON.toJSONString(message)).string();
            BotResponse botResponse = JSON.toJavaObject(JSON.parseObject(returnStr),BotResponse.class);
            System.out.println("返回数据:" + botResponse.toString());
            return botResponse.isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean send(String message) {
        String returnStr = null;
        try {
            returnStr = HttpClientUtils.httpPost(botUrl,message).string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BotResponse botResponse = JSON.toJavaObject(JSON.parseObject(returnStr),BotResponse.class);
        System.out.println("返回数据:" + botResponse.toString());
        return botResponse.isSuccessful();
    }

}
