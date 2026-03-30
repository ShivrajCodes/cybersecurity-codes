import java.security.*;
import java.util.Base64;

public class DSA_Signature {

    public static void main(String[] args) throws Exception {

        String message = "Digital Signature using DSA";

        long start = System.nanoTime();

        // a) Generate DSA key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();

        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        // c) Sign message
        Signature sign = Signature.getInstance("SHA256withDSA");
        sign.initSign(privateKey);
        sign.update(message.getBytes());

        byte[] signature = sign.sign();

        long end = System.nanoTime();

        System.out.println("Signature: " + Base64.getEncoder().encodeToString(signature));
        System.out.println("Signing Time (ns): " + (end - start));

        // d) Verify
        Signature verify = Signature.getInstance("SHA256withDSA");
        verify.initVerify(publicKey);
        verify.update(message.getBytes());

        boolean result = verify.verify(signature);

        System.out.println("Verification Result: " + result);
    }
}