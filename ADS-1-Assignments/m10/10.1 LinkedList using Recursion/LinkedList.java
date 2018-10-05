import java.util.*;
/**
 * Class for node.
 */
class Node {
    String data;
    Node next;
    Node(String val){
        data = val;
    }
}
/**
 * List of linkeds.
 */
class LinkedList{
    Node initial;
    int size;
    LinkedList(){
        initial = null;
        size = 0;
    }
    /**
     * { inserts element at node given}.
     *
     * @param      i     {node given}
     */
    void insert(Node i){
        if(size == 0){
            initial = i;
            return;
        }
    }
    /**
     * { inserts at the given index and node }.
     *
     * @param      index      The index
     * @param      n          { gives node place }
     *
     * @throws     Exception  { exception if it is empty }
     */
    void insertAt(int index,Node n) throws Exception{
        if(index < 0 || index > size){
            throw new Exception("");

                    }

        if(index == 0){
            n.next = initial;
            initial = n;
            size++;
            return;
        }
        initial =insertAt(index, initial,n,0);

    }
    /**
     * { inserts element at the index given and node}.
     *
     * @param      index    The index
     * @param      first    The first
     * @param      element  The element
     * @param      count    The count
     *
     * @return     { returns the first element }
     */
    Node insertAt(int index,Node first, Node element,int count ){
        if(count == index){
            element.next = first;
            return element;
        }
        first.next = insertAt(index,first.next,element,count+1);
        size++;
        return first;
    }
    /**
     * {reverse the list}.
     *
     * @throws     Exception  { exception is raised}
     */
    void reverse() throws Exception{
        if(initial == null){
            throw new Exception();
        }
        reverse(null,initial);
    }
    /**
     * { reverses the current and previous node}.
     *
     * @param      prev     The previous
     * @param      current  The current
     */
void reverse( Node prev, Node current)
{
   if(current!=null){
      reverse(current,current.next);
      current.next = prev;
    }else{
        initial = prev;
    }
}
/**
 * { displays the data }.
 */
    void display(){
        Node temp = initial;
        String str="";
        while(temp !=null){
            str += temp.data+", ";
            temp = temp.next;
        }
        System.out.println(str.substring(0,str.length()-2));
    }
}