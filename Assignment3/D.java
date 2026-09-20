import java.io.*;
import java.util.*;

public class D {
    static long MOD=1000000007;

    static class Matrix{
        long c11,c12,c21,c22;
        Matrix(long c11,long c12,long c21,long c22){
            this.c11=c11;
            this.c12=c12;
            this.c21=c21;
            this.c22=c22;
        }
    }
    static Matrix identity;

    public static void main (String[]args) throws Exception{
    BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    int T=Integer.parseInt(br.readLine());
    StringTokenizer st=null;
    long x=0;

    while(T-->0){
     st=new StringTokenizer(br.readLine());
     x=Long.parseLong(br.readLine());
     identity=new Matrix(1,0,0,1);
     Matrix arr1=new Matrix(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));

     matExpo(arr1,x);

     pw.println(identity.c11+" "+identity.c12);
     pw.println(identity.c21+" "+identity.c22);
        
    }

    pw.flush();
 }

public static void matExpo(Matrix a,long x){
    while(x>0){
        if(x%2!=0){
            identity=product(identity,a);
        }
        a=product(a,a);

        x=x/2;
    }
 }

 public static Matrix product(Matrix iden,Matrix a){

    long n11=((iden.c11*a.c11)+(iden.c12*a.c21))%MOD;
    long n12=((iden.c11*a.c12)+(iden.c12*a.c22))%MOD;
    long n21=((iden.c21*a.c11)+(iden.c22*a.c21))%MOD;
    long n22=((iden.c21*a.c12)+(iden.c22*a.c22))%MOD;

    return new Matrix(n11,n12,n21,n22);
 }

}
