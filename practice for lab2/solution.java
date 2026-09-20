import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = null;
        StringTokenizer st1= null;
        int test, n, s;
        test = Integer.parseInt(br.readLine());
        int t=0;
        while (t<test) {
            st = new StringTokenizer(br.readLine());
            st1 = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // input
            s = Integer.parseInt(st.nextToken()); // input
            
            int [] a=new int [n];

            int idx=0;
            while(st1.hasMoreElements()){
                a[idx]=Integer.parseInt(st1.nextToken());
                idx++;
            }

            int p1=0;
            int p2=p1+1;
            int p3=n-1;
            boolean flag=false;

            while(p1<n){
                while(p2<p3){
                    long sum=a[p1]+a[p2]+a[p3];
                    if(sum==s){
                        pw.println((p1+1)+" "+(p2+1)+" "+(p3+1));
                        flag=true;
                        break;
                    }

                    if(sum<s){
                        p2++;
                    }
                    else{
                        p3--;
                    }
                }
                if(flag){
                    break;
                }
                p1++;
            }

            if(flag==false){
                pw.println(-1);
            }

            t++;
        }
        pw.flush();
        System.exit(0);
    }
}
