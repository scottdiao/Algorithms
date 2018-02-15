package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
*
* @author Scott
*/
// Just Eulerian path. Greedy DFS
public class ReconstructItinerary  {
    
    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;
    
    public static void main(String[] args) {
            String[][] tickets = {{"JFK","AAA"},{"JFK","BBB"}};
//            String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
            ReconstructItinerary r = new ReconstructItinerary();
            List<String> res = r.findItinerary(tickets);
            Iterator i = res.iterator();
            while(i.hasNext()){
                System.out.println(i.next());
            }
    }

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }
    
//    // GIPlan
    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap();
        path = new LinkedList();
        for(String[] ticket : tickets){
            flights.putIfAbsent(ticket[0], new PriorityQueue<String>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }
    
    public void dfs(String departure){
        PriorityQueue<String> arrivals = flights.get(departure);
        while(arrivals!=null&&!arrivals.isEmpty()){
            dfs(arrivals.poll());
        }
        path.addFirst(departure);
     }
}
