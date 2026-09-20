import java.io.*;
import java.util.*;

public class A{
    static long inversion=0;
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        Integer N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());

        int [] a=new int[N];

        int idx=0;
        while(st.hasMoreElements()){
            a[idx]=Integer.parseInt(st.nextToken());
            idx++;
        }

        int [] r=mergeSrt(a,0,a.length-1);

        pw.println(inversion);

        for(int i=0;i<r.length;i++){
            if(i==r.length-1){
                pw.println(r[i]);
            }
            else{
                pw.print(r[i]+" ");
            }
        }
        pw.flush();
    }

    public static int[] mergeSrt(int[]a,int i,int j){
        if(i==j){
            int [] arr=new int[1];
            arr[0]=a[i];
            return arr;
        }
        int mid=(i+j)/2;
        int [] a1=mergeSrt(a,i,mid);
        int [] a2=mergeSrt(a,mid+1,j);
        int [] a3=merge(a1,a2);
        return a3;
    }

    public static int[] merge(int[]a,int[]b){
        int l=0;
        int h=0;
        int [] m=new int[a.length+b.length];
        int pointer=0;
        while(l<a.length && h<b.length){
            if(a[l]<=b[h]){
                m[pointer]=a[l];
                pointer++;
                l++;
            }
            else{
                m[pointer]=b[h];
                pointer++;
                h++;
                inversion+=(a.length-l);
            }
        }

        while(l<a.length){
            m[pointer]=a[l];
            pointer++;
            l++;
        }

        while(h<b.length){
            m[pointer]=b[h];
            pointer++;
            h++;
        }
        return m;
    }
    
}