import java.io.*;
import java.util.*;

public class B {
   public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer nm=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(nm.nextToken());
        int M=Integer.parseInt(nm.nextToken());

        ArrayList<Integer> [] adj=new ArrayList[N];

        for(int i=0;i<N;i++){  
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            StringTokenizer hr=new StringTokenizer(br.readLine());
            int H=Integer.parseInt(hr.nextToken());
            int R=Integer.parseInt(hr.nextToken());
            adj[H-1].add(R-1);
            adj[R-1].add(H-1);
        }

        int [] colour=new int[N];
        int [] vis=new int[N];
        Arrays.fill(colour,-1);
        Arrays.fill(vis,-1);

        Queue<Integer> q=new LinkedList<>();
        int answer=0;

        for(int i=0;i<N;i++){

            if(vis[i]==-1){

                int robot=0;
                int human=0;
                q.add(i);
                colour[i]=0; //0-->human 1-->robot
                human++;

                while(!q.isEmpty()){ 
                    int u=q.remove();
                    vis[u]=1;
                    for(int j=0;j<adj[u].size();j++){ 
                        int v=adj[u].get(j);
                        if(colour[v]==-1){
                            colour[v]=1-colour[u];
                            q.add(v);
                            if(colour[v]==1){
                                robot++;
                            }
                            else{
                                human++;
                            }
                        }
                    }
                }

                answer+=Math.max(robot,human);
            }
        }

        pw.println(answer);
        pw.flush();
    } 
}
