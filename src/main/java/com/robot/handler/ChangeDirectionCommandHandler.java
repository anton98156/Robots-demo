package com.robot.handler;

import java.util.UUID;

import com.robot.map.RobotMap;

public class ChangeDirectionCommandHandler implements CommandHandler {

    @Override
    public String commandName() {
        return "change-direction";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) {
        UUID robotId = UUID.fromString(args[0]);
        RobotMap.Direction newDirection = RobotMap.Direction.valueOf(args[1]);

        RobotMap.Robot robotById = map.getRobotById(robotId);
        if (robotById != null) {
            robotById.changeDirection(newDirection);
        } else {
            System.out.println("Робот с идентификаторо " + robotId + " не найден");
        }
    }
}