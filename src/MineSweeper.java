import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {
    int row;
    int column;
    int elementNumber;
    String[][] fullStar;
    String[][] emptyStar;
    boolean isFinish;
    boolean isWin;
    int number ;
    Random random = new Random();
    Scanner scanner =  new Scanner(System.in);

    MineSweeper(int row, int column){
        this.row = row;
        this.column = column;
        this.elementNumber = row*column/4;
        this.fullStar = new String[row][column];
        this.emptyStar = new String[row][column];
        this.isFinish=false;
        this.isWin=false;

    }
    public void run(){
        int runRow, runCol, num = 0;
        bosTahta();
        referasTahtasi();
        print(1);
        while (!isFinish){
            print(0);
            System.out.print("Satır Giriniz :");
            runRow = scanner.nextInt();
            System.out.print("Sütun Giriniz :");
            runCol = scanner.nextInt();
            if (runRow < 0 || runRow >= this.row || runCol < 0 || runRow >= this.column){
                System.out.println("Yalnış Konum Değerleri Girdiniz! lütfen Tekrar Deneyiniz.");
                continue;
            }else {
                if (fullStar[runRow][runCol].equals("*")){
                    System.out.println("Malesef Oyunu Kaybettiniz!...");
                    System.out.println("===========================================");
                    isFinish = true;
                    isWin = true;
                    break;
                }else {
                    num--;
                    if (num <= 0){
                        System.out.println("Tebrikler Oyunu Kazandınız!...");
                        System.out.println("=======================================");
                        isFinish = true;
                        isWin = true;
                        break;
                    }else {
                        int count = control(runRow, runCol);
                        emptyStar[runRow][runCol] = String.valueOf(count);
                    }
                }
            }
        }
    }
    public void  bosTahta(){
        for (int i = 0; i < this.emptyStar.length; i++) {
            for (int j = 0; j < this.emptyStar[i].length; j++) {
                this.emptyStar[i][j] = "-";
                this.fullStar[i][j] = "-";
            }
        }
    }

    public void referasTahtasi() {
        int randRow, randCol,count =0;
        while (count != this.elementNumber){
            randRow = random.nextInt(this.row);
            randCol = random.nextInt(this.column);
            if (fullStar[randRow][randCol]=="*"){
                count++;
            }
            this.fullStar[randRow][randCol] = "*";
        }
    }
    public void print(int num){
        if (num == 1){
            System.out.println("Mayının Eksen Konumları : ");
            print(fullStar);
            System.out.println("==========================================");
            System.out.println("Mayın Tarlasına Hoş Deldiniz");
        }else {
            System.out.println("==========================================");
            print(emptyStar);
        }
    }
    public void print(String[][] str){
        for (String[] st : str){
            for (String string : st){
                System.out.print(string+ " ");
            }
            System.out.println();
        }
    }
    public int control(int row, int col){
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (row+i < 0 || col+j<0 || row+i >= this.row || col+j >= this.column || i == 0 && this.column == 0){
                    continue;
                }
                if (this.fullStar[row+i][col+j].equals("*")){
                    count++;
                }
            }
        }
        return count;
    }

}
