package refactoringtopatterns.build.factory.parser.rfc;

public class Client {
    //7.修改客户端代码
    public static void main(String[] args) {
        Parser parser = new Parser();
        NodeFactory nodeFactory = new NodeFactory();
        nodeFactory.setShouldDecode(true);
        parser.setNodeFactory(nodeFactory );
        Node node = parser.parse("suyongbing");
        System.out.println(node.getText());
        System.out.println(node.getType());

        /*parser.setShouldDecode(true);
        parser.parse("suyongbing");*/
    }

}
