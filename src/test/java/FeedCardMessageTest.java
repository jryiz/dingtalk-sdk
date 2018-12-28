import com.dingtalk.robot.BotMessage;
import com.dingtalk.robot.model.FeedCardMessage;
import com.dingtalk.robot.model.FeedCardText;
import com.dingtalk.robot.model.LinkText;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by: qiliu
 * Date: 2018/12/28
 * Description:
 */
public class FeedCardMessageTest {
    public static void main(String[] args) {
        String botUrl = "https://oapi.dingtalk.com/robot/send?access_token=cce66b68c57bf4021c5d1589987e9f9a70855ae16a606e5f4839736e86dba822";
        FeedCardMessage feedCardMessage = new FeedCardMessage();
        FeedCardText text = new FeedCardText();
        LinkText link = new LinkText();
        link.setTitle("时代的火车向前开");
        link.setMessageUrl("https://www.baidu.com/s?wd=时代的火车向前开");
        link.setPicUrl("https://www.dingtalk.com/");
        LinkText link1 = new LinkText();
        link1.setTitle("时代的火车向前开2");
        link1.setMessageUrl(link.getMessageUrl());
        link1.setPicUrl(link.getPicUrl());
        List<LinkText> links = new ArrayList<>();
        links.add(link);
        links.add(link1);
        text.setLinks(links);
        feedCardMessage.setFeedCard(text);
        Set<String> mobiles = new HashSet<>();
        mobiles.add("1375824****");
        feedCardMessage.setAtMobiles(mobiles);
        BotMessage message = new BotMessage(botUrl);
//        message.send(feedCardMessage);

        String str = "{\"atAll\":false,\"atMobiles\":[\"13758248635\"],\"feedCard\":{\"links\":[{\"messageURL\":\"https://www.baidu.com/s?wd=时代的火车向前开\",\"picURL\":\"https://www.dingtalk.com/\",\"title\":\"时代的火车向前开\"},{\"messageURL\":\"https://www.baidu.com/s?wd=时代的火车向前开\",\"picURL\":\"https://www.dingtalk.com/\",\"title\":\"时代的火车向前开2\"}]},\"msgtype\":\"feedCard\"}";
        message.send(str);
    }
}
