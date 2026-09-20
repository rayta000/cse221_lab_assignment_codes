import java.io.*;
import java.util.*;
public class F {
 public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st1=new StringTokenizer(br.readLine());
        StringTokenizer st2=new StringTokenizer(br.readLine());

        int L=Integer.parseInt(st1.nextToken());
        int T=Integer.parseInt(st1.nextToken());

        long [] a=new long[L];

        int idx=0;
        while(st2.hasMoreElements()){
            a[idx]=Long.parseLong(st2.nextToken());
            idx++;
        }

        while(T-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            long low=Long.parseLong(st.nextToken());
            long high=Long.parseLong(st.nextToken());

            int count=(higher(a,high)-lower(a,low))+1;

            if(count<=0){
              pw.println(0);  
            }
            else{
            pw.println(count);
            }
            pw.flush();
        }
    }
    
    public static int higher(long[] a,long tgt){
        int l=0;
        int r=a.length-1;
        int result=-1;

        while(l<=r){
            int mid=(l+r)/2;
            if(a[mid]<=tgt){
                result=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return result;
    }

    public static int lower(long[] a,long tgt){
        int l=0;
        int r=a.length-1;
        int result=a.length;

        while(l<=r){
            int mid=(l+r)/2;
            if(a[mid]>=tgt){
                result=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return result;
    }
}

