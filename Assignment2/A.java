import java.io.*;
import java.util.*;
public class A{
    public static void main(String[]args) throws Exception{
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pw=new PrintWriter(System.out);
       StringTokenizer st1=null;

       st1=new StringTokenizer(br.readLine());

       int N=Integer.parseInt(st1.nextToken());
       int S=Integer.parseInt(st1.nextToken());
        
       StringTokenizer st2=null;
       st2=new StringTokenizer(br.readLine());

       int [] num=new int[N];

       int idx=0;
       while(st2.hasMoreTokens()){
        num[idx]=Integer.parseInt(st2.nextToken());
        idx++;
       }

       int h=N-1,l=0;
       boolean flag=false;

       while(l<h){
        int sum=num[l]+num[h];
        if(sum==S){
            pw.println((l+1)+" "+(h+1));
            flag=true;
            break;
        }
        else if(sum<S){
            l++;
        }
        else{
            h--;
        }
       }

       if(flag==false){
        pw.println("-1");
       }

       pw.flush();
    }
}