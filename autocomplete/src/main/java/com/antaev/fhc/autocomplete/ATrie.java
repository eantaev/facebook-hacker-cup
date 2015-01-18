package com.antaev.fhc.autocomplete;

/**
 * Date: 18.01.15
 * Time: 4:55
 *
 * @author Evgeny Antaev
 */

class ATrie {
    private static final int ALPHABET_SIZE = 'z' - 'a' + 1;
    private final Node root = createNode();

    private Node createNode() {
        return new Node();
    }

    private static int charIndex(char c) {
        return c - 'a';
    }

    public int countStepsToIdentifyKey(String key) {
        return countStepsToIdentifyKey(root, key);
    }

    private static int countStepsToIdentifyKey(Node root, String key) {
        Node node = root;
        int steps = 0;
        while (steps < key.length() && (node = node.next(key.charAt(steps))).count != 1)
            ++steps;
        if (steps < key.length())
            ++steps;
        return steps;
    }

    public void add(String key) {
        add(root, key);
    }

    private void add(Node root, String key) {
        Node node = root;
        for (int i = 0; i < key.length(); ++i) {
            int k = charIndex(key.charAt(i));
            Node nextNode = node.next[k];
            if (nextNode == null) {
                nextNode = createNode();
                node.next[k] = nextNode;
            }
            node = nextNode;
            node.count++;
        }
    }

    private static class Node {
        private final Node[] next;
        private int count;

        private Node() {
            next = new Node[ALPHABET_SIZE];
        }

        Node next(char c) {
            return next[charIndex(c)];
        }
    }

}
