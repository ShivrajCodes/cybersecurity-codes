import java.util.Scanner;

public class RailFenceDecrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter encrypted text: ");
        String text = sc.nextLine();

        System.out.print("Enter number of rails: ");
        int rails = sc.nextInt();

        boolean[][] mark = new boolean[rails][text.length()];

        int row = 0, dir = 1;
        for (int i = 0; i < text.length(); i++) {
            mark[row][i] = true;
            row += dir;

            if (row == 0 || row == rails - 1)
                dir *= -1;
        }

        char[][] fence = new char[rails][text.length()];
        int index = 0;

        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < text.length(); j++) {
                if (mark[i][j] && index < text.length())
                    fence[i][j] = text.charAt(index++);
            }
        }

        String result = "";
        row = 0; dir = 1;

        for (int i = 0; i < text.length(); i++) {
            result += fence[row][i];
            row += dir;

            if (row == 0 || row == rails - 1)
                dir *= -1;
        }

        System.out.println("Decrypted: " + result);
    }
}