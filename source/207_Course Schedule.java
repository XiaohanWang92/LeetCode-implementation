public class Solution {

    class Course {
        int id;
        boolean visited;
        boolean visiting;
        List<Course> preReqList;
        Course(int id) {
            this.id = id;
            preReqList = new ArrayList<Course>();
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites.length == 0)    return true;
        Course[] mycourse = new Course[numCourses];
        for(int i = 0; i < numCourses; i++) {
            mycourse[i] = new Course(i);
        }
        for(int[] pre : prerequisites) {
            mycourse[pre[0]].preReqList.add(mycourse[pre[1]]);
        }
        for(Course c : mycourse) {
            if(isCyclic(c)) return false;
        }
        return true;
    }
    private boolean isCyclic(Course c) {
        if(c.visited == true)   return false;
        if(c.visiting == true)   return true;
        c.visiting = true;
        for(Course pre : c.preReqList) {
            if(isCyclic(pre))   return true;
        }
        c.visited = true;
        return false;
    }
}

// another solution
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites.length == 0)    return true;
        HashMap<Integer, Integer> prerequisiteMap = new HashMap<>();
        HashMap<Integer, Set<Integer>> successorMap = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            prerequisiteMap.put(i, 0);
            successorMap.put(i, new HashSet<Integer>());
        }
        for(int[] prerequisite : prerequisites) {
            int prerequisiteId = prerequisite[1];
            int current = prerequisite[0];

            // If contains, do not add more degrees (lc's test case is so bloody tricky)
            boolean isContain = successorMap.get(prerequisiteId).add(current);
            if(isContain) {
                prerequisiteMap.put(current, prerequisiteMap.get(current) + 1);
            }
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(prerequisiteMap.get(i) == 0) {
                q.offer(i);
                count++;
            }
        }
        while(q.size() != 0) {
            int id = q.poll();
            Set<Integer> successors = successorMap.get(id);
            for(int sucId : successors) {
                int preNum = prerequisiteMap.get(sucId);
                preNum -= 1;
                if(preNum == 0) {
                    q.offer(sucId);
                    count++;
                }
                prerequisiteMap.put(sucId, preNum);
            }
        }
        if(count != numCourses) {
            return false;
        }
        return true;
    }
}
