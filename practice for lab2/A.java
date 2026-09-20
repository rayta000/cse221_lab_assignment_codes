import java.io.*;
import java.util.*;

public class A{
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st1=new StringTokenizer(br.readLine());
        StringTokenizer st2=new StringTokenizer(br.readLine());

        int L=Integer.parseInt(st1.nextToken());
        int tgt=Integer.parseInt(st1.nextToken());

        int [] a=new int[L];

        int idx=0;
        while(st2.hasMoreTokens()){
            a[idx]=Integer.parseInt(st2.nextToken());
            idx++;
        }

        int l=0;
        int r=a.length-1;

        boolean flag=false;

        while(l<r){
            int sum=a[l]+a[r];

            if(sum==tgt){
                pw.println((l+1)+" "+(r+1));
                flag=true;
                break;
            }
            else if(sum<tgt){
                l++;
            }
            else{
                r--;
            }
               
        }

        if(flag==false){
            pw.println(-1);
        }

        pw.flush();

    }
}