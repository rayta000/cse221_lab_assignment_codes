import java.io.*;
import java.util.*;

public class C{
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int L1=Integer.parseInt(br.readLine());
        StringTokenizer st1=new StringTokenizer(br.readLine());
        int L2=Integer.parseInt(br.readLine());
        StringTokenizer st2=new StringTokenizer(br.readLine());
        

        double [] a1=new double[L1+1];
        double [] a2=new double[L2+1];

        int idx=0;
        while(st1.hasMoreTokens()){
            a1[idx]=Double.parseDouble(st1.nextToken());
            idx++;
        }
        a1[idx]=Double.POSITIVE_INFINITY;

        idx=0;
        while(st2.hasMoreTokens()){
            a2[idx]=Double.parseDouble(st2.nextToken());
            idx++;
        }
        a2[idx]=Double.POSITIVE_INFINITY;

        double [] result=new double[a1.length+a2.length];
        
        int l=0,r=0;

        int i=0;
        while(l<a1.length && r<a2.length){
            if(a1[l]<a2[r]){
                result[i]=a1[l];
                i++;
                l++;
            }
            else{
                result[i]=a2[r];
                i++;
                r++;
            }
        }

        for(int j=0;j<result.length;j++){
            if(j==result.length-1){
                pw.println();
            }
            else if(result[j]==Double.POSITIVE_INFINITY){
                continue;
            }
            else{
              pw.print((int)result[j]+" ");  
            }
        }

        pw.flush();

    }
}
