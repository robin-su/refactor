package sjmszm.pattern.flyweight.chess.rfc;

/**
 * 像刚刚的实现方式，在内存中会有大量的相似对象。这些相似对象的 id、text、color 都是相同的，唯独 positionX、positionY 不同。实际上，
 * 我们可以将棋子的 id、text、color 属性拆分出来，设计成独立的类，
 */
// 享元类 --> 这些元素大多数不变，可以被复用
public class ChessPieceUnit {
    private int id;
    private String text;
    private Color color;

    public ChessPieceUnit(int id, String text, Color color) {
        this.id = id;
        this.text = text;
        this.color = color;
    }

    public static enum Color {
        RED, BLACK
    }





}
