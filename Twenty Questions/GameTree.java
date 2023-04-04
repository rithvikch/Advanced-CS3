import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.jar.Attributes.Name;

import javax.print.attribute.standard.MediaSize.NA;

/**
 * A model for the game of 20 questions
 *
 * @author Rick Mercer
 */

public class GameTree
{
	private BSTNode root;
	private BSTNode rn;
	private String NAME = "";
	private class BSTNode {
		String val;
		BSTNode left, right;
		
		
		public BSTNode(String val){
		this.val = val;
		
		}
		public String toString(){
		return " " + this.val;
		}
		
		}
		

	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName
	 *          this is the name of the file we need to import the game questions
	 *          and answers from.
	 */

	public GameTree(String fileName)
	{
		//TODO
		
		try {
			Scanner scan = new Scanner(new File(fileName));
			
			addNodes(null, false, scan);
			rn = root;
			NAME = fileName;
		} catch (Exception WAOW){}
		
		
		
		
		

		

	}
	public void addNodes(BSTNode bruh, boolean may, Scanner scan){
		BSTNode stupid;
		if (bruh == null){
			root = new BSTNode(scan.nextLine().trim());
			stupid = root;


		}
		else {



			stupid = new BSTNode(scan.nextLine().trim());
			if (may){
				bruh.left = stupid;


			}
			else {
				bruh.right = stupid;


			}
		}
		if (stupid.val.substring(stupid.val.length()-1, stupid.val.length()).equals("?")){
			addNodes(stupid, true, scan);
			addNodes(stupid, false, scan);

		}


	}


	/*
	 * Add a new question and answer to the currentNode. If the current node has
	 * the answer chicken, theGame.add("Does it swim?", "goose"); should change
	 * that node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken  horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ
	 *          The question to add where the old answer was.
	 * @param newA
	 *          The new Yes answer for the new question.
	 */
	public void add(String newQ, String newA)
	{
		Queue<BSTNode> stuff = new LinkedList<>();

		stuff.add(root);
		while (stuff.size() > 0){
			BSTNode checkpls = stuff.poll();
			
			if (checkpls.right != null && checkpls.left != null){
				if (checkpls.left == rn){
					BSTNode fornow = checkpls.left;
					checkpls.left = new BSTNode(newQ.trim());
					checkpls.left.left = new BSTNode(newA.trim());
					checkpls.left.right = fornow;
					
				}
				else if (checkpls.right == rn){
					BSTNode fornow = checkpls.right;
					checkpls.right = new BSTNode(newQ);
					checkpls.right.left = new BSTNode(newA);
					checkpls.right.right = fornow;
					

				}
				else {
					stuff.add(checkpls.left);
					stuff.add(checkpls.right);
				}
				

			}
		}
		//TODO
	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer()
	{
		//TODO
		return rn.left == null && rn.right == null;
	}

	/**
	 * Return the data for the current node, which could be a question or an
	 * answer.  Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
	public String getCurrent()
	{
		//TODO

		return rn.val; //replace
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or
	 * right for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 *
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo)
	{
		//TODO
		if (yesOrNo == Choice.Yes){
			rn = rn.left;

		}
		else {
			rn = rn.right;
		}
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void reStart()
	{
		//TODO
		rn = root;
	}

	@Override
	public String toString()
	{
		//TODO

		return helpSTRING(root, "", 0);
	}
	/** */
	public String helpSTRING(BSTNode RN, String curcur, int wow){
		String waow = "";
		for (int i = 0; i < wow; i++){
			waow += "-";
		}
		if (RN.right != null){
			curcur = helpSTRING(RN.right, curcur, wow+1);
		}
		curcur += waow + RN.val + "\n";
		if (RN.left != null){
			curcur = helpSTRING(RN.left, curcur, wow+1);
		}
		return curcur;


	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may
	 * have new questions added since the game started.
	 *
	 */
	
	public void saveGame(){
		if (NAME.length() > 0){
			


			try{




				PrintWriter WOW = new PrintWriter(NAME);

				Stack<BSTNode> junko = new Stack<>();

				junko.add(root);


				while (junko.size() > 0){
					BSTNode cool = junko.pop();
					
					WOW.write(cool.val = "\n");
					if (cool.right != null){

						junko.add(cool.right);


					}
					if (cool.left != null){

						junko.add(cool.left);
					}

				}
				
			
		}
		catch (Exception BRO){}
	}
	}
}
	
	