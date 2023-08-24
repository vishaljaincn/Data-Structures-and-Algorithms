package primerContent;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double height=sc.nextDouble();
        double weight=sc.nextDouble();
        double bmi=(weight/(height*height))*10000;
        System.out.println(bmi);
        bmi=Math.round(bmi*10)/10d;
        if(bmi<18.5)
        {
            System.out.println("Underweight");
            System.out.println(bmi);
        }
        else if(bmi>18.5 && bmi<24.9)
        {
            System.out.println("Normal");
            System.out.println(bmi);
        }
        else if(bmi>24.9 && bmi<29.9)
        {
            System.out.println("Overweight");
            System.out.println(bmi);
            return;
        }
        else if(bmi>29.9)
        {
            System.out.println("Obese");
            System.out.println(bmi);
        }

    }
}
