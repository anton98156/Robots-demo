package com.robot.handler;

import java.util.Arrays;
import java.util.List;

import com.robot.map.RobotMap;

public class CommandManager {

    private RobotMap map;
    private List<CommandHandler> handlers;

    public CommandManager(RobotMap map, List<CommandHandler> handlers) {
        this.map = map;
        this.handlers = handlers;
    }

    public void handleCommand(String command) {
        String[] split = command.split(" ");
        String commandName = split[0];
        String[] arguments = Arrays.copyOfRange(split, 1, split.length);

        for (CommandHandler handler : handlers) {
            if (commandName.equals(handler.commandName())) {
                handler.handleCommand(map, arguments);
                return;}
            else {
                throw new UnsupportedOperationException("Команда не найдена. Попробуйте сначала");
            }
        }
    }
}