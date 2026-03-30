import java.util.Scanner;
import java.security.MessageDigest;

public class HashCompare {
public static void main(String[] args) {
try{
Scanner sc = new Scanner(System.in);

System.out.print("Enter first message: ");
String m1 = sc.nextLine();

System.out.print("Enter second message: ");
String m2 = sc.nextLine();

MessageDigest md1 = MessageDigest.getInstance("MD5");
byte[] h1 = md1.digest(m1.getBytes());
byte[] h2 = md1.digest(m2.getBytes());

String s1 = "", s2 = "";
for(int i=0;i<h1.length;i++){
int v = h1[i] & 0xff;
String hex = Integer.toHexString(v);
if(hex.length()==1) s1 += "0";
s1 += hex;
}
for(int i=0;i<h2.length;i++){
int v = h2[i] & 0xff;
String hex = Integer.toHexString(v);
if(hex.length()==1) s2 += "0";
s2 += hex;
}

System.out.println("MD5 Match: " + s1.equals(s2));

MessageDigest md2 = MessageDigest.getInstance("SHA-1");
byte[] sh1 = md2.digest(m1.getBytes());
byte[] sh2 = md2.digest(m2.getBytes());

String t1 = "", t2 = "";
for(int i=0;i<sh1.length;i++){
int v = sh1[i] & 0xff;
String hex = Integer.toHexString(v);
if(hex.length()==1) t1 += "0";
t1 += hex;
}
for(int i=0;i<sh2.length;i++){
int v = sh2[i] & 0xff;
String hex = Integer.toHexString(v);
if(hex.length()==1) t2 += "0";
t2 += hex;
}

System.out.println("SHA-1 Match: " + t1.equals(t2));
}
catch(Exception e){
System.out.println(e);
}
}
}