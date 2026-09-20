import java.io.*;
import java.util.*;
public class C {
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int N=Integer.parseInt(br.readLine());
        int [] arr=new int[N];

        StringTokenizer st1=new StringTokenizer(br.readLine());

        int i=0;
        while(st1.hasMoreElements()){
            arr[i]=Integer.parseInt(st1.nextToken());
            i++;
        }

        int M=Integer.parseInt(br.readLine());
        int [] arr1=new int[M];

        StringTokenizer st2=new StringTokenizer(br.readLine());

        i=0;
        while(st2.hasMoreElements()){
            arr1[i]=Integer.parseInt(st2.nextToken());
            i++;
        }

        int[]r=new int[M+N];
        int p1=0,p2=0;
        int j=0;

        while(p1<N && p2<M){
            if(arr[p1]<arr1[p2]){
                r[j]=arr[p1];
                j++;
                p1++;
            }
            else{
                r[j]=arr1[p2];
                j++;
                p2++; 
            }
        }

        while(p1<N){
            r[j]=arr[p1];
            p1++;
            j++;
        }

        while(p2<M){
            r[j]=arr1[p2];
            p2++;
            j++;
        }

        for(int p=0;p<(N+M);p++){
            if(p==(N+M)-1){
                pw.println(r[p]);
            }
            else{
                pw.print(r[p]+" ");
            }
        }

        pw.flush();

    }
}
