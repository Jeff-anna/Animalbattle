package Trainingstuff;

import java.util.Scanner;
public class MyTriangle {
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        double a,b,c,area,peri,mud;
        boolean jug;
        System.out.print("Please enter three lengths or -1 to quit:");
        a=input.nextFloat();
        b=input.nextFloat();
        c=input.nextFloat();
        while(a!=-1){
            jug=istrue(a,b,c);
            if(jug==true){
                mud=(a+b+c)/2;
                area=Math.sqrt(mud*(mud-a)*(mud-b)*(mud-c));
                peri=a+b+c;
                System.out.printf("the area is "+area+"\nthe perimeter is "+peri);
            }else{
                System.out.print("invalid");
            }
            System.out.print("\nPlease enter three lengths or -1 to quit:");
            a=input.nextFloat();
            b=input.nextFloat();
            c=input.nextFloat();
        }
            System.out.print("Bye");

    }
    public static boolean istrue(double x,double y,double z){
        boolean n;
        if(x+y>z&&y+z>x&&x+z>y) {
            n=true;
        }else n=false;
        return n;
    }
}
