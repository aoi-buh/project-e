package com.example;

public class Unit {
    private float temperature;
    private float humidity;

    public Unit(float temperatureInCelcius, float humidity) throws IllegalArgumentException {
        setTemperetureKelvin((float) (temperatureInCelcius + 273.15));
        setHumidity(humidity);
    }

    public float getTemperature() {
        return this.temperature;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public void setTemperetureCelcius(float temperatureInCelcius) throws IllegalArgumentException{
        this.setTemperetureKelvin((float) (temperatureInCelcius + 273.15));             // no method for conversion from double to float hence the cast
    }

    public void setTemperetureKelvin(float temperatureInKelvin) throws IllegalArgumentException {
        if (temperatureInKelvin < 0) {
            throw new IllegalArgumentException("Temperature must be above absolute zero.");
        }
        this.temperature = temperatureInKelvin;
    }

    public void setHumidity(float humidity) throws IllegalArgumentException {
        if (humidity < 0) {
            throw new IllegalArgumentException("Humidity must be positive.");
        }
        this.humidity = humidity;
    }

    public String toString() {
        return String.format("[%f, %f]", this.temperature, this.humidity);
    }
}
