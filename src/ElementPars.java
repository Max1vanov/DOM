import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
public class ElementPars {

    public static void printTagTextContent(Document document, String parentTag, String... tags) {

        NodeList parent = document.getElementsByTagName(parentTag);

        for (int i = 0; i < parent.getLength(); i++) {
            Element node = (Element)parent.item(i);
            NodeList children = node.getChildNodes();
            for (int j = 0; j < children.getLength(); j++) {
                if (children.item(j).getNodeType()==Node.ELEMENT_NODE) {
                    Element childeNode = (Element) children.item(j);
                    for (int k = 0; k < tags.length; k++) {
                       if (tags[k].equals(childeNode.getTagName())){
                           System.out.println(tags[k] + "." + (i+1) + ": " + childeNode.getTextContent());
                       }
                    }
                }
            }
            System.out.println("--------------------");
        }
    }

    public static void printTagTextContent(Document document, String parentTag, String attr, String valueAttr, String... tags) {

        NodeList parent = document.getElementsByTagName(parentTag);

        for (int i = 0; i < parent.getLength(); i++) {
            Element node = (Element)parent.item(i);
            //System.out.println(node.getAttribute(attr));
            NodeList children = node.getChildNodes();
            for (int j = 0; j < children.getLength(); j++) {
                if (children.item(j).getNodeType()==Node.ELEMENT_NODE) {
                    Element childeNode = (Element) children.item(j);

                    for (int k = 0; k < tags.length; k++) {
                        if(node.getAttribute(attr).equals(valueAttr)) {
                            if (tags[k].equals(childeNode.getTagName())) {
                                System.out.println(tags[k] + "." + (i + 1) + ": " + childeNode.getTextContent());
                            }
                        }
                    }
                }
            }
            if (node.getAttribute(attr).equals(valueAttr)) {
                System.out.println("--------------------");
            }
        }
    }
}

