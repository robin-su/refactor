package refactoringtopatterns.build.composedmethod;

public class GrowList {

    private Object[] elements;
    private boolean readOnly;
    private int size;

    public void add(Object element) {
        if(!readOnly) {
            int newSize = this.size + 1;
            if(newSize > elements.length) {
                Object[] newElements = new Object[elements.length + 10];
                for (int i =0 ; i< size; i++) {
                    newElements[i] = elements[i];
                }
                elements = newElements;
            }
            elements[size++] = element;
        }
    }

}
