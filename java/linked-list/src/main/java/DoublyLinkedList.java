class DoublyLinkedList<T> {
    private Element<T> head;

    void push(T value) {
        if (head == null) {
            head = new Element<>(value, null, null);
            return;
        }
        var node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Element<>(value, node, null);
    }

    T pop() {
        if (head == null) {
            return null;
        }
        var node = head;
        while (node.next != null) {
            node = node.next;
        }
        var result = node.value;
        if (node.prev != null)
            node.prev.next = null;
        return result;
    }

    void unshift(T value) {
        var newNode = new Element<>(value, null, head);
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    T shift() {
        if (head == null) {
            return null;
        }
        var result = head.value;
        head = head.next;
        return result;
    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
