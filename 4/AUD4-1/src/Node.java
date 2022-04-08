class RBTNode {

  public static final boolean black=false;
  public static final boolean red=true;

  public int key;
  public String val;
  public RBTNode left, right, parent;
  public boolean color;

    public RBTNode(int k, String s) {

      this.key = k;
      this.val = s;
    }
  }