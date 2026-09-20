public class ktsuba{
    public static void main (String[]args){
        String n2="7693";
        String n1="49881";
        String r=karatsuba(n1,n2);
        System.out.println(r);
    }
    public static String karatsuba(String a,String b){
        if(a.length()!=b.length()){
            if(a.length()<b.length()){
                int diff=b.length()-a.length();
                for(int i=0;i<diff;i++){
                    a="0"+a;
                }
            }
            else{
                int diff=a.length()-b.length();
                for(int i=0;i<diff;i++){
                    b="0"+b;
                }
            }
        }
        if(a.length()==1){
            int n1=Integer.parseInt(a);
            int n2=Integer.parseInt(b);
            int m=n1*n2;
            String r=Integer.toString(m);
            return r;
        }
        int mid=a.length()/2;
        String ah="";
        String bh="";
        for(int i=0;i<mid;i++){
            ah+=a.charAt(i);
            bh+=b.charAt(i);
        }
        String al="";
        String bl="";
        for(int i=mid;i<a.length();i++){
            al+=a.charAt(i);
            bl+=b.charAt(i);
        }
 
        
        String p=karatsuba(ah, bh);

        String r=karatsuba(al, bl);

        int m1=Integer.parseInt(ah);
        int m2=Integer.parseInt(al);

        int aa=m1+m2;

        int n1=Integer.parseInt(bh);
        int n2=Integer.parseInt(bl);

        int bb=n1+n2;

        String a1=Integer.toString(aa);
        String b1=Integer.toString(bb);

        String q=karatsuba(a1, b1);

        int pp=Integer.parseInt(p);
        int rr=Integer.parseInt(r);
        int qq=Integer.parseInt(q);

        qq=qq-pp-rr;

        int padding = a.length() - mid;
        
        String sqq=Integer.toString(qq);
        for(int i=0;i<padding;i++){
            sqq+="0";
        }

        String spp=Integer.toString(pp);
        for(int i=0;i<(padding * 2);i++){
            spp+="0";
        }
        
        int result=Integer.parseInt(spp)+Integer.parseInt(sqq)+rr;
        return Integer.toString(result);
        
    }
}