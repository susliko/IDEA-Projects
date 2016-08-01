import java.util.*;

public class Table {

    public int M, N;
    public int[][] cells, colors;
    public int partsNum = 1;

    public Table(int M, int N) {
        this.M = M;
        this.N = N;
        initCells();
    }

    private void initCells() {
        cells = new int[M][N];
        colors = new int[M][N];
        generateParts( (int) ((Math.sqrt(M) + 1) * (Math.sqrt(N) + 1)));
    }

    void generateParts (int maxSize) {
        if (maxSize > M * N) maxSize = M * N;
        Random random = new Random(System.currentTimeMillis());
        int m = 0, n = 0;

        while (hasFreeCell()) {
            for(int j = 0; j < N; j++)
                for (int i = 0; i < M; i++)
                    if (cells[i][j] == 0) {
                        m = i;
                        n = j;
                       break;
                    }

            cells[m][n] = partsNum;
            int currLength = random.nextInt(maxSize - 1) + 1;

            for (int i = 0; i < currLength; i++) {

                switch (dirToMove(m, n, random)) {
                    case 0 :
                        m--;
                        break;
                    case 1 :
                        n++;
                        break;
                    case 2 :
                        m++;
                        break;
                    case 3 :
                        n--;
                        break;
                    case -1 :
                        n = -1;
                        break;
                }

                if (m >= 0 & m < M & n >= 0 & n < N) {
                    cells[m][n] = partsNum;
                }
                else break;

            }
            partsNum++;
        }

    }

    boolean hasFreeCell() {
        for(int j = 0; j < N; j++)
            for (int i = 0; i < M; i++)
                if (cells[i][j] == 0) {
                    return true;
                }
        return false;
    }

    private int dirToMove(int i, int j, Random random) {
        Integer[] dirs = {0, 1, 2, 3};
        List<Integer> list = new ArrayList<>(Arrays.asList(dirs));

        if ((i == 0) || cells[i-1][j] != 0) list.remove(new Integer(0));
        if ((i == M-1) || cells[i+1][j] != 0) list.remove(new Integer(2));
        if ((j == N-1) || cells[i][j+1] != 0) list.remove(new Integer(1));
        if ((j == 0) || cells[i][j-1] != 0) list.remove(new Integer(3));

        if (list.isEmpty())
            return -1;
        else return list.get(random.nextInt(list.size()));
    }

    public void printsCells () {
        for (int i = 0; i < M; i++){
            System.out.print((i % 2 == 0) ? "" : " ");
            for(int j = 0; j < N; j++) {
                System.out.print( ((cells[i][j] < 10)? "0" : "") + cells[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void makeMove(int partToColor, int colorToUse) {

        if (isPossibleMove(partToColor, colorToUse) && isPossibleColor(colorToUse)) {
            for (int i = 0; i < M; i++)
                for (int j = 0; j < N; j++){
                    if (cells[i][j] == partToColor) colors[i][j] = colorToUse;
                }
        }
    }

    private boolean isPossibleMove(int partToColor, int colorToUse) {
        return true;
    }

    private boolean isPossibleColor(int colorToUse) {
        return true;
    }

}
