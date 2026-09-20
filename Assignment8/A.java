import java.io.*;
import java.util.*;

public class A {
    static int[]parent;
    static int[]size;

    static int find(int x){ 
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    static int union(int a,int b){
        a=find(a);
        b=find(b);
        if(a==b){ 
            return size[a];
        }
        if(size[a]<size[b]){ 
            int temp=a;
            a=b;
            b=temp;
        }
        parent[b]=a;
        size[a]+=size[b];
        return size[a];
    }
    
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        parent=new int[n+1];
        size=new int[n+1];

        for(int i=1;i<=n;i++){ 
            parent[i]=i;
            size[i]=1;
        }

        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int ans=union(a,b);
            pw.println(ans);
        }

        pw.flush();
    }
}
