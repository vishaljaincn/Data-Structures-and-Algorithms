package primerContent;

public class StringToCharArray {
    public static void main(String[] args) {
        String s="hello mofo";
        System.out.println(s);
        char[]arr=s.toCharArray();
        System.out.println(arr);
        char[]arr1={'a','b','c','d'};
        System.out.println(arr1);
        String s1=new String(arr1);
        System.out.println(s1);
    }
}
