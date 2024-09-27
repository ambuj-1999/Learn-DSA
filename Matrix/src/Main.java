import java.lang.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static int columnWiseMax(int[][] mat, int c){

        int m = mat.length;
        int max = mat[0][c];
        for(int r=0; r<m; r++){
            if(mat[r][c]>max){
                max = mat[r][c];
            }
        }
        return max;
    }
    public static int addRowWiseSum(int[][] mat, int n){
        int sum = 0;
        int col = mat[0].length;

        for(int c=0; c<col; c++){
            sum += mat[n][c];
        }
        return sum;
    }
    public static void printWaveForm(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        for(int r=0; r<m; r++){
            if(r%2==0) {
                for (int c = 0; c < n; c++) {
                    System.out.print(mat[r][c] + " ");

                }
                System.out.println();
            }
            else{
                for(int c = n-1; c >= 0; c--){
                    System.out.print(mat[r][c]+" ");
                }
                System.out.println();
            }
        }


    }

    public static int addElements(int[][] mat){
        int sum = 0;
        int m = mat.length;
        int n = mat[0].length;

        for(int c=0; c<n; c++){
            for(int r=0; r<m; r++) {
                sum += mat[r][c];

            }
        }
        return sum;
    }
    public static void printMatrixColumnByColumn(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        for(int c=0; c<n; c++){
            for(int r=0; r<m; r++){
                System.out.print(mat[r][c]+" ");

            }
            System.out.println();
        }
    }

    public static void printMatrixRowByRow(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                System.out.print(mat[r][c]+" ");

            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int[][] mat = new int[m][n];

        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                mat[row][col] = scn.nextInt();

            }
        }

//        printMatrixRowByRow(mat);
//        printMatrixColumnByColumn(mat);
//        System.out.println(addElements(mat));
//        printWaveForm(mat);
//
//        for(int i = 0; i<m; i++){
//            System.out.print(addRowWiseSum(mat, i)+" ");
//        }
//        System.out.println();

        for(int c=0; c<n; c++){
            System.out.print(columnWiseMax(mat, c)+ " ");
        }








    }
}