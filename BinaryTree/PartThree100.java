package com.ouc.algorithem.CodingInterviewGuidePart3;
import static com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;
/*
 * 难度：二星尉
 * 较为直观地打印出二叉树地形状
 */
public class PartThree100 {

	/*
	 * 将二叉树逆时针旋转90度来打印，另外
	 * 1.如果一个打印结果的前缀和后缀都有‘H’，表明它是头结点
	 * 2.如果一个打印结点的前缀和后缀都有‘v’,表明父结点在当前所在结点的前一列
	 * 3.如果一个打印结点的前缀后后缀都有‘^’，表名父节点在当前所在节点的后一列
	 * 
	 * 需要保证每个结点数据打印时所占用的统一长度，以保证对齐
	 * 这里规定每个结点占17个位置，不够的地方用空格补充
	 * 
	 * 实现使用右 中 左的遍历方法，如果这个结点所在层为i,先打印i * 17 个空格结点
	 */
	public static void printTree(Node head){
		System.out.println("Binary Tree:");
		//开始打印过程
		printInOrder(head, 0, "H", 5);
		System.out.println();
	}
	
	/*
	 * height：表示当前结点所处的高度，用来计算前面需要打印多少先导空格
	 * to: 连接在value前后的标识符号 ‘H’, ‘^’, 'v'
	 * len: 结点所占的长度
	 * 由于打印是从上往下一行一行打印的，根据二叉树旋转后的结构，打印顺序必须是右中左
	 * 如果是顺时针，打印顺序就是左中右
	 */
	private static void printInOrder(Node head, int height, String to, int len) {
		// TODO Auto-generated method stub
		if(head == null){
			return;
		}
		printInOrder(head.left, height + 1, "v", len);
		
		String val = to + head.value + to;
		int lenM = val.length();						//中间字符长度
		int lenL = (len - lenM) / 2;					//左边空格长度
		int lenR = len - lenL - lenM;					//右边空格长度
		val = getSpace(lenL) + val + getSpace(lenR);	//组装
		System.out.println(getSpace(height * len) + val);
		
		printInOrder(head.right, height + 1, "^", len);
	}

	private static String getSpace(int length) {
		// TODO Auto-generated method stub
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for(int i = 0;i < length; i++){
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Node head = createTree(arr);
		printTree(head);
	}

}
