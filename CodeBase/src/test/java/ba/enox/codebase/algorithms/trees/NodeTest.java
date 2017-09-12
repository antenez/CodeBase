package ba.enox.codebase.algorithms.trees;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

	
	@Test
	public void test() {
		Node treeNode = new Node(55);
		treeNode.insert(30);
		treeNode.insert(25);
		treeNode.insert(45);
		
		treeNode.insert(75);
		treeNode.insert(65);
		treeNode.insert(85);
		
		assertTrue("could not find value 55 ", treeNode.contains(55));
		assertTrue("could not find value 30 ", treeNode.contains(30));
		assertTrue("could not find value 25 ", treeNode.contains(25));
		assertTrue("could not find value 45 ", treeNode.contains(45));
		assertTrue("could not find value 75 ", treeNode.contains(75));
		assertTrue("could not find value 65 ", treeNode.contains(65));
		assertTrue("could not find value 85 ", treeNode.contains(85));
		treeNode.printInOrder();
	}

}
