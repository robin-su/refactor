package sjmszm.pattern.visitor.rfc1;

public class Extractor {

    public void extract2txt(PPTFile pptFile) {
        System.out.printf("Extract PPT.");
    }

    public void extract2txt(PdfFile pdfFile) {
        System.out.println("Extract PDF.");
    }

    public void extract2txt(WordFile wordFile) {
        System.out.println("Extract WORD.");
    }

}
