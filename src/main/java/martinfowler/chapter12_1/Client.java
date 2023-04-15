package martinfowler.chapter12_1;

import java.io.IOException;

public class Client {

    private static final String SAMPLE_CSV_STRING =
            "Student.,Good Morinig.\n"
                    +"Teacher~,Hello.\n"
                    +"Student.,Good evening.\n"
                    +"Geek.,Good night.\n";

    public static void main(String[] args) throws IOException {

        new CSVStringTablePrinter(SAMPLE_CSV_STRING).print();
        new CSVFileTreePrinter(SAMPLE_CSV_STRING).print();
    }

}
