package martinfowler.chapter12_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

class CSVStringReader extends CSVReader{

    private final BufferedReader bufReader;

    public CSVStringReader(String filename) throws IOException {
        this.bufReader = new BufferedReader(new StringReader(filename));
    }

    @Override
    public String[] readCSV() throws IOException {
        String line = bufReader.readLine();
        if (line == null) {
            return null;
        } else {
            String[] item = CSV_PATTERN.split(line);
            return item;
        }
    }

    @Override
    public void close() throws IOException {
        bufReader.close();
    }
}
