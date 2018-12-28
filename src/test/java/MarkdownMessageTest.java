import com.dingtalk.robot.BotMessage;
import com.dingtalk.robot.model.BaseText;
import com.dingtalk.robot.model.MarkdownMessage;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by: qiliu
 * Date: 2018/12/28
 * Description:
 */
public class MarkdownMessageTest {
    public static void main(String[] args) {
        String botUrl = "https://oapi.dingtalk.com/robot/send?access_token=cce66b68c57bf4021c5d1589987e9f9a70855ae16a606e5f4839736e86dba822";
        MarkdownMessage markdownMessage = new MarkdownMessage();
        BaseText text = new BaseText();
        text.setTitle("今天天气不错!");
        text.setText("#### 杭州天气 \n > 9度，@13758248635 西北风1级，空气良89，相对温度73%\n\n > ![screenshot](http://i01.lw.aliimg.com/media/lALPBbCc1ZhJGIvNAkzNBLA_1200_588.png)\n  > ###### 10点20分发布 [天气](http://www.thinkpage.cn/)");
        markdownMessage.setMarkdown(text);
        Set<String> mobiles = new HashSet<>();
        mobiles.add("1375824****");
        markdownMessage.setAtMobiles(mobiles);
        BotMessage message = new BotMessage(botUrl);
        message.send(markdownMessage);
    }
}
