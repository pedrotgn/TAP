package json;

public class Measurement {
    private String timestamp;
    private String sensorName;
    private double value;
    @Override
    public String toString() {
        return sensorName + " @ " + timestamp + " = " + value;
    }
}
