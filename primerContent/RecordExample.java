package primerContent;

public record RecordExample(int id, String name,int age) {
    public static void main(String[] args) {
        RecordExample recordExample=new RecordExample(2,"Vishal",24);
        System.out.println(recordExample.hashCode());
    }
}
