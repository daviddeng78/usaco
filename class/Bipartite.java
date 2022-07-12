import java.util.*;

public class Bipartite {
    public static boolean isBipartite(boolean[][] graph, int start) {
        //initialize neighbor trackers
        HashSet<Integer> hs1 = new HashSet<Integer>();
        hs1.add(start);
        HashSet<Integer> hs2 = new HashSet<Integer>();

        //initialize for BFS
        Queue<Integer> children = new LinkedList<Integer>();
        children.add(start);

        boolean whichHashset = true; //to determine which hashset to add children to

        int parent;
        while (children.size() > 0) {
            parent = children.poll();
            for (int i = 0; i < graph[parent].length; i++) {
                if (graph[parent][i]) {
                    if (whichHashset) {
                        if (hs1.contains(i)) {
                            return false;
                        }
                        hs2.add(i);
                    }
                    else {
                        if (hs2.contains(i)) {
                            return false;
                        }
                        hs1.add(i);
                    }
                    children.add(i);
                }
            }
            whichHashset = !whichHashset;
        }
        return true;
    }
}