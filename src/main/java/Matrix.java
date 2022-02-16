import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.regex.*;

public class Matrix {
    private double [][] a;
    private double [] masSum;
    private int n, m;
    private void create(int k, int l)
    {
        a = new double[k][];
        int i;
        for (i = 0; i < k; i++)
            a[i] = new double [l];
    }

    public void print()
    {
        int i, j;
        for (i = 0; i < n; i++)
        {
            for (j = 0; j < m; j++)
                System.out.printf("%15.6E", a[i][j]);
            System.out.println();
        }
    }

    public void init(String s) throws  FileNotFoundException
    {
        File file = new File(s);
        Scanner scan = new Scanner(file);
        Pattern pat = Pattern.compile("[\\s\\t]+");
        String str = scan.nextLine();
        String [] sn = pat.split(str);
        n = Integer.parseInt(sn[0]);
        m = Integer.parseInt(sn[1]);
        create(n, m);
        int i, j;
        for (i = 0; i < n; i++)
        {
            str = scan.nextLine();
            sn = pat.split(str);
            for(j = 0; j < m; j++)
                a[i][j] = Double.parseDouble(sn[j]);
        }
        scan.close();
    }
    //меняет столбцы местами
    private void change(int x,int y){
        for(int j = 0; j < n; j++){
            double k=a[j][x];
            a[j][x]=a[j][y];
            a[j][y]=k;
        }

    }
    private double[] findSum(){
        double [] mas = new double[m];
        for(int i = 0; i < m; i++) {
            double sum = 0;
            for (int j = 0; j < n; j++) {

                sum += a[j][i];
            }
            mas[i]=sum;
        }
        return mas;
    }
    public void printSum(){
        masSum=findSum();
        System.out.println("\u001B[33m"+"Сумма столбцов" + "\u001B[0m");
        for (int j = 0; j < m; j++)
            System.out.printf("%15.6E", masSum[j]);
        System.out.println();

    }
    //сортирует по сумме столбцов
    public void insertSort(){

        for(int i=1;i<m;i++){
            int j=i;
            while (j>=1 && masSum[j]<masSum[j-1]){
                change(j,j-1);
                double k=masSum[j];
                masSum[j]=masSum[j-1];
                masSum[j-1]=k;
                j--;
            }
        }

    }
}


