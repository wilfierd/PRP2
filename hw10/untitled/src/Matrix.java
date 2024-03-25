import java.io.*;
import java.util.Scanner;

public class Matrix {
    private double[][] a;
    private int row;
    private int col;
    public Matrix(int n, int m) {
        this.row = n;
        this.col = m;
        this.a = new double[n][m];
    }

    public void save(String file) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(row + " " + col);
            writer.newLine();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    writer.write(Double.toString(a[i][j]));
                }
                writer.newLine();
            }
        }
    }

    public static Matrix read(String file) throws IOException {
        Scanner scanner = new Scanner(new File(file));
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Matrix matrix = new Matrix(n, m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix.a[i][j] = scanner.nextDouble();
                }
            }
            return matrix;
    }

    public Matrix sum(Matrix m) {
        if (this.row != m.row || this.col != m.col) {
            return null;
        }

        Matrix result = new Matrix(this.row, this.col);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                result.a[i][j] = this.a[i][j] + m.a[i][j];
            }
        }
        return result;
    }

    public Matrix product(Matrix m) {
        if (this.col != m.row) {
            System.out.println("Incompatible dimensions for matrix multiplication.");
            return null;
        }

        Matrix result = new Matrix(this.row, m.col);
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < m.col; j++) {
                for (int k = 0; k < this.col; k++) {
                    result.a[i][j] += this.a[i][k] * m.a[k][j];
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of rows for matrix A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Number of columns for matrix A: ");
        int colsA = scanner.nextInt();
        Matrix A = new Matrix(rowsA, colsA);
        System.out.println("Enter elements of matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                System.out.print("Enter element at position (" + (i + 1) + "," + (j + 1) + "): ");
                A.a[i][j] = scanner.nextDouble();
            }
        }
        try {
            A.save("B:\\hw10\\untitled\\src\\file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.print("Enter number of rows for matrix B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Enter number of columns for matrix B: ");
        int colsB = scanner.nextInt();

        Matrix B = new Matrix(rowsB, colsB);

        System.out.println("Enter elements of matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                System.out.print("Enter element at position (" + (i + 1) + "," + (j + 1) + "): ");
                B.a[i][j] = scanner.nextDouble();
            }
        }
        System.out.println(A.product(B));;
    }
}


