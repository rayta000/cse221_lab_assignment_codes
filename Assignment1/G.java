import java.io.*;
import java.util.*;

public class G {
 public static void main (String[]args) throws Exception{

    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(System.out);
    StringTokenizer st1=null;
    StringTokenizer st2=null;

    int T=Integer.parseInt(br.readLine());
    int tc=0;

    while(tc<T){

        int N=Integer.parseInt(br.readLine());

        st1=new StringTokenizer(br.readLine());
        st2=new StringTokenizer(br.readLine());

        int [] id=new int[N];
        int [] mrks=new int[N];

        int idx=0;
        while(st1.hasMoreElements()){
            id[idx]=Integer.parseInt(st1.nextToken());
            mrks[idx]=Integer.parseInt(st2.nextToken());
            idx++;
        }

        int sp=0;

        //Selection sort
        for(int i=0;i<N-1;i++){
            int max=i; //current indx of current maximum number
            for(int j=i;j<N;j++){
                if(mrks[j]>mrks[max]){
                    max=j;
                }
                else if(mrks[max]==mrks[j]){
                    if(id[j]<id[max]){
                        max=j;
                    } 
                }
            }
            if(max!=i){
                int t1=mrks[i];
                int t2=id[i];

                mrks[i]=mrks[max];
                id[i]=id[max];

                mrks[max]=t1;
                id[max]=t2;

                sp++;
            }
        }

        pw.println("Minimum swaps: "+sp);
        for(int i=0;i<N;i++){
            pw.println("ID: "+id[i]+" Mark: "+mrks[i]);
        }

        tc++;
    }
    pw.flush();
 }   
}