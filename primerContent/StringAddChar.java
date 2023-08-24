package primerContent;

public class StringAddChar {
    public static void main(String[] args) {
        String s = "hellho";
        char c=s.charAt(0);
        String s1 = s.substring(1);
        String s2 = s1.replace(c, '$');
        String s3 = c +s2;
        System.out.println(s3);
        System.out.println(c+s);
        char ch1 = 'S';
        char ch2 = 'C';
        String s9="ALER";
        String s5 = ch1 + s9+ch2;
        System.out.println(s5);
        System.out.println('X'+"tore");
        System.out.println('X'+'Y'+"tore");
        String s10="i love programming";
        String  s20=s10.replace("love","x");
        System.out.println(s20);


    }
}
