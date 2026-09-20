import java.io.*;
public class H {

   public static class Train{
      String line;
      String name;
      String time;
      Integer min;

      public Train(String l){
         line=l;
         String [] fragment=l.split(" ");
         name=fragment[0];
         time=fragment[fragment.length-1];
         String [] timeInMin=time.split(":");
         min=Integer.parseInt(timeInMin[0])*60 + Integer.parseInt(timeInMin[1]);
      }
   }
 public static void main (String[]args) throws Exception{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw=new PrintWriter(System.out);
    int N=Integer.parseInt(br.readLine());
    
    Train [] t=new Train[N];

    for(int i=0;i<N;i++){
      t[i]=new Train(br.readLine());
    }

    //bubble sort 
    for(int i=0;i<N-1;i++){
      for(int j=0;j<N-1-i;j++){

         int condition1=t[j].name.compareTo(t[j+1].name);
         int condition2=t[j].min.compareTo(t[j+1].min);

         if(condition1>0){
            Train temp=t[j];
            t[j]=t[j+1];
            t[j+1]=temp;
         }
         else if(condition1==0){
            if(condition2<0){
               Train temp=t[j];
               t[j]=t[j+1];
               t[j+1]=temp;
            }
         }

      }
    }

    for(int i=0;i<t.length;i++){ 
      pw.println(t[i].line);
    }

    pw.flush();
 }   
}
