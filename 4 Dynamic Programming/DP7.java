//Longest common substring

class LCSS{
    public int lcssr(String s1,String s2,int n,int m,int countofLCS){
        if(n==0 ||m==0){
            return countofLCS;
        }

        if(s1.charAt(n-1)==s2.charAt(m-1)){
            countofLCS= 1+lcssr(s1,s2,n-1,m-1,countofLCS+1);
        }

        int count1=lcssr(s1,s2,n-1,m,0);
        int count2=lcssr(s1,s2,n,m-1,0);

        return Math.max(countofLCS,Math.max(count1,count2));
    }


    /*
    public int lcsstd(String s1,String s2,int n,int m,Integer[][] arr){
        if(n==0 ||m==0){
            return 0;
        }

        if(arr[n][m]==null){
            if(s1.charAt(n-1)==s2.charAt(m-1)){
                arr[n][m]=1+lcsqtd(s1,s2,n-1,m-1,arr);
            }else{
                arr[n][m]=Math.max(lcsqtd(s1,s2,n-1,m,arr),lcsqtd(s1,s2,n,m-1,arr));
            }
        }

        return arr[n][m];
    }
    */

    public int lcssdt(String s1,String s2,int n,int m){
        if(n==0 ||m==0){
            return 0;
        }

        int lcs=0;

        int[][] arr=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;i<=m;i++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    arr[i][j]=1+arr[i-1][j-1];

                    lcs=Math.max(lcs,arr[i][j]);
                }else{
                    arr[i][j]=0;
                }
            }
        }



        return lcs;
    }
}


public class DP7{
    public static void main(String[] args){
        LCSS a=new LCSS();

        String s1="abd";
        String s2="abca";

        System.out.println(a.lcssr(s1,s2,s1.length(),s2.length(),0));

        Integer[][] arr=new Integer[s1.length()+1][s2.length()+1];
        //System.out.println(a.lcsstd(s1,s2,s1.length(),s2.length(),arr));
        System.out.println(a.lcssdt(s1,s2,s1.length(),s2.length()));
    }
}