import builder.PhoneBuilder;
import model.Phone;

public class Shop {
    public static void main(String args[]) {
        Phone phone = new PhoneBuilder().setBattery("12000mah").setOs("Android ").setProcessor("Bionic").getPhone();
        System.out.println(phone);
    }
}
