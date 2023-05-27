package refactoringtopatterns.build.factory.parser;

public class Client {

    public static void main(String[] args) {
        Parser parser = new Parser();
        parser.setShouldDecode(true);
        Node node = parser.parse("suyongbing");

    }

}
