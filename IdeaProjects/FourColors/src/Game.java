import java.util.Scanner;

public class Game {

    public enum players {
        FIRST, SECOND;

        static players opposite(players player) {
            if (player == FIRST) return SECOND;
            else return FIRST;
        }
    }

    private players whoseTurn;
    private final Bot bot1;
    private  Bot bot2;
    private final Table table;
    private int color;



/*          (AI VS AI) mode
*****************************************/

    Game(Bot bot1, Bot bot2, players firstPlayer, Table table) {
        this.table = table;
        this.bot1 = bot1;
        this.bot2 = bot2;
        whoseTurn = firstPlayer;
        color = 1;
    }

    void run() {
        while (!table.freeFigures.isEmpty()) {
            if (whoseTurn == players.FIRST) {
                bot1.makeMove(1);

            } else {
                bot2.makeMove(1);
            }
            whoseTurn = players.opposite(whoseTurn);
        }

    }




 /*          (human VS AI) mode
 *****************************************/

    Game(Bot bot1,players firstPlayer, Table table) {
        this.table = table;
        this.bot1 = bot1;
        whoseTurn = firstPlayer;
        color = 0;
    }

    void run(Scanner sc) {
        int[] humanScore = new int[]{0};
        while (!table.PossibleFigures(color % 4 + 1).isEmpty()) {
            color = color % 4 + 1;


            /*      Useful outputs      */
            /****************************/
            String colorInStr;
            switch (color) {
                case 1:
                    colorInStr = (char) 27 + "[31mRED" + (char) 27 + "[37m ";
                    break;
                case 2:
                    colorInStr = (char) 27 + "[32mGREEN" + (char) 27 + "[37m ";
                    break;
                case 3:
                    colorInStr = (char) 27 + "[33mYELLOW" + (char) 27 + "[37m ";
                    break;
                case 4:
                    colorInStr = (char) 27 + "[34mBLUE" + (char) 27 + "[37m ";
                    break;
                default:
                    colorInStr = "ERROR : Invalid color" + (char) 27 + "[37m ";
            }

            System.out.println("======================================");
            if (whoseTurn == players.SECOND) {
                System.out.println("Your's turn now!!!");
                table.printsCellsColored();
                System.out.print("score : ");
                bot1.printScore();
                System.out.println(" - " + humanScore[0] + " you" + '\n');
                System.out.println("You may choose to paint one of the following figures :");
                table.printPossibleFiguresSh(color);
            }
            System.out.println("current color " + colorInStr);


            /*          Making turns        */
            /********************************/
            if (whoseTurn == players.FIRST) {
                System.out.println("bot's move : " + bot1.makeMove(color) + "\n");
            } else {
                System.out.println("Enter a num : [numOfFigure]");
                while (!table.makeMove(sc.nextInt(), color, humanScore)) {
                    humanScore[0] += humanScore[0];
                    System.out.println("Enter a [numOfFigure] :");
                }
            }
            System.out.println("======================================");
            whoseTurn = players.opposite(whoseTurn);

            System.out.print("\033[H\033[2J");
        }
        bot1.printScore();
        System.out.println(" - " + humanScore[0] + " you");
        if (bot1.getScore() > humanScore[0])
            System.out.println("YOU LOSE!!!");
        else
            System.out.println("YOU WIN!!!");
    }
}
