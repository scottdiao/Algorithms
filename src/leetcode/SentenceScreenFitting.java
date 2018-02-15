package leetcode;

//Say sentence=["abc", "de", "f], rows=4, and cols=6.
//The screen should look like
//
//"abc de"
//"f abc "
//"de f  "
//"abc de"
//Consider the following repeating sentence string, with positions of the start character of each row on the screen.
//
//"abc de f abc de f abc de f ..."
// ^      ^     ^    ^      ^
// 0      7     13   18     25
//Our goal is to find the start position of the row next to the last row on the screen, which is 25 here. Since actually it's the length of everything earlier, we can get the answer by dividing this number by the length of (non-repeated) sentence string. Note that the non-repeated sentence string has a space at the end; it is "abc de f " in this example.
//
//Here is how we find that position. In each iteration, we need to adjust start based on spaces either added or removed.
//
//"abc de f abc de f abc de f ..." // start=0
// 012345                          // start=start+cols+adjustment=0+6+1=7 (1 space removed in screen string)
//        012345                   // start=7+6+0=13
//              012345             // start=13+6-1=18 (1 space added)
//                   012345        // start=18+6+1=25 (1 space added)
//                          012345

public class SentenceScreenFitting  {
    public int wordsTyping(String[] sentence, int rows, int cols) {
       // convert the sentence array to a string with dilimiter " "
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
//            start is the index of the String s
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }
        
        return start / s.length();
    }
}
