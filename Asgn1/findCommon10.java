
import java.io.*;
import java.util.*;


public class findCommon10 {
 public static void main(String[] args) throws Exception {
  BufferedReader br=new BufferedReader(new FileReader("inp3.txt"));
    PrintWriter pw=new PrintWriter(new FileWriter("1000054838.out"));
    
    StringTokenizer st=new StringTokenizer(br.readLine());
    
    int N=Integer.parseInt(st.nextToken());
    int M=Integer.parseInt(st.nextToken());
    
    StringTokenizer st1=new StringTokenizer(br.readLine());
    StringTokenizer st2=new StringTokenizer(br.readLine());
    
    int [] a1=new int[N];
    int [] a2= new int[M];
    
    for(int i=0;i<N;i++){
      a1[i]=Integer.parseInt(st1.nextToken());
    }
    for(int i=0;i<M;i++){
      a2[i]=Integer.parseInt(st2.nextToken());
    }
    br.close();
    
    ArrayList<Integer> r=new ArrayList<>();
    int p1=0,p2=0;
    
    while(p1!=a1.length && p2!=a2.length){
      if(a1[p1]==a2[p2]){
        r.add(a1[p1]);
        p1++;
        p2++;
      }
      else if(a1[p1]<a2[p2]){
        p1++;
      }
      else{
        p2++;
      }
    }
    
    for(int i=0;i<r.size();i++){
      if(i==0){
        pw.print(r.get(i)+" ");
      }
      else{
        if(!r.get(i-1).equals(r.get(i))){
          pw.print(r.get(i)+" ");
        }
      }
    }
    pw.println();
    pw.close();   
 }   
}
