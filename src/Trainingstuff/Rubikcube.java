package Trainingstuff;

import java.util.Scanner;
public class Rubikcube {
    public static void main(String[]args){
        int times,count=1;
        Scanner input=new Scanner(System.in);
//        System.out.print("enter the times you want:");
        times=input.nextInt();
        while(count<=times){
//            System.out.print("enter the first row:");
            input.next();
  //          System.out.print("enter the second row:");
            input.next();

 //           System.out.print("enter the third row:");
            input.next();
            input.next();
            String e = input.next();
            input.next();
            input.next();
            input.next();
            input.next();
            System.out.printf("%s\n",e);
            count++;
        }
    }
}
