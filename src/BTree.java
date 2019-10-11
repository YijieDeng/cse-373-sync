import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BTree<T extends Comparable<T>> {
    public DNode root;

    public BTree(){
        root = new DNode(null);
    }

    private class DNode {
        private DNode parent;
        private boolean isRed;
        private DNode left;
        private DNode right;
        private T data;

        DNode(T value) {
            this.parent = null;
            markRed();
            this.left = null;
            this.right = null;
            this.data = value;
        }

        DNode(DNode parent, T value) {
            this(value);
            this.parent = parent;
        }

        DNode(DNode parent,DNode left,DNode right, T value) {
            this(parent, value);
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
            root.left.parent = root;
        } else if (comp > 0) {
            root.right = add(root.right, value);
            root.right.parent = root;
        } else {
            // do nothing yet!
        }

        if(root.right.isRed() && !root.left.isRed()) {
            root = rotateLeftPivot(root.right);
        }
        if(root.left.isRed()&&
                root.left.left!=null&&
                root.left.left.isRed()) {
            root = rotateRightPivot(root.left);
            flip(root);
            root = rotateLeftPivot(root);
        }
        if(root.right.isRed() && root.left.isRed()) {
            flip(root);
        }


        return root;
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

    public DNode rotateLeftPivot(DNode pivot){
        throw new NotImplementedException();
    }

    public DNode rotateRightPivot(DNode pivot){
        throw new NotImplementedException();
    }


}

