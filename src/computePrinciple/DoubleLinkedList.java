package computePrinciple;

public class DoubleLinkedList {
    Node head;
    Node tail;
    private int capacity;
    private int size;

    public DoubleLinkedList(int c){
        capacity = c;
    }

    public DoubleLinkedList(){}


    public Node addHead(Node node){
        if (head == null){
            head = node;
            tail = node;
        }
        else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        size ++;
        return node;
    }

    public Node addTail(Node node){
        if (tail == null){
            tail = node;
            head = node;
        }
        else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        size++;
        return node;
    }

    public Node delTail(){
        if (tail == null)
            return null;
        Node res = tail;
        if (tail.pre == null){
            head = tail = null;
        }
        else {
            tail = res.pre;
            tail.next = null;
            res.pre = null;
        }
        size -=1;
        return res;
    }

    public Node delHead(){
        if (head == null)
            return null;
        Node res = head;
        if (head.next == null){
            head = tail = null;
        }
        else {
            head = head.next;
            head.pre = null;
            res.next = null;
        }
        size -=1;
        return res;
    }

    public Node remove(Node node){
        if (node == null){
            //删除尾部节点
            node = tail;
        }
        if (node == tail){
            delTail();
        }
        else if (node == head){
            delHead();
        }
        else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            node.next = null;
            node.pre = null;
            size -=1;
        }
        return node;
    }


    public Node pop(){
        return delHead();
    }

    public Node add(Node node){
        return addTail(node);
    }

    public Node addFront(Node node){
        return addHead(node);
    }

    public Node remove(){
        return remove(null);
    }

    public void print(){
        Node p = head;
        StringBuilder sb = new StringBuilder();
        while (p!=null){
            sb.append(p);
            p = p.next;
            if (p!=null)
                sb.append("=>");
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList(10);
        Node[] nodes = new Node[10];
        for (int i=0;i<10;i++){
            nodes[i] = new Node(i, i);
        }

        list.add(nodes[0]);
        list.print();
        list.add(nodes[1]);
        list.print();
        list.pop();
        list.print();
        list.add(nodes[2]);
        list.print();
        list.addHead(nodes[3]);
        list.print();
        list.add(nodes[4]);
        list.print();
        list.remove(nodes[2]);
        list.print();
        list.remove();
        list.print();
    }

    public int getSize(){
        return size;
    }
}
