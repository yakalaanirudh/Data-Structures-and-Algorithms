//LRU Cache Implementation using Queue
//Deque supports addition and subtraction from both ends

/*
Cache is based on user and database
If user makes same request again and if cache has it the cache responses
instead of communication with Database by returning response
If user makes new reques(not there in cache) then db responses
and response is stored in cache

Cache has size
so if cache is full which data to remove?
we use LRU algorithm (least recently used {means oldest}) to remove data

We put most recently request at front of queue(Doubly Linked List)
So oldest is at end of queue(Doubly Linked List)
So when cache size limit reached last is removed

When a previously used request (Still in cache is requested again)
we remove from that slot(in dequeue{linkedlist}  ) and put it at the front
To check whether if request is already there in cache we use hashmap

Put
If cache doesnt have response
DB sends response and the response is also put in cache

Get
If user makes a request and cache have it we will changes that request slot
in queue to front if not there in cache return -1

If value not there in map there are two conditions
1)Cache is full     then remove element from last and add newest at front and in map
2)If cache not full then add the value at front of queue and in map also

 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Deque;


class CacheEntry{
    int key;
    String value;

    CacheEntry(int key,String value){
        this.key=key;
        this.value=value;
    }
}

class LRUCacheImpl{
    Deque<CacheEntry> q=new LinkedList<>();
    Map<Integer,CacheEntry> map=new HashMap<>();
    int CACHE_SIZE=3;

    public String getFromCache(int key){
        if(map.containsKey(key)){
            CacheEntry entry=map.get(key);
            q.remove(entry);
            q.addFirst(entry);
            return entry.value;
        }

        return null;
    }

    public void putEntryIntoCache(int key,String value){
        if(map.containsKey(key)){
            CacheEntry entry=map.get(key);
            q.remove(entry);
        }else {
            if (q.size() == CACHE_SIZE) {
                CacheEntry entryToBeRemoved = q.removeLast();
                map.remove(entryToBeRemoved.key);
            }
        }
            //the next three lines are
            //Since we removed key from queue in if
            //We create new key value below and add to queue and map
            CacheEntry newEntry=new CacheEntry(key,value);
            q.addFirst(newEntry);
            map.put(key,newEntry);
    }
}


public class Queue5{
    public static void main(String[] args){

        LRUCacheImpl cache=new LRUCacheImpl();
        cache.putEntryIntoCache(1,"Product-1-Info");
        cache.putEntryIntoCache(2,"Product-2-Info");
        cache.putEntryIntoCache(3,"Product-3-Info");
        cache.putEntryIntoCache(4,"Product-4-Info");

        System.out.println(cache.getFromCache(2));
        System.out.println(cache.getFromCache(6));
    }
}