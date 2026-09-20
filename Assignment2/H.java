import java.io.*;
import java.util.*;

public class H {
   public static void main (String [] args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(System.out);
    StringTokenizer st1=new StringTokenizer (br.readLine());
    StringTokenizer st2=new StringTokenizer(br.readLine());

    int n=Integer.parseInt(st1.nextToken());
    long k=Long.parseLong(st1.nextToken());

    int[]a=new int[n];

    int max=Integer.MIN_VALUE;
    int min=1;

    int idx=0;
    while(st2.hasMoreElements()){
        int num=Integer.parseInt(st2.nextToken());
        if(num>max){
            max=num;
        }
        a[idx]=num;
        idx++;
    }
    int res=0;

    while(min<=max){
        int mid=(max+min)/2;
        if(canCut(a,mid,k)){
            res=mid;
            min=mid+1;
        }
        else{
            max=mid-1;
        }
    }

    if(res==0){
      pw.println(-1);  
    }
    else{
    pw.println(res);
    }
    pw.flush();
   }
   
   public static boolean canCut(int[]arr,int m,long K){
    long sum=0;
    for(int i=0;i<arr.length;i++){
        sum+=arr[i]/m;
    }
    if(sum>=K){
        return true;
    }
    return false;
   }

}
