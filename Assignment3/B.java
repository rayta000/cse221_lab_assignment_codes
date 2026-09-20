import java.io.*;
import java.util.*;

public class B {
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

        inversion+=findInversion(a1,a2);

        int [] a3=merge(a1,a2);
        return a3;
    }

    public static int findInversion(int[]lft,int[]rgt){
        int count=0;
        for(int i=0;i<rgt.length;i++){

            long val=(long)rgt[i]*(long)rgt[i];

            int idx=findIdx(lft,val);

            count+=(lft.length-idx);
        }
        return count;
    }

    public static int findIdx(int[]lft,long tgt){
        int l=0;
        int h=lft.length-1;
        int res=lft.length;
        while(l<=h){
            int mid=(l+h)/2;
            if(lft[mid]>tgt){
                res=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
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
