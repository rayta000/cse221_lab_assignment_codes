import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st1=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st1.nextToken());
        int K=Integer.parseInt(st1.nextToken());

        StringTokenizer st2=new StringTokenizer(br.readLine());

        int [] arr=new int[N];

        int i=0;
        while(st2.hasMoreElements()){
            arr[i]=Integer.parseInt(st2.nextToken());
            i++;
        }
        
        //Sliding Window

        int r=0;
        int l=0;
        int sum=0;
        int best=0;

        while(r<N){ 
            sum+=arr[r]; //it stretches the right portion of the window by summing up the value
            while(sum>K){ //if sum exceeds K,it get reduced by moving the left portion of the window to the right 
                sum-=arr[l];
                l++;
            }
            int len=(r-l)+1;
            if(len>best && len<=K){ //it checks if the new value of length is better than the previous one
                best=len;
            }
            r++;
        }

        pw.println(best);
        pw.flush();
    }
}
