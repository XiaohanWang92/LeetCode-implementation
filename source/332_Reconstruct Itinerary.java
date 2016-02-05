public class Solution {
        public List<String> findItinerary(String[][] tickets) {
        List<String> ans = new ArrayList<String>();
        if(tickets == null || tickets.length == 0) return ans;
        Map<String, PriorityQueue<String>> ticketsMap = new HashMap<>();
        for(String[] ticket : tickets) {
            if(!ticketsMap.containsKey(ticket[0])) ticketsMap.put(ticket[0], new PriorityQueue<String>());
            ticketsMap.get(ticket[0]).add(ticket[1]);
        }

        String curr = "JFK";
        Deque<String> drawBack = new LinkedList<String>();
        for(int i = 0; i < tickets.length; i++) {
            while(!ticketsMap.containsKey(curr) || ticketsMap.get(curr).isEmpty()) {//last destination
                drawBack.push(curr);
                curr = ans.remove(ans.size()-1);
            }
            ans.add(curr);
            curr = ticketsMap.get(curr).poll();
        }
        ans.add(curr);
        while(!drawBack.isEmpty()) ans.add(drawBack.pop());
        return ans;
    }
}
