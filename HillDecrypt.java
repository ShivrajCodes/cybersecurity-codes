import java.util.Scanner;

public class HillDecrypt {
    static int modInverse(int a) {
        a = a % 26;
        for (int x = 1; x < 26; x++)
            if ((a * x) % 26 == 1)
                return x;
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] key = new int[2][2];

        System.out.println("Enter 2x2 key matrix:");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                key[i][j] = sc.nextInt();

        int det = key[0][0]*key[1][1] - key[0][1]*key[1][0];
        det = (det % 26 + 26) % 26;

        int invDet = modInverse(det);

        int[][] invKey = new int[2][2];
        invKey[0][0] = key[1][1];
        invKey[1][1] = key[0][0];
        invKey[0][1] = -key[0][1];
        invKey[1][0] = -key[1][0];

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                invKey[i][j] = (invKey[i][j] * invDet % 26 + 26) % 26;

        System.out.print("Enter ciphertext: ");
        String text = sc.next().toUpperCase();

        String result = "";

        for (int i = 0; i < text.length(); i += 2) {
            int[] vec = {text.charAt(i) - 'A', text.charAt(i + 1) - 'A'};
            int[] res = new int[2];

            for (int j = 0; j < 2; j++) {
                res[j] = (invKey[j][0] * vec[0] + invKey[j][1] * vec[1]) % 26;
                result += (char) (res[j] + 'A');
            }
        }

        System.out.println("Decrypted: " + result);
    }
}