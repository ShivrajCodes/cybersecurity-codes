import java.security.*;
import java.util.Base64;

public class ECDSA_Signature {

    public static void main(String[] args) throws Exception {

        String message = "ECDSA Digital Signature";

        long start = System.nanoTime();

        // a) Generate EC Key Pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        keyGen.initialize(256);
        KeyPair pair = keyGen.generateKeyPair();

        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        // b) Sign
        Signature sign = Signature.getInstance("SHA256withECDSA");
        sign.initSign(privateKey);
        sign.update(message.getBytes());

        byte[] signature = sign.sign();

        long end = System.nanoTime();

        System.out.println("ECDSA Signature: " + Base64.getEncoder().encodeToString(signature));
        System.out.println("Execution Time (ns): " + (end - start));

        // Verify
        Signature verify = Signature.getInstance("SHA256withECDSA");
        verify.initVerify(publicKey);
        verify.update(message.getBytes());

        boolean result = verify.verify(signature);

        System.out.println("Verification Result: " + result);

        // Compare key size
        System.out.println("Public Key Size: " + publicKey.getEncoded().length * 8 + " bits");
    }
}