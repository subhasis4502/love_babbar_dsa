/* Ref: https://www.youtube.com/watch?v=uDS8AkTAcIU */

import java.util.*;

class Node implements Comparable<Node>{
    char ch;
    int freq;
    Node left, right;
    Node(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
        left = right = null;
    }
    
    public int compareTo(Node other){
        if(this.freq == other.freq)
            return 1;
        
        return this.freq - other.freq;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        String s = "abcdef";
        int[] freq = {5, 9, 12, 13, 16, 45};

        huffmanCodes(s, freq);
    }

    static ArrayList<String> encoding;
    private static void huffmanCodes(String s, int[] freq) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        for(int i = 0; i<freq.length; i++){
            q.add(new Node(s.charAt(i), freq[i]));
        }
        
        while(q.size()>1){
            Node left = q.remove();
            Node right = q.remove();
            
            Node root = new Node('#', left.freq+right.freq);
            root.left = left;
            root.right = right;
            
            q.add(root);
        }
        
        Node root = q.remove();
        encoding = new ArrayList<>();
        preorder(root, "");
        
        System.out.println("Encoded message:");
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i) + ": " + encoding.get(i));
        }
    }

    private static void preorder(Node root, String s) {
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            encoding.add(s);
            return;
        }
        
        preorder(root.left, s+"0");
        preorder(root.right, s+"1");
    }
}
