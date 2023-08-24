package primerContent;

public class PassByReference {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Before method call: sb = " + sb);
        modifyStringBuilder(sb);
        System.out.println("After method call: sb = " + sb);
    }

    public static void modifyStringBuilder(StringBuilder builder) {
        builder.append(" World"); // Changes made to the StringBuilder object will affect the original 'sb'.
    }
}
