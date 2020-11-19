# Undirected-Unweighted-Graph

This is a graph implements hashmap and give you best Complexity ever.
you can use it,edit it, publish it,and what you want to do with it.


##Graph_DS
Graph_DS is implement of graph.java

##Methods 
addNode -adding new node to the graph that takes O(1)
removeNode - removing node that graph had that takes O(n)
getV(int node_id) - returned Collection of node_data that containing all the nodes that connected to node_id. this takes o(1)
removeEdge - remove given edge from graph - run in O(1)
getNode - get node from the nodes list that the graph had. it takes just O(1)
hasEdge - check if the graph had given edge. this takes O(1)
connect - create edge between node1 and node2 by key this takes O(1)
get(v) - this method return a pointer (shallow copy) for the collection representing all the nodes in the graph. it takes just o(1)
edgesize() - return the number of edges (undirectional graph). this method  run in O(1) time.
getMC() - return the Mode Count - for testing changes in the graph. run in o(1)
nodeSize() - return the number to verices (nodes) in the graph. run in O(1).


##Graph_Algo
Graph_Algo is implement of graph_algorithms.java

##Methods 
init - Init the EX0.ex0.graph on which this set of algorithms operates on.
copy() - clone the graph to new one
isConnected() - check if the graph is connected graph or not using bfs
bfs - implement the bfs algorithm starting from given int of node.
shortestPathDist - returns the length of the shortest path between src to dest
ReverseArrayList - method to make a reverse of ArrayList.
shortestPath - Returns the the shortest path between src to dest - as an ordered List of nodes: src--> n1-->n2-->...dest

##NodeData
NodeData is implement of node_data.java

##Methods 
getkey - Return the key (id) associated with this node. each EX0.ex0.node_data should have a unique key.
setkey - set key manually for a node.
getNi() - This method returns a collection with all the Neighbor nodes of this EX0.ex0.node_data
hasNi - check if node is adjacent of some another node.
addNi - Adding new neighbor to specific node.
removeNode - remove the edge from chosen node to given node.
getInfo - return info of node
setInfo - set info of node
getTag - get the tag of node
SetTag - set a tag of node
getCopy() - clone the node to a new one.

Graph_Ex0_Test2.Java
had many test of the graph and check that all have complexity that matched the required.

Ex0_GraphTest
another test for the graph.





