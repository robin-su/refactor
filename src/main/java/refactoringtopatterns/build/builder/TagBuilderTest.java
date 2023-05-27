package refactoringtopatterns.build.builder;

public class TagBuilderTest {

    public static void testBuildOneNode() {
        String expectedXml = "<flavors/>";
        String actualXml = new TagBuilder("flavors").toXml();
        System.out.println(expectedXml.equals(actualXml));
    }

    public static void testBuildOneChild() {
        String expectedXml = "<flavors>" +
                             "<flavor>" +
                             "</flavors>";
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("<flavor>");
        String actualXml = builder.toXml();
        System.out.println(expectedXml.equals(actualXml));
    }

    public static void main(String[] args) {
        testBuildOneNode();
    }
}
