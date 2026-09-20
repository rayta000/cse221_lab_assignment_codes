import java.io.*;
import java.util.*;

public class B {
   public static void main (String[]args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(System.out);
    StringTokenizer st=null;
    int T=Integer.parseInt(br.readLine());

    for(int i=0;i<T;i++){
        String [] r=new String[4];
        st=new StringTokenizer(br.readLine());
        int idx=0;
        while(st.hasMoreTokens()){
            r[idx]=st.nextToken();
            idx++;
        }
        if(r[2].equals("+")){
            int result=Integer.parseInt(r[1]) + Integer.parseInt(r[3]);
            pw.println(result);
        }
        else if(r[2].equals("-")){
            int result=Integer.parseInt(r[1]) - Integer.parseInt(r[3]);
            pw.println(result);
        }
        else if(r[2].equals("*")){
           long result=Long.parseLong(r[1]) * Long.parseLong(r[3]);
            pw.println(result); 
        }
        else if(r[2].equals("/")){
           double result=Double.parseDouble(r[1]) / Double.parseDouble(r[3]);
            pw.println(result); 
        }
        else if(r[2].equals("%")){
           double result=Double.parseDouble(r[1]) % Double.parseDouble(r[3]);
            pw.println(result); 
        }
        else if(r[2].equals("|")){
           long result=Long.parseLong(r[1]) | Long.parseLong(r[3]);
            pw.println(result); 
        }
        else if(r[2].equals("&")){
           long result=Long.parseLong(r[1]) & Long.parseLong(r[3]);
            pw.println(result); 
        }
        else if(r[2].equals("^")){
           long result=Long.parseLong(r[1]) ^ Long.parseLong(r[3]);
            pw.println(result); 
        }
        else if(r[2].equals("<<")){
           long result=Long.parseLong(r[1]) << Long.parseLong(r[3]);
            pw.println(result); 
        }
        else if(r[2].equals(">>")){
           long result=Long.parseLong(r[1]) >> Long.parseLong(r[3]);
            pw.println(result); 
        }
    }
    
    pw.flush();
   } 
}
