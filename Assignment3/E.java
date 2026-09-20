import java.io.*;
import java.util.*;

public class E {
    static long m;
    public static void main (String[]args) throws Exception{
    BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(System.out);
    StringTokenizer st=null;

    int T=Integer.parseInt(br.readLine());
    

    int t=0;
    while(t<T){
        st=new StringTokenizer(br.readLine());

        long a=Long.parseLong(st.nextToken());
        long n=Long.parseLong(st.nextToken());
        m=Long.parseLong(st.nextToken());

        pw.println(seriesSum(a,n)[1]);
        t++;
    }
        pw.flush();
    }

    public static long[] seriesSum(long a,long n){
      if(n==0){
        return new long[]{1,0};
      }
       long half=n/2;
       long [] smallerResult=seriesSum(a,half);
       
       long powerAtHalf=smallerResult[0];
       long sumAtHalf=smallerResult[1];

       long power=(powerAtHalf * powerAtHalf)%m;
       long sum=(sumAtHalf*(1+powerAtHalf))%m;

       if(n%2!=0){
        power=(power*a)%m;
        sum=(sum+power)%m;
       }

       return new long[]{power,sum};
    }


}

