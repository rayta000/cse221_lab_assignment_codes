import java.io.*;
import java.util.*;

public class H {

    public static int gcd(int a,int b){
        
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }

   public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int Q=Integer.parseInt(st.nextToken());

        ArrayList [] adjList=new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            adjList[i]=new ArrayList<>();
        }

        for(int j=1;j<=N;j++){
            for(int i=j+1;i<=N;i++){
                if(gcd(j,i)==1){
                    adjList[j].add(i);
                    adjList[i].add(j);
                }
            }
        }

        while(Q-->0){
            StringTokenizer q=new StringTokenizer(br.readLine());
            int idx=Integer.parseInt(q.nextToken());
            int kth=Integer.parseInt(q.nextToken());

            if(kth<=adjList[idx].size()){
                pw.println(adjList[idx].get(kth-1));
            }
            else{
                pw.println(-1);
            }
        }

        pw.flush();
    } 
}
