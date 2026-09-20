import java.io.*;
import java.util.*;
public class H {
    public static void main (String[]args) throws Exception{ 
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer s=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(s.nextToken());
        String from=s.nextToken();
        String to=s.nextToken();

        boolean[][]connect=new boolean[26][26];

        int source=(from.charAt(from.length()-1))-'A';
        int des=(to.charAt(0))-'A';

        for(int i=0;i<N;i++){ 
            String a=br.readLine();
            int f=(a.charAt(0)-'A');
            int d=(a.charAt(a.length()-1)-'A');
            connect[f][d]=true;
        }

        if(from.equals(to)){
            pw.println("YES");
            pw.flush();
            return;
        }
        ///BFS
        Queue<Integer> q=new LinkedList<>();
        boolean[]vis=new boolean[26];
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
