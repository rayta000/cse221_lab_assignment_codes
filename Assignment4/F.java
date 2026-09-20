import java.io.*;
import java.util.*;

public class F {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int N=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());

        int i=Integer.parseInt(st.nextToken())-1;
        int j=Integer.parseInt(st.nextToken())-1;

        int[]dr={-1,-1,-1,0,0,1,1,1};
        int[]dc={-1,0,1,-1,1,-1,0,1};

        ArrayList<int[]> valid=new ArrayList<>();

        int count=0;
        for(int m=0;m<8;m++){  
            int nR=i+dr[m];
            int nC=j+dc[m];

            if(nR>=0 && nR<N && nC>=0 && nC<N){
                count=count+1;
                valid.add(new int[]{nR+1,nC+1});
            }

        }

        pw.println(count);
        for(int p=0;p<valid.size();p++){
            int[] m=valid.get(p);
            pw.println(m[0]+" "+m[1]);
        }  

        pw.flush();
    }
}
