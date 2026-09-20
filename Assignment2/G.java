import java.io.*;
import java.util.*;
public class G {
  public static void main (String[]args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(System.out);
    StringTokenizer st1=new StringTokenizer(br.readLine());
    StringTokenizer st2=new StringTokenizer(br.readLine());

    int N=Integer.parseInt(st1.nextToken());
    int K=Integer.parseInt(st1.nextToken());

    long [] a=new long[N];

    long l=0;
    long r=0;

    int idx=0;
    while(st2.hasMoreElements()){
        long num=Long.parseLong(st2.nextToken());
        if(num>l){
            l=num;
        }
        r+=num;
        a[idx]=num;
        idx++;
    }

    long result=0;

    while(l<=r){
        long mid=(l+r)/2;
        if(canSplit(a,K,mid)){
            result=mid;
            r=mid-1;
        }
        else{
            l=mid+1;
        }
    }

    pw.println(result);
    pw.flush();
  }
  
  public static boolean canSplit(long[]a ,int k, long m){
    long sum=0;
    int count=1;
    int l=0;

    while(l<a.length){
        long val=a[l];
        if(l==0){
            sum+=val;
            l++;
        }
        else if(sum+a[l]>m){
            count++;
            sum=a[l];
            l++;
        }
        else{
            sum+=a[l];
            l++;
        }
    }

    if(count<=k){
        return true;
    }
    return false;
    
  }

}
