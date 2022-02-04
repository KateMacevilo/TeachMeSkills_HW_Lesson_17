package com.teachMeSkills.lesson_17.parser.saxParser;

import com.teachMeSkills.lesson_17.model.Sonnet;
import com.teachMeSkills.lesson_17.parser.IParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxParser implements IParser {


    @Override
    public void process(String file) {

        try{
            File inputFile = new File(file);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            SonnetHandler sonnetHandler = new SonnetHandler();
            saxParser.parse(inputFile, sonnetHandler);

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

    }
}
