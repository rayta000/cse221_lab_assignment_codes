
import java.io.*;
import java.util.*;

public class dcQues4 {//prblm with the logic of binary search
 public static void main (String[]args) throws Exception{
    BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new FileWriter("1000054838.out"));

    int N=Integer.parseInt(bw.readLine().trim());
    StringTokenizer st=new StringTokenizer(bw.readLine());

    ArrayList<Integer> a=new ArrayList<>();
    for(int i=0;i<N;i++){
        a.add(Integer.parseInt(st.nextToken()));
    }
    bw.close();
    int l=0;
    int r=N-1;
    while(l<r){
        int mid=(l+r)/2;
        if(a.get(mid)%2!=0){
            l=mid+1;
        }
        else{
            r=mid;
        }
    }
    if(a.get(l)%2!=0){
      pw.println(N+" "+0);  
    }
    else{
      pw.println(l+" "+(N-l));  
    }
    pw.close();
 }   
}
