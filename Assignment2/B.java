
import java.io.*;
import java.util.*;
public class B {
    public static void main (String[]args) throws Exception{

    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(System.out);

    StringTokenizer st1=new StringTokenizer(br.readLine());
    StringTokenizer st2=new StringTokenizer(br.readLine());
    StringTokenizer st3=new StringTokenizer(br.readLine());

    int N=Integer.parseInt(st1.nextToken());
    int M=Integer.parseInt(st1.nextToken());

    int trgt=Integer.parseInt(st1.nextToken());
    
    int [] a1=new int[N];
    int [] a2=new int[M];
    
    int idx=0;
    while(st2.hasMoreElements()){
        a1[idx]=Integer.parseInt(st2.nextToken());
        idx++;
    }

    idx=0;
    while(st3.hasMoreElements()){
        a2[idx]=Integer.parseInt(st3.nextToken());
        idx++;
    }


    int l=0,h=M-1;
    long diff=Long.MAX_VALUE;
    int b1=0,b2=0;

    while(l<N && h>-1){
        long sum=(long)a1[l]+(long)a2[h];
        long d=Math.abs(sum-trgt);

        if(d<diff){
            diff=d;
            b1=l;
            b2=h;
        }

        if(sum<trgt){
            l++;
        }
        else{
            h--;
        }
        
    }

    pw.println((b1+1)+" "+(b2+1));

    
    pw.flush();

    }   

}
