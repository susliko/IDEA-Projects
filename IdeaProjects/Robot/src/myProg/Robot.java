package myProg;

public final class Robot {
    private int X, Y;
    private Direction dir;

    public Robot(int X, int Y, Direction dir){
        this.X = X;
        this.Y = Y;
        this.dir = dir;
    }

    public Direction getDirection() {
        return dir;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void turnLeft() {
        if (dir.ordinal() > 0) {
            dir = Direction.values()[dir.ordinal()-1];
        }
        else {
            dir = Direction.values()[Direction.values().length-1];
        }
    }

    public void turnRight() {
        dir = Direction.values()[(dir.ordinal()+1)%Direction.values().length];
    }

    public void stepForward() {
        switch (dir){
            case UP:
                Y++;
                break;
            case DOWN:
                Y--;
                break;
            case LEFT:
                X--;
                break;
            case RIGHT:
                X++;
                break;
        }
    }
}

