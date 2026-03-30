mport java.util.Scanner;
import java.security.MessageDigest;
public class SHA1Hash {
public static void main(String[] args) {
try{
Scanner sc = new Scanner(System.in);
System.out.print("Enter message: ");
String message = sc.nextLine();
MessageDigest md = MessageDigest.getInstance("SHA-1");
byte[] hash = md.digest(message.getBytes());
System.out.print("SHA1 Hash: ");
for(int i=0;i<hash.length;i++){
int value = hash[i] & 0xff;
String hex = Integer.toHexString(value);
if(hex.length()==1){
System.out.print("0");
}
System.out.print(hex);
}
}
catch(Exception e){
System.out.println(e);
}
}
}
