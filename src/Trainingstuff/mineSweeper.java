package Trainingstuff;

import java.util.Scanner;
public class mineSweeper {
    public static void main(String[]args){
        int n,r=0,h=0,j=0,k=0,x,y,p,q;
        mineSweeper ed=new mineSweeper();
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        char[][] arr1=new char[n][n];
        String[] arr2=new String[n];
        for(;h<=n-1;h++){
            arr2[h]=in.next();
        }
        for(;j<=n-1;j++){
            for(;k<=n-1;k++){
                arr1[j][k]=arr2[j].charAt(k);
            }
            k=0;
        }
        p=in.nextInt();
        q=in.nextInt();
        x=p+1;
        y=q+1;
        if(n>=3){
            if(ed.test(arr1[x-1][y-1])){
                System.out.print(-1);
            }else{
                if(x==1&&y==1){
                    if(ed.test(arr1[0][1])){
                        r++;
                    }
                    if (ed.test(arr1[1][0])) {
                        r++;
                    }
                    if (ed.test(arr1[1][1])) {
                        r++;
                    }
                } else if (x==1&&y==n) {
                    if(ed.test(arr1[0][n-2])){
                        r++;
                    }
                    if (ed.test(arr1[1][n-1])) {
                        r++;
                    }
                    if (ed.test(arr1[1][n-2])) {
                        r++;
                    }
                }else if (x==n&&y==n) {
                    if(ed.test(arr1[n-1][n-2])){
                        r++;
                    }
                    if (ed.test(arr1[n-2][n-1])) {
                        r++;
                    }
                    if (ed.test(arr1[n-2][n-2])) {
                        r++;
                    }
                }else if (x==n&&y==1) {
                    if(ed.test(arr1[n-2][0])){
                        r++;
                    }
                    if (ed.test(arr1[n-1][1])) {
                        r++;
                    }
                    if (ed.test(arr1[n-2][1])) {
                        r++;
                    }
                }else if (x!=1&&x!=n&&y==1) {
                    if(ed.test(arr1[x-2][0])){
                        r++;
                    }
                    if (ed.test(arr1[x][0])) {
                        r++;
                    }
                    if (ed.test(arr1[x-2][1])) {
                        r++;
                    }
                    if (ed.test(arr1[x][1])) {
                        r++;
                    }
                    if (ed.test(arr1[x-1][1])) {
                        r++;
                    }
                }else if (x!=1&&x!=n&&y==n) {
                    if(ed.test(arr1[x-2][0])){
                        r++;
                    }
                    if (ed.test(arr1[x][0])) {
                        r++;
                    }
                    if (ed.test(arr1[x-2][n-2])) {
                        r++;
                    }
                    if (ed.test(arr1[x][n-2])) {
                        r++;
                    }
                    if (ed.test(arr1[x-1][n-2])) {
                        r++;
                    }
                }else if (y!=1&&y!=n&&x==1) {
                    if(ed.test(arr1[0][y-2])){
                        r++;
                    }
                    if (ed.test(arr1[0][y])) {
                        r++;
                    }
                    if (ed.test(arr1[1][y-2])) {
                        r++;
                    }
                    if (ed.test(arr1[1][y-1])) {
                        r++;
                    }
                    if (ed.test(arr1[1][y])) {
                        r++;
                    }
                }else if (y!=1&&y!=n&&x==n) {
                    if(ed.test(arr1[n-1][y-2])){
                        r++;
                    }
                    if (ed.test(arr1[n-1][y])) {
                        r++;
                    }
                    if (ed.test(arr1[n-2][y-2])) {
                        r++;
                    }
                    if (ed.test(arr1[n-2][y-1])) {
                        r++;
                    }
                    if (ed.test(arr1[n-2][y])) {
                        r++;
                    }
                }else{
                    if(ed.test(arr1[x-1][y-2])){
                        r++;
                    }
                    if (ed.test(arr1[x-1][y])) {
                        r++;
                    }
                    if (ed.test(arr1[x-2][y-2])) {
                        r++;
                    }
                    if (ed.test(arr1[x-2][y-1])) {
                        r++;
                    }
                    if (ed.test(arr1[x-2][y])) {
                        r++;
                    }
                    if (ed.test(arr1[x][y-2])) {
                        r++;
                    }
                    if (ed.test(arr1[x][y-1])) {
                        r++;
                    }
                    if (ed.test(arr1[x][y])) {
                        r++;
                    }
                }
                System.out.print(r);
            }
        }else if(n==2){
            int l=0;
            if(ed.test(arr1[p][q])){
                System.out.print(-1);
            }else{
                if(ed.test(arr1[0][0])){
                    l++;
                }
                if(ed.test(arr1[0][1])){
                    l++;
                }
                if(ed.test(arr1[1][0])){
                    l++;
                }
                if(ed.test(arr1[1][1])){
                    l++;
                }
                System.out.print(l);
            }
        } else if (n==1) {
            if(ed.test(arr1[0][0])){
                System.out.print(-1);
            }else
                System.out.print(0);

        }


    }
    public boolean test(char a){
        return a!='o';
    }
}
