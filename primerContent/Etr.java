package primerContent;

public class Etr {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        sb.append("1234");
        sb.reverse();
        Integer.parseInt(sb.toString());
        System.out.println();
        int i = (int) sb.charAt(1);
    }
}
