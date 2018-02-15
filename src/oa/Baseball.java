package oa;

import java.util.Stack;

/**
*
* @author Scott
*/
public class Baseball  {
    public static void main(String[] args){
        System.out.println("res:"+ballscore(new String[]{"5", "-2", "4", "Z","X", "9", "+", "+"}));
    }
    public static int ballscore(String[] strarr) {
        Stack<Integer> s = new Stack<>();
        int res=0;
        for(int i=0;i<strarr.length;i++){
            char c = strarr[i].charAt(0);
            if(Character.isDigit(c)||c=='-'){ //用第一个字符来判断是不是数字要考虑负号
                res+=Integer.parseInt(strarr[i]);
                s.push(Integer.parseInt(strarr[i]));
            }else if("X".equals(strarr[i])){
                if(!s.isEmpty()){
                    int t = s.peek();
                    res+=2*t;
                    s.push(2*t);
                }
            }else if("Z".equals(strarr[i])){
                if(!s.isEmpty()){
                    int t = s.pop();
                    res-=t;
                }
            }else if("+".equals(strarr[i])){
                if(!s.isEmpty()){
                    int first=0,sec=0;
                    first = s.pop();
                    if(!s.isEmpty()){
                        sec = s.peek();
                    }
                    res+=first+sec;
                    s.push(first);
                    s.push(first+sec);
                }
            }
            System.out.println(res);
        }
        return res;
    }
}
