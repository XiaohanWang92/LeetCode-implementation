public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = Math.abs(C - A) * Math.abs(D - B) + Math.abs(G - E) * Math.abs(H - F);
        // Improve:no need use absolution
        // Check overlap
        if(C <= E || G <= A)  return area;
        if(D <= F || H <= B)  return area;
        int[] xCor = new int[4];
        int[] yCor = new int[4];
        xCor[0] = A;
        xCor[1] = E;
        xCor[2] = C;
        xCor[3] = G;
        yCor[0] = B;
        yCor[1] = D;
        yCor[2] = F;
        yCor[3] = H;
        Arrays.sort(xCor);
        Arrays.sort(yCor);
        int coverArea = Math.abs(xCor[2] - xCor[1]) * Math.abs(yCor[2] - yCor[1]);
        area = area - coverArea;
        return area;
    }
}
