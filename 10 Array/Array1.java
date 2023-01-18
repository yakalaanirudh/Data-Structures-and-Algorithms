//Insertion

public class Array1{
    public static void main (String[] args){

        int a[]=new int[5];

        a[0]=12;
        a[1]=34;
        a[2]=15;
        a[3]=67;
        a[4]=48;

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
    }
}

/*

//When inserting all elements after that will be displaced by +1 index
public void insertAtPosition(int a[],int position,int val){
    for(int i=position;i<a.length;i++){
        a[i+1]=a[i]
    }
    a[position]=val
}
*/