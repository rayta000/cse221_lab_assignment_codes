import java.io.*;
import java.util.*;
public class C {
 public static void main (String[]args) throws Exception{
    BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(System.out);
    StringTokenizer st=new StringTokenizer(br.readLine());

    long a=Long.parseLong(st.nextToken());
    long b=Long.parseLong(st.nextToken());
    int m=107;

    long r=1;
    while(b!=0){
        if(b%2==1){
            r=(r*a)%m;
        }
        a=(a*a)%m;
        b=b >> 1;
    }
    pw.println(r);
    pw.flush();
 }
 
}
