//Find the kth closest point to origin

import java.util.*;

class Coordinate{
    int x;
    int y;

    public Coordinate(int x,int y){
        this.x=x;
        this.y=y;
    }

    public double distanceFromOrigin(){
        return x*x+y*y;
    }
}

class HeapApp{

    public static List<Coordinate> kClosestPointFromOriginUsingList(List<Coordinate> listOfCoordinate,int k){
        if(listOfCoordinate.size()==0){
            return new ArrayList<>();
        }

        Collections.sort(listOfCoordinate,(n1,n2)->n1.distanceFromOrigin()-n2.distanceFromOrigin());

        List<Coordinate> result=new ArrayList<>();

        int i=0;
        while(i<listOfCoordinate.size() &&i<k){
            result.add(listOfCoordinate.get(i));
            i++;
        }

        return result;
    }

    public static List<Coordinate> kClosestPointFromOriginUsingMinHeap(List<Coordinate> listOfCoordinate,int k){
        if(listOfCoordinate.size()==0){
            return new ArrayList<>();
        }

        PriorityQueue<Coordinate> minHeap=new PriorityQueue<>((n1.n2) ->n1.distanceFromOrigin()-n2.distanceFromOrigin());

        for(Coordinate c:listOfCoordinate){
            minHeap.add(c);
        }

        List<Coordinate> result=new ArrayList<>();

        int i=0;
        while(!minHeap.isEmpty()&&i<k){
            result.add(minHeap.poll());
            i++;
        }
        return result;
    }


    public static List<Coordinate> kClosestPointFromOriginUsingMaxHeap(List<Coordinate> listOfCoordinate,int k){
        if(listOfCoordinate.size()==0){
            return new ArrayList<>();
        }

        PriorityQueue<Coordinate> minHeap=new PriorityQueue<>((n1.n2) ->n2.distanceFromOrigin()-n1.distanceFromOrigin());

        for(int i=0;i<k;i++){
            maxHeap.add(listOfCoordinate.get(i));
        }


        for(int i=k;i<listOfCoordinate.size();i++){
            if(listOfCoordinate.get(i).distanceFromOrigin()<maxHeap.peek().distanceFromOrigin()){
                maxHeap.poll();
                maxHeap.add(listOfCoordinate.get(i));
            }
        }



        List<Coordinate> result=new ArrayList<>();

        while(!maxHeap.isEmpty()){
            result.add(maxHeap.poll());
        }
        return result;
    }
}

public class Heap11{
    public static void main(String[] args){


        Coordinate c1=new Coordinate(2,3);
        Coordinate c2=new Coordinate(1,4);
        Coordinate c3=new Coordinate(3,5);
        Coordinate c4=new Coordinate(0,4);

        List<Coordinate> listOfCoordinate=new Arraylist<>();
        listOfCoordinate.add(c1);
        listOfCoordinate.add(c2);
        listOfCoordinate.add(c3);
        listOfCoordinate.add(c4);

        List<Coordinate> kClosestPointsUsingList=HeapApp.kClosestPointFromOriginUsingList(listOfCoordinate,3){
            for(Coordinate c:kClosestPointsUsingList){
                System.out.println(c.x+" "+c.y);
            }

            System.out.println();
        }

        List<Coordinate> kClosestPointsUsingMinHeap=HeapApp.kClosestPointFromOriginUsingMinHeap(listOfCoordinate,3){
            for(Coordinate c:kClosestPointsUsingMinHeap){
                System.out.println(c.x+" "+c.y);
            }

            System.out.println();
        }

        List<Coordinate> kClosestPointsUsingMaxHeap=HeapApp.kClosestPointFromOriginUsingMaxHeap(listOfCoordinate,3){
            for(Coordinate c:kClosestPointsUsingMaxHeap){
                System.out.println(c.x+" "+c.y);
            }

            System.out.println();
        }
    }
}