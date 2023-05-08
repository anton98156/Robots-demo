package robots;

import java.util.UUID;

public class MoveRobotCommandHendler implements CommandHandler{
    
    @Override
    public String commandName() {
        return "move-robot";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) {
        UUID robotId = UUID.fromString(args[0]);

        RobotMap.Robot robotById = map.getRobotById(robotId);
        if (robotById != null) {
            try {
                robotById.move();
            } catch (PositionException e) {
                System.out.println("\nНе удалось переместить робота: " + e.getMessage());
            }
        } else {
            System.out.println("Робот с идентификаторо " + robotId + " не найден");
        }
    }
}
