import java.io.*;
import java.util.*;

public class D {
      public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);


        StringTokenizer st1=new StringTokenizer(br.readLine());
        StringTokenizer st2=new StringTokenizer(br.readLine());
        
        int N=Integer.parseInt(st1.nextToken());
        int K=Integer.parseInt(st1.nextToken());

        int [] a=new int[N];

        int idx=0;
        while(st2.hasMoreElements()){
            a[idx]=Integer.parseInt(st2.nextToken());
            idx++;
        }

        int l=0;
        int r=0;
        int best=0;
        int sum=0;

        while(r<N){
            sum+=a[r];
            while(sum>K){
                sum-=a[l];
                l++;
            }
            int len=(r-l)+1;
            if(len>best && sum<=K){
                best=len;
            }
            r++;
        }
        
        pw.println(best);
        pw.flush();

    } 
}
