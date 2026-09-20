import java.io.*;
import java.util.*;
public class F {
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

    for(int i=0; i<N; i++){ 
        for(int j=0; j<N-1; j++){
            if(arr[j]%2==0 && arr[j+1]%2==0){
                if(arr[j]>arr[j+1]){
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
            else if(arr[j]%2!=0 && arr[j+1]%2!=0){
                if(arr[j]>arr[j+1]){
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                }
            }
        }
    }

    for(int p=0;p<N;p++){
        if(p==N-1){
            pw.println(arr[p]);
        }
        else{
            pw.print(arr[p]+" ");
        }
    }
    
    pw.flush();
 }   
}