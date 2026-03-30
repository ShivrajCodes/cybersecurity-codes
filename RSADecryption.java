import java.math.BigInteger;
public class RSADecryption {
public static void main(String[] args) {
int p = 11;
int q = 19;
int e = 7;
int C = 87;

int n = p * q;
int phi = (p - 1) * (q - 1);
int d = 0;
for(int i = 1; i < phi; i++)
{
if((i * e) % phi == 1)
{
d = i;
break;
}
}
System.out.println("Value of n = " + n);
System.out.println("Value of phi(n) = " + phi);
System.out.println("Private Key d = " + d);
BigInteger cipher = BigInteger.valueOf(C);
BigInteger exponent = BigInteger.valueOf(d);
BigInteger modulus = BigInteger.valueOf(n);
BigInteger message = cipher.modPow(exponent, modulus);
System.out.println("Decrypted Message = " + message);
}
}