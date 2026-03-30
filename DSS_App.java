import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class DSS_App {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file text: ");
        String data = sc.nextLine();

        // Generate key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();

        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        // Hash + Sign
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(privateKey);
        sign.update(data.getBytes());

        byte[] signature = sign.sign();

        System.out.println("Digital Signature: " + Base64.getEncoder().encodeToString(signature));

        // Verify
        Signature verify = Signature.getInstance("SHA256withRSA");
        verify.initVerify(publicKey);
        verify.update(data.getBytes());

        boolean result = verify.verify(signature);

        System.out.println("Verification Result: " + result);
        sc.close();
    }
}