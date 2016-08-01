import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Table table = new Table(10,10);
        table.printsCells();

        try(FileWriter writer = new FileWriter("forAnton.txt", false))
        {
            // запись всей строки
            for (int[] line : table.cells){
                writer.write(Arrays.toString(line));
                writer.append('\n');
            }
        // запись по символам0
//            writer.append('\n');
//            writer.append('E');

            writer.flush();
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
