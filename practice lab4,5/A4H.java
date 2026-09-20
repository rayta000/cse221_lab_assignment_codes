import java.io.*;
import java.util.*;

public class A4H {
    public static void main (String[]args) throws Exception{
      BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
      
      StringTokenizer s=new StringTokenizer(br.readLine());

      int N=Integer.parseInt(s.nextToken());
      int Q=Integer.parseInt(s.nextToken());

      ArrayList<Integer>[] adj=new ArrayList[N];

      for(int i=0;i<N;i++){
        adj[i]=new ArrayList<>();
      }

      for(int i=0;i<N;i++){ 
            for(int j=i+1;j<N;j++){ 
                if(GCD((i+1),(j+1))==1){
                    adj[i].add(j);
                    adj[j].add(i);
                 }
            }
        }

        int q=0;
        while(q<Q){
            StringTokenizer uv=new StringTokenizer(br.readLine());
            int idx=Integer.parseInt(uv.nextToken());
            int Kth=Integer.parseInt(uv.nextToken());
            if(Kth<=adj[idx-1].size()){
                int k=adj[idx-1].get(Kth-1);
                pw.println((k+1));
            }
            else{
                pw.println(-1);
            }
            q++;
        }

        pw.flush();

    }

    public static int GCD(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}
