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




//        String dirName = "10*20";
//
//        for (int i = 1; i < 1000; i++) {
//            String fileName = "file_" + i;
//            File mainFile = new File(dirName, fileName);
//            Table table = new Table(10, 20);
//
//            try (FileWriter writer = new FileWriter(mainFile, false)) {
//                writer.write(table.cellsInStr());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


//        try {
//            System.out.println(mainFile.createNewFile());
//            FileWriter writer = new FileWriter(mainFile, false);
//            writer.write(table.cellsInStr());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Table table = new Table(10, 20);
        RandomBot randomBot = new RandomBot(table);
        Game game = new Game(randomBot, Game.players.FIRST, table);
        Scanner in = new Scanner(System.in);
        game.run(in);
    }
}
