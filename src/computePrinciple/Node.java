package computePrinciple;

public class Node {
     int key;
     int value;
     Node pre;
     Node next;

     public Node(int key,int value){
          this.key = key;
          this.value = value;
     }

     @Override
     public String toString() {
          return "["+key+":"+value+"]";
     }
}
