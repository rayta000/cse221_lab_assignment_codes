import java.io.*;
import java.util.*;

public class A {
    public static void main (String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st1=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st1.nextToken());
        int M=Integer.parseInt(st1.nextToken());

        int[][]result=new int[N][N];

        while(M-->0){
            StringTokenizer st2=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st2.nextToken());
            int v=Integer.parseInt(st2.nextToken());
            int w=Integer.parseInt(st2.nextToken());

            result[u-1][v-1]=w;
        }

        for(int r=0;r<result.length;r++){
            for(int c=0;c<result[0].length;c++){
                pw.print(result[r][c]+" ");
            }
            pw.println();
        }

        pw.flush();
    }
}
