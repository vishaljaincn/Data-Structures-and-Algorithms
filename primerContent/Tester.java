package primerContent;

import java.util.LinkedList;
import java.util.Queue;

public class Tester {
    public static void main(String[] args) {
        Queue<Character>q=new LinkedList<>();
        q.offer('a');
        q.offer('b');
        q.offer('c');
        q.offer('a');
        q.offer('b');
        q.offer('c');
        System.out.println(q);
        q.poll();
        System.out.println(q);
    }
}
