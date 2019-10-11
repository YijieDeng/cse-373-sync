
public class BTree<T extends Comparable<T>> {
    public DNode root;

    public BTree(){
        root = new DNode(null);
    }

    private class DNode {

        private boolean isRed;
        private DNode left;
        private DNode right;
        private T data;

        DNode(T value) {
            markRed();
            this.left = null;
            this.right = null;
            this.data = value;
        }

        DNode(DNode left,DNode right, T value) {
            this(value);
            this.left = left;
            this.right = right;
        }

        public void markRed(){
            this.isRed = true;
        }
        public void markBlack(){
            this.isRed = false;
        }
        public void reverseColor(){
            if (isRed()){
                markBlack();
            } else {
                markRed();
            }
        }
        public boolean isRed(){
            return isRed;
        }
    }

    public void add(T value) {
        this.root = add(this.root, value);
    }

    public DNode add(DNode root, T value) {
        if (root == null) {
            return new DNode(value);
        }
        int comp = value.compareTo(root.data);
        if (comp < 0) {
            root.left = add(root.left, value);
        } else if (comp > 0) {
            root.right = add(root.right, value);
        } else {
            // do nothing yet!
        }

        if(!isRed(root.left) && isRed(root.right)) {
            root = rotateLeftPivot(root);
        }
        if(isRed(root.left) && isRed(root.left.left)) {
            root = rotateRightPivot(root);
        }
        if(isRed(root.left) && isRed(root.right)) {
            flip(root);
        }
        return root;
    }

    public boolean isRed(DNode node) {
        if (node == null) {
            return false;
        }
        return node.isRed();
    }

    public void flip(DNode root) {
        root.reverseColor();
        if(root.left!=null) {
            root.left.reverseColor();
        }
        if(root.right!=null) {
            root.right.reverseColor();
        }
    }

    public DNode rotateLeftPivot(DNode root){
        DNode pivot = root.right;
        root.right = pivot.left;
        pivot.left = root;
        return pivot;
    }

    public DNode rotateRightPivot(DNode root){
        DNode pivot = root.left;
        root.left = pivot.right;
        pivot.right = root;
        return pivot;
    }


}

