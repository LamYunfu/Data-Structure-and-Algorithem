package com.ouc.algorithem.CodingInterviewGuidePart3;
import static com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;

/*
 * 难度：二星尉
 * 逆时针打印二叉树的边界结点
 */
public class PartThree095 {
	/*
	 * 头结点 + 页结点 + 结点是所在层的最左或者最右结点
	 */
	public static void printEdge1(Node head){
		if(head == null){
			return;
		}
		//得到二叉树的高度
		int height = getHeight(head, 0);
		Node[][] edgeMap = new Node[height][2];				//用来存放每层的两边的结点
		setEdgeMap(head, 0, edgeMap);						//得到每层两边结点
		//先打印左边结点
		for(int i = 0;i < height;i++){
			System.out.print(edgeMap[i][0].value + " ");
		}
		//打印既不是左边界，又不是右边界的叶子结点
		printLeafNotInMap(head, 0, edgeMap);
		//打印最右边界结点，（但是不是最左边界，比如一层只有一个结点）
		for(int i = edgeMap.length - 1; i >= 0; i--){
			if(edgeMap[i][1] != edgeMap[i][0]){
				System.out.print(edgeMap[i][1].value + " ");
			}
		}
	}
	
	private static void printLeafNotInMap(Node head, int i, Node[][] edgeMap) {
		// TODO Auto-generated method stub
		if(head == null){
			return;
		}
		if(head.left == null && head.right == null && head != edgeMap[i][0] && head != edgeMap[i][1]){
			System.out.print(head.value + " ");
		}
		printLeafNotInMap(head.left, i + 1, edgeMap);
		printLeafNotInMap(head.right, i + 1, edgeMap);
	}

	/*
	 * 每一层的最左结点一定是在先序遍历中在这一层最先遍历到的结点
	 * 每一层的最右边结点一定是在先序遍历在这一层中最后遍历到的结点
	 * 先序遍历中左右
	 * 由于向左的递归在前面
	 * 一开始会一直往左走，走投无路往右，那也是这一层左边第一个
	 * 而右边的是最后访问的，因此只需要不断的刷新每一层右边的结点，最后一次刷新的就是最右边的结点
	 */
	private static void setEdgeMap(Node head, int i, Node[][] edgeMap) {
		// TODO Auto-generated method stub
		if(head == null){
			return;
		}
		edgeMap[i][0] = edgeMap[i][0] == null ? head : edgeMap[i][0];
		edgeMap[i][1] = head;
		setEdgeMap(head.left, i + 1, edgeMap);
		setEdgeMap(head.right, i + 1, edgeMap);
	}


	//得到二叉树的高度，利用递归,我的方法是先到最底层，然后再往上计数
	//大佬是直接在往下层递归的时候就在计数
	/*
	private int getHeight(Node head) {
		// TODO Auto-generated method stub
		if(head == null){
			return 0;
		}
		int h1 = getHeight(head.left);				//左子树高度
		int h2 = getHeight(head.right);				//右子树高度
		return h1 > h2 ? (h1 + 1) : (h2 + 1);
	}
	*/
	//大佬方法
	private static int getHeight(Node head, int depth) {
		// TODO Auto-generated method stub
		if(head == null){
			return depth;
		}
		return Math.max(getHeight(head.left, depth + 1), getHeight(head.right, depth + 1));
	}

	
	
	
	
	/*
	 * 头结点 + 叶结点 + 树左右两边延伸下去的结点
	 * 先打印完树顶的长条棒状结点（如果有的话）
	 */
	public static void printEdge2(Node head){
		if(head == null){
			return;
		}
		System.out.print(head.value + " ");
		//从根结点开始往下，找到的第一个既有左孩子，又有右孩子的结点
		if(head.left != null && head.right != null){		
			printLeftEdge(head.left, true);		//打印左边延伸路径以及左子树上所有的叶结点
			printRightEdge(head.right, true);		//打印右边。。。
		}
		//还在棒子区域,用递归往下找
		else{
			printEdge2(head.left != null ? head.left : head.right);
		}
	}
	
	//由于要求逆时针的缘故，因此右子树需要使用后序遍历
	private static void printRightEdge(Node h, boolean print) {
		if(h == null){
			return;
		}
		printRightEdge(h.left, print && h.right == null ? true : false);
		printRightEdge(h.right, print);			//右边无条件
		//如果递归到了叶子结点,或者是可以打印的结点（叶子结点不受print限制）
		if(print || (h.left == null && h.right == null)){
			System.out.print(h.value + " ");
		}
		
	}

	private static void printLeftEdge(Node h, boolean print) {
		if(h == null){
			return;
		}
		//如果递归到了叶子结点
		if(print || (h.left == null && h.right == null)){
			System.out.print(h.value + " ");
		}
		printLeftEdge(h.left, true);		//往左边走，只要不为空，就一定是可以打印的
		/*
		 * 往右边走
		 * 1.同一层左边结点为空，那么这个右边结点是可以打印的
		 * 2.为什么还要判断一下print?
		 * 因为这个遍历过程会遍历整棵左子树
		 * 有可能当前进来的位置已经不是最左边了，这个时候其实是在左子树的右子树上
		 * 即使左边兄弟结点为空，也不能被打印，此时print早就已经在上层变为false
		 * print在进入左子树的左边非空右子树的时候，会变成false(h.left == null ?)
		 */
		printLeftEdge(h.right, print && h.left == null ? true : false);
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Node head = createTree(arr);
		printEdge1(head);
		System.out.println();
		printEdge2(head);
	}

}
