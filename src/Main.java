import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Satır: ");
        int row = scanner.nextInt();
        System.out.print("Sütun: ");
        int col = scanner.nextInt();
        MineSweeper mineSweeper = new MineSweeper(row,col);
        mineSweeper.run();
    }
}