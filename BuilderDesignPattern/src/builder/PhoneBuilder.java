package builder;

import model.Phone;

public class PhoneBuilder {

    private String os;
    private String processor;
    private String battery;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setBattery(String battery) {
        this.battery = battery;
        return this;
    }

    public Phone getPhone() {
        return new Phone(os, processor, battery);
    }
}
