
public class MainClass_07_201401703 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "A";
		Node string1 = new Node("B");
		Node string2 = new Node("C");
		Node node = new Node(string, string1, string2);
		node.inorder(node);
		node.preorder(node);
		node.postorder(node);
		
		System.out.println(node.height());
		System.out.println(node.numberOfNodes());
	}
}
