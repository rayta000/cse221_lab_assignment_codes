import java.io.*;
import java.util.*;

public class I {
    public static void main(String[]args) throws Exception{ 
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int N=Integer.parseInt(br.readLine());
        String [] words=new String[N];

        for(int i=0;i<N;i++){ 
            words[i]=br.readLine();
        }

        boolean[]letters=new boolean[26];
        boolean[][]edge=new boolean[26][26];
        int[]indeg=new int[26];
        
        for(int i=0;i<words.length;i++){
            String w=words[i]; 
            for(int j=0;j<w.length();j++){
                letters[w.charAt(j)-'a']=true;
            }
        }

        for(int i=0;i<N-1;i++){ 
            String a=words[i];
            String b=words[i+1];
            int len=Math.min(a.length(),b.length());

            boolean foundDiff=false;
            for(int j=0;j<len;j++){ 
                char l1=a.charAt(j);
                char l2=b.charAt(j);
                if(l1!=l2){ 
                    int u=l1-'a';
                    int v=l2-'a';
                    if(!edge[u][v]){ 
                        edge[u][v]=true;
                        indeg[v]++;
                    }
                    foundDiff=true;
                    break;
                }
            }

            if(foundDiff==false && a.length()>b.length()){ 
                pw.println(-1);
                pw.flush();
                return;
            }
        }

        //topsrt
        PriorityQueue<Integer> minHp=new PriorityQueue<>();
        int totalLetter=0;

        for(int i=0;i<26;i++){ 
            if(letters[i]){
                totalLetter++;
                if(indeg[i]==0){ 
                    minHp.add(i);
                }
            }
        }

        ArrayList<Character> res=new ArrayList<>();

        while(!minHp.isEmpty()){  
            int u=minHp.remove();
            res.add((char)('a'+ u));

            for(int v=0 ; v<26 ; v++){ 
                if(edge[u][v]){ 
                    indeg[v]--;
                    if(indeg[v]==0){ 
                        minHp.add(v);
                    }
                }
            }
        }

        if(res.size()!=totalLetter){
            pw.println(-1);
        }
        else{ 
            for(int i=0;i<res.size();i++){ 
                pw.print(res.get(i));
            }
        }

        pw.println();
        pw.flush();
    }
}
