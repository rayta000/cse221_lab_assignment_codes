import java.io.*;
import java.util.*;

public class F {
  public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st1=new StringTokenizer(br.readLine());
        
        int len=Integer.parseInt(st1.nextToken());

        Long[]a=new Long[len];

        int T=Integer.parseInt(st1.nextToken());

        StringTokenizer st2=new StringTokenizer(br.readLine());

        int idx=0;
        while(st2.hasMoreElements()){
            a[idx]=Long.parseLong(st2.nextToken());
            idx++;
        }

        while(T-->0){

           StringTokenizer st3=new StringTokenizer(br.readLine());

           long min=Long.parseLong(st3.nextToken());
           long max=Long.parseLong(st3.nextToken());

           int lb=lower(a,0,a.length-1,min);
           int up=upper(a,0,a.length-1,max);

           int count=(up-lb)+1;

           if(count<=0){
            pw.println(0);
           }
           else{
            pw.println(count);
           }

           pw.flush();
        }   
    }

    public static int lower(Long[]a,int l,int r,long tgt){
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

    public static int upper(Long[]a,int l,int r,long tgt){
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
}
