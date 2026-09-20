import java.io.*;
import java.util.*;

public class H{
    public static void main(String[]args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        String s=st.nextToken();
        String d=st.nextToken();

        boolean[][]connect=new boolean[26][26];

        for(int i=0;i<N;i++){ 
            String wrd=br.readLine();
            connect[wrd.charAt(0)-'A'][wrd.charAt(wrd.length()-1)-'A']=true;
        }

        int source=s.charAt(s.length()-1)-'A';
        int des=d.charAt(0)-'A';

        if(source==des){ 
            pw.println("YES");
            pw.flush();
            return;
        }

        ///BFS
        Queue<Integer> q=new LinkedList<>();
        boolean [] vis=new boolean[26];
        q.add(source);
        vis[source]=true;

        while(!q.isEmpty()){  
            int u=q.remove();
            for(int v=0;v<26;v++){ 
                if(connect[u][v] && !vis[v]){ 
                    vis[v]=true;
                    q.add(v);
                }
            }
        }

        if(vis[des]){
            pw.println("YES");
        }
        else{
           pw.println("NO"); 
        }
         
        pw.flush();
    }
}