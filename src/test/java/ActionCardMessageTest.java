import com.dingtalk.robot.BotMessage;
import com.dingtalk.robot.model.ActionCardMessage;
import com.dingtalk.robot.model.ActionCardText;
import com.dingtalk.robot.model.Button;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by: qiliu
 * Date: 2018/12/28
 * Description:
 */
public class ActionCardMessageTest {
    public static void main(String[] args) {
        String botUrl = "https://oapi.dingtalk.com/robot/send?access_token=cce66b68c57bf4021c5d1589987e9f9a70855ae16a606e5f4839736e86dba822";
        ActionCardMessage actionCardMessage = new ActionCardMessage();
        ActionCardText text = new ActionCardText();
        text.setHideAvatar(true);
        text.setBtnOrientation(true);
//        text.setSingleTitle("it's test!");
//        text.setSingleURL("http://www.baidu.com/s?wd=杭州天气");
        text.setText("查看杭州天气");
        text.setTitle("杭州天气");
        Button button = new Button();
        button.setTitle("牛逼");
        button.setActionURL("http://www.baidu.com/s?wd=牛逼");
        Button button1 = new Button();
        button1.setTitle("Nice");
        button1.setActionURL("http://www.baidu.com/s?wd=exhausted");
        List<Button> btns = new ArrayList<>();
        btns.add(button);
        btns.add(button1);
        text.setBtns(btns);
        actionCardMessage.setActionCard(text);
        Set<String> mobiles = new HashSet<>();
        mobiles.add("1375824****");
        actionCardMessage.setAtMobiles(mobiles);
        BotMessage message = new BotMessage(botUrl);
        message.send(actionCardMessage);
    }
}
