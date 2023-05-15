package Trainingstuff;

import java.util.Scanner;
public class polynomial {
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        int m,n,times,h,jk=0,e;
        int up;


  //      System.out.print("how many times to calculate:");
        times=input.nextInt();
        int[][]arr5=new int[times][jk];
        for(int not=1;not<=times;not++){
            h=0;
            up=0;
   //             System.out.print("how many terms:");
                m=input.nextInt();
                int[] arr1=new int[m];
                for(int nit=0;nit<=m-1;nit++){
                    arr1[nit]=input.nextInt();
                }
 //               System.out.print("how many times:");
                n= input.nextInt();
                arr5[not-1]=new int[m+n-1];
                int op=n-1;
                int[] arr2=new int[n];
                for(int mit=0;mit<=n-1;mit++){
                    arr2[mit]= input.nextInt();
                }
                int[] arr3=new int[m+n-1];
                int[][] arr4=new int[m+n][m+n];
                for(int g=0;g<=m-1;) {
                    for (int l; h <=op; h++) {
                        arr4[g][h] = arr1[g] * arr2[up];
                        up++;
                    }
                    up=0;
                    op++;
                    g++;
                    h=g;
                }

                for(int j=0,k=0;j<=m+n-2;j++){
                    for(int l;k<=j;k++){
                        arr3[j]+=arr4[k][j];
                    }
                    k=0;
                }
                e=0;
                for(int em;e<=m+n-2;e++){

                    arr5[not-1][e]=arr3[e];

                }

                }

        for(int d=0;d<=times-1;d++){
            for(int c=0;c<=arr5[d].length-1;c++){
                System.out.print(arr5[d][c]);
                System.out.print(" ");
            }
            System.out.println();
        }
                }

            }


