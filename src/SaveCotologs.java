import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.ArrayList;

public class SaveCotologs {
    //list of objects from XML
    private static ArrayList<Catalog> catalogs = new ArrayList<>();

    public static void createCatalogsList(Document document, String parentTag, String... tags) throws IOException {

        NodeList parent = document.getElementsByTagName(parentTag);
        for (int i = 0; i < parent.getLength(); i++) {
            Element node = (Element) parent.item(i);
            NodeList childs = node.getChildNodes();
            Catalog catalog = new Catalog();
            for (int j = 0; j < childs.getLength(); j++) {
                if (childs.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Element childNode = (Element) childs.item(j);
                    for (int k = 0; k < tags.length; k++) {
                        if (tags[k].equals(childNode.getTagName())) {
                            switch (childNode.getTagName()) {
                                case "COMMON":
                                    catalog.setCommon(childNode.getTextContent());
                                    break;
                                case "BOTANICAL":
                                    catalog.setBotanical(childNode.getTextContent());
                                    break;
                                case "ZONE":
                                    catalog.setZone(childNode.getTextContent());
                                    break;
                                case "LIGHT":
                                    catalog.setLight(childNode.getTextContent());
                                    break;
                                case "PRICE":
                                    catalog.setPrice(childNode.getTextContent());
                                    break;
                                case "AVAILABILITY":
                                    catalog.setAvailability(childNode.getTextContent());
                                    break;
                            }
                        }
                    }
                }
            }
            catalogs.add(catalog);
        }
        printListCatalog();
    }

    private static void printListCatalog(){
        for (Catalog c :
                catalogs) {
            System.out.println(String.format("Info: common - %s, botanical - %s", c.getCommon(), c.getAvailability()));
        }
    }

    public static void testTags(Document document, String purent, String... tags) {
        NodeList list = document.getElementsByTagName(purent);
        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);
            NodeList children = element.getChildNodes();
            StringBuilder builder = new StringBuilder("");
            for (String tag : tags) {
                int count = 0;
                for (int j = 0; j < children.getLength(); j++) {
                    if (children.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element temp = (Element) children.item(j);
                        if (tag.equals(temp.getTagName())) {
                            count++;
                        }
                    }
                }
                if (count == 0) {
                    builder.append("\t").append(tag).append("\n");
                }
            }
            if (!builder.toString().equals(""))
            System.out.print("line " + (i+1)+" missing tags;\n" +builder);
        }
    }
}
