package com.dingtalk.robot.model;

import com.dingtalk.robot.constant.Constant;
import lombok.Data;

import java.util.List;

/**
 * Created by: qiliu
 * Date: 2018/12/27
 * Description:
 */
@Data
public class ActionCardText extends BaseText{
    private String singleTitle;
    private String singleURL;
    private String btnOrientation;
    private String hideAvatar;
    private List<Button> btns;
    public void setBtnOrientation(boolean btnOrientation) {
        if (btnOrientation){
            this.btnOrientation = Constant.NUM_ONE;
        }else {
            this.btnOrientation = Constant.NUM_ZERO;
        }
    }

    public void setHideAvatar(boolean hideAvatar) {
        if (hideAvatar){
            this.hideAvatar = Constant.NUM_ONE;
        }else {
            this.hideAvatar = Constant.NUM_ZERO;
        }

    }
}
