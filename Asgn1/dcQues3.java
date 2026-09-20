import java.io.*;
import java.util.*;

public class dcQues3{
    public static void main(String[]args) throws Exception{

        BufferedReader bw = new BufferedReader(new FileReader("inp4.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("1000054838.out"));
        int N = Integer.parseInt(bw.readLine().trim());
        StringTokenizer st = new StringTokenizer(bw.readLine());

        ArrayList<Integer> a=new ArrayList<>();

        for(int i=0;i<N;i++){
            a.add(Integer.parseInt(st.nextToken()));
        }

        bw.close();
        ArrayList<Integer> b=mergeSort(a,0,N-1);
        for(int i = 0; i < b.size(); i++){
            pw.print(b.get(i)+" ");
        }
        pw.println();
        pw.close();
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr,int l,int h){

        if(l==h){
            return arr;
        }
        int mid=(l+h)/2;
        ArrayList<Integer> left  = new ArrayList<>(arr.subList(l, mid + 1));
        ArrayList<Integer> right = new ArrayList<>(arr.subList(mid + 1, h + 1));
        ArrayList<Integer> a1 = mergeSort(left,  0, left.size()  - 1);
        ArrayList<Integer> a2 = mergeSort(right, 0, right.size() - 1);
        ArrayList<Integer> a3=merge(a1,a2);
        return a3;

    }

    public static ArrayList<Integer> merge(ArrayList<Integer> a,ArrayList<Integer> b){
        ArrayList<Integer> result= new ArrayList<>();
        int p1=0,p2=0;
        int c1=0,c2=0;
        while(p1<a.size() || p2<b.size()){
            Integer n1=a.get(p1);
            Integer n2=b.get(p2);
            if(n1==0 && n2==0){
                p1++;
                p2++;
                c1++;
                c2++;
            }
            else if(n1==0 && n2!=0){
                result.add(n2);
                p1++;
                p2++;
                c1++;
                
            }
            else if(n2==0 && n1!=0){
                result.add(n1);
                p1++;
                p2++;
                c2++; 
            }
            else{
                if(n1<=n2){
                    result.add(n1);
                    p1++;
                }
                else{
                    result.add(n2);
                    p2++;
                }
            }
             
            if(p1==a.size() && p2<b.size()){
                while(p2<b.size()){
                    result.add(b.get(p2));
                    p2++;
                }
            }

            if(p2==b.size() && p1<a.size()){
                while(p1<a.size()){
                    result.add(a.get(p1));
                    p1++;
                }
            }
        }
        while(c1>0){
            result.add(0);
            c1--;
        }
        while(c2>0){
            result.add(0);
            c2--;
        }
        return result;
    }
    

}
