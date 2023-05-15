package Trainingstuff;

import java.util.Scanner;
public class mikupuzzle {
    public static void main(String[] args) {
        int m,u=1,n,k,count=0,j=1,not=0;
        String d;
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        d=in.next();
        char []arr4=new char[1700];
        char[][] arr1 = new char[m][n];
        char[] arr3=new char[m*n];
        char[]arr2=d.toCharArray();
        int[]arr5=new int[1700];
        for(int i=0;i<=m*n-1;i++){
            arr3[i]='?';
        }
        for(int y=1;y<=arr2.length;y++){
            if(arr2[y-1]>='a'&&arr2[y-1]<='z'){
                arr4[count]=arr2[y-1];
                arr5[count]=y-1;
                count++;
            }
        }
        for(int x=0;x<= arr4.length-1;x++ ){
            if(x+1<=arr5.length-1){
                if(arr5[x+1]!=0){
                    k=Integer.valueOf(d.substring(arr5[x]+1,arr5[x+1]));
                    for(;j<=m*n;j++){
                        if(arr3[j-1]=='?'){
                            not++;
                            for(;u<=k;u++){
                                arr3[j-1+u-1]=arr4[not-1];
                            }
                            u=1;
                            break;
                        }
                    }
                    j=1;
                }else{
                    k = Integer.parseInt(d.substring(arr5[x]+1));
                    for(;j<=m*n;j++){
                        if(arr3[j-1]=='?'){
                            not++;
                            for(;u<=k;u++){
                                arr3[j-1+u-1]=arr4[not-1];
                            }
                            u=1;
                            break;
                        }
                    }
                    j=1;
                    break;
                }
            }else{
                k = Integer.parseInt(d.substring(arr5[x]+1));
                for(;j<=m*n;j++){
                    if(arr3[j-1]=='?'){
                        not++;
                        for(;u<=k;u++){
                            arr3[j-1+u-1]=arr4[not-1];
                        }
                        u=1;
                        break;
                    }
                }
                j=1;
                break;
            }

        }
        //now I have arr3
        mikupuzzle ed=new mikupuzzle();
        int cout=0,y=0,l=0;
        for(int r=0;r<=m-1;r++){
            for(;l<=n-1;l++){
                arr1[r][l]='?';
            }
            l=0;
        }
        for(int z=1;z<=m*n;z++){
            if(!ed.test(arr1,m,n)){
                if(z%4==1){
                    for(;y<=n-1-(z-1)/2;y++){
                        arr1[m-1-(z-1)/4][(z-1)/4+y]=arr3[cout];
                        cout++;
                    }
                    y=0;
                }
                if(z%4==2){
                    for(;y<=m-1-z/2;y++){
                        arr1[m-1-(z+2)/4-y][n-1-(z-2)/4]=arr3[cout];
                        cout++;
                    }
                    y=0;
                }
                if(z%4==3){
                    for(;y<=n-1-(z-1)/2;y++){
                        arr1[(z+1)/4-1][n-1-(z+1)/4-y]=arr3[cout];
                        cout++;
                    }
                    y=0;

                }
                if(z%4==0){
                    for(;y<=m-1-z/2;y++){
                        arr1[z/4+y][(z/4)-1]=arr3[cout];
                        cout++;
                    }
                    y=0;

                }
            }
        }
        for(int r=0;r<=m-1;r++){
            for(;l<=n-1;l++){
                System.out.print(arr1[r][l]);
            }
            System.out.println();
            l=0;
        }
    }
    public boolean test(char[][]a,int x,int y){
        int h=0;
        boolean b=true;
        for(int g=0;g<=x-1;g++){
            for(;h<=y-1;h++){
                if(a[g][h]=='?'){
                    b=false;
                }
            }
            h=0;
        }
        return b;
    }
}
