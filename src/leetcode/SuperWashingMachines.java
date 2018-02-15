package leetcode;
/**
*
* @author Scott
*/
public class SuperWashingMachines  {
    // Trick
    public int findMinMoves(int[] machines) {
        int total = 0; 
        for(int i: machines) total+=i;
        if(total%machines.length!=0) return -1;
        int avg = total/machines.length, cnt = 0, max = 0;
        for(int load: machines){
            cnt += load-avg; //load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load-avg);
        }
        return max;
    }
    
    //DP
    public int findMinMoves(int[] machines) {
        int total = 0, target = 0, result = 0, n = machines.length;
        for (int d : machines) total += d;
        if (total == 0) return 0;
        if (total % n != 0) return -1;
        target = total / n;
        
        int[] move = new int[n];
        for (int i = 0; i < n - 1; i++) {
            if (machines[i] > target) {
                move[i] += machines[i] - target;
                machines[i + 1] += machines[i] - target;
                machines[i] = target;
                result = Math.max(result, move[i]);
            }
            else {
                move[i + 1] = target - machines[i];
                machines[i + 1] -= target - machines[i];
                machines[i] = target;
                result = Math.max(result, move[i + 1]);
            }
        }
        
        return result;
    }
}
