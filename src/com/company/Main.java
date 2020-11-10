package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException, SameValuesException {
        File file = new File("data.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file));
        System.out.println("properties:\n" + properties);
        String[] propertiesString;
        propertiesString = properties.toString().split(", ");
        for (int i = 0; i < propertiesString.length; i++) {
            propertiesString[i] = propertiesString[i].replaceAll("\\{|}", "");
        }

        String[][] propertiesString2D = new String[propertiesString.length][];
        for (int i = 0; i < propertiesString.length; i++) {
            propertiesString2D[i] = propertiesString[i].split("=");
        }

        String temp;
        for (int i = 0; i < propertiesString.length; i++) {
            temp = propertiesString2D[i][0];
            propertiesString2D[i][0] = propertiesString2D[i][1];
            propertiesString2D[i][1] = temp;
        }

        for (int i = 0; i < propertiesString.length; i++) {
            if (propertiesString2D[i][0].equals(propertiesString2D[i][1])) {
                throw new SameValuesException("Values are equal!");
            }
        }
        for (int i = 0; i < propertiesString.length; i++) {
            propertiesString[i] = propertiesString2D[i][0] + "=" + propertiesString2D[i][1];
        }
        TreeSet<String> result = new TreeSet<String>(Arrays.asList(propertiesString));
        System.out.println("Result = " + result);

        FileWriter writer = new FileWriter("result.properties");

        Iterator<String> itr = result.iterator();
        while (itr.hasNext()) {
            writer.write(String.valueOf(itr.next())+"\n");
        }
        writer.close();
    }
}
