package robots;

public class CreateRobotCommandHendler implements CommandHandler{
    
    @Override
    public String commandName() {
        return "create-robot";
    }

    @Override
    public void handleCommand(RobotMap map, String[] args) {

        RobotMap.Robot robot = null;
        try {
            robot = map.createRobot(new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
            System.out.println(robot);
        } catch (PositionException e) {
            System.out.println("\nВо время создания робота возникло исключение: " + e.getMessage() + "." +
                    " Попробуйте еще раз");
        }
    }

}
