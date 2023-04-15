package martinfowler.chapter12_1;

import java.io.IOException;

class CSVStringTablePrinter extends CSVStringReader{

    public CSVStringTablePrinter(String filename) throws IOException {
        super(filename);
    }

    public void print() throws IOException {
        System.out.println("<table>");
        for(int row = 0; true; row++) {
            String[] item = readCSV();
            if(item == null) {
                break;
            }
            System.out.println("<tr>");
            for(int column = 0; column < item.length ; column++) {
                System.out.print("<td>");
                System.out.print(item[column]);
                System.out.print("</td>");
            }
            System.out.println("</tr>");
        }
        System.out.println("</table>");
        close();
    }

}
