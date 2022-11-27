package model;

public class Phone {
    private String os;
    private String processor;
    private String battery;

    public Phone() {
    }

    public Phone(String os, String processor, String battery) {
        super();
        this.os = os;
        this.processor = processor;
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", processor='" + processor + '\'' +
                ", battery=" + battery +
                '}';
    }
}
