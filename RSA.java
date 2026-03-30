import java.math.BigInteger;
public class RSAEncryption {
public static void main(String[] args) {
int p = 13;
int q = 17;
int e = 5;
int M = 9;
int n = p * q;
int phi = (p - 1) * (q - 1);
System.out.println("Value of n = " + n);
System.out.println("Value of phi(n) = " + phi);
BigInteger message = BigInteger.valueOf(M);
BigInteger exponent = BigInteger.valueOf(e);
BigInteger modulus = BigInteger.valueOf(n);
BigInteger cipher = message.modPow(exponent, modulus);
System.out.println("Public Key (e,n) = (" + e + "," + n + ")");
System.out.println("Cipher Text = " + cipher);
}
}