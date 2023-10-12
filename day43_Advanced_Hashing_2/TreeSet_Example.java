package day43_Advanced_Hashing_2;

import java.util.TreeSet;

public class TreeSet_Example {
    public static void main(String args[]) {
        TreeSet<Integer> tree = new TreeSet<Integer>();
        tree.add(1);
        tree.add(3);
        tree.add(5);
        tree.add(2);
        tree.add(4);
        System.out.println(tree.floor(3));
        System.out.println(tree.lower(3));
        System.out.println(tree.ceiling(3));
        System.out.println(tree.higher(3));
        System.out.println(tree.lower(1));
        System.out.println(tree.higher(5));
    }
}
