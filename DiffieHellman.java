import java.math.BigInteger;
import java.util.Scanner;
public class DiffieHellman {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter prime number p: ");
int p = sc.nextInt();
System.out.print("Enter primitive root g: ");
int g = sc.nextInt();
System.out.print("Enter private key of User A: ");
int a = sc.nextInt();
System.out.print("Enter private key of User B: ");
int b = sc.nextInt();
BigInteger P = BigInteger.valueOf(p);
BigInteger G = BigInteger.valueOf(g);
BigInteger A = G.modPow(BigInteger.valueOf(a), P);
BigInteger B = G.modPow(BigInteger.valueOf(b), P);
BigInteger keyA = B.modPow(BigInteger.valueOf(a), P);
BigInteger keyB = A.modPow(BigInteger.valueOf(b), P);
System.out.println("Public Key of A = " + A);
System.out.println("Public Key of B = " + B);
System.out.println("Shared Secret Key for A = " + keyA);
System.out.println("Shared Secret Key for B = " + keyB);
sc.close();
}
}