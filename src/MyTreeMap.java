import java.util.NoSuchElementException;

public class MyTreeMap<Key extends Comparable<Key>, Value> {

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size; //РєРѕР»-РІРѕ СѓР·Р»РѕРІ РІ РґРµСЂРµРІРµ, РєРѕСЂРЅРµРј РєРѕС‚РѕСЂРѕРіРѕ СЏРІР»СЏРµС‚СЃСЏ РґР°РЅРЅС‹Р№ СѓР·РµР»
        int height;

        public Node(Key key, Value value, int size, int height) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
        }
    }

    private Node root = null;

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.size;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.height;
        }
    }

    public Value get(Key key) { //a[key]
        return get(key, root);
    }

    private Value get(Key key, Node node) { //key = B
        if (key == null) {
            throw new IllegalArgumentException("РќРµ РјРѕР¶РµС‚ Р±С‹С‚СЊ РєР»СЋС‡Р° СЃРѕ Р·РЅР°С‡РµРЅРёРµРј null.");
        }

        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        }
        if (cmp < 0) {
            return get(key, node.left);
        } else { //cmp > 0
            return get(key, node.right);
        }
    }

    public void put(Key key, Value value) { //a[key] = value
        root = put(key, value, root);
    }

    private Node put(Key key, Value value, Node node) {
        if (key == null) {
            throw new IllegalArgumentException("РќРµ РјРѕР¶РµС‚ Р±С‹С‚СЊ РєР»СЋС‡Р° СЃРѕ Р·РЅР°С‡РµРЅРёРµРј null.");
        }

        if (node == null) {
            return new Node(key, value, 1, 0);
        }

        if (node.height < 7) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) {
                node.value = value;
            } else if (cmp < 0) {
                node.left = put(key, value, node.left);
            } else { //cmp > 0
                node.right = put(key, value, node.right);
            }
            node.size = size(node.left) + size(node.right) + 1;
            if (height(node.left) > height(node.right)) {
                node.height = height(node.left);
            } else {
                node.height = height(node.right);
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }

    public Value min() {
        return min(root).value;
    }

    private Node max(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return max(node.right);
        }
    }

    public Value max() {
        return max(root).value;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.left = removeMin(node.left);
        }
        node.size = size(node.left) + size(node.right) + 1;
        if (height(node.left) > height(node.right)) {
            node.height = height(node.left);
        } else {
            node.height = height(node.right);
        }
        return node;
    }

    public void removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Р”РµСЂРµРІРѕ - РїСѓСЃС‚РѕРµ.");
        }
        root = removeMin(root);
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            return node.left;
        } else {
            node.right = removeMax(node.right);
        }
        node.size = size(node.left) + size(node.right) + 1;
        if (height(node.left) > height(node.right)) {
            node.height = height(node.left);
        } else {
            node.height = height(node.right);
        }
        return node;
    }

    public void removeMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Р”РµСЂРµРІРѕ - РїСѓСЃС‚РѕРµ.");
        }
        root = removeMax(root);
    }

    public void remove(Key key) {
        root = remove(key, root);
    }

    private Node remove(Key key, Node node) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) { //remove
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node tmp = node;
            node = max(node.left); //node = min(node.right);
            node.left = removeMax(tmp.left);
            node.right = tmp.right; //node.right = removeMin(node.right);
            tmp = null;
        } else if (cmp < 0) {
            node.left = remove(key, node.left);
        } else { //cmp >
            node.right = remove(key, node.right);
        }
        node.size = size(node.left) + size(node.right) + 1;
        if (height(node.left) > height(node.right)) {
            node.height = height(node.left);
        } else {
            node.height = height(node.right);
        }
        return node;
    }

    private int lh = 0;
    private int rh = 0;

    private void leftHeight(Node node) {
        if (root != null) {
            lh = height(node.left);
            lh = lh + 1;
        }
    }

    private void rightHeight(Node node) {
        if (root != null) {
            rh = height(node.right);
            rh = rh + 1;
        }
    }

    public boolean balance() {
        leftHeight(root);
        rightHeight(root);
        int res = lh - rh;
        lh = rh = 0;
        return res < 2;
    }

    public boolean isHeightBalanced(Node node) {
        return (node == null) ||
                (isHeightBalanced(node.left) && isHeightBalanced(node.right) && Math.abs(height(node.left) - height(node.right)) <= 1);
    }

}