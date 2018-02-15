package oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
*
* @author Scott
*/
public class ShoppingCart  {
    public static void main(String[] args){
        List<List<String>> codeList = new ArrayList<>();
//        test case 1:passed
        codeList.add(Arrays.asList(new String[]{"apple","apple"}));
        codeList.add(Arrays.asList(new String[]{"orange","banana","orange"}));
        List<String> shoppingCart = Arrays.asList(new String[]{"orange","apple","apple","orange","banana","orange"});
        
//         test case 2:passed
//        codeList.add(Arrays.asList(new String[]{"orange","banana","orange"}));
//        codeList.add(Arrays.asList(new String[]{"apple","apple"}));
//        List<String> shoppingCart = Arrays.asList(new String[]{"orange","apple","apple","orange","banana","orange"});

//         test case 3:passed
//        codeList.add(Arrays.asList(new String[]{"apple","apple"}));
//        codeList.add(Arrays.asList(new String[]{"orange","banana","orange"}));
//        codeList.add(Arrays.asList(new String[]{"pear","orange","grape"}));
//        List<String> shoppingCart = Arrays.asList(new String[]{"orange","apple","apple","orange","banana","orange", "pear", "grape"});

//        test case 4: passed        
//        codeList.add(Arrays.asList(new String[]{"apple","apple"}));
//        codeList.add(Arrays.asList(new String[]{"orange","anything","orange"}));
//        List<String> shoppingCart = Arrays.asList(new String[]{"orange","apple","apple","orange","mango","orange"});
//        
       
        System.out.println("result:"+check(codeList,shoppingCart ));
    }
    public static int check(List<List<String>> codeList, List<String> shoppingCart){
        int p1=0, p2=0;
        for(int i=0;i<shoppingCart.size();i++){
            if(shoppingCart.get(i).equals(codeList.get(p1).get(p2))||"anything".equals(codeList.get(p1).get(p2))){
                p2++;
                if(p2>=codeList.get(p1).size()){
                    p1++;
                    p2=0;
                    if(p1>=codeList.size()){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    //题目问的是顺序相同就可以
//    public static int check(List<List<String>> codeList, List<String> shoppingCart){
//        int res=0;
//        for(int i=0;i<shoppingCart.size();i++){
//            if(codeList.get(0).get(0).equals(shoppingCart.get(i))){
//                int j = i, codeCount = 0;
//                for(int a=0;a<codeList.size();a++){
//                    for(int b=0;b<codeList.get(a).size();b++){
//                        codeCount++;
//                        if(j<shoppingCart.size()&&codeList.get(a).get(b).equals(shoppingCart.get(j))||"anything".equals(codeList.get(a).get(b))){
//                            j++;
//                        }else{
//                            break;
//                        }
//                    }
//                }
//                if(j-i==codeCount){
//                    res=1;
//                }
//            }
//        }
//        return res;
//    }
}
