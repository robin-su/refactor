package sjmszm.pattern.visitor.rfc1;

public class Compressor {

    public void compress(PPTFile pptFile) {
        System.out.println("compress ppt.");
    }

    public void compress(PdfFile pdfFile) {
        System.out.printf("compress pdf.");
    }

    public void compress(WordFile wordFile) {
        System.out.println("compress word.");
    }

}
