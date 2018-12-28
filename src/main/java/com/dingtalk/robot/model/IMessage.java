package com.dingtalk.robot.model;

public interface IMessage {
    boolean send(Message message);
    boolean send(String message);
}
