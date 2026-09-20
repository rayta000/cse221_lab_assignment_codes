import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        
        StringTokenizer u=new StringTokenizer(br.readLine());
        StringTokenizer v=new StringTokenizer(br.readLine());

        int[] u_connection=new int[N+1];


        for(int i=1;i<=M;i++){
            int u1=Integer.parseInt(u.nextToken());
            int v1=Integer.parseInt(v.nextToken());

            u_connection[u1]+=1;
            u_connection[v1]+=1;
        }
 
        int odd_count=0;

        for(int i=0;i<N;i++){ 
            if(u_connection[i+1]%2!=0){
                odd_count++;
            }
        }

        if(odd_count>2){
            pw.println("NO");
        }
        else{
            pw.println("YES");
        }
        
        pw.flush();
    }
}
