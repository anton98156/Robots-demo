package com.robot;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.robot.handler.ChangeDirectionCommandHandler;
import com.robot.handler.CommandHandler;
import com.robot.handler.CommandManager;
import com.robot.handler.CreateRobotCommandHendler;
import com.robot.handler.MoveRobotCommandHendler;
import com.robot.map.RobotMap;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nВведите команду для создания карты:");

        RobotMap map = null;
        while (true) {
            String command = sc.nextLine();
            if (command.startsWith("create-map")) {
                String[] split = command.split(" ");
                String[] arguments = Arrays.copyOfRange(split, 1, split.length); 
                try {
                    map = new RobotMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("\nПри создании карты возникло исключение: " + e.getMessage() + "." +
                            " Попробуйте еще раз");
                }
            } else {
                System.out.println("Команда не найдена. Попробуйте еще раз");
            }
        }

        List<CommandHandler> handlers = List.of(
                    new CreateRobotCommandHendler(),
                    new MoveRobotCommandHendler(), 
                    new ChangeDirectionCommandHandler());
        
        CommandManager commandManager = new CommandManager(map, handlers);

        int count = 0;
        System.out.println("\nИГРАЕМ...");
        while (count < 20) {
            System.out.println("\nВведите команду:");
            String command = sc.nextLine();
            commandManager.handleCommand(command);
            System.out.println("\nКарта: ");
            System.out.println(RobotMap.robots.toString());
            Thread.sleep(1000);
            count++;
        }
        sc.close();
    }
}