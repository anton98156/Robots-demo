package com.robot.handler;

import com.robot.map.RobotMap;

public interface CommandHandler {
    String commandName();
    void handleCommand(RobotMap map, String[] args);
}