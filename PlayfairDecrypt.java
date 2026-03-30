import java.util.*;

public class PlayfairDecrypt {
    static char[][] matrix = new char[5][5];

    static void generateMatrix(String key) {
        key = key.toUpperCase().replace("J", "I");
        StringBuilder sb = new StringBuilder();

        for (char c : key.toCharArray())
            if (sb.indexOf("" + c) == -1)
                sb.append(c);

        for (char c = 'A'; c <= 'Z'; c++) {
            if (c == 'J') continue;
            if (sb.indexOf("" + c) == -1)
                sb.append(c);
        }

        int k = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                matrix[i][j] = sb.charAt(k++);
    }

    static String decrypt(String text) {
        text = text.toUpperCase();
        String result = "";

        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);

            int r1=0,c1=0,r2=0,c2=0;

            for (int r=0;r<5;r++)
                for (int c=0;c<5;c++) {
                    if(matrix[r][c]==a){r1=r;c1=c;}
                    if(matrix[r][c]==b){r2=r;c2=c;}
                }

            if (r1 == r2) {
                result += matrix[r1][(c1+4)%5];
                result += matrix[r2][(c2+4)%5];
            } else if (c1 == c2) {
                result += matrix[(r1+4)%5][c1];
                result += matrix[(r2+4)%5][c2];
            } else {
                result += matrix[r1][c2];
                result += matrix[r2][c1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter key: ");
        String key = sc.nextLine();

        System.out.print("Enter ciphertext: ");
        String text = sc.nextLine();

        generateMatrix(key);
        System.out.println("Decrypted: " + decrypt(text));
    }
}