import java.io.*;
import java.util.*;

public class E {
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

        int [] freq=new int[N+1];

        int l=0;
        int r=0;
        int distinct=0;
        int best=0;

        while(r<N){

            if(freq[a[r]]==0){
                freq[a[r]]++;
                distinct++;
            }
            else{
              freq[a[r]]++;  
            }
            while(distinct>K){ 
                freq[a[l]]--;
                if(freq[a[l]]==0){
                    distinct--;
                }
                l++;
            }
            int len=(r-l)+1;
            if(len>best && distinct<=K){
                best=len;
            }
            r++;  
        }
        
        pw.println(best);
        pw.flush();

    }    
}
