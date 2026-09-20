import java.io.*;
import java.util.*;

public class F {
  public static void main(String[]args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(br.readLine());
        boolean [] invalid=new boolean[10000];

        for(int i=0;i<n;i++){ 
            int num=Integer.parseInt(br.readLine());
            invalid[num]=true;
        }

        int source=Integer.parseInt(st.nextToken());
        int des=Integer.parseInt(st.nextToken());

        Queue<Integer> q=new LinkedList<>();
        int[]vis=new int[10000];
        int[]dis=new int[10000];
        Arrays.fill(vis,-1);
        Arrays.fill(dis,-1);

        q.add(source);
        vis[source]=1;
        dis[source]=0;

        while(!q.isEmpty()){ 
            int u=q.remove();

            int[]digit=new int[4];
            int temp=u;
            for(int i=3;i>=0;i--){ 
               digit[i]=temp%10;
               temp=temp/10; 
            }

            for(int pos=0;pos<4;pos++){ 
                int dgt=digit[pos]+1;
                if(dgt==10){ 
                    dgt=0;
                }
                check(vis,dis,u,dgt,pos,q,invalid);

                dgt=digit[pos]-1;
                if(dgt==-1){
                   dgt=9; 
                }
                check(vis,dis,u,dgt,pos,q,invalid);
            }
        }

        pw.println(dis[des]);
        pw.flush();
    }
    
    public static void check(int[]vis,int[]dis,int u,int dgt,int pos,Queue<Integer> q,boolean[]invalid){ 
        int[]newDgt=new int[4];
        int t=u;
        for(int i=3;i>=0;i--){ 
            newDgt[i]=t%10;
            t/=10;
        }
        newDgt[pos]=dgt;
        int num=1000*newDgt[0]+100*newDgt[1]+10*newDgt[2]+newDgt[3];

        if(vis[num]==-1 && !invalid[num]){ 
            vis[num]=1;
            dis[num]=dis[u]+1;
            q.add(num);
        }
    }
}
