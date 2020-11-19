package ex0;

import java.util.Collection;
import java.util.HashMap;

public class NodeData implements node_data
{

private String info = "";
private int tag;
private int k;
private static int key=0;
HashMap<Integer,node_data> nei=new HashMap<Integer, node_data>();
NodeData()
{
    this.nei=new HashMap<Integer, node_data>();
    this.k=key;
    key++;
    info="";
    tag=0;
}
    /**
     * Return the key (id) associated with this node.
     * Note: each EX0.ex0.node_data should have a unique key.
     * @return
     */
    @Override
    public int getKey() {
        return k;
    }


    /**
     * Allow setting the "key" of the this EX0.ex0.node_data
     * practice for marking by algorithms.
     * @param key - the key value of this EX0.ex0.node_data
     */
    public void setKey (int key){
    k=key;
    }
    /**
     * This method returns a collection with all the Neighbor nodes of this EX0.ex0.node_data
     * @return*/
    @Override
    public Collection<node_data> getNi() {
         return nei.values();
    }
    /**
     * return true iff this<==>key are adjacent, as an edge between them.
     * @param key
     * @return
     */
    @Override
    public boolean hasNi(int key) {
    if(nei.containsKey(key))
    {
        return true;
    }
    else
        {
            return false;
        }
    }
    /** This method adds the EX0.ex0.node_data (t) to this EX0.ex0.node_data.
     * This method is wrongly designed! and was used mainly for educational example - to be improved in Ex1
     * */
    @Override
    public void addNi(node_data t) {
          nei.put(t.getKey(),t);
    }


    /**
     * Removes the edge this-node,
     * @param node
     */
    @Override

    public void removeNode(node_data node) {

    nei.remove(node.getKey());

    }

    /**
     * return the remark (meta data) associated with this node.
     * @return
     */

    @Override
    public String getInfo() {
        return info;
    }
    /**
     * Allows changing the remark (meta data) associated with this node.
     * @param s
     */
    @Override
    public void setInfo(String s) {
    info=s;

    }
    /**
     * Temporal data (aka color: e,g, white, gray, black)
     * which can be used be algorithms
     * @return
     */
    @Override
    public int getTag() {
        return tag;
    }
    /**
     * Allow setting the "tag" value for temporal marking an node - common
     * practice for marking by algorithms.
     * @param t - the new value of the tag
     */
    @Override
    public void setTag(int t) {
tag = t;

    }
    /**
     * Allow the client add node copy. this is very usefull in OOP.
     * @return n - return clone node
     */
  public  node_data getCopy(){
    node_data n= new NodeData();
      ((NodeData)n).setKey(k);
      n.setTag(tag);
      n.setInfo(info);
    return n;
  }

}
