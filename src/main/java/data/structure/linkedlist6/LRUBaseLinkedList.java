package data.structure.linkedlist6;

/**
 * 基于单链表的LRU
 */
public class LRUBaseLinkedList<T> {

    /**
     * 默认容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private SNode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUBaseLinkedList() {
        this.headNode = new SNode<T>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity) {
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data) {
        SNode preNode = findFirstSNode(data);
        if(preNode != null){
            deleteElemOptim(preNode);
            insertElementAtBegin(data);
        }else{
            if(length >capacity){
                deleteEndElement();
            }
            insertElementAtBegin(data);
        }


    }
    /**
     * 删除preNode结点下一个元素
     * @param preNode
     */
    private void deleteElemOptim(SNode preNode) {
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length -- ;
    }

    /**
     * 链表头部插入结点
     * @param data
     */
    private void insertElementAtBegin(T data){
        SNode next = headNode.getNext();
        headNode.setNext(new SNode(data, next));
        length++;
    }

    /**
     * 获取查到元素的前一个结点
     * @param data
     * @return
     */
    private SNode findFirstSNode(T data){
        SNode node = headNode;
        while(node.getNext() != null){
            if(data.equals(node.getNext().getElement())){
                return node;
            }
            node = headNode.getNext();
        }
        return null;
    }

    /**
     * 删除尾结点
     */
    private void deleteEndElement(){
        SNode ptr = headNode.getNext();
        if(ptr == null){
            return;
        }

        //倒数第二个结点
        while(ptr.getNext().getNext() != null){
            ptr = ptr.getNext();
        }

        SNode temp = ptr.getNext();
        ptr.setNext(null);
        temp = null;
        length -- ;
    }
    private void printAll(){
        SNode node = headNode.getNext();
        while(node != null){
            System.out.println("---->" + node.getElement());
            node = node.getNext();
        }
    }

    public class SNode<T>{
        private T element;
        private SNode next;

        public SNode() {
            this.next = null;
        }
        public SNode(T element) {
            this.element = element;
        }

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public void setNext(T element,SNode next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }
}


