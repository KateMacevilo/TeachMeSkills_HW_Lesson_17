package com.teachMeSkills.lesson_17.util;

import com.teachMeSkills.lesson_17.model.Sonnet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Util {

    public static void addSonnetInDoc(List<Sonnet> list) {

        String fileName = list.get(0).getAuthorLastName() + "_" + list.get(0).getAuthorFirstName() + "_" + list.get(0).getTitle();

        try (FileWriter outFile = new FileWriter(fileName + ".txt")) {

            for (Sonnet sonnet : list) {
                for (String str : sonnet.getSonnetLines()) {
                    outFile.write(str);
                    outFile.write(System.lineSeparator());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Конец обработки документа");
        }


    }


}
