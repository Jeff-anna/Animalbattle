package Trainingstuff;

import java.util.Scanner;
public class Particlemovement {
    public static void main(String[]args){
        int times,count=1;
        float u,q,m,v;
        double min,t;
        Scanner input=new Scanner(System.in);
 //       System.out.print("enter the times:");
        times=input.nextInt();
        while(times>=count){
 //           System.out.print("enter the velocity:");
            v=input.nextFloat();
 //           System.out.print("enter the mass:");
            m=input.nextFloat();
//            System.out.print("enter the electricity:");
            q=input.nextFloat();
 //           System.out.print("enter the voltage:");
            u=input.nextFloat();
            min=2*u*q/m;
            t=Math.sqrt(min);
            if(t>v){
                System.out.print("true\n");
            }else
                System.out.print("false\n");
            count++;
        }
    }
}

