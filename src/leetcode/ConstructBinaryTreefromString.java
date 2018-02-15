package leetcode;

import java.util.Stack;

/**
*
* @author Scott
*/
public class ConstructBinaryTreefromString  {
     public static void main(String[] args) {
         str2tree("-4(2(3)(1))(6(5)(7))");
    }
     public static TreeNode str2tree(String s) {
       Stack<TreeNode> st = new Stack<>();
       for(int i=0;i<s.length();i++){
          if(s.charAt(i)=='-'||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
              int start = i;
              while(i < s.length()&&s.charAt(i)>='0'&&s.charAt(i)<='9'){
                  i++;
              }
              System.out.println("s:"+start+"i:"+i);
              int val = Integer.valueOf(s.substring(start,i));
              i--;
              TreeNode node = new TreeNode(val);
              if(!st.isEmpty()){
                  TreeNode parent = st.peek();
                  if(parent.left==null){
                      parent.left=node;
                  }else{
                      parent.right=node;
                  }
              }
              st.push(node);
          }else if(s.charAt(i)==')'){
              st.pop();
          }
       }
       return st.isEmpty()?null:st.pop();
    }
//     public TreeNode str2tree(String s) {
//        Stack<TreeNode> stack = new Stack<>();
//        for(int i = 0, j = i; i < s.length(); i++, j = i){
//            char c = s.charAt(i);
//            if(c == ')')    stack.pop();
//            else if(c >= '0' && c <= '9' || c == '-'){
//                while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
//                TreeNode currentNode = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
//                if(!stack.isEmpty()){
//                    TreeNode parent = stack.peek();
//                    if(parent.left != null)    parent.right = currentNode;
//                    else parent.left = currentNode;
//                }
//                stack.push(currentNode);
//            }
//        }
//        return stack.isEmpty() ? null : stack.peek();
//    }
    
}
