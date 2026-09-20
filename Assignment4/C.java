import java.io.*;
import java.util.*;

public class C {
    public static void main(String[]args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out); 
        
        int N=Integer.parseInt(br.readLine());

        int[][]adjMat=new int[N][N];

        int i=0;
        while(i<N){
            StringTokenizer st=new StringTokenizer (br.readLine());
            int loop=Integer.parseInt(st.nextToken());
            for(int j=0;j<loop;j++){
                adjMat[i][Integer.parseInt(st.nextToken())]=1;
            }
            i++;
        }

        for(int r=0;r<adjMat.length;r++){
            for(int c=0;c<adjMat[0].length;c++){
                pw.print(adjMat[r][c]+" ");
            }
            pw.println();
        }

        pw.flush();


    }
}
