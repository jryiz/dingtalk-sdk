import com.dingtalk.robot.BotMessage;
import com.dingtalk.robot.model.LinkMessage;
import com.dingtalk.robot.model.LinkText;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by: qiliu
 * Date: 2018/12/28
 * Description:
 */
public class LinkMessageTest {
    public static void main(String[] args) {
        String botUrl = "https://oapi.dingtalk.com/robot/send?access_token=cce66b68c57bf4021c5d1589987e9f9a70855ae16a606e5f4839736e86dba822";
        LinkMessage linkMessage = new LinkMessage();
        LinkText linkText = new LinkText();
        linkText.setText("这是一个测试链接！");
        linkText.setTitle("今天天气不错！");
        linkText.setMessageUrl("http://www.baidu.com/s?wd=杭州天气");
        linkMessage.setLink(linkText);
        Set<String> mobiles = new HashSet<>();
        mobiles.add("1375824****");
        linkMessage.setAtMobiles(mobiles);
        BotMessage message = new BotMessage(botUrl);
        message.send(linkMessage);
    }
}
