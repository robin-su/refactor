package refactoringtopatterns.build.unifiedAdapter.rfc;

/**
 * 1.1
 */
public interface XMLNode {

    void add(XMLNode childNode);

    void addAttribute(String attribute, String value);

    void addValue(String value);


}
