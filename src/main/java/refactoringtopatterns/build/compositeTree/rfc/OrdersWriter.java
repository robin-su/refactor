package refactoringtopatterns.build.compositeTree.rfc;


public class OrdersWriter {

    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        StringBuffer xml = new StringBuffer();
        writeOrderTo(xml);
        return xml.toString();
    }

    private void writeOrderTo(StringBuffer xml) {
        /*xml.append("<orders>");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            xml.append("<order");
            xml.append(" id='");
            xml.append(order.getOrderId());
            xml.append("'>");
            writeProductsTo(xml,order);
            xml.append("</order>");
        }
        xml.append("</orders>");*/

        TagNode ordersTag = new TagNode("orders");
        for (int i = 0; i < orders.getOrderCount(); i++) {
            Order order = orders.getOrder(i);
            TagNode orderTag = new TagNode("order");
            orderTag.addAttribute("id",String.valueOf(order.getOrderId()));
            writeProductsTo(orderTag, order);
            ordersTag.add(orderTag);
        }
        xml.append(ordersTag.toString());

    }

    private void writeProductsTo(TagNode orderTag, Order order) {
        for (int i = 0; i < order.getProductCount(); i++) {
            Product product = order.getProduct(i);
            TagNode productTag = new TagNode("product");
            productTag.addAttribute("id",String.valueOf(product.getId()));
            productTag.addAttribute("color",colorFor(product));
            if(product.getSize() != ProductSize.NOT_APPLICABLE) {
                productTag.addAttribute("size",String.valueOf(sizeFor(product)));
            }
            writePriceTo(productTag,product);
            productTag.addValue(product.getName());
//            xml.append(productTag.toString());
            orderTag.add(productTag);
            /*xml.append("<product");
            xml.append(" id='");
            xml.append(product.getId());
            xml.append("'");
            xml.append(" color='");
            xml.append(colorFor(product));
            xml.append("'");
            if(product.getSize() != ProductSize.NOT_APPLICABLE) {
                xml.append(" size='");
                xml.append(sizeFor(product));
                xml.append("'");
            }
            xml.append(">");
            writePriceTo(xml,product);
            xml.append(product.getName());
            xml.append("</product>");*/
        }
    }

    private void writePriceTo(TagNode productTag, Product product) {
//        xml.append("<price");
//        xml.append(" currency='");
//        xml.append(currencyFor(product));
//        xml.append("'>");
//        xml.append(priceFor(product));
//        xml.append("</price>");

        TagNode priceNode = new TagNode("price");
        priceNode.addAttribute("currency", String.valueOf(currencyFor(product)));
        priceNode.addValue(String.valueOf(priceFor(product)));
//        xml.append(priceNode.toString());
        productTag.add(priceNode);
    }

    private String colorFor(Product product) {
        return product.getColor();
    }

    private int sizeFor(Product product) {
        return product.getSize();
    }

    private float currencyFor(Product product) {
        return product.getCurrency();
    }

    private double priceFor(Product product) {
        return product.getPrice();
    }

}
