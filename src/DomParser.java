import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.IOException;

public class DomParser {
    //XML file path.
    private static final String FILE_NAME = ".\\src\\plant_catalog.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        Document document = Pars.doc(FILE_NAME);

        //String[] st = new String[]{"COMMON","BOTANICAL", "EMPTY", "AVAILABILITY"};
        String[] st = new String[]{"COMMON","BOTANICAL","AVAILABILITY"};

        SaveCotologs.testTags(document, "PLANT", st);
        System.out.println("\nParse\n");
        SaveCotologs.createCatalogsList(document,"PLANT", st);
        System.out.println("\nPrint\n");
        ElementPars.printTagTextContent(document, "PLANT", st);

        /*Element e1 = document.getDocumentElement(); //root
        System.out.println(e1.getNodeName());

        NodeList plant = document.getElementsByTagName("PLANT");//возвращает список элементов с указанным тегом
        NodeList allChaild = document.getChildNodes();//вернет всех потомков
        for (int i = 0; i < plant.getLength(); i++) {
            Element e2 = (Element)plant.item(i);

            Catalog catalog = new Catalog();
            NodeList plantProperties = e2.getChildNodes();
            for (int j = 0; j < plantProperties.getLength(); j++) {
                if (plantProperties.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Element parent = (Element) plantProperties.item(j);
                    switch (parent.getTagName()) {
                        case "COMMON":
                            catalog.setCommon(parent.getTextContent());
                            break;
                        case "BOTANICAL":
                            catalog.setBotanical(parent.getTextContent());
                            break;
                        case "ZONE":
                            catalog.setZone(parent.getTextContent());
                            break;
                        case "LIGHT":
                            catalog.setLight(parent.getTextContent());
                            break;
                        case "PRICE":
                            catalog.setPrice(parent.getTextContent());
                            break;
                        case "AVAILABILITY":
                            catalog.setAvailability(parent.getTextContent());
                            break;
                        default:
                            System.out.println(parent.getTagName());
                    }
                }
            }
            catalogs.add(catalog);
        }
        for (Catalog c : catalogs) {
            System.out.println(String.format("Info: common - %s, botanical - %s", c.getCommon(), c.getAvailability()));
        }*/
    }
}
