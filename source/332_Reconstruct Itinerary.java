// 泽哥简单通俗易懂版
public class Solution {
    class Ticket {
        String fromCity;
        String toCity;
        boolean isVisited = false;
        Ticket(String from, String to) {
            fromCity = from;
            toCity = to;
        }
    }
    
    public List<String> findItinerary(String[][] tickets) {
        if(tickets == null || tickets.length == 0)  return new ArrayList<String>();
        Ticket[] ticketsArray = new Ticket[tickets.length];
        Map<String, List<Ticket>> destinationMap = new HashMap<>();
        for(int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            ticketsArray[i] = new Ticket(from, to);
            if(destinationMap.containsKey(from)) {
                destinationMap.get(from).add(ticketsArray[i]);
            } else {
                destinationMap.put(from, new ArrayList(Arrays.asList(ticketsArray[i])));
            }
        }
        for(String k : destinationMap.keySet()) {
            Collections.sort(destinationMap.get(k), new Comparator<Ticket>() {
                
                @Override
                public int compare(Ticket i1, Ticket i2) {
                    return i1.toCity.compareTo(i2.toCity);
                }
            });
        }
        return DFSConstruct("JFK", tickets.length, new ArrayList<String>(), destinationMap);
    }
    
    private List<String> DFSConstruct(String currCity, int totalStops, List<String> path, Map<String, List<Ticket>> destinationMap) {
        if(path.size() == totalStops) {
            List<String> results = new ArrayList<>();
            results.add("JFK");
            results.addAll(path);
            return results;
        }
        if(!destinationMap.containsKey(currCity)) {
            return null;
        }
        List<Ticket> nextTickets = destinationMap.get(currCity);
        for(Ticket nextTicket : nextTickets) {
            if(!nextTicket.isVisited) {
                nextTicket.isVisited = true;
                path.add(nextTicket.toCity);
                List<String> results = DFSConstruct(nextTicket.toCity, totalStops, path, destinationMap);
                if(results != null) {
                    return results;
                }
                nextTicket.isVisited = false;
                path.remove(path.size() - 1);
            }
        }
        return null;
    }
}

// 不想让人看懂版
public class Solution {
        public List<String> findItinerary(String[][] tickets) {
        List<String> results = new ArrayList<String>();
        if(tickets == null || tickets.length == 0) return results;
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
                curr = results.remove(results.size() - 1);
            }
            results.add(curr);
            curr = ticketsMap.get(curr).poll();
        }
        results.add(curr);
        while(!drawBack.isEmpty()) results.add(drawBack.pop());
        return results;
    }
}
