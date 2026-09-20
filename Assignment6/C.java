import java.io.*;
import java.util.*;

public class C {
    static int [][] dis;
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int N=Integer.parseInt(br.readLine());
        StringTokenizer s=new StringTokenizer(br.readLine());

        int [][] adj=new int[N][N];
        dis=new int[N][N];
        for(int r=0;r<N;r++){ 
            for(int c=0;c<N;c++){ 
                dis[r][c]=-1;
            }
        }

        int i1=Integer.parseInt(s.nextToken());
        int i2=Integer.parseInt(s.nextToken());
        int f1=Integer.parseInt(s.nextToken());
        int f2=Integer.parseInt(s.nextToken());

        BFS(adj,N,i1,i2,f1,f2);

        pw.println(dis[f1-1][f2-1]);
        pw.flush();
    }

    public static void BFS(int[][]adj,int N,int i1,int i2,int f1,int f2){
        int [] dr={-2,-2,-1,-1,1,1,2,2};
        int [] dc={-1,1,-2,2,-2,2,-1,1};
        boolean[][] vis=new boolean[N][N];

        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{i1-1,i2-1});
        dis[i1-1][i2-1]=0;

        while(!q.isEmpty()){
            int[]cell=q.remove();
            int r=cell[0];
            int c=cell[1];
            vis[r][c]=true;

            for(int i=0;i<8;i++){ 
                int nr=r+dr[i];
                int nc=c+dc[i];
                
                boolean isValid=false;

                if(nr>=0 && nr<N && nc>=0 && nc<N){
                    isValid=true;
                }

                if(isValid && vis[nr][nc]==false){
                    vis[nr][nc]=true;
                    dis[nr][nc]=dis[r][c]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }

    }
}
