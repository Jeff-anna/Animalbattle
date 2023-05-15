package Trainingstuff;

import java.util.Scanner;
import java.util.EnumSet;
public class Phonemodel1test {
    public static void main(String[]args){
        Scanner in =new Scanner(System.in);
        int m=0;
        while(m!=-1){
            System.out.print("enter your budget or -1 to quit:");
            m=in.nextInt();
            System.out.print("the recommended phone list:");
            System.out.println();
            if(m<5588) {
                System.out.print("no");
                System.out.println();
            }
            if(m>=5588&&m<6666){
                for(Phonemodel1 phone:EnumSet.range(Phonemodel1.LG,Phonemodel1.LG)){
                    System.out.printf("%-10s",phone);
                    System.out.printf("%-40s",phone.getPrice());
                    System.out.println();
                }
            }
            if(m>=6666&&m<8888){
                for(Phonemodel1 phone:EnumSet.range(Phonemodel1.LG,Phonemodel1.PIXEL)){
                    System.out.printf("%-10s",phone);
                    System.out.printf("%-40s",phone.getPrice());
                    System.out.println();
                }
            }
            if(m>=8888&&m<9939){
                for(Phonemodel1 phone:EnumSet.range(Phonemodel1.LG,Phonemodel1.HUAWEI)){
                    System.out.printf("%-10s",phone);
                    System.out.printf("%-40s",phone.getPrice());
                    System.out.println();
                }
            }
            if(m>=9939&&m<9999){
                for(Phonemodel1 phone:EnumSet.range(Phonemodel1.LG,Phonemodel1.SAMSUNG)){
                    System.out.printf("%-10s",phone);
                    System.out.printf("%-40s",phone.getPrice());
                    System.out.println();
                }
            }
            if(m>=9999){
                for(Phonemodel1 phone:EnumSet.range(Phonemodel1.LG,Phonemodel1.IPHONE)){
                    System.out.printf("%-10s",phone);
                    System.out.printf("%-40s",phone.getPrice());
                    System.out.println();
                }
            }
        }

    }
}
