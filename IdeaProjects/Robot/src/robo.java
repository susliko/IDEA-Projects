import myProg.Direction;
import myProg.Robot;

public class robo {


    public static void setDirection(Robot robot, Direction direction){
        while (robot.getDirection() != direction)
            robot.turnLeft();
    }

    public static void main(String[] args) {

        Robot robot = new Robot(-5,-7,Direction.UP);
        int toX = -1, toY = -2;

        if (robot.getX() > toX)
        {
            setDirection(robot,Direction.LEFT);
            while (robot.getX() != toX)
                robot.stepForward();
        }
        else if (robot.getX() < toX)
        {
            setDirection(robot,Direction.RIGHT);
            while (robot.getX() != toX)
                robot.stepForward();
        }



        if (robot.getY() > toY)
        {
            setDirection(robot,Direction.DOWN);
            while (robot.getY() != toY)
                robot.stepForward();
        }
        else if (robot.getY() < toY)
        {
            setDirection(robot,Direction.UP);
            while (robot.getY() != toY)
                robot.stepForward();
        }


        double d = Double.valueOf(3).hashCode();
        int a = Integer.valueOf(Double.valueOf(3.1).hashCode()+Double.valueOf(4).hashCode()).hashCode();

        System.out.println(robot.getX()+" "+robot.getY());
        System.out.println(a);

    }

}
