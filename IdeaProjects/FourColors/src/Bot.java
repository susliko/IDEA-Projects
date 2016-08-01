public abstract class Bot {

    public Table table;

    public Bot(Table table) {
        this.table = table;
    }

    public abstract int chooseMove();

}
