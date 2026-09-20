import java.io.*;
import java.util.*;

public class A{
    static int [][] dis; 
    public static void main (String[]args) throws Exception{ 
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int N=Integer.parseInt(br.readLine());
        StringTokenizer s=new StringTokenizer(br.readLine());

        int i1=Integer.parseInt(s.nextToken());
        int i2=Integer.parseInt(s.nextToken());
        int f1=Integer.parseInt(s.nextToken());
        int f2=Integer.parseInt(s.nextToken());

        int[][]grid=new int[N][N];
        dis=new int[N][N];
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){ 
                dis[r][c]=-1;
            }
        }

        BFS(grid,i1,i2,f1,f2,N);

        pw.println(dis[f1-1][f2-1]);
        pw.flush();
    }
    public static void BFS(int[][]grid,int i1,int i2,int f1,int f2,int N){ 
        int [] dr={-2,-2,-1,-1,1,1,2,2};
        int [] dc={-1,1,-2,2,-2,2,-1,1};
        boolean [][]vis=new boolean[N][N];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{(i1-1),(i2-1)});
        dis[i1-1][i2-1]=0;
        vis[i1-1][i2-1]=true;

        while(!q.isEmpty()){ 
            int[]cell=q.remove();
            int r=cell[0];
            int c=cell[1];

            for(int i=0;i<8;i++){ 
                int nr=r+dr[i];
                int nc=c+dc[i];

                boolean isValid=false;

                if(nr>=0 && nc<N && nr<N && nc>=0){ 
                    isValid=true;
                }

                if(isValid && !vis[nr][nc]){ 
                    vis[nr][nc]=true;
                    dis[nr][nc]=dis[r][c]+1;
                    q.add(new int[]{nr,nc});
                }
            }
        }
    }
}