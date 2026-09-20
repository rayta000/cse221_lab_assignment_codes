import java.io.*;
public class A{
    public static void main (String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int N=Integer.parseInt(br.readLine());

        for(int j=0;j<N;j++){
            int n=Integer.parseInt(br.readLine());
            if(n%2==0){
                pw.println(n+" is an Even number.");
            }
            else{
               pw.println(n+" is an Odd number."); 
            }
        }
        pw.flush();
    }
}