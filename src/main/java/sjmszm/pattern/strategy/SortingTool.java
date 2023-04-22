package sjmszm.pattern.strategy;

public class SortingTool {

    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        sorter.sortFile(args[0]);
    }
}
