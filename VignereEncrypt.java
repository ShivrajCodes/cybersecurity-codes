import java.util.Scanner;

public class VigenereEncrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine().toUpperCase();

        System.out.print("Enter key: ");
        String key = sc.nextLine().toUpperCase();

        String result = "";
        int j = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                int shift = key.charAt(j % key.length()) - 'A';
                result += (char) ((c - 'A' + shift) % 26 + 'A');
                j++;
            } else {
                result += c;
            }
        }

        System.out.println("Encrypted: " + result);
    }
}