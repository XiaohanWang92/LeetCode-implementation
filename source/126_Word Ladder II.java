public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> results = new ArrayList<>();
    
        // Neighbors for every word (one substitution and exist in dict)
        HashMap<String, ArrayList<String>> wordNeighbors = new HashMap<>();
    
        // Distance of every word from the start word
        HashMap<String, Integer> distance = new HashMap<>();
        ArrayList<String> solution = new ArrayList<String>();
        dict.add(end);
        bfs(start, end, dict, wordNeighbors, distance);
        dfs(start, end, dict, wordNeighbors, distance, solution, results);
        return results;
    }
    
    // BFS: Trace every word's distance from the start word by level, until find the end word
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> wordNeighbors, HashMap<String, Integer> distance) {
        for (String str : dict)
            wordNeighbors.put(str, new ArrayList<String>());
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            int count = queue.size();
            boolean isFound = false;
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                ArrayList<String> neighbors = getNeighbors(cur, dict);
                for (String neighbor : neighbors) {
                    wordNeighbors.get(cur).add(neighbor);
    
                    // If we haven't visited to this word yet
                    if (!distance.containsKey(neighbor)) {
    
                        // Add this word into distance map
                        distance.put(neighbor, curDistance + 1);
    
                        // If we found the end word, we do not need to traverse to next level or to check next neighbor
                        // Because for each current word, the generated neighbors are unique
                        if (end.equals(neighbor))
                            isFound = true;
                        else
                            queue.offer(neighbor);
                    }
                }
            }
            if (isFound)
                break;
        }
    }
    
    // Find all next level words (contains in dict)
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        char chs[] = node.toCharArray();
        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    result.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }
        }
        return result;
    }
    
    // DFS: output all paths with the shortest distance
    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> wordNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
        } else {
            for (String next : wordNeighbors.get(cur)) {
    
                // See line 35, If next's distance is not (mostly less than) current distence, means that
                // Next is not on cur's path, if with no if, stack will over flow
                // cur is 5 distance, next is 3 distace, we are tracing back, oops.....
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, wordNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }
}
