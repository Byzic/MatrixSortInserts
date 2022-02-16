import java.io.FileNotFoundException;

public class MatrixTest {

    public static void main(String[] args) {
        Matrix mat = new Matrix();
        try
        {
            mat.init("src/main/data.txt");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found!");
        }
        System.out.println("\u001B[31m"+"Матрица из файла"+"\u001B[0m");
        mat.print();

        mat.printSum();
        mat.insertSort();
        System.out.println("\u001B[32m"+"Отсортированная матрица"+"\u001B[0m");
        mat.print();
        mat.printSum();

    }
}
