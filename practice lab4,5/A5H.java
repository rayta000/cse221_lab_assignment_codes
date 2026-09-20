import java.io.*;
import java.util.*;

public class A5H {
    static boolean[][]vis;
    static char[][]adj;
   public static void main (String[]args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(System.out);

    StringTokenizer rh=new StringTokenizer(br.readLine());

    int R=Integer.parseInt(rh.nextToken());
    int H=Integer.parseInt(rh.nextToken());

    adj=new char[R][];
    vis=new boolean[R][H];
    int bestD=0;

    for(int i=0;i<R;i++){ 
        adj[i]=br.readLine().toCharArray();
    }

    for(int r=0;r<adj.length;r++){
        for(int c=0;c<adj[0].length;c++){ 
            if(!vis[r][c] && adj[r][c]!='#'){ 
                int D=BFS(r,c,R,H);
                bestD=Math.max(bestD,D);
            }
        }
    }

    pw.println(bestD);
    pw.flush();

   }
   
   public static int BFS(int r,int c,int R,int H){
    int[]dr={-1,0,0,1};
    int[]dc={0,1,-1,0};

    Queue<int[]> q=new LinkedList<>();
    q.add(new int[]{r,c});
    int diamond=0;

    while(!q.isEmpty()){
        int[]v=q.remove();
        int rr=v[0];
        int cc=v[1];

        if(adj[rr][cc]=='D'){
        diamond++;
        }

        boolean isValid=false;
        vis[rr][cc]=true;

        for(int d=0;d<4;d++){ 
            int nr=rr+dr[d];
            int nc=cc+dc[d];

            if(nr>-1 && nr<R && nc>-1 && nc<H){
                isValid=true;
            }
            else{
                isValid=false;
            }

            if(isValid && !vis[nr][nc] && adj[nr][nc]!='#'){
                vis[nr][nc]=true;
                q.add(new int[]{nr,nc});
            }
        }   
    }
    return diamond;

   }
}
