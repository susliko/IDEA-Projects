import java.util.*;

class Table {

    /*             Initialization of the Table
    *******************************************************/

    private final int M;
    private final int N;
    private int[][] cells, colors;
    private int partsNum = 1;
    public final Map<Integer, List<int[]>> freeFigures = new HashMap<>();

    /*
    41 red
    42 green
    43 yellow
    44 blue
    45 magenta
    46 cyan */
    private final String[] ASCIIcolors = new String[] {"[31m", "[32m", "[33m", "[34m", "[35m","[36m" };

    public Table(int M, int N) {
        this.M = M;
        this.N = N;
        initCells();
    }

    /*             Functions for internal use
    *******************************************************/

    private void initCells() {
        cells = new int[M][N];
        colors = new int[M][N];
        generateParts( (int) ((Math.sqrt(M) + 1) * (Math.sqrt(N) + 1)));
    }

    private void generateParts(int maxSize) {
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
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{m,n});

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
                    list.add(new int[]{m,n});
                }
                else break;

            }
            freeFigures.put(partsNum, list);

            partsNum++;
        }

    }

    private boolean hasFreeCell() {
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


/**********************************************************************/

private boolean isPossibleMove(int partToColor, int colorToUse) {

        if (!freeFigures.containsKey(partToColor))
            return false;
        for (int[] cage : freeFigures.get(partToColor)) {
            if (!mayColorTheCage(colorToUse, cage[0], cage[1]))
                return false;
        }
        return true;
    }

    private boolean mayColorTheCage(int colorToUse, int i, int j) {
        List<int[]> neibs = returnNeibs(i, j);

        for (int[] neib : neibs) {
            if (colors[neib[0]][neib[1]] == colorToUse)
                return false;
        }
        return true;
    }

    private List<int[]> returnNeibs(int i, int j) {
        List<int[]> list = new ArrayList<>();

        for (int m = i - 1; m < i + 2; m++) {
            for (int n = j - 1; n < j + 2; n++) {
                if ((m < 0 || m > M - 1) || (n < 0 || n > N - 1) || (m == i && n == j) ||
                        (i % 2 == 0 && m != i && n == j + 1) ||
                        (i % 2 == 1 && m != i && n == j - 1))
                    continue;
                list.add(new int[]{m,n});
            }
        }
        return list;
    }

    /*                  Functions for external use
    *******************************************************************/

// --Commented out by Inspection START (04.08.16 0:50):
//    public void printsCells () {
//        for (int i = 0; i < M; i++){
//            System.out.print((i % 2 == 0) ? "" : " ");
//            for(int j = 0; j < N; j++) {
//
//                String cell;
//                if
//               (cells[i][j] < 10){
//                    cell = "0" + cells[i][j];
//                }else {
//                    cell = "" + cells[i][j];
//                }
//
//                String s = (char)27 + ASCIIcolors[cells[i][j] % ASCIIcolors.length] + cell;
//                System.out.print( s + " ");
//            }
//            System.out.println((char)27 + "[30m" + " ");
//        }
//    }
// --Commented out by Inspection STOP (04.08.16 0:50)

    public void printsCellsColored () {
        for (int i = 0; i < M; i++) {
            System.out.print((i % 2 == 0) ? "" : " ");
            for (int j = 0; j < N; j++) {

                String cell;
                if
                        (cells[i][j] < 10) {
                    cell = "0" + cells[i][j];
                } else {
                    cell = "" + cells[i][j];
                }

                int col = colors[i][j];
                String s;

                if (col != 0) {
                    s = (char) 27 + ASCIIcolors[colors[i][j] - 1] + cell;
                }
                else {
                    s = cell;
                }

                System.out.print(s + (char) 27 + "[37m" + " ");
            }
            System.out.println((char) 27 + "[37m" + " ");
        }
    }

    public String cellsInStr () {
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++)
                strb.append(cells[i][j]).append(' ');
            strb.append('\n');
        }
        return strb.toString();
    }


// --Commented out by Inspection START (04.08.16 0:50):
//    public void           printPossibleFigures(int colorToUse) {
//        for (Map.Entry<Integer, List<int[]>> entry : PossibleFigures(colorToUse).entrySet()){
//            System.out.print("Figure : " + entry.getKey() + " Cages : ");
//            entry.getValue().forEach((X) -> System.out.print(Arrays.toString(X) + " "));
//            System.out.println();
//        }
//    }
// --Commented out by Inspection STOP (04.08.16 0:50)

    public void printPossibleFiguresSh(int colorToUse) {
         for (Map.Entry<Integer, List<int[]>> entry : PossibleFigures(colorToUse).entrySet()){
             System.out.print(entry.getKey() + " ");
         }
        System.out.println();
    }

    public Map<Integer, List<int[]>> PossibleFigures (int colorToUse) {
        Map<Integer, List<int[]>> possibleFigures = new HashMap<>(freeFigures);
        freeFigures.keySet().stream().filter(key -> !isPossibleMove(key, colorToUse)).forEach(possibleFigures::remove);
        return possibleFigures;
    }

    public boolean makeMove(int partToColor, int colorToUse, int[] turn) {

        if (isPossibleMove(partToColor, colorToUse)) {
            for (int i = 0; i < M; i++)
                for (int j = 0; j < N; j++){
                    if (cells[i][j] == partToColor) colors[i][j] = colorToUse;
                }
            turn[0] += freeFigures.get(partToColor).size();
            freeFigures.remove(partToColor);

            return true;
        }
        return false;
    }

}
