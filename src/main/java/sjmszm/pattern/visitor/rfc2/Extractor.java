package sjmszm.pattern.visitor.rfc2;

public class Extractor implements Visitor{

    @Override
    public void visit(PdfFile pdfFile) {
        //...
        System.out.println("Extract PDF.");
    }

    @Override
    public void visit(PPTFile pptFile) {
        System.out.printf("Extract PPT.");
    }

    @Override
    public void visit(WordFile wordFile) {
        System.out.printf("Extract WORD.");
    }
}
