//Longest common subsequence

class LCSQ{
    public int lcsqr(String s1,String s2,int l1,int l2){
        if(l1==0 ||l2==0){
            return 0;
        }

        if(s1.charAt(l1-1)==s2.charAt(l2-1)){
            return 1+lcsqr(s1,s2,l1-1,l2-1);
        }

        return Math.max(lcsqr(s1,s2,l1-1,l2),lcsqr(s1,s2,l1,l2-1));
    }


    public int lcsqtd(String s1,String s2,int n,int m,Integer[][] arr){
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


    public int lcsqdt(String s1,String s2,int l1,int l2){
        if(l1==0 ||l2==0){
            return 0;
        }

        int[][] arr=new int[l1+1][l2+1];

        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    arr[i][j]=1+arr[i-1][j-1];
                }else{
                    arr[i][j]=Math.max(arr[i][j-1],arr[i-1][j]);
                }
            }
        }



        return arr[l1][l2];
    }
}


public class DP6{
    public static void main(String[] args){
        LCSQ a=new LCSQ();

        String s1="abde";
        String s2="acd";

        System.out.println(a.lcsqr(s1,s2,s1.length(),s2.length()));

        Integer[][] arr=new Integer[s1.length()+1][s2.length()+1];
        System.out.println(a.lcsqtd(s1,s2,s1.length(),s2.length(),arr));
        System.out.println(a.lcsqdt(s1,s2,s1.length(),s2.length()));
    }
}

/*
recursion

If last elements match
recursively call with last but one elements of both strings


topdown
If last elements match

save the value in that matrix
recursively call with last but one elements of both strings

in downtop
the matches value is stored in diagonally top left value
the not matches is max of(right value and top value) that is max of(n-1,m and n,m-1 )
 */