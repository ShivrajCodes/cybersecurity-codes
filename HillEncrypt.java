import java.util.Scanner;

public class HillEncrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] key = new int[2][2];

        System.out.println("Enter 2x2 key matrix:");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                key[i][j] = sc.nextInt();

        System.out.print("Enter plaintext (even length): ");
        String text = sc.next().toUpperCase();

        String result = "";

        for (int i = 0; i < text.length(); i += 2) {
            int[] vec = {text.charAt(i) - 'A', text.charAt(i + 1) - 'A'};
            int[] res = new int[2];

            for (int j = 0; j < 2; j++) {
                res[j] = (key[j][0] * vec[0] + key[j][1] * vec[1]) % 26;
                result += (char) (res[j] + 'A');
            }
        }

        System.out.println("Encrypted: " + result);
    }
}