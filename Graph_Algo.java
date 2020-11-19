package ex0;

import java.util.*;

public class Graph_Algo implements graph_algorithms {
    graph galgo;


    /**
     * Init the EX0.ex0.graph on which this set of algorithms operates on.
     * @param g
     */
    @Override
    public void init(graph g) {
        this.galgo=g;
    }
    /**
     * Compute a deep copy of this EX0.ex0.graph.
     * @return
     */
    @Override
    public graph copy() {
        Graph_DS graph=new Graph_DS();
        for(node_data n : this.galgo.getV()){
            NodeData new_node=new NodeData();
            new_node.setKey(n.getKey());
            new_node.setInfo(n.getInfo());
            new_node.setTag(n.getTag());
            graph.addNode(new_node);
        }
        for(node_data n : this.galgo.getV()){
            for(node_data n2:n.getNi())
                graph.connect(n.getKey(),n2.getKey());
        }
        return graph;
    }

    /**
     * Returns true if and only if (iff) there is a valid path from EVREY node to each
     * other node. NOTE: assume ubdirectional EX0.ex0.graph.
     * @return
     */
    @Override
    public boolean isConnected() {
        if(galgo==null)
            return false;
        if(galgo.nodeSize()==0&&galgo.edgeSize()==1 || galgo.nodeSize()==1&&galgo.edgeSize()==1)
            return true;
        if((galgo.getV().size())!=0 )
            bfs(galgo.getV().iterator().next().getKey());
        for (node_data node: galgo.getV())
        {
            if(node.getTag()==-1)
                return false;
        }
        return true;
    }

    /**
     * implement bfs algorithm on the graph from given startnode
     * @param src - start node
     */
    private void bfs(int src)
    {
        for(node_data node:galgo.getV())
            node.setTag(-1);
        Queue<node_data> qbfs= new ArrayDeque<>();
        galgo.getNode(src).setTag(0);
        qbfs.add(galgo.getNode(src));
        while(!qbfs.isEmpty())
        {
            node_data head = qbfs.poll();
            for(node_data nei: galgo.getV(head.getKey()))
            {
                if(nei.getTag()==-1)
                {
                    nei.setTag(head.getTag()+1);
                    qbfs.add(nei);
                }
            }
        }
    }

    /**
     * returns the length of the shortest path between src to dest
     * Note: if no such path --> returns -1
     * @param src - start node
     * @param dest - end (target) node
     * @return
     */
    @Override
    public int shortestPathDist(int src, int dest) {
        bfs(src);
        int count=-1;
        node_data startnode = galgo.getNode(dest);
        int tag=startnode.getTag()-1;
        node_data oldnode;
        while (startnode.getKey() != src){
            count++;
            oldnode=startnode;
            for(node_data n:startnode.getNi())
            {
                if(n.getTag()==tag) {
                    startnode = n;
                    break;
                }
            }
            tag--;
            if(oldnode == startnode)
            {
                count=-2;
                break;
            }
        }
        count++;
        return count;
    }
    /**
     * get array list and return the reverse of her,very useful.
     * @param arr - get Array List
     * @return reverse Array List
     */
    private List<node_data> ReverseArrayList(ArrayList<node_data> arr){
        ArrayList<node_data>reverseAL=new ArrayList<>();
        for(int i=arr.size()-1;i>=0;i--){
            reverseAL.add(arr.get(i));
        }
        return reverseAL;
    }

    /**
     * returns the the shortest path between src to dest - as an ordered List of nodes:
     * src--> n1-->n2-->...dest
     * see: https://en.wikipedia.org/wiki/Shortest_path_problem
     * Note if no such path --> returns null;
     * @param src - start node
     * @param dest - end (target) node
     * @return
     */
    @Override
    public List<node_data> shortestPath(int src, int dest) {
        bfs(src);
        int mark=1;
        boolean flag=true;
        ArrayList<node_data>ShortPath=new ArrayList<>();
        node_data start = galgo.getNode(dest);
        mark=start.getTag()-1;
        node_data oldnod;
        while (start.getKey() != src) {
            ShortPath.add(start);
            oldnod=start;
            for (node_data nei : start.getNi()) {
                if (nei.getTag() == mark) {
                    start = nei;
                    break;
                }
            }
            mark--;
            if(oldnod == start)
            {
                ShortPath=new ArrayList<>();
                flag=false;
                break;
            }
        }
        if(flag)
            ShortPath.add(start);
        return ReverseArrayList(ShortPath);
    }
}