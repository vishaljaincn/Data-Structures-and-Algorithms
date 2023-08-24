package primerContent;

public class BeeslyString {
    public static void main(String[] args) {
        String A="mmaappmm";
        char []car=A.toCharArray();
        int pcount=0;
        int acount=0;
        int mcount=0;
        for(char c:car)
        {
            if(c=='p')
            {
                pcount++;
            }
            else if(c=='a')
            {
                acount++;
            }
            else if(c=='m')
            {
                mcount++;
            }

        }
        int dcount=pcount+acount;
        if(dcount==mcount)
        {
            System.out.println("can be emptied");
        }

    }
}
