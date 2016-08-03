import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static class RandomBot extends Bot {

        Random random;
        public RandomBot(Table table) {
            super(table);
            random = new Random(System.currentTimeMillis());
        }

        @Override
        public int makeMove(int color) {
            LinkedList<Integer> possibleFiguresKeys= new LinkedList<>(table.PossibleFigures(color).keySet());
            int move = possibleFiguresKeys.get(random.nextInt(possibleFiguresKeys.size()));
            table.makeMove(move, color, score);
            return move;
        }

        @Override
        public void printScore() {
            System.out.print("RandomBot " + score[0]);
        }
    }


    public static void main(String[] args) {

        Table table = new Table(10, 5);

        RandomBot randomBot = new RandomBot(table);
        Game game = new Game(randomBot, Game.players.FIRST, table);
        Scanner in = new Scanner(System.in);
        game.run(in);
    }
}
