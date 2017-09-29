package tree;

/**
 * 二叉树的三叉链表结构
 * 
 *
 * @author {wqz}
 *
 * @date 2017年9月2日 下午8:58:01
 */
public class BinTreeNode {
	private Object data;
	private BinTreeNode parent; // 父节点
	private BinTreeNode lChild;
	private BinTreeNode rChild;
	private int height; // 以该节点为根子树的高度
	private int size; // 以该节点为根子树的节点数（包括结点本身）

	public BinTreeNode() {
		this(null);
	}

	public BinTreeNode(Object e) {
		data = e;
		height = 0;
		size = 1;
		parent = lChild = rChild = null;
	}

	public Object getData() {
		return data;
	}

	/**
	 * 判断是否有父节点
	 * 
	 * @return
	 */
	public boolean hasParent() {
		return parent != null;
	}
	public boolean hasLChild() {
		return lChild != null;
	}
	public boolean hasRChild() {
		return rChild != null;
	}
	/**
	 * 判断是否为叶子
	 * @return
	 */
	public boolean isLeaf() {
		return !hasLChild() && !hasRChild();
	}
	public boolean isLChild() {
		return hasParent() && this==parent.lChild;
	}
	public boolean isRChild() {
		return hasParent() && this==parent.rChild;
	}
	/*****************和height有关的方法**************************/
	public int getHeight(){
		return height; 
	}
	/**
	 * 更新当前节点及其祖先的高度
	 */
	public void updateHeight(){
		//System.out.println("进入updateheight");
		int newH =0;    //新高度等于左右子树高度加1中的大者
		if(hasLChild()) 
			newH = Math.max(newH,1+getLChild().getHeight());
		if(hasRChild()) 
			newH = Math.max(newH, 1+getRChild().getHeight());
		if(newH==height) 
			return;
		height = newH;
		if(hasParent()) 
			getParent().updateHeight();     //递归更新祖先的高度
	}
                 /**************size相关的方法***********************/
	public int getSize(){
		return size;
	}
	/**
	 * 更新该结点及其祖先的子孙数
	 */
	public void updateSize(){
		size =1;    //初始化为结点本身
		if(hasLChild()) size+=getLChild().getSize();     //加上左子树规模
		if(hasRChild()) size+=getRChild().getSize();     //加上右子树规模
		if(hasParent()) getParent().updateHeight();      //递归更新祖先的规模
	}
	/**********parent相关的方法************/
	public BinTreeNode getParent() {
          return parent;
 	}
	/**
	 * 断开与父节点的关系
	 */
    public void server(){
    	if(!hasParent()) return;
    	if(isLChild()){ 
   		parent.lChild=null;
    	}	
    	else
    		parent.rChild = null;
    	parent.updateHeight();   //更新父节点及其祖先的高度
    	parent.updateSize();     //跟新父节点及其祖先的规模
    	parent = null;
    }
    /**********RChild相关的方法************/
	public BinTreeNode getRChild() {
		return rChild;
	}
	/**
	 * 设置当前节点的右孩子，返回原右孩子
	 * @param rc
	 * @return
	 */
    public BinTreeNode setRChild(BinTreeNode rc){
    	BinTreeNode oldRC = this.rChild;
    	if(hasRChild()){
    		rChild.server();   //断开当前右孩子与节点的关系
    	}
    	if(rc!=null){
    		rc.server();   //断开rc与其父节点的关系
    		this.rChild =rc;   //确定父子关系
    		rc.parent = this;
    		this.updateHeight();
    		this.updateSize();
    	}
    	return oldRC;
    }
    /**********LChild相关的方法************/
	private BinTreeNode getLChild() {
		return lChild;
	}
	/**
	 * 设置当前节点的左孩子，返回原左孩子
	 * @param rc
	 * @return
	 */
	 public BinTreeNode setLChild(BinTreeNode lc){
	    	BinTreeNode oldLC = this.lChild;
	    	if(hasLChild()){
	    		lChild.server();   //断开当前左孩子与节点的关系
	    	}
	    	if(lc!=null){
	    		lc.server();   //断开lc与其父节点的关系
	    		this.lChild =lc;   //确定父子关系
	    		lc.parent = this;
	    		this.updateHeight();
	    		this.updateSize();
	    	}
	    	return oldLC;
	    }
	 public static void main(String[] args) {
		BinTreeNode a = new BinTreeNode("A");
		BinTreeNode b = new BinTreeNode("B");
		a.setLChild(b);
		BinTreeNode c = new BinTreeNode("C");
		a.setRChild(c);
		BinTreeNode d = new BinTreeNode("D");
		BinTreeNode e = new BinTreeNode("E");
		b.setLChild(d);
		b.setRChild(e);
//		BinTreeNode f = new BinTreeNode("F");
//		BinTreeNode g = new BinTreeNode("G");
//		c.setLChild(f);
//		c.setRChild(g);
		System.out.println(a.getHeight());
	}
	 
}
