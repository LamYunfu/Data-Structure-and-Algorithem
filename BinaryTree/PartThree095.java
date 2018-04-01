package com.ouc.algorithem.CodingInterviewGuidePart3;
import static com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;

/*
 * �Ѷȣ�����ξ
 * ��ʱ���ӡ�������ı߽���
 */
public class PartThree095 {
	/*
	 * ͷ��� + ҳ��� + ��������ڲ������������ҽ��
	 */
	public static void printEdge1(Node head){
		if(head == null){
			return;
		}
		//�õ��������ĸ߶�
		int height = getHeight(head, 0);
		Node[][] edgeMap = new Node[height][2];				//�������ÿ������ߵĽ��
		setEdgeMap(head, 0, edgeMap);						//�õ�ÿ�����߽��
		//�ȴ�ӡ��߽��
		for(int i = 0;i < height;i++){
			System.out.print(edgeMap[i][0].value + " ");
		}
		//��ӡ�Ȳ�����߽磬�ֲ����ұ߽��Ҷ�ӽ��
		printLeafNotInMap(head, 0, edgeMap);
		//��ӡ���ұ߽��㣬�����ǲ�������߽磬����һ��ֻ��һ����㣩
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
	 * ÿһ���������һ�������������������һ�����ȱ������Ľ��
	 * ÿһ������ұ߽��һ�����������������һ�������������Ľ��
	 * �������������
	 * ��������ĵݹ���ǰ��
	 * һ��ʼ��һֱ�����ߣ���Ͷ��·���ң���Ҳ����һ����ߵ�һ��
	 * ���ұߵ��������ʵģ����ֻ��Ҫ���ϵ�ˢ��ÿһ���ұߵĽ�㣬���һ��ˢ�µľ������ұߵĽ��
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


	//�õ��������ĸ߶ȣ����õݹ�,�ҵķ������ȵ���ײ㣬Ȼ�������ϼ���
	//������ֱ�������²�ݹ��ʱ����ڼ���
	/*
	private int getHeight(Node head) {
		// TODO Auto-generated method stub
		if(head == null){
			return 0;
		}
		int h1 = getHeight(head.left);				//�������߶�
		int h2 = getHeight(head.right);				//�������߶�
		return h1 > h2 ? (h1 + 1) : (h2 + 1);
	}
	*/
	//���з���
	private static int getHeight(Node head, int depth) {
		// TODO Auto-generated method stub
		if(head == null){
			return depth;
		}
		return Math.max(getHeight(head.left, depth + 1), getHeight(head.right, depth + 1));
	}

	
	
	
	
	/*
	 * ͷ��� + Ҷ��� + ����������������ȥ�Ľ��
	 * �ȴ�ӡ�������ĳ�����״��㣨����еĻ���
	 */
	public static void printEdge2(Node head){
		if(head == null){
			return;
		}
		System.out.print(head.value + " ");
		//�Ӹ���㿪ʼ���£��ҵ��ĵ�һ���������ӣ������Һ��ӵĽ��
		if(head.left != null && head.right != null){		
			printLeftEdge(head.left, true);		//��ӡ�������·���Լ������������е�Ҷ���
			printRightEdge(head.right, true);		//��ӡ�ұߡ�����
		}
		//���ڰ�������,�õݹ�������
		else{
			printEdge2(head.left != null ? head.left : head.right);
		}
	}
	
	//����Ҫ����ʱ���Ե�ʣ������������Ҫʹ�ú������
	private static void printRightEdge(Node h, boolean print) {
		if(h == null){
			return;
		}
		printRightEdge(h.left, print && h.right == null ? true : false);
		printRightEdge(h.right, print);			//�ұ�������
		//����ݹ鵽��Ҷ�ӽ��,�����ǿ��Դ�ӡ�Ľ�㣨Ҷ�ӽ�㲻��print���ƣ�
		if(print || (h.left == null && h.right == null)){
			System.out.print(h.value + " ");
		}
		
	}

	private static void printLeftEdge(Node h, boolean print) {
		if(h == null){
			return;
		}
		//����ݹ鵽��Ҷ�ӽ��
		if(print || (h.left == null && h.right == null)){
			System.out.print(h.value + " ");
		}
		printLeftEdge(h.left, true);		//������ߣ�ֻҪ��Ϊ�գ���һ���ǿ��Դ�ӡ��
		/*
		 * ���ұ���
		 * 1.ͬһ����߽��Ϊ�գ���ô����ұ߽���ǿ��Դ�ӡ��
		 * 2.Ϊʲô��Ҫ�ж�һ��print?
		 * ��Ϊ����������̻��������������
		 * �п��ܵ�ǰ������λ���Ѿ�����������ˣ����ʱ����ʵ��������������������
		 * ��ʹ����ֵܽ��Ϊ�գ�Ҳ���ܱ���ӡ����ʱprint����Ѿ����ϲ��Ϊfalse
		 * print�ڽ�������������߷ǿ���������ʱ�򣬻���false(h.left == null ?)
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
