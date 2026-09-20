import java.io.*;
import java.util.*;

public class G {
    static int[]inorder;
    static int[]preorder;
    static int[]index;
    static PrintWriter pw=new PrintWriter(System.out);
  public static void main(String[]args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    int N=Integer.parseInt(br.readLine());

    StringTokenizer st1=new StringTokenizer(br.readLine());
    StringTokenizer st2=new StringTokenizer(br.readLine());

    index=new int[N+1];
    inorder=new int[N];
    preorder=new int[N];

    int idx=0;
    while(st1.hasMoreElements()){
        inorder[idx]=Integer.parseInt(st1.nextToken());
        index[inorder[idx]]=idx;
        idx++;
    }

    idx=0;
    while(st2.hasMoreElements()){
        preorder[idx]=Integer.parseInt(st2.nextToken());
        idx++;
    }

    postOrder(0,N-1,0,N-1);
    pw.println();

    pw.flush();
  }
  
  public static void postOrder(int inL,int inR,int preL,int preR){
    if(inL>inR){
        return;
    }
    int root=preorder[preL];
    int idxAtInoder=index[root];
    int size=idxAtInoder-inL;

    //leftsubtree
    postOrder(inL,idxAtInoder-1,preL+1,preL+size);
    //rightsubtree
    postOrder(idxAtInoder+1,inR,preL+size+1,preR);

    pw.print(root+" ");
  }
}
