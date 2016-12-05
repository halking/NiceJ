package com.hal.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import com.hal.utils.FileUtils;


public class ParseXmlDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
         DocumentBuilderFactory  factory  =  DocumentBuilderFactory.newInstance();
         DocumentBuilder  builder  = factory.newDocumentBuilder();
         Document  doc  = builder.parse(FileUtils.getOneFiles(FileUtils.PATH_2));
     /*    Element  root =  getRoot(doc);          //得到根元素
         NodeList  childres  = getChildresList(root);      //根节点下的子元素   （name || size）
         List<String>  arraylList =  getNodeText(root);
         for (int i = 0; i < arraylList.size(); i++) {
		 System.out.println(arraylList.get(i));
	    }*/
       //Xpath测试  
        System.out.println("---------------Xpath测试--------------------");
        XPathFactory   xFactory = XPathFactory.newInstance();
        XPath  xPath = xFactory.newXPath();
        try {
			String  name = xPath.evaluate("/Email/Service", doc);
			System.out.println(name);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 } 
   public static  Element  getRoot(Document doc){
	   return    doc.getDocumentElement();
   }
   public static  NodeList  getChildresList(Node node){
	   return  node.getChildNodes();
   }
   public  static List<String>  getNodeText(Node  node){
	   List<String> textList  = new ArrayList<String>();
	   String  text = "";
	   NodeList childresList = getChildresList(node);
	   for (int i = 0; i < childresList.getLength(); i++) {
		 Node  child = childresList.item(i);
		 if (child instanceof Element) {
		  Element  childElement  =  (Element)child;
	      Text textNode = (Text)child.getFirstChild();   //得到节点的第一个文本节点
	    	   text = textNode.getData().trim();   //得到文本节点的值  忽略空白格
	    	   if (text ==null) 
				continue;
	    	   textList.add(text);
		 }
	   }
	   return  textList;
   }
}
