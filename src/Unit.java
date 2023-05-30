package src;

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
}
