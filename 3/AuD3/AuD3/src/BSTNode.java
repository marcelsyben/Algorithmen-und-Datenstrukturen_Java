class BSTNode {
	
    public int key;
    public String val;
    public BSTNode left, right, parent;
    
    public BSTNode(int k, String s) {
        this.key = k;
        this.val = s;
        this.left = null;
        this.right = null;
    }
   
   public int getKey() {
       return key;
   }
   
   public void setKey(int key) {
       this.key = key;
   }
   
   public String getVal() {
       return val;
   }
   
   public void setVal(String val) {
       this.val = val;
   }
   
   @Override
   public String toString() {
       return "BSTNode [key=" + key + ", val=" + val + "]";
   }
    
   }