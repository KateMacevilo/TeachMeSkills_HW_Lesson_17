package com.teachMeSkills.lesson_17.runner;

import com.teachMeSkills.lesson_17.parser.domParser.DomParser;
import com.teachMeSkills.lesson_17.parser.saxParser.SaxParser;
import com.teachMeSkills.lesson_17.properties.Property;


public class Main {

    public static void main(String[] args) {

        Property property = new Property();
        property.getProperties();

        String xmlPath = property.getXMLPath();

        if (property.getParseType() == 1){
            SaxParser saxParser = new SaxParser();
            System.out.println("SAX");
            saxParser.process(xmlPath);
        } else if (property.getParseType() == 2){
            DomParser domParser = new DomParser();
            System.out.println("DOM");
            domParser.process(xmlPath);
        } else {
            System.out.println("Неизвестный параметр parseType");
        }

    }


}
