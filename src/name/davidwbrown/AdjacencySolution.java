package name.davidwbrown;

public class AdjacencySolution {

    public static void main(String[] args) {
	    int[] A = {1, 1, 0, 1, 0, 0, 1, 1};



        int adjPairs = solution(A);

        System.out.println("Adjacent pairs: " + adjPairs);

    }

    static int initAdj(int[] A) {
        int adj = 0;
        for (int i=0; i<A.length; i++) {
            if (i+1 == A.length)
                break;;
            if (A[i] == A[i+1]) {
                adj++;
            }
        }
        return adj;
    }

    static int solution(int[] A) {
        int result = 0;
        int initPairs = initAdj(A);
        int last = 0;
        for (int i=0; i<A.length; i++) {

            A = flip(A, i);
            result = initAdj(A);

            if (result > initPairs)
                initPairs = result;
            else
                A = flip(A, i);
        }
        return initPairs;
    }

    static int[] flip(int[] A, int index) {
        if (A[index]==0)
            A[index] = 1;
        else
            A[index] = 0;

        return A;
    }
}
