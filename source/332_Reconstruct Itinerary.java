public class Solution {
    class Itinerary {
        String fromCity;
        String toCity;
        boolean isVisited = false;
        Itinerary(String from, String to) {
            fromCity = from;
            toCity = to;
        }
    }
    
    public List<String> findItinerary(String[][] tickets) {
        if(tickets == null || tickets.length == 0)  return new ArrayList<String>();
        Itinerary[] itineraries = new Itinerary[tickets.length];
        Map<String, List<Itinerary>> destinationMap = new HashMap<>();
        for(int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            itineraries[i] = new Itinerary(from, to);
            if(destinationMap.containsKey(from)) {
                destinationMap.get(from).add(itineraries[i]);
            } else {
                destinationMap.put(from, new ArrayList(Arrays.asList(itineraries[i])));
            }
        }
        for(String k : destinationMap.keySet()) {
            Collections.sort(destinationMap.get(k), new Comparator<Itinerary>() {
                
                @Override
                public int compare(Itinerary i1, Itinerary i2) {
                    return i1.toCity.compareTo(i2.toCity);
                }
            });
        }
        return DFSConstruct("JFK", tickets.length, new ArrayList<String>(), destinationMap);
    }
    
    private List<String> DFSConstruct(String currCity, int totalStops, List<String> path, Map<String, List<Itinerary>> destinationMap) {
        if(path.size() == totalStops) {
            List<String> results = new ArrayList<>();
            results.add("JFK");
            results.addAll(path);
            return results;
        }
        if(!destinationMap.containsKey(currCity)) {
            return null;
        }
        List<Itinerary> nextTickets = destinationMap.get(currCity);
        for(Itinerary nextTicket : nextTickets) {
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
