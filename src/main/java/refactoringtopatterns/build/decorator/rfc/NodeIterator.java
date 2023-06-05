package refactoringtopatterns.build.decorator.rfc;

import java.util.Iterator;

public class NodeIterator implements Iterator<Node> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Node next() {
        return null;
    }
}
