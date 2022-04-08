package Jannik2;

import java.util.Arrays;

public class MinPQ {

	private PQElement[] arr;
	private int maxsize;
	private int currentsize;

	public MinPQ(int max) {
		this.maxsize = max + 1;
		arr = new PQElement[this.maxsize];
		this.currentsize = 0;
	}

	public boolean isEmpty() {
		return (currentsize == 0);

	}

	public boolean insert(PQElement n) {
		if (n == null) {
			throw new IllegalArgumentException("Element kann nicht null sein!");
		}
		insert(n.getData(), n.getPrio());
		return false;
	}

	public boolean insert(String d, double p) { 
		if (currentsize == maxsize) {
			System.out.println("Array ist voll!");
			return false;
		}
		PQElement tmp = new PQElement(d, p);
		currentsize = currentsize + 1;
		arr[currentsize] = tmp;
		heapUp(currentsize);
		return true;
	}


	public PQElement extractElement() { 
		if (isEmpty()) {
			return null;
		}
		PQElement tmp = arr[1];
		arr[1] = arr[currentsize];
		arr[currentsize] = null;
		currentsize--;
		heapDown(1);
		return tmp;
		
	}

	public String extractData() {
		if (isEmpty()) {
			return null;
		}
		PQElement tmp = arr[1];
		arr[1] = arr[currentsize];
		arr[currentsize] = null;
		currentsize = currentsize - 1;
		heapDown(1);
		return tmp.getData();
	}
	
	public void heapDown(int i) {
		int l = leftChild(i);
		int r = rightChild(i);
		int smallest;
		if(l <= currentsize && arr[l].getPrio() < arr[i].getPrio()) {
			smallest = l;
		}
		else { 
			smallest = i;
		}
		if(r <= currentsize && arr[r].getPrio() < arr[smallest].getPrio()) {
			smallest = r;
		}
		if(smallest != i) {
			tausche(i, smallest);
			heapDown(smallest);
		}
	}
	
	public void heapUp(int i) {
		int tmp = currentsize;
		if (arr[i] != null) {

			while (tmp != 1 && arr[i].getPrio() < arr[parent(tmp)].getPrio()) {
				tausche(tmp, parent(tmp));
				tmp = parent(tmp);
			}
		}
	}
	
	public int parent(int pos) {
		return pos / 2;
	}

	public int leftChild(int pos) {
		return (pos * 2);
	}

	public int rightChild(int pos) {
		return (pos * 2) + 1;
	}
	
	public void tausche(int a, int b) {
		PQElement tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	@Override
	public String toString() {
		return "MinPQ [arr=" + Arrays.toString(arr) + ", maxsize=" + maxsize + ", currentsize=" + currentsize + "]";
	}


	public void update(String s, double n) {
		for (int i = 1; i < maxsize;i++) {
			if(arr[i].getData() == s && arr[i].getPrio() > n) {
				arr[i].setPrio(n);

			}
			
		}
	}

	public void update() {}

}