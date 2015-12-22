package com.strel.lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Сергей on 08.12.2015.
 */
public class WeatherReader {
    public void read(String filename) {
        Path path = Paths.get(filename);
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WeatherReader reader = new WeatherReader();
        reader.read("Lab_2/src/main/resources/weather.dat");
    }
}
