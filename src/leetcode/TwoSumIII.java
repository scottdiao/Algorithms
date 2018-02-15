package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Design and implement a TwoSum class. It should support the following operations: add and find.
//
//add - Add the number to an internal data structure.
//find - Find if there exists any pair of numbers which sum is equal to the value.
//
//For example,
//
//add(1); 
//add(3); 
//add(5);
//find(4) -> true
//find(7) -> false


// add cost O(n) find P(1)
public class TwoSumIII  {
    Set<Integer> sum; // Store all combinations
    Set<Integer> num;

    TwoSum(){
        sum = new HashSet();
        num = new HashSet();
    }
    // Add the number to an internal data structure.
    public void add(int number) {
        if(num.contains(number)){
            sum.add(number * 2);
        }else{
            Iterator<Integer> iter = num.iterator();
            while(iter.hasNext()){
                sum.add(iter.next() + number);
            }
            num.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        return sum.contains(value);
    }
}
// add O(1) find P(n)
public class TwoSum {
    Map<Integer,Integer> hm;
    
    TwoSum(){
        hm = new HashMap<Integer,Integer>();
    }
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(hm.containsKey(number)){
	        hm.put(number,2); // duplicate case only 2 is needed
	    }else{
	        hm.put(number,1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    Iterator<Integer> iter = hm.keySet().iterator();
	    while(iter.hasNext()){
	        int num1 = iter.next();
	        int num2 = value - num1;
	        if(hm.containsKey(num2)){
	            if(num1 != num2 || hm.get(num2) == 2){
	                return true;
	            }
	        }
	    }
	    return false;
	}
        
        
        
}
