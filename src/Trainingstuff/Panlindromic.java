package Trainingstuff;

import java.util.Scanner;
public class Panlindromic {
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        int m,o=1,p=0,num,u=0;
        String g,t,r;
        Panlindromic ob=new Panlindromic();
    //    System.out.print("how many times:");
        m=in.nextInt();
        int[]arr1=new int[m];
        for(int i=1;i<=m;i++){
            g=in.next();
            num=0;
            for(;o<=g.length();o++){
                for(;p<=g.length()-o-1;p++){
                    t=g.substring(p,p+o);
                    if(ob.test(t)){
                        num++;
                    }
                }
                p=0;
            }
            for(;u<=g.length()-1;u++) {
                r = g.substring(u);
                if (ob.test(r)) {
                    num++;
                }
            }
            u=0;
            arr1[i-1]=num;
            o=1;
        }
        for(int h=0;h<=m-1;h++){
            System.out.print(arr1[h]);
            System.out.println();
        }
    }
    public boolean test(String f){
        String u=new StringBuilder(f).reverse().toString();
        return f.equals(u);
    }
}
