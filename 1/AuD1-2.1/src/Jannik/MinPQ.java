package Jannik;

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

	public boolean insert(String d, double p) { // Testclass mit Hilfe von Kommilitone Patrick Hohn erstellt

		PQElement newArr = new PQElement(d, p);	
		arr[++currentsize] = newArr;
		
		int stelle = currentsize;
		
		while (stelle != 1 && newArr.getPrio() < arr[stelle/2].getPrio()) {
			arr[stelle] = arr[stelle/2];
			stelle /= 2;
		}
		
		arr[stelle] = newArr;
		return false;
	}

	public void tausche(int a, int b) {
		PQElement tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public PQElement extractElement() { // Testclass mit Hilfe von Kommilitone Patrick Hohn erstellt
		
		double lowest = Double.MAX_VALUE;
		PQElement pqreturn;
		for (int i = 1; i < maxsize; i++) {
			if (arr[i] != null) {
				if (arr[i].getPrio() < lowest) {
					lowest = arr[i].getPrio();
				}
			}
		}

		for (int i = 1; i < maxsize; i++) {
			if (arr[i] != null) {
				if (lowest == arr[i].getPrio()) {
					pqreturn = new PQElement(arr[i].getData(), arr[i].getPrio());
					arr[i] = null;
					currentsize--;
					System.out.println(pqreturn);
					heapify(arr, 1);
					return pqreturn;
				}
			}
		}
		System.out.println("Array ist leer");
		return null;
		}

	public void heapify(PQElement[] A, int i) { // mit Hilfe der Quelle https://examples.javacodegeeks.com/min-heap-java-example/
		if (arr[i] != null) {
			int l = leftChild(i);
			int r = rightChild(i);

			if (A[i].getPrio() > A[l].getPrio() || A[i].getPrio() > A[r].getPrio()) {
				if (A[l].getPrio() < A[r].getPrio()) {
					tausche(l, i);
					heapify(A, r);
				} else {
					tausche(i, r);
					heapify(A, r);
				}
			}
		}
	}

	public void update() {
		for (int i = 1; i < maxsize; i = i + 2) {
			double j = arr[i].getPrio() - 0.1;
			arr[i].setPrio(j);
		}
	}

	@Override
	public String toString() {
		return "MinPQ [arr=" + Arrays.toString(arr) + ", maxsize=" + maxsize + ", currentsize=" + currentsize + "]";
	}

	public int leftChild(int i) {
		return 2 * i;
	}

	public int rightChild(int i) {
		return 2 * i + 1;
	}

	public String extractData() {
		if (isEmpty()) {
			return null;
		}
		PQElement tmp = arr[1];
		arr[1] = arr[currentsize];
		currentsize = currentsize - 1;
		heapify(arr, 1);
		return tmp.getData();
	}

}