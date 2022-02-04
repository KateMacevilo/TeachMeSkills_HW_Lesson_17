package com.teachMeSkills.lesson_17.parser.domParser;

import com.teachMeSkills.lesson_17.model.Sonnet;
import com.teachMeSkills.lesson_17.parser.IParser;
import com.teachMeSkills.lesson_17.util.Util;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements IParser {

    private List<Sonnet> sonnetList = new ArrayList<>();
    private Sonnet sonnet1 = new Sonnet();

    @Override
    public void process(String file) {

        try {

            System.out.println("Начало обработки документа");

            File xmlFile = new File(file);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();

            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("author");
            getAuthor(nList);

            NodeList nList2 = doc.getDocumentElement().getElementsByTagName("title");
            getTitle(nList2);

            NodeList nList3 = doc.getDocumentElement().getElementsByTagName("line");
            getLines(nList3);

            sonnetList.add(sonnet1);
            Util.addSonnetInDoc(sonnetList);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }

    private void getAuthor(NodeList nList) {

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element elem = (Element) nNode;

                Node node1 = elem.getElementsByTagName("firstName").item(0);
                if (node1 != null) {
                    String fname = node1.getTextContent();
                    sonnet1.setAuthorFirstName(fname);
                } else {
                    System.out.println("firstName element doesn't exist");
                }

                Node node2 = elem.getElementsByTagName("lastName").item(0);
                if (node2 != null) {
                    String lname = node2.getTextContent();
                    sonnet1.setAuthorLastName(lname);
                } else {
                    System.out.println("lastName element doesn't exist");
                }
            }
        }

    }

    private void getTitle(NodeList nList) {

        String title = "";

        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            title = node.getTextContent();
            sonnet1.setTitle(title);
        }
    }

    private void getLines(NodeList nList) {

        List<String> lineList = new ArrayList<>();

        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            lineList.add(node.getTextContent());
        }

        sonnet1.setSonnetLines(lineList);

    }

}
