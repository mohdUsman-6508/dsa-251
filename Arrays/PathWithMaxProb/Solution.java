package Arrays.PathWithMaxProb;

public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] probs = new double[n];
        probs[start_node] = 1;
        for (int i = 0; i < n - 1; i++) {
            boolean c = false;
            for (int j = 0; j < edges.length; j++) {
                int src = edges[j][0];
                int dest = edges[j][1];
                double prob = succProb[j];

                if (probs[src] * prob > probs[dest]) {
                    probs[dest] = probs[src] * prob;
                    c = true;
                }
                if (probs[dest] * prob > probs[src]) {
                    probs[src] = probs[dest] * prob;
                    c = true;
                }
            }
            if (c == false)
                break;
        }
        return probs[end_node];
    }
}