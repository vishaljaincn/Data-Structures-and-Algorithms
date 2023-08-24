package primerContent;

public class StringBuilderExample {
    public static void main(String[] args) {
        String s = "I like Programming";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb);
        System.out.println(sb.length());
        sb.append(" and coffee");
        System.out.println(sb);
        sb.insert(18,", gaming");
        System.out.println(sb);
        sb.replace(2,6,"love");
        System.out.println(sb);
        sb.delete(7,20);
        sb.deleteCharAt(789);
        System.out.println(sb);
        String str1=sb.reverse().toString();
        System.out.println(str1);
//        String str=sb.toString();
//        System.out.println(str);

    }
}
