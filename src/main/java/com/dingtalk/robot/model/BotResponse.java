package com.dingtalk.robot.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by: qiliu
 * Date: 2018/12/28
 * Description:
 */
@Data
public class BotResponse {
    @JSONField(name = "errmsg")
    private String errMsg;
    @JSONField(name = "errcode")
    private Integer errCode;

    public boolean isSuccessful(){
        return errCode == 0;
    }
}
