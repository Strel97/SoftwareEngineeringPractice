package com.strel.lab;

/**
 * Created by Сергей on 24.11.2015.
 */
public class Weather {

    private final int day;
    private final int maxTemperature;
    private final int minTemperature;


    public Weather(int newDay, int newMax, int newMin){
        this.day = newDay;
        this.maxTemperature = newMax;
        this.minTemperature = newMin;
    }

    public int getDay(){
        return day;
    }

    public int getTemperatureSpread(){
        return maxTemperature - minTemperature;
    }

    @Override
    public String toString(){
        return "Weather:\n  Day: " + day +
                "\n  Max temperature: " + maxTemperature +
                "\n  Min temperature: " + minTemperature +
                "\n  Temperature spread: " + getTemperatureSpread();
    }
}
