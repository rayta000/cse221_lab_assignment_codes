import java.io.*;
import java.util.*;

public class divide02{

    static class values{
        String s;
        int n;
        values(String s,int n){
            this.s=s;
            this.n=n;
        }
    }

    public static void main(String[] args) throws Exception {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(System.out);
    StringTokenizer st=null;

    int N=Integer.parseInt(br.readLine());
    st=new StringTokenizer(br.readLine());

    values []s1=new values[N];

    int idx=0;
    while(st.hasMoreElements()){
        s1[idx]=st.nextToken();
        idx++;
    }

    values result=Divide(length,0,length.length-1);

    pw.println(result);
    pw.flush();

    }

    public static values Divide(String [] s,int i,int j){
        if(i==j){

        }
        int m=(i+j)/2;
        values s1=Divide(s,i,m);
        values s2=Divide(s,m+1,j);

        if()

    }
}
