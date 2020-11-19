package ex0;


import java.util.*;

public class Graph_DS implements graph {
    public int E;
    public int T;
    HashMap<Integer, node_data> nodes;

     Graph_DS()
    {
        nodes = new HashMap<Integer, node_data>();
        E=0;
        T=0;
    }

    /**
     * add a new node to the graph with the given node_data.
     * Note: this method run in O(1) time.
     * @param n
     */
    public void addNode(node_data n) {
            nodes.put(n.getKey(),n);
            T=T+1;
    }
    /**
     * Delete the node (with the given ID) from the graph -
     * and removes all edges which starts or ends at this node.
     * This method run in O(n), |V|=n, as all the edges should be removed.
     * @return the data of the removed node (null if none).
     * @param key
     */
    @Override
    public node_data removeNode(int key) {
        node_data node_copy = null;
        if (nodes.containsKey(key))
        {
            node_data node_p = nodes.get(key);
             node_copy = ((NodeData) node_p).getCopy();
            T++;
            NodeData[] ni = node_p.getNi().toArray(new NodeData[0]);

            for (node_data ra: ni) {
                removeEdge(node_p.getKey(),ra.getKey());
                T++;
            }

            nodes.remove(key);
            T++;
        }
        else
        {
            node_copy = nodes.get(key);
            T++;
        }




        return node_copy;
    }

    /**
     * This method returns a collection containing all the
     * nodes connected to node_id
     * Note: this method run in O(1) time.
     * @return Collection<node_data>
     */

    public Collection<node_data> getV(int node_id)
    {
        return nodes.get(node_id).getNi();
    }

    /**
     * Delete the edge from the graph,
     * Note: this method should run in O(1) time.
     * @param node1
     * @param node2
     */
    @Override
    public void removeEdge(int node1, int node2) {
        if(nodes.get(node1).hasNi(node2)==true && nodes.get(node2).hasNi(node1)==true)
        {
                nodes.get(node1).removeNode(nodes.get(node2));
                nodes.get(node2).removeNode(nodes.get(node1));
                T=T+2;
                E-=1;
        }

    }




    /**
     * return the node_data by the node_id,
     * @param key - the node_id
     * @return the node_data by the node_id, null if none.
     */
    @Override
    public node_data getNode(int key) {
        return nodes.get(key);
    }

    public boolean hasEdge(int node1, int node2) {
        if(nodes.get(node1).getNi().contains(nodes.get(node2)) && nodes.get(node2).getNi().contains(nodes.get(node1)))
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    /**
     * Connect an edge between node1 and node2.
     * Note: this method run in O(1) time.
     * Note2: if the edge node1-node2 already exists - the method simply does nothing.
     */
    public  void connect(int node1, int node2) {

        if(nodes.containsKey(node1) && nodes.containsKey(node2))
        {
            if(nodes.get(node1).hasNi(node2)==false && nodes.get(node2).hasNi(node1)==false)
            {
                if(node1!=node2)
                {
                    nodes.get(node1).addNi(nodes.get(node2));
                    nodes.get(node2).addNi(nodes.get(node1));
                    E+=1;
                    T=T+2;
                }

            }




        }

    }

    /**
     * This method return a pointer (shallow copy) for the
     * collection representing all the nodes in the graph.
     * Note: this method run in O(1) time.
     * @return Collection<node_data>
     */
    @Override
    public Collection<node_data> getV() {

        return nodes.values();
    }
    /**
     * return the number of edges (undirectional graph).
     * Note: this method should run in O(1) time.
     * @return
     */

    public int edgeSize()
    {
        return E;
    }

    /**
     * return the Mode Count - for testing changes in the graph.
     * Any change in the inner state of the graph should cause an increment in the ModeCount
     * @return
     */
    public int getMC() {
        return T;
    }
    /** return the number of vertices (nodes) in the graph.
     * Note: this method should run in O(1) time.
     * @return
     */
    public int nodeSize()
    {
        return nodes.size();
    }



}