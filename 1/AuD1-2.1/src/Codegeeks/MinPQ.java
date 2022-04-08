package Codegeeks;

// Java implementation of Min Heap
public class MinPQ {

    private PQElement[] Heap;
    private int currentsize;
    private int maxsize;

    private static final int FRONT = 1;

    public MinPQ(int maxsize) {
        this.maxsize = maxsize;
        this.currentsize = 0;
        Heap = new PQElement[this.maxsize + 1];
        //Heap[0] = Integer.MIN_VALUE;
    }

    // Function to return the position of
    // the parent for the node currently
    // at pos
    private int parent(int pos) {
        return pos / 2;
    }

    // Function to return the position of the
    // left child for the node currently at pos
    private int leftChild(int pos) {
        return (2 * pos);
    }

    // Function to return the position of
    // the right child for the node currently
    // at pos
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Function that returns true if the passed
    // node is a leaf node
    private boolean isLeaf(int pos) {
        if (pos >= (currentsize / 2) && pos <= currentsize) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return (currentsize == 0);
    }



    // Function to swap two nodes of the heap
    private void swap(int fpos, int spos) {
        PQElement tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Function to heapify the node at pos
    private void minHeapify(int pos) {

        // If the node is a non-leaf node and greater
        // than any of its child
        if (!isLeaf(pos)) {
            if (Heap[pos].getPrio() > Heap[leftChild(pos)].getPrio()
                    || Heap[pos].getPrio() > Heap[rightChild(pos)].getPrio()) {

                // Swap with the left child and heapify
                // the left child
                if (Heap[leftChild(pos)].getPrio() < Heap[rightChild(pos)].getPrio()) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }

                // Swap with the right child and heapify
                // the right child
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(String s, double p) {
        PQElement n = new PQElement(s, p);
        insert(n);
    }


    // Function to insert a node into the heap
    public void insert(PQElement n) {
        if (currentsize >= maxsize) {
            return;
        }
        Heap[++currentsize] = n;
        int current = currentsize;

        while (current != 1 && Heap[current].getPrio() < Heap[parent(current)].getPrio()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Function to build the min heap using
    // the minHeapify
    public void minHeap() {
        for (int pos = (currentsize / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    // Function to remove and return the minimum
    // element from the heap
    public PQElement extractElement() {
        PQElement popped = Heap[FRONT];
        Heap[FRONT] = Heap[currentsize--];
        minHeapify(FRONT);
        return popped;
    }

    public String extractData() {
        return extractElement().getData();
    }

    public void update(String s, double n) {

        for (int i = 1; i < maxsize; i++) {
            if (Heap[i].getData() == s) {
                PQElement p = Heap[i];
                Heap[i] = null;
                insert(p);
            }
        }
    }

    public void update(int e) {

        for (int i = 1; i < maxsize; i+=e) {

            PQElement p = Heap[i];
            p.setPrio(p.getPrio()/2);
            Heap[i] = null;
            insert(p);

        }
    }
}