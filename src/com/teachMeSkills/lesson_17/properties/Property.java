package com.teachMeSkills.lesson_17.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {

    private String XMLPath;
    private int parseType;

    public Property(String XMLPath, int parseType) {
        this.XMLPath = XMLPath;
        this.parseType = parseType;
    }

    public Property() {
    }

    public String getXMLPath() {
        return XMLPath;
    }

    public int getParseType() {
        return parseType;
    }

    public void getProperties() {

        Properties appProps = new Properties();

        try (FileInputStream fis = new FileInputStream("D:\\все_файлы\\java\\projects\\Homework_17\\src\\resource\\app.properties")) {
            appProps.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.XMLPath = appProps.getProperty("urlXML");
        this.parseType = Integer.parseInt(appProps.getProperty("parseType"));

    }


}
