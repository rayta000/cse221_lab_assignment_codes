import java.io.*;
import java.util.*;

public class B{
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st1=new StringTokenizer(br.readLine());
        StringTokenizer st2=new StringTokenizer(br.readLine());
        StringTokenizer st3=new StringTokenizer(br.readLine());

        int L1=Integer.parseInt(st1.nextToken());
        int L2=Integer.parseInt(st1.nextToken());
        int K=Integer.parseInt(st1.nextToken());

        int [] a1=new int[L1];
        int [] a2=new int[L2];

        int idx=0;
        while(st2.hasMoreTokens()){
            a1[idx]=Integer.parseInt(st2.nextToken());
            idx++;
        }

        idx=0;
        while(st3.hasMoreTokens()){
            a2[idx]=Integer.parseInt(st3.nextToken());
            idx++;
        }

        int l=0,r=a2.length-1;
        int b1=0,b2=0;
        long bestDiff=Long.MAX_VALUE;

        while(l<L1 && r>-1){
            long sum=(long)a1[l]+(long)a2[r];
            long diff=Math.abs(sum-K);
            if(diff<bestDiff){
                b1=l;
                b2=r;
                bestDiff=diff;
            }

            if(sum<K){
                l++;
            }
            else{
                r--;
            }
        }

        pw.println((b1+1)+" "+(b2+1));
        pw.flush();

    }
}