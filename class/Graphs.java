import java.io.*;
import java.util.*;

public class Graphs {
    public static String DFS(String current, HashMap<String, ArrayList<String>> graph, HashSet<String> visited) {
        //check if all nodes have been reached
        if (visited.size() == graph.size()) {
            return "";
        }
        //check for children
        for (String child : graph.get(current)) {
            if (!visited.contains(child)) {
                visited.add(child);
                return child + DFS(child, graph, visited);
            }
        }
        
        //check for isolated subgraphs
        for (String key : graph.keySet()) {
            if (!visited.contains(key)) {
                visited.add(key);
                return key + DFS(key, graph, visited);
            }
        }
        return "";
    }

    public static String BFS(HashMap<String, ArrayList<String>> graph, HashSet<String> visited) {
        Queue<String> children = new LinkedList<String>();
        String BFS = "";
        String parent;
        while (visited.size() < graph.size()) {
            if (children.isEmpty()) {
                for (String key : graph.keySet()) {
                    if (!visited.contains(key)) {
                        visited.add(key);
                        children.add(key);
                        if (BFS == null) {
                            BFS = key;
                        }
                        else {
                            BFS += key;
                        }
                        break;
                    }
                }
            }
            parent = children.poll();
            for (String child : graph.get(parent)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    children.add(child);
                    BFS += child;
                }
            }
        }
        return BFS;
    }

    public static void main(String[] args) throws IOException {
        HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int connections = Integer.parseInt(st.nextToken());

        String node1;
        String node2;
        for (int i = 0; i < connections; i++) {
            ArrayList<String> start;
            st = new StringTokenizer(br.readLine());
            node1 = st.nextToken();
            node2 = st.nextToken();

            if (!hm.containsKey(node1)) {
                start = new ArrayList<String>();
                start.add(node2);
                hm.put(node1, start);
            }
            else {
                hm.get(node1).add(node2);
            }
            
            if (!hm.containsKey(node2)) {
                start = new ArrayList<String>();
                start.add(node1);
                hm.put(node2, start);
            }
            else {
                hm.get(node2).add(node1);
            }
        }

        if (hm.isEmpty()) {
            System.out.println("Graph is empty");
        }
        else {
            //DFS
            HashSet<String> visited = new HashSet<String>();
            String start = "";
            for (String key : hm.keySet()) {
                start = key;
                visited.add(start);
                break;
            }
            System.out.println(start + DFS(start, hm, visited));
            visited.clear();
            
            //BFS
            System.out.println(BFS(hm, visited));
        }
    }
}