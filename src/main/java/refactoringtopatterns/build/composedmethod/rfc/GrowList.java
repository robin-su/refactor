package refactoringtopatterns.build.composedmethod.rfc;

public class GrowList {

    private Object[] elements;
    private boolean readOnly;
    private int size;

    //2.修改魔数
    private final static int GROWTH_INCREMENT = 10;

    public void add(Object element) {
        //1.谓哨子句
        if(readOnly) {
            return;
        }
        //3.修改判断条件
        if(atCapacity()) {
            //4.提取方法
            grow();
        }
        addElement(element);
    }

    private void addElement(Object element) {
        elements[size++] = element;
    }

    private void grow() {
        Object[] newElements = new Object[elements.length + GROWTH_INCREMENT];
        for (int i =0 ; i< size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    public boolean atCapacity() {
        return (this.size + 1) > elements.length;
    }

}
