import java.util.Scanner;
/**
 * Class for book.
 */
class Book implements Comparable<Book> {
    /**
     * {name to be stored as string}.
     */
    private String name;
    /**
     * {name of author tobe stored as string}.
     */
    private String author;
    /**
     * {price to be stored as double.}.
     */
    private double price;
    /**
     * Constructs the object.
     *
     * @param      bookName    The book name
     * @param      authorName  The author name
     * @param      cost        The cost
     */
    Book(final String bookName, final String authorName,
         final double cost) {
        this.name = bookName;
        this.author = authorName;
        this.price = cost;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * {compare the names}.
     * time complexity is O(1)
     * @param      obj   The object
     *
     * @return     {return int value}
     */
    public int compareTo(final Book obj) {
        return this.getName().compareTo(obj.getName());
    }
}
/**
 * Class for binary search tree
 *
 * @param      <Key>     The key
 * @param      <Values>  The values
 */
class BinarySearchT<Key extends Comparable<Key>, Values> {
    /**
     * {root node}.
     */
    private Node root;
    /**
     * Class for node.
     */
    class Node {
        /**
         * {object of book class which has book details}.
         */
        private Key key;
        /**
         * {value of book in Book class}.
         */
        private Values value;
        /**
         * {right node of BST}.
         */
        private Node right;
        /**
         * {left node of BST}.
         */
        private Node left;
        /**
         * Constructs the object.
         *
         * @param      key1  The key 1
         * @param      val   The value
         */
        Node(final Key key1, final Values val) {
            this.key = key1;
            this.value = val;
        }

    }
    /**
     * {to add a key and value to BST}
     * Here order is 1 beacause we are calling another function.
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Key key, final Values value) {
        if (key == null) {
            return;
        }
        root = put(root, key, value);
    }
    /**
     * {add element to BST}.
     * complexity is O(N).
     * @param      node   The node
     * @param      key    The key
     * @param      value  The value
     *
     * @return     {node}
     */
    public Node put(final Node node, final Key key,
                    final Values value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }
    /**
     * {gives value of the key}.
     * order is complexity is O(N)
     * @param      key   The key
     *
     * @return     {value}
     */
    public Values get(final Key key) {
        return get(root, key);
    }
    /**
     * {return value of key}.
     * complexity is O(N)
     * @param      node  The node
     * @param      key   The key
     *
     * @return     {value}
     */
    private Values get(final Node node, final Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }
}
/**
 * {class for solution}.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * {main method}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchT<Book, Integer> obj = new BinarySearchT<>();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                obj.put(new Book(tokens[1], tokens[2], Double.parseDouble(
                                     tokens[3])),
                        Integer.parseInt(tokens[4]));
                break;
            case "get":
                System.out.println(obj.get(new Book(
                                               tokens[1], tokens[2],
                                               Double.parseDouble(
                                                   tokens[3]))));
                break;
            default:
                break;
            }
        }
    }
}