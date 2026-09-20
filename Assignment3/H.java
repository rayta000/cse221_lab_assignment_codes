import java.io.*;
import java.util.*;

public class H {
    static int[]inorder;
    static int[]postorder;
    static int[]index;
    static PrintWriter pw=new PrintWriter(System.out);
  public static void main(String[]args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    int N=Integer.parseInt(br.readLine());

    StringTokenizer st1=new StringTokenizer(br.readLine());
    StringTokenizer st2=new StringTokenizer(br.readLine());

    index=new int[N+1];
    inorder=new int[N];
    postorder=new int[N];

    int idx=0;
    while(st1.hasMoreElements()){
        inorder[idx]=Integer.parseInt(st1.nextToken());
        index[inorder[idx]]=idx;
        idx++;
    }

    idx=0;
    while(st2.hasMoreElements()){
        postorder[idx]=Integer.parseInt(st2.nextToken());
        idx++;
    }

    preOrder(0,N-1,0,N-1);
    pw.println();

    pw.flush();
  }
  
  public static void preOrder(int inL,int inR,int posL,int posR){
    if(inL>inR){
        return;
    }
    int root=postorder[posR];
    int idxAtInorder=index[root];
    int size=idxAtInorder-inL;

    pw.print(root+" ");

    //leftsubtree
    preOrder(inL,idxAtInorder-1,posL,posL+size-1);

    //rightsubtree
    preOrder(idxAtInorder+1,inR,posL+size,posR-1);

  } 
}
