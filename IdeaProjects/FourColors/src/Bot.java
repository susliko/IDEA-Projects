abstract class Bot {

    final Table table;
    final int[] score;

    public Bot(Table table) {
        this.table = table;
        score = new int[]{0};
    }

    public int getScore() {return score[0];}

    public abstract void printScore();

    public abstract int makeMove(int color);

}