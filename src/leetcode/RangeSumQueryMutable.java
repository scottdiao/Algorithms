package leetcode;

// Segment tree
public class RangeSumQueryMutable {
    int[] tree;
    int n;
    // Constructor
    public  NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    // 2 4 5 7 8 9
    // 35 29 6 12 17 2 4 5 7  8  9
    //  1  2 3  4  5 6 7 8 9 10 11
//For an array implementation, if the element at index ii is not a leaf, its left and right child are stored at index 2i and 2i+1 respectively
    private void buildTree(int[] nums) {
        // Construct leaf
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        // Construct node
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }
    public  void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }
    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
//      l = 6 r = 11
//      l=3 r=5 sum=6 l=4
        int sum = 0;
        while (l <= r) {
            //Check if l is right child of its parent P
            if ((l % 2) == 1) {
               sum += tree[l];
               l++;
            }
            //Check if r is left child of its parent PP
            if ((r % 2) == 0) {
               sum += tree[r];
               r--;
            }
            l /= 2;  // go to the parent
            r /= 2;
        }
        return sum;
    }
}
