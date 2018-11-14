# DOM

STEPS:
1. imports
  org.w3c.dom.*
  javax.xml.parsers.*
  
2. DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

3. DocumentBuilder builder = factory.newDocumentBuilder();

4. Document document = builder.parse(new File("path to the faile XML"));

Next:

5. Element root = document.getDocumentElement();//root

6. Parsing for specified tags that are in the parent tag

  NodeList parent = document.getElementsByTagName(parentTag);//создаем список узлов по указанному тегу
  
  for (int i = 0; i < parent.getLength(); i++) {
  
      Element node = (Element)parent.item(i);//создаем элемент для каждого узла в списке
      
      NodeList childs = node.getChildNodes();//создаем список узлов подузлов для каждого элемента
      
      for (int j = 0; j < childs.getLength(); j++) {
      
          if (childs.item(j).getNodeType()==Node.ELEMENT_NODE) {//если это подузел - типа элемент
          
              Element childeNode = (Element) childs.item(j); //создаем элемент для этого подузла
              
              if (findTag.equals(childeNode.getTagName())){//если тег этого элемента = искомому
              
                  System.out.println(findTag + "." + (i+1) + ": " + childeNode.getTextContent());//печатаем его текст 
                  
              } 
          }
      }           
  }
  
7. Tag attribure chacking
  if(node.getAttribute(attr).equals(valueAttr)) {
  
     //do somthing
     
  }
 

