import java.io.*;
import java.util.*;

public class B {
    static int[] parent;
    static int[] size;
    public static void main (String[]args) throws Exception{ 
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        Edge [] e=new Edge[M];

        for(int i=0;i<M;i++){ 
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            e[i]=new Edge(u,v,w);
        }

        Arrays.sort(e,(a,b)->a.w-b.w);

        parent=new int[N+1];
        size=new int[N+1];

        for(int i=1;i<=N;i++){ 
            parent[i]=i;
            size[i]=1;
        }

        long cost=0;

        for(int i=0;i<M;i++){ 
            Edge ee=e[i];

            if(union(ee.u,ee.v)){ 
                cost+=ee.w;
            }
        }
        pw.println(cost);
        pw.flush();
    }
    static class Edge{
        int u;
        int v;
        int w;
        Edge(int u,int v,int w){ 
            this.u=u;
            this.v=v;
            this.w=w;
        }
    }
    static int find(int x){ 
        if(parent[x]==x){ 
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    static boolean union(int a,int b){ 
        a=find(a);
        b=find(b);

        if(a==b){
            return false;
        }

        if(size[a]<size[b]){
            int temp=a;
            a=b;
            b=temp;
        }
        parent[b]=a;
        size[a]+=size[b];
    
        return true;
    }
}
