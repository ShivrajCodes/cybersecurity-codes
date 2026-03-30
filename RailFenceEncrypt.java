import java.util.Scanner;

public class RailFenceEncrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter number of rails: ");
        int rails = sc.nextInt();

        StringBuilder[] fence = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) fence[i] = new StringBuilder();

        int row = 0, dir = 1;

        for (char c : text.toCharArray()) {
            fence[row].append(c);
            row += dir;

            if (row == 0 || row == rails - 1)
                dir *= -1;
        }

        String result = "";
        for (StringBuilder sb : fence)
            result += sb.toString();

        System.out.println("Encrypted: " + result);
    }
}