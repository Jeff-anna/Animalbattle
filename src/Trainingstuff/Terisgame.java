package Trainingstuff;

import java.util.Scanner;

public class Terisgame {
    public static void main(String[] args) {
        int width, height, num, index,u=0,v=0,z=0,x=3,p=3,q=0;
        char type;
        Scanner in = new Scanner(System.in);
        width = in.nextInt();
        height = in.nextInt();
        num = in.nextInt();
        int[][] arr1 = new int[height + 3][width];
        Terisgame ed = new Terisgame();
        for (int y = 1; y <= num; y++) {
            type=in.next().charAt(0);
            index =in.nextInt();
            ed.fall(arr1, index, height, type);
            for(;x<=height+2;x++){
                if(ed.eliminateCheck(arr1,width,x)){
                    for(;v<=x-1;v++){
                        for(;u<=width-1;u++){
                            arr1[x-v][u]=arr1[x-v-1][u];
                        }
                        u=0;
                    }
                    v=0;
                    for(;z<=width-1;z++){
                        arr1[0][z]=0;
                    }
                    z=0;

                }
            }
            x=3;
            if(ed.endCheck(arr1,width)){
                break;
            }
        }
        p=3;
        for(;p<=height+2;p++){
            for(;q<=width-1;q++){
                System.out.print(arr1[p][q]);
            }
            System.out.println();
            q=0;
        }
    }

    public void fall(int[][] arr1, int y, int h, char q) {
        switch (q) {
            case 'I': {
                for (int z = 0; z <= h - 1; z++) {
                    if (arr1[3 + z][y] != 0 || arr1[3 + z][y + 1] != 0 || arr1[3 + z][y + 2] != 0 || arr1[3 + z][y + 3] != 0) {
                        arr1[2 + z][y] = arr1[2 + z][y + 1] = arr1[2 + z][y + 2] = arr1[2 + z][y + 3] = 1;
                        break;
                    }
                    if (z == h - 1) {
                        arr1[2 + h][y] = arr1[2 + h][y + 1] = arr1[2 + h][y + 2] = arr1[2 + h][y + 3] = 1;
                    }
                }
                break;
            }
            case 'O': {
                for (int z = 0; z <= h - 1; z++) {
                    if (arr1[3 + z][y] != 0 || arr1[3 + z][y + 1] != 0 || arr1[2 + z][y] != 0 || arr1[2 + z][y + 1] != 0) {
                        arr1[2 + z][y] = arr1[2 + z][y + 1] = arr1[1 + z][y] = arr1[1 + z][y + 1] = 1;
                        break;
                    }
                    if (z == h - 1) {
                        arr1[2 + h][y] = arr1[2 + h][y + 1] = arr1[1 + h][y] = arr1[1 + h][y + 1] = 1;
                    }
                }
                break;
            }
            case 'L': {
                for (int z = 0; z <= h - 1; z++) {
                    if (arr1[3 + z][y] != 0 || arr1[3 + z][y + 1] != 0 || arr1[2 + z][y] != 0 || arr1[1 + z][y] != 0) {
                        arr1[2 + z][y] = arr1[2 + z][y + 1] = arr1[1 + z][y] = arr1[z][y] = 1;
                        break;
                    }
                    if (z == h - 1) {
                        arr1[2 + h][y] = arr1[2 + h][y + 1] = arr1[1 + h][y] = arr1[h][y] = 1;
                    }
                }
                break;
            }
            case 'J': {
                for (int z = 0; z <= h - 1; z++) {
                    if (arr1[3 + z][y] != 0 || arr1[3 + z][y + 1] != 0 || arr1[2 + z][y + 1] != 0 || arr1[1 + z][y + 1] != 0) {
                        arr1[2 + z][y] = arr1[2 + z][y + 1] = arr1[1 + z][y + 1] = arr1[z][y + 1] = 1;
                        break;
                    }
                    if (z == h - 1) {
                        arr1[2 + h][y] = arr1[2 + h][y + 1] = arr1[1 + h][y + 1] = arr1[h][y + 1] = 1;
                    }
                }
                break;
            }
            case 'T': {
                for (int z = 0; z <= h - 1; z++) {
                    if (arr1[2 + z][y] != 0 || arr1[2 + z][y + 1] != 0 || arr1[2 + z][y + 2] != 0 || arr1[3 + z][y + 1] != 0) {
                        arr1[1 + z][y] = arr1[1 + z][y + 1] = arr1[1 + z][y + 2] = arr1[2 + z][y + 1] = 1;
                        break;
                    }
                    if (z == h - 1) {
                        arr1[1 + h][y] = arr1[1 + h][y + 1] = arr1[1 + h][y + 2] = arr1[2 + h][y + 1] = 1;
                    }
                }
                break;
            }
            case 'S': {
                for (int z = 0; z <= h - 1; z++) {
                    if (arr1[3 + z][y] != 0 || arr1[3 + z][y + 1] != 0 || arr1[2 + z][y + 1] != 0 || arr1[2 + z][y + 2] != 0) {
                        arr1[2 + z][y] = arr1[2 + z][y + 1] = arr1[1 + z][y + 1] = arr1[1 + z][y + 2] = 1;
                        break;
                    }
                    if (z == h - 1) {
                        arr1[2 + h][y] = arr1[2 + h][y + 1] = arr1[1 + h][y + 1] = arr1[1 + h][y + 2] = 1;
                    }
                }
                break;
            }
            case 'Z': {
                for (int z = 0; z <= h - 1; z++) {
                    if (arr1[2 + z][y] != 0 || arr1[2 + z][y + 1] != 0 || arr1[3 + z][y + 1] != 0 || arr1[3 + z][y + 2] != 0) {
                        arr1[1 + z][y] = arr1[1 + z][y + 1] = arr1[2 + z][y + 1] = arr1[2 + z][y + 2] = 1;
                        break;
                    }
                    if (z == h - 1) {
                        arr1[1 + h][y] = arr1[1 + h][y + 1] = arr1[2 + h][y + 1] = arr1[2 + h][y + 2] = 1;
                    }
                }
                break;
            }
        }

    }

    public boolean eliminateCheck(int[][] arr1, int width, int row) {
        int y = 0, sum = 0;
        boolean i = false;
        for (; y <= width - 1; y++) {
            sum += arr1[row][y];
        }
        if (sum == width) {
            i = true;
        }
        return i;
    }

    public boolean endCheck(int[][] arr1, int width) {
        boolean i = false;
        for (int x = 0; x <= width - 1; x++) {
            if (arr1[2][x] != 0||arr1[1][x]!=0||arr1[0][x]!=0) {
                i = true;
                break;
            }
        }
        return i;
    }
}
