package martinfowler.chapter12_1;

import java.io.IOException;

class CSVFileTreePrinter extends CSVFileReader{

    public CSVFileTreePrinter(String filename) throws IOException {
        super(filename);
    }

    public void print() throws IOException {
        String[] prevItem = new String[0];
        for(int row = 0; true; row++) {
            String[] item = readCSV();
            if(item == null) {
                break;
            }
            boolean justprint = false;
            for(int column = 0; column < item.length ; column++) {
                if(justprint) {
                    printline(column,item[column]);
                }else {
                    if(prevItem.length <= column || item[column].equals(prevItem[column])) {
                        printline(column,item[column]);
                        justprint = true;
                    }
                }
                prevItem = item;
            }
        }
        close();
    }

    private void printline(int indent,String string) {
        for (int i=0;i < indent; i++) {
            System.out.println("   ");
        }
        System.out.println(string);
    }
}
