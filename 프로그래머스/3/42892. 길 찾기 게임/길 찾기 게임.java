import java.util.*;

class Solution {
    
    class Node implements Comparable<Node>{
        
        int index, x, y;
        Node left, right;
        
        public Node(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Node other) {
            if (this.y == other.y) {
                return Integer.compare(this.x, other.x);
            }
            return Integer.compare(other.y, this.y);
        }
    }
    
    private Node Root;
    private List<Integer> Preorders = new ArrayList<>();
    private List<Integer> Postorders = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        List<Node> nodes = new ArrayList<>();
        
        for (int i = 0; i < nodeinfo.length; ++i) {
            nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        Collections.sort(nodes);
        
        Root = nodes.get(0);
        for (int i = 1; i < nodes.size(); ++i) {
            construct(Root, nodes.get(i));
        }
        
        preorder(Root);
        postorder(Root);
        
        answer[0] = Preorders.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = Postorders.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
    private void construct(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                construct(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                construct(parent.right, child);
            }
        }
    }
    
    private void preorder(Node root) {
        if (root == null) return;
        Preorders.add(root.index);
        preorder(root.left);
        preorder(root.right);
    }
    
    private void postorder(Node root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        Postorders.add(root.index);
    }
}