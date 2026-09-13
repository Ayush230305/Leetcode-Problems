class LargestOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        int maxOverlap = 0;
        for(int rowoff = -n +1 ; rowoff < n ; rowoff++){
            for(int coloff = -n + 1 ; coloff < n ; coloff++){
                int count = countOverlaps(A,B,rowoff,coloff);
                maxOverlap = Math.max(maxOverlap, count);
            }
        }
        return maxOverlap;
    }
    int countOverlaps(int[][] A, int[][] B, int rowoff, int coloff){
        int n = A.length;
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int Bi = i + rowoff;
                int Bj = j + coloff;
                if(Bi < 0 || Bi >= n || Bj < 0 || Bj >= n) continue;
                if(A[i][j] == 1 && B[Bi][Bj] == 1) count++;
            }
        }
        return count;
    }
}