import java.util.Scanner;

public class CaesarDecrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter encrypted text: ");
        String text = sc.nextLine();

        System.out.print("Enter shift: ");
        int shift = sc.nextInt();

        String result = "";

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                result += (char) ((c - base - shift + 26) % 26 + base);
            } else {
                result += c;
            }
        }

        System.out.println("Decrypted: " + result);
    }
}