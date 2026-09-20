import java.io.*;
import java.util.*;

public class G {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        boolean[][]pos=new boolean[N][M];
        ArrayList<int[]>knights=new ArrayList<>();

        int r=0;
        while(r<K){
            StringTokenizer s=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(s.nextToken());
            int y=Integer.parseInt(s.nextToken());
            knights.add(new int[]{x-1,y-1});
            pos[x-1][y-1]=true;
            r++;
        }
        
        int[]dr={1,1,-1,-1,2,2,-2,-2};
        int[]dc={2,-2,2,-2,1,-1,1,-1};

        boolean matched=false;
        for(int p=0;p<K;p++){
            int[]kngt=knights.get(p);
            int r1=kngt[0];
            int c1=kngt[1];
            for(int l=0;l<8;l++){
                int nr=(r1+dr[l]);
                int nc=(c1+dc[l]);
                if(nr>=0 && nr<N && nc>=0 && nc<M && pos[nr][nc]==true){
                    matched=true;
                    break;
                }
            }
        }

        if(matched){
            pw.println("YES");
        }
        else{
            pw.println("NO");
        }
        
        pw.flush();
    }
}
