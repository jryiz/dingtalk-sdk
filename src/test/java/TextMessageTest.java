import com.dingtalk.robot.BotMessage;
import com.dingtalk.robot.model.Text;
import com.dingtalk.robot.model.TextMessage;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by: qiliu
 * Date: 2018/12/28
 * Description:
 */
public class TextMessageTest {
    public static void main(String[] args) {
        String botUrl = "https://oapi.dingtalk.com/robot/send?access_token=cce66b68c57bf4021c5d1589987e9f9a70855ae16a606e5f4839736e86dba822";
        TextMessage textMessage = new TextMessage();
        textMessage.setText(new Text("test"));
        Set<String> mobiles = new HashSet<>();
        mobiles.add("1375824****");
        textMessage.setAtMobiles(mobiles);
        BotMessage message = new BotMessage(botUrl);
        message.send(textMessage);
    }
}
