package sjmszm.pattern.visitor.rfc2;


public interface Visitor {

    void visit(PdfFile pdfFile);
    void visit(PPTFile pptFile);
    void visit(WordFile wordFile);

}
