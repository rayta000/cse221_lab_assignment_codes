import java.io.*;
import java.util.*;

public class D {
    public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(System.out);
    StringTokenizer st=null;

    int T=Integer.parseInt(br.readLine());

    int c1=0;
    
    while(c1<T){
        int N=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        
        int [] arr=new int[N];
        int idx=0;

        while(st.hasMoreTokens()){
            arr[idx]=Integer.parseInt(st.nextToken());
            idx++;
        }
            
        boolean flag=true;
            
        for(int i=0;i<N-1;i++){
                
            if(arr[i]>arr[i+1]){    
                pw.println("NO");   
                flag=false;
                break;
            }

        }
        if(flag){
          pw.println("YES");
        }
        c1++;
    }
    pw.flush();
    }
}
