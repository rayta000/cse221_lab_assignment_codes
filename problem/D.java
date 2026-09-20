import java.io.*;
import java.util.*;

public class D {
    static long MOD=1000000007;
   public static void main (String[]args) throws Exception{
    BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    int T=Integer.parseInt(br.readLine());

    int t=0;
    while(t<T){
     StringTokenizer st=new StringTokenizer(br.readLine());
     long x=Long.parseLong(br.readLine());

     long a11=Long.parseLong(st.nextToken());
     long a12=Long.parseLong(st.nextToken());
     long a21=Long.parseLong(st.nextToken());
     long a22=Long.parseLong(st.nextToken());

     long [][] arr={{a11,a12},{a21,a22}};

     long[][]res=matExpo(arr,x);

     pw.println(res[0][0]+" "+res[0][1]);
     pw.println(res[1][0]+" "+res[1][1]);
     
     t++;  
    }

    pw.flush();
 }

 public static long[][] matExpo(long[][]a,long x){
    long [][] identity={{1,0},{0,1}};

    while(x!=0){
        if(x%2!=0){
            identity=product(identity,a);
        }
        a=product(a,a);

        x=x >> 1;
    }
    return identity;
 }

 public static long[][] product(long [][] b,long [][] c){
    long[][]d=new long[2][2];

    d[0][0]=(((b[0][0]*c[0][0])%MOD)+((b[0][1]*c[1][0])%MOD))%MOD;
    d[0][1]=(((b[0][0]*c[0][1])%MOD)+((b[0][1]*c[1][1])%MOD))%MOD;
    d[1][0]=(((b[1][0]*c[0][0])%MOD)+((b[1][1]*c[1][0])%MOD))%MOD;
    d[1][1]=(((b[1][0]*c[0][1])%MOD)+((b[1][1]*c[1][1])%MOD))%MOD;

    return d;
 }
}

