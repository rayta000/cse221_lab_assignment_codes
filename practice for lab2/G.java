import java.io.*;
import java.util.*;
public class G {
 public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st1=new StringTokenizer(br.readLine());
        StringTokenizer st2=new StringTokenizer(br.readLine());

        int L=Integer.parseInt(st1.nextToken());
        int K=Integer.parseInt(st1.nextToken());

        int [] a=new int[L];

        int idx=0;
        long max_sum=0;
        int min_sum=Integer.MIN_VALUE;
        while(st2.hasMoreElements()){
            int n=Integer.parseInt(st2.nextToken());
            if(n>min_sum){
                min_sum=n;
            }
            max_sum+=n;
            a[idx]=n;
            idx++;
        }

        long l=min_sum;
        long r=max_sum;
        long res=0;
        while(l<=r){
            long mid=(l+r)/2;
            if(canSplit(a,mid,K)){
                res=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        pw.println(res);
        pw.flush();

    }

    public static boolean canSplit(int[]a,long m,int k){
        long sum=0;
        int count=1;
        int p=0;
        while(p<a.length){
            int val=a[p];
            if(p==0){
                sum+=val;
                p++;
            }
            else if(sum+val>m){
                count++;
                sum=a[p];
                p++;
            }
            else{
                sum+=val;
                p++;
            }
        }

        if(count<=k){
            return true;
        }
        else{
            return false;
        }
    }
}


