package com.strel.lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Сергей on 24.11.2015.
 */
public class Main {
    public static void main(String[] args) {

        try {
            File file3 = new File("Lab_2/src/main/resources/weather.dat");

            Forecast forecast = new Forecast();
            forecast.reading(file3);


            File file2 = new File("Lab_2/src/main/resources/football.dat");

            FootbalTable data2 = new FootbalTable();
            data2.reading(file2);
        }
        catch (FileNotFoundException ex) {
            System.err.println("File not found! " + ex.getMessage());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
