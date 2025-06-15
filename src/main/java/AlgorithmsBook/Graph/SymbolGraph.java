package AlgorithmsBook.Graph;

import edu.princeton.cs.algs4.In;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class SymbolGraph {
    private Map<String, Integer> st;
    private String[] keys;
    private Graph g;

    public SymbolGraph(String steam, String sp) {
        st = new HashMap<>();
        In in = new In(steam);

        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++) {
                if (!st.containsKey(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }
        keys = new String[st.size()];
        for (String name: st.keySet()) {
            keys[st.get(name)] = name;
        }

        g = new Graph(st.size());
        in = new In(steam);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 0; i < a.length; i++) {
                g.addEdge(v, st.get(a[i]));
            }
        }
    }

    public static void main(String[] args) {
        ClassLoader classLoader = SymbolGraph.class.getClassLoader();
        URL resource = classLoader.getResource("data/movies.txt");
        SymbolGraph sg = new SymbolGraph(resource.getPath(), "/");

        Graph g = sg.g;
    }
}
