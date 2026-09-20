import java.io.*;
import java.util.*;

public class F {
   static PrintWriter pw=new PrintWriter(System.out);
   public static void main (String[]args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=null;
    int N=Integer.parseInt(br.readLine());
    st=new StringTokenizer(br.readLine());

    
    int [] tree=new int[N];
    int idx=0;
    while(st.hasMoreElements()){
        tree[idx]=Integer.parseInt(st.nextToken());
        idx++;
    }

    int l=0;
    int h=tree.length-1;

    minHeightTree(tree,l,h);
    pw.println();

    pw.flush();
    
   }
   
   public static void minHeightTree(int[]t,int l,int h){
    if(l>h){
        return;
    }
    if(l==h){
        pw.print(t[l]+" ");
        return;
    }
    int mid=(l+h)/2;
    pw.print(t[mid]+" ");
    minHeightTree(t,l,mid-1);
    minHeightTree(t,mid+1,h);
    return;
   }
}
