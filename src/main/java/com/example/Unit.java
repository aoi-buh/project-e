package com.example;

public class Unit {
    private float temperature;
    private float humidity;

    public Unit(float temperature, float humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public void setTempereture(float temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
