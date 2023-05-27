package refactoringtopatterns.build.builder;

public class TagBuilderTest {

    public static void testBuilderOneNode() {
        String exceptedXml = "<flavors/>";

        String actualXml = new TagBuilder("flavors").toXml();
        System.out.println(actualXml);
        System.out.println(exceptedXml.equals(actualXml));
    }

    public static void testBuildOneChild() {
        String expectedXml = "<flavors>" +
                                "<flavor/>" +
                             "</flavors>";

        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
        String actualXml = builder.toXml();
        System.out.println(actualXml);
        System.out.println(expectedXml.equals(actualXml));
    }

    public static void testBuildChildrenOfChildren() {
        String excepted = "<flavors>" +
                            "<flavor>" +
                                "<requirements>" +
                                    "<requirement/>" +
                                "</requirements>" +
                            "</flavor>" +
                          "</flavors>";
        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor");
        builder.addChild("requirements");
        builder.addChild("requirement");

        String actualXml = builder.toXml();
        System.out.println(actualXml);
        System.out.println(excepted.equals(actualXml));
    }

    public static void testBuildSibling() {
        String exceptedXml = "<flavors><flavor1/><flavor2/></flavors>";

        TagBuilder builder = new TagBuilder("flavors");
        builder.addChild("flavor1");
        builder.addSibling("flavor2");

        String actualXml = builder.toXml();
        System.out.println(actualXml);
        System.out.println(exceptedXml.equals(actualXml));
    }

    public static void testRepeatingChildrenAndGrandChildren() {
        String exceptedXml = "<flavors>" +
                                "<flavor>" +
                                    "<requirements>" +
                                        "<requirement/>" +
                                    "</requirements>" +
                                "</flavor>" +
                                "<flavor>" +
                                    "<requirements>" +
                                        "<requirement/>" +
                                    "</requirements>" +
                                "</flavor>" +
                            "</flavors>";

        System.out.println(exceptedXml);

        TagBuilder builder = new TagBuilder("flavors");
        for(int i = 0; i < 2; i++) {
//            builder.addChild("flavor");
            builder.addToParent("flavors","flavor");
            builder.addChild("requirements");
            builder.addChild("requirement");
        }

        String actualXml = builder.toXml();
        System.out.println(actualXml);
        System.out.println(exceptedXml.equals(actualXml));

    }

    public static void testAttributesAndValues() {
        String exceptedXml = "<flavor name='Test-Driven Development'>" +
                                "<requirements>" +
                                    "<requirement type='hardware'>" +
                                        "1 computer for every 2 participant" +
                                    "</requirement>" +
                                    "<requirement type='software'>" +
                                        "IDE" +
                                    "</requirement>" +
                                "</requirements>" +
                            "</flavor>";

        System.out.println(exceptedXml);

        TagBuilder builder = new TagBuilder("flavor");
        builder.addAttribute("name", "'Test-Driven Development'");
        builder.addChild("requirements");
        builder.addToParent("requirements","requirement");
        builder.addAttribute("type","'hardware'");
        builder.setValue("1 computer for every 2 participant ");
        builder.addToParent("requirements","requirement");
        builder.addAttribute("type","'software'");
        builder.setValue("IDE");

        String actualXml = builder.toXml();
        System.out.println(actualXml);
        System.out.println(exceptedXml.equals(actualXml));

    }

    public static void main(String[] args) {
//        testBuilderOneNode();
//        testBuildOneChild();
//        testBuildChildrenOfChildren();
//        testBuildSibling();
//        testRepeatingChildrenAndGrandChildren();
        testAttributesAndValues();
    }

}
