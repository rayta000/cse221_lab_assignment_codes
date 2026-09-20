import java.io.*;
import java.util.*;
public class E {
 public static void main (String[]args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(System.out);
    StringTokenizer st=null;
    int N=Integer.parseInt(br.readLine());

    int [] arr=new int[N];

    st=new StringTokenizer(br.readLine());
    int idx=0;
    while(st.hasMoreElements()){
        arr[idx]=Integer.parseInt(st.nextToken());
        idx++;
    }

    ArrayList<String> m=new ArrayList<>();
    int count=0;

    
    for(int j=0;j<N;j++){

        for(int i=0;i<N-2;i++){

            if(arr[i]>arr[i+2]){
                int t=arr[i];
                arr[i]=arr[i+2];
                arr[i+2]=t;
                count++;
                m.add((i+1)+" "+(i+3));
            }
        }
    }
    

    boolean flag=true;

    for(int i=0;i<N-1;i++){
        if(arr[i]>arr[i+1]){
            flag=false;
            break;
        }
    }

    if(flag){
        pw.println("YES");
        pw.println(count);
        int i=0;
        while(i<m.size()){
            pw.println(m.get(i));
            i++;
        }
    }
    else{
      pw.println("NO");  
    }
    pw.flush();
 }  
}
