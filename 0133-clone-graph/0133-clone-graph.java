/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node[] visited = new Node[101];

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited[node.val] != null) {
            return visited[node.val];
        }

        Node newNode = new Node(node.val);
        visited[node.val] = newNode;

        for (Node next : node.neighbors) {
            newNode.neighbors.add(cloneGraph(next));
        }

        return newNode;
    }
}