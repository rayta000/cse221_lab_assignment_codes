import java.io.*;
import java.util.*;

public class H {
    static boolean[][] vis;
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer s=new StringTokenizer(br.readLine());

        int R=Integer.parseInt(s.nextToken());
        int H=Integer.parseInt(s.nextToken());

        char[][]grid=new char[R][];

        for(int i=0;i<R;i++){  
            grid[i]=br.readLine().toCharArray();
        }
        vis=new boolean[R][H];
        int bestD=0;

        for(int r=0;r<R;r++){
            for(int c=0;c<H;c++){
                if(!vis[r][c] && grid[r][c]!='#'){
                    int D=BFS(grid,r,c,R,H);
                    bestD=Math.max(bestD,D);
                }
            }
        }

        pw.println(bestD);
        pw.flush();

    }

    public static int BFS(char[][]grid,int r,int c,int R,int H){
        int [] dr={-1,1,0,0};
        int [] dc={0,0,-1,1};

        Queue<int[]> q=new LinkedList<>();
        vis[r][c]=true;
        q.add(new int[]{r,c});

        int Dcount=0;
        boolean isValid=false;


        while(!q.isEmpty()){
            int[]cell=q.remove();
            int row=cell[0];
            int col=cell[1];

            
            if(grid[row][col]=='D'){
                Dcount++;
            }

            for(int direction=0;direction<4;direction++){
                int new_r=row+dr[direction];
                int new_c=col+dc[direction];

                if(new_r>=0 && new_r< R && new_c>=0 && new_c< H){
                    isValid=true;
                }
                else{
                  isValid=false;  
                }

                if(isValid && grid[new_r][new_c]!='#' && vis[new_r][new_c]==false){
                    q.add(new int[]{new_r,new_c});
                    vis[new_r][new_c]=true;
                }
            }

        }
        return Dcount;
    }
}
