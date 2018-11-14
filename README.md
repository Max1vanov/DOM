# Java DOM
![DOM](https://cdn2.howtodoinjava.com/wp-content/uploads/2014/07/dom.gif)

STEPS:
1. imports
```java
  org.w3c.dom.*;  
  javax.xml.parsers.*;
```

2. ```java DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();```

3. ```java DocumentBuilder builder = factory.newDocumentBuilder();```

4. ```java Document document = builder.parse(new File("path to the faile XML"));```

4.1 Normalize the XML Structure

   ```java document.getDocumentElement().normalize();```
   
Next:

5. ```java Element root = document.getDocumentElement();//root```

6. Parsing for specified tags that are in the parent tag
```java

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
```  
7. Tag attribure chacking
```java
  if(node.getAttribute(attr).equals(valueAttr)) {
  
     //do somthing
     
  }
 ```
8. Validate
```java
  Schema schema = null;
  
  try {
    String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
    
    SchemaFactory factory = SchemaFactory.newInstance(language);
    
    schema = factory.newSchema(new File(name));
    
  } catch (Exception e) {
  
    e.printStackStrace();
    
  }
  
  Validator validator = schema.newValidator();
  
  validator.validate(new DOMSource(document));
```

