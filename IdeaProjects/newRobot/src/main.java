public class main {


    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {



        boolean success = false;

        for (int i = 0; i < 3; i++) {

            if (success == false) {


                try (RobotConnection r = robotConnectionManager.getConnection()) {

                    r.moveRobotTo(toX, toY);
                    success = true;

                } catch (RobotConnectionException robotConnectionException) {
                    continue;
                } catch (Throwable e) {
                    throw e;
                }
            }
        }
        if (success == false) throw new RobotConnectionException("");
    }

    public static void main(String[] args) {

    }
}
