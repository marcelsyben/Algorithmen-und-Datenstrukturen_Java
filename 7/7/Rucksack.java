import java.util.ArrayList;

class Rucksack {

    public ArrayList<Integer> rucksack (int n, int a[], int w[], int G) {

        int[][] W = new int[n + 1][G + 1];
        for (int i = 0; i <= G; i++) {
            W[0][i] = 0;
        }

        for (int k = 1; k <= n; k++) {
            for (int j = 1; j <= G; j++) { 
                if (w[k - 1] > j) {
                    W[k][j] = W[k - 1][j];
                } else {
                    W[k][j] = Math.max(
                      W[k - 1][j], 
                      W[k - 1][j - w[k - 1]] + a[k - 1]);
                }
            }
        }


        return null;
    }


    public static void main(String[] args) {
    
    }
}