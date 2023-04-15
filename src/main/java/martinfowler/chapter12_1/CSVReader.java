package martinfowler.chapter12_1;

import java.io.IOException;
import java.util.regex.Pattern;

abstract class CSVReader {

    protected static final Pattern CSV_PATTERN = Pattern.compile("\\s*,\\s*");
    public abstract String[] readCSV() throws IOException;
    public abstract void close() throws IOException;

}
