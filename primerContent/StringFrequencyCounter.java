package primerContent;


public class StringFrequencyCounter {

    public static String countAndConstruct(String inputStr) {
        if (inputStr == null || inputStr.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == inputStr.charAt(i - 1)) {
                count++;
            } else {
                result.append(inputStr.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        result.append(inputStr.charAt(inputStr.length() - 1)).append(count);

        return result.toString();
    }

    public static void main(String[] args) {
        String inputStr = "aaabbcccaaa";
        String outputStr = countAndConstruct(inputStr);
        System.out.println(outputStr);
    }
}
