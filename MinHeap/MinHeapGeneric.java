public class MinHeapGeneric<T extends Comparable<T>> {
   
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 8;
    private T[] heap;

    public MinHeapGeneric(){
       
        this.heap = (T[]) new Comparable[DEFAULT_CAPACITY];
    }
    public MinHeapGeneric(T[] stuff){
        buildHeap(stuff);
    }

    public void buildHeap(T[] stuff){
        for (int i = 0; i < stuff.length; i++){
            insert(stuff[i]);
        }
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        else {
            return false;
        }
    }



    public T peekMinimum(){
        if (!isEmpty()){
            return heap[1];

        }
        return null;
    }
    public int getLeftChildIndex(int index){
        return index*2;
    }
    public int getRightChildIndex(int index){
        return 1+(index*2);
    }
    public int getParentIndex(int index){
        return index/2;
    }
    private void doubleCapacity(){
        int len = heap.length*2;


        T[] wow = (T[]) new Comparable[len];
        for (int i = 0; i < len/2; i++){
            wow[i] = heap[i];
        }
        heap = wow;


    }

    public void insert(T value){
        if (( getSize()+1== heap.length)){


            doubleCapacity();


        }
        heap[size++] = value;
        bubbleup(size);
        

        
    }

    public void bubbleup(int index){
            if (index > 1 && heap[getParentIndex(index)] > heap[index]){
            
            
            T parval = heap[getParentIndex(index)];
            
            heap[getParentIndex(index)] = heap[index];

            heap[index] = parval;
            bubbleup(getParentIndex(index));

        }

    }

    public T popMinimum(){    
        T min = peekMinimum();
        if (size > 1){
        heap[1] = heap[size];   
        heap[size] = null;
        size--;
        siftdown(1);
        }
        return min;
    }
    public void siftdown(int ind){

        T l = heap[getLeftChildIndex(ind)];
        
        T r = heap[getRightChildIndex(ind)];

        T cur = heap[ind];

        Integer INDEX = -1;


        if (l != null && cur.compareTo(l) > 1 && (r == null || l.compareTo(r) <= 0)){

            INDEX = getLeftChildIndex(ind);

        }

        else if (r != null && cur.compareTo(r) > 1 && (l == null || r.compareTo(l) <= 0)){
            INDEX = getLeftChildIndex(ind);
        }

        if (INDEX != -1){
            T parcur = heap[INDEX];
            
            heap[INDEX] = heap[ind];
            heap[ind] = parcur;
            

            siftdown(INDEX);

        }


    }

    @Override
    public String toString()
    {
        String output = "";
        for (int i = 1; i <= getSize(); i++)
            output += heap[i] + ", ";
            return output.substring(0, output.lastIndexOf(","));
//lazily truncate last comma
    }
/** method borrowed
with minor modifications
from the internet somewhere, for printing */
    public void display() {
    int nBlanks = 32,
    itemsPerRow = 1, column = 0, j = 1;
    String dots = "...............................";
    System.out.println(dots + dots);
    while (j <= this.getSize())
    {
    if (column == 0)
    for (int k = 0; k < nBlanks; k++)
    System.out.print(' ');
    System.out.print((heap[j] == null)? "" : heap[j]);
    if (++column == itemsPerRow) {
    nBlanks /= 2;
    itemsPerRow *= 2;
    column = 0;
    System.out.println();
    }
    else
    for (int k = 0; k < nBlanks * 2-2; k++)
    System.out.print(' ');
    j++;
    }   
    System.out.println("\n" + dots + dots);
}

    

    
}
