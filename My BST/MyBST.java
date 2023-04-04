import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class MyBST {
private BSTNode root;
HashMap<BSTNode, Integer> allheights = new HashMap<>();
private class BSTNode {
Integer val;
BSTNode left, right;
Integer dep;

public BSTNode(Integer val){
this.val = val;
left = right = null;
dep = -1;
}
public String toString(){
return " " + this.val;
}

}

public Integer size(){
BSTNode start = root;
Integer size = sizeHelper(start);
return size;


}
public Integer sizeHelper(BSTNode cur){
if (cur==null){
return 0;
}
return sizeHelper(cur.right) + sizeHelper(cur.left)+1;
}

public void insert(Integer n){
BSTNode wow = new BSTNode(n);
BSTNode cur = root;
if (cur == null){
root = new BSTNode(n);
}
else{
while ((cur.val>wow.val && cur.left!= null) || (cur.val < wow.val && cur.right != null)){
if (wow.val > cur.val){
cur = cur.right;
}
else {
cur = cur.left;
}

}
if (wow.val > cur.val){
cur.right = wow;

}
else {
cur.left = wow;
}
}
}
public boolean contains(Integer n){
BSTNode curr = root;
boolean rightmay = containsHELP(n, curr);
return rightmay;
}
public boolean containsHELP(Integer targer, BSTNode cur){
if (cur == null){
return false;
}
else if (cur.val.equals(targer)){
return true;
}
return containsHELP(targer, cur.right) || containsHELP(targer, cur.left);
}

public Integer getMax(){


if (root == null){
return null;
}

return maxHELP(root);

}
public Integer maxHELP(BSTNode cur){
if (cur.right == null){
return cur.val;
}
return maxHELP(cur.right);


}

public Integer getMin(){
if (root == null){
return null;
}
return minHELP(root.left);

}
public Integer minHELP(BSTNode cur){
if (cur.left == null){
return cur.val;
}
return minHELP(cur.left);
}

public void delete(Integer n){
deleteHELPHELP(root, root, n);
}
public boolean deleteHELPHELP(BSTNode cur, BSTNode prev, Integer targer){
if (cur == null){
return false;
}
else if (cur.val.equals(targer)){
if (cur.left == null && cur.right == null){
if (cur.val > prev.val){
prev.right = null;
}
else if (cur.val < prev.val){
prev.left = null;
}
return true;
}

else if (cur.right != null || cur.left != null){
if (cur.right == null && cur.left != null){
if (cur.val > prev.val){
prev.right = cur.left;
}
else {
prev.left = cur.left;
}
}
else if (cur.left == null && cur.right != null){
if (cur.val > prev.val){
prev.right = cur.right;
}
else {
prev.left = cur.right;
}
}
}

else {
BSTNode replacer = deleteHELPHELPHELP(cur.right, cur.right);
if (cur.val < prev.val){
BSTNode left = cur.left;
BSTNode right = cur.right;
prev.left = replacer;
replacer.left = left;
replacer.right = right;
}
else if (cur.val > prev.val){
BSTNode left = cur.left;
BSTNode right = cur.right;
prev.right = replacer;
replacer.left = left;
replacer.right = right;
}
}


return true;
}
return deleteHELPHELP(cur.right, cur, targer) || deleteHELPHELP(cur.left, cur, targer);
}

public BSTNode deleteHELPHELPHELP(BSTNode cur, BSTNode prev){
if (cur.left == null){
prev.left = null;
return cur;
}
return deleteHELPHELPHELP(cur.left, cur);
}

public void inOrder(){
orderHELP(root, "");
}
public void orderHELP(BSTNode cur, String fin){
if (cur == null){
return ;
}
orderHELP(cur.left, fin);

System.out.print(cur.val + " ");
orderHELP(cur.right, fin);
if (cur == root){
System.out.println();
fin += "\n";
}
return ;

}

int getloco(BSTNode n, int depth) {
    if(n == null) return 0;
    n.dep = depth;



    allheights.put(n, 1 + Math.max(getloco(n.left, depth + 1), getloco(n.right, depth + 1)));

    return allheights.get(n);

  }

  void print() {
    int heirn = getloco(root, 0);
    int deprn = 0;


    int sizern = 0;
    if(heirn > 0) {
      Queue<BSTNode> baba = new LinkedList<>();
      baba.add(root);



      while(baba.size() > 0) { 


        BSTNode WAOW = baba.poll();
        if(WAOW == null) {


          if(deprn < heirn) {
            baba.add(null);
            System.out.print(getMSG(5));
          }
        }
        if(WAOW != null) {
          System.out.print(getMSG(allheights.get(WAOW) * 3) + WAOW.val + getMSG(allheights.get(WAOW) * 3));
          baba.add(WAOW.left);


          baba.add(WAOW.right);
        }
        if(sizern++ == (1 << deprn)) {
          deprn++;


          sizern = 0;


          System.out.println("\n\n");
        }
      }
    }
  }
  private String getMSG(int n) {
    String ans = "";
    for(int i = 0; i < n - 1; ++i) ans += ' ';
    return ans;
  }



} 