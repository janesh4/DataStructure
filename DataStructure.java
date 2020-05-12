1. Serialize and Deserialize Binary Search Tree.
https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1

class Tree {
	public void serialize(Node root, ArrayList<Integer> A) {
	    if (root == null){}
	    
	    Queue<Node> q = new LinkedList<Node>();
	    
	    q.add(root);
	    
	    while(q.size() != 0){
	        Node d = q.poll();
	         if(d == null){
	           A.add(-1);
	         }else{
	           A.add(d.data);  
	           q.add(d.left);
	           q.add(d.right);
	         }
	    }
	}
	
    public Node deSerialize(ArrayList<Integer> A){
        
        if(A.get(0) == null){return null;}
        
        Queue<Node> q = new LinkedList<Node>();
    
        Node root1 = new Node(A.get(0));
        
        // root.data = A.get(0);
        q.add(root1);
        
        int i = 1;
        
        while(q.size() != 0){
            Node h = q.poll();
            if(h != null){
                Node left = null;
                if(A.get(i) != -1 ){
                    left = new Node(A.get(i));
                }
                h.left = left;
                q.add(h.left);
                
                i++;
                
                Node right = null;
                if(A.get(i) != -1 ){
                    right = new Node(A.get(i));
                }
                h.right = right;
                q.add(h.right);
                
                i++;
            }
        }
        return root1;
    }
}

2.Anagram
https://practice.geeksforgeeks.org/problems/anagram/0

class GFG {
	public static void main (String[] args) {
		//code
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		while(cases>0)
		{
		    String a=scan.next();
		    String b=scan.next();
		    
		    boolean isAnagram=true;
		    
		    int al[]=new int[256];
		    for(char c: a.toCharArray())
		    {
		        int index=(int) c;
		        al[index]++;
		    }
		    for(char c: b.toCharArray())
		    {
		        int index=(int) c;
		        al[index]--;
		    }
		    
		    for(int i =0; i < 256; i++){
		        if(al[i] != 0 ){
		            isAnagram=false;
		            break;
		        }
		    }
		    
		    if(isAnagram)
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		        System.out.println("NO");
		    }
		    cases = cases - 1;
		}    
		
	}
}

3. Tree Level Order Traversal
https://practice.geeksforgeeks.org/problems/level-order-traversal/1
class Level_order_traversal
{
    //You are required to complete this method
    static void levelOrder(Node node) 
    {
    //     if(node == NULL)
    // {System.out.println('NULL');}
    
  Queue<Node> q = new LinkedList<Node>();
  
  q.add(node);
  
  while(true){
      int nodeCount = q.size();
      
      if(nodeCount == 0)
      {break;}
      
      while(nodeCount > 0){
          Node d = q.peek();
          System.out.print(d.data+" ");
          q.remove();
          if(d.left != null)
          {q.add(d.left);}
          if(d.right != null)
          {q.add(d.right);}
          nodeCount --;
      }
  }
    }
}

4. Given a number n and a number k. You have to find the next bigger number from n which is obtained after exaclty k swaps.
https://www.geeksforgeeks.org/amazon-interview-set-106-campus-internship/

class shiftSet106 {

	public static void main(String[] args) {
		int[] n = {9,3,5,4,2,1,6,9};
		
		int k = 5;
		int i =0;
		int swap =0;
		int range = k-swap;
		int count =0;
		int s =0;
		while(range <= k && range >=0)
		{	int max = 0;
			int index = 0;
			count = count + 1; 
			max = n[count -1];
			for(int j =count; j<= range+1 ; j ++) {
			
			if(n[j] > max)
				{max = n[j];
				index =j;}
				
			}

			}

			range = range-swap;
			s=s+1;
		}

		
		for(int m =0; m<n.length; m ++)
			System.out.print(n[m]);

	}
}

5. Check if a linked list is palindrome or not.
https://www.geeksforgeeks.org/amazon-interview-set-106-campus-internship/

class Palindrome
{
    // Function to check if linked list is palindrome
    boolean isPalindrome(Node head) 
    {
        Stack<Integer> s = new Stack<Integer>();
        Node temp = head;
        
        while(temp != null){
            s.push(temp.data);
            temp = temp.next;
        }
        
        while(head != null){
            int d = s.pop();
            if(d != head.data){
                return false;
            }
            head = head.next;
        }
        return true;
    }    
}

6. square root of perfect squarers..

static long squareRoot(int n) 
    { 
        int x = n; 
        int y = 1; 
        while (x > y) { 
            x = (x + y) / 2; 
            y = n / x; 
        } 
        return (long)x; 
    }

7. Phone Number Keypad To Different Possibilities

class phoneKeyPad {
  Map<String, String> phone = new HashMap<String, String>() {{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};

  ArrayList<String> output = new ArrayList<String>();

  public void backtrack(String combination, String next_digits) {
    // if there is no more digits to check
    if (next_digits.length() == 0) {
      // the combination is done
      output.add(combination);
    }
    // if there are still digits to check
    else {
      // iterate over all letters which map 
      // the next available digit
      String digit = next_digits.substring(0, 1);
      String letters = phone.get(digit);
      for (int i = 0; i < letters.length(); i++) {
        String letter = phone.get(digit).substring(i, i + 1);
        // append the current letter to the combination
        // and proceed to the next digits
        backtrack(combination + letter, next_digits.substring(1));
      }
    }
  }

  public ArrayList<String> letterCombinations(String digits) {
    if (digits.length() != 0)
      backtrack("", digits);
    return output;
  }
  public static void main(String args[]) 
  { 
	  phoneKeyPad t = new phoneKeyPad();
	  t.letterCombinations("23");
}
  
}
  
      

////////////////////////////////////////////////////////////////////////////// Trees ////////////////////////////////////////////////////////////////////
                  															Trees To Do List:
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

1. Preorde Iterative 

Preorder(Node node) { 
          
        // Base Case 
        if (node == null) { 
            return; 
        } 
  
        // Create an empty stack and push root to it 
        Stack<Node> nodeStack = new Stack<Node>(); 
        nodeStack.push(root); 
  
        /* Pop all items one by one. Do following for every popped item 
         a) print it 
         b) push its right child 
         c) push its left child 
         Note that right child is pushed first so that left is processed first */
        while (nodeStack.empty() == false) { 
              
            // Pop the top item from stack and print it 
            Node mynode = nodeStack.peek(); 
            System.out.print(mynode.data + " "); 
            nodeStack.pop(); 
  
            // Push right and left children of the popped node to stack 
            if (mynode.right != null) { 
                nodeStack.push(mynode.right); 
            } 
            if (mynode.left != null) { 
                nodeStack.push(mynode.left); 
            } 
        } 
    } 

2. Inorder

class Inorder 
{ 
    Node root; 
    void inorder() 
    { 
        if (root == null) 
            return; 
  
  
        Stack<Node> s = new Stack<Node>(); 
        Node curr = root; 
  
        // traverse the tree 
        while (curr != null || s.size() > 0) 
        { 
  
            /* Reach the left most Node of the 
            curr Node */
            while (curr !=  null) 
            { 
                /* place pointer to a tree node on 
                   the stack before traversing 
                  the node's left subtree */
                s.push(curr); 
                curr = curr.left; 
            } 
  
            /* Current must be NULL at this point */
            curr = s.pop(); 
  
            System.out.print(curr.data + " "); 
  
            /* we have visited the node and its 
               left subtree.  Now, it's right 
               subtree's turn */
            curr = curr.right; 
        } 
    }

3. Postorder:  2-Stacks
static void postOrderIterative(node root) 
    { 
        // Create two stacks 
        static Stack<node> s1, s2; 
        s1 = new Stack<>(); 
        s2 = new Stack<>(); 
  
        if (root == null) 
            return; 
  
        // push root to first stack 
        s1.push(root); 
  
        // Run while first stack is not empty 
        while (!s1.isEmpty()) { 
            // Pop an item from s1 and push it to s2 
            node temp = s1.pop(); 
            s2.push(temp); 
  
            // Push left and right children of 
            // removed item to s1 
            if (temp.left != null) 
                s1.push(temp.left); 
            if (temp.right != null) 
                s1.push(temp.right); 
        } 
  
        // Print all elements of second stack 
        while (!s2.isEmpty()) { 
            node temp = s2.pop(); 
            System.out.print(temp.data + " "); 
        } 
    } 

    		: 1-Stack

4. Level Order

levelOrder(Node root) { 
    if (root == null) 
      return; 
  
    Queue<Node> q = new LinkedList<>(); 
  
    // Pushing root node into the queue. 
    q.add(root); 
  
    // Pushing delimiter into the queue. 
    q.add(null); 
  
    // Executing loop till queue becomes 
    // empty 
    while (!q.isEmpty()) { 
  
      Node curr = q.poll(); 
  
      // condition to check the 
      // occurence of next level 
      if (curr == null) { 
        if (!q.isEmpty()) { 
          q.add(null); 
          System.out.println(); 
        } 
      } else { 
        // Pushing left child current node 
        if (curr.left != null) 
          q.add(curr.left); 
  
        // Pushing right child current node 
        if (curr.right != null) 
          q.add(curr.right); 
  
        System.out.print(curr.data + " "); 
      } 
    } 
  } 

5. Pre To Inorder

6. Pre To Postorder

7. Inorder To Preorder

8. Inorder To Postorder

9. Post To Inorder

10. Post To Preorder






