import java.io.*;
import java.util.*;

public class E {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st1=new StringTokenizer(br.readLine());
        StringTokenizer st2=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st1.nextToken());
        int K=Integer.parseInt(st1.nextToken());

        int[]arr=new int[N];

        int idx=0;
        while(st2.hasMoreElements()){
            arr[idx]=Integer.parseInt(st2.nextToken());
            idx++;
        }

        int [] frq=new int[N+1];

        int r=0;
        int l=0;
        int max=Integer.MIN_VALUE;
        int distinct=0;

        while(r<N){
          if(frq[arr[r]]==0){
            distinct++;
            frq[arr[r]]++;
          }
          else{
            frq[arr[r]]++;
          }
          while(distinct>K){
            frq[arr[l]]--;
            if(frq[arr[l]]==0){
                distinct--;
            }
            l++;
          }
          int best=(r-l)+1;
          if(best>max){
            max=best;
          }
          r++;
        }

        pw.println(max);
        pw.flush();
    } 
}
