import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int p = sc.nextInt();
        
        int[][] matrix1 = new int[m][n];
        int[][] matrix2 = new int[n][p];
        int[][] martix3 = new int[m][p];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix1[i][j] = sc.nextInt();
            }
            
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                matrix2[i][j] = sc.nextInt();
            }
            
        }

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < p; j++) {
                    martix3[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println(m + " " + p);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print(martix3[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    
}
