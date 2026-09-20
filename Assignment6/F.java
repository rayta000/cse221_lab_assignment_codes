import java.io.*;
import java.util.*;

public class F {
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        StringTokenizer s=new StringTokenizer(br.readLine());

        int source=Integer.parseInt(s.nextToken());
        int des=Integer.parseInt(s.nextToken());

        int num=Integer.parseInt(br.readLine());

        boolean [] invalid=new boolean[10000];
        for(int i=0;i<num;i++){ 
            int n=Integer.parseInt(br.readLine());
            invalid[n]=true;
        }

        int[]dis=new int[10000];
        int[]vis=new int[10000];
        Arrays.fill(dis,-1);
        Queue<Integer> q=new LinkedList<>();

        q.add(source);
        dis[source]=0;
        vis[source]=1;

        while(!q.isEmpty()){
            int u=q.remove();
            vis[u]=1;
            if(u==des){
                break;
            }

            int[]digit=new int[4];
            int temp=u;
            for(int i=3;i>-1;i--){ 
                digit[i]=temp%10;
                temp=temp/10;
            }

            for(int pos=0;pos<4;pos++){ 
                int newDigit=digit[pos]+1;
                if(newDigit==10){
                    newDigit=0;
                }
                check(digit,pos,newDigit,invalid,dis,u,q,vis);
                newDigit=digit[pos]-1;
                if(newDigit==-1){
                    newDigit=9;
                }
                check(digit,pos,newDigit,invalid,dis,u,q,vis);
            }
        }

        pw.println(dis[des]);
        pw.flush();
    }
    
    public static void check(int[]digit,int pos,int newDigit,boolean[]invalid,int[]dis,int u,Queue<Integer> q,int[]vis){ 
        int[]store=new int[4];
        for(int i=0;i<4;i++){
            store[i]=digit[i];
        }
        store[pos]=newDigit;
        int d=store[0]*1000+store[1]*100+store[2]*10+store[3];

        if(!invalid[d] && vis[d]==0){ 
            dis[d]=dis[u]+1;
            q.add(d);
            vis[d]=1;
        }
    }
}
