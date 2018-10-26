import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for hash table.
 */
class HashTable {
    /**
     * Class for node.
     */
    class Node {
        /**
         * { key will be given word}.
         */
        private String key;
        /**
         * {count of the word given}.
         */
        private Integer val;
        /**
         * {it will give the next node}.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      k     { name of the string}
         * @param      v     { count of the given string }
         * @param      n     { next node}
         */
        Node(final String k, final Integer v, final Node n) {
            this.key = k;
            this.val = v;
            this.next = n;
        }
        /**
         * { gives the key}.
         *
         * @return     {key}
         */
        String getkey() {
            return this.key;
        }
        /**
         * Gets the value.
         *
         * @return     The value.
         */
        Integer getValue() {
            return this.val;
        }
        /**
         * { sets the value}.
         *
         * @param      v     {count }
         */
        void setvalue(final Integer v) {
            this.val = v;
        }
    }
    /**
     * {array for node}.
     */
    private Node[] st;
    /**
     * { size of the array}.
     */
    private int s = (2 * (2 + 2 + 1)) * (2 * (2 + 2 + 1));
    /**
     * Constructs the object.
     */
    HashTable() {
        st = new Node[s];
    }
    /**
     * { gives hash code}.
     *
     * @param      k     { name of the string}
     *
     * @return     { returns hash code }
     */
    int hash(final String k) {
        final int numb = 0x7fffffff;
        return (k.hashCode() & numb) % s;
    }
    /**
     * { resizes the array }.
     */
    public void resize() {
        st = Arrays.copyOf(st, 2 * s);
    }
    /**
     *In the insertion method here, the time complexity will be 
     *in the O(log(N)) in the worst case and constant time in other cases.
     */
    /**
     * { puts the value in hash table}.
     *
     * @param      k     {string}
     * @param      v     {count}
     */
    public void put(final String k, final Integer v) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                x.setvalue(x.getValue() + 1);
                return;
            }
        }
        if (i >= st.length) {
            resize();
        }
        st[i] = new Node(k, v, st[i]);
    }
    /**
     *In the search method , the time complexity will be
     *in the order of the log(N) in the worst cases and constant
     *time in avereage and worst cases.
     */
    /**
     * {returns the boolean value based on the condition}.
     *
     * @param      k     {word}
     *
     * @return     {boolean value}
     */
    public boolean get(final String k) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                if (x.getValue() > 0) {
                    x.setvalue(x.getValue() - 1);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
/**
 * { class of Solution }.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * {main function}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        String[] magazine = sc.nextLine().split(" ");
        String[] note = sc.nextLine().split(" ");
        HashTable h = new HashTable();
        for (int i = 0; i < m; i++) {
            h.put(magazine[i], 1);
        }
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (!h.get(note[i])) {
                flag = false;
                System.out.println("No");
                break;
            }
        }
        if (flag) {
            System.out.println("Yes");
        }
    }
}
