public class Solution {
    
    class Course {
        boolean isVisited = false;
        boolean isScheduled = false;
        int id;
        List<Course> pre;
        public Course(int i){
            id = i;
            pre = new ArrayList<Course>();
        }
    }
    
    private int currPos = 0;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] results = new int[numCourses];
        Course[] course = new Course[numCourses];
        for(int i = 0; i < numCourses; i++) {
            course[i] = new Course(i);
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            course[prerequisites[i][0]].pre.add(course[prerequisites[i][1]]);
        }
        
        for(Course c:course) {
            if(findCycle(results, c))
                return new int[0];
        }
        return results;
    }
    
    private boolean findCycle(int[] results, Course c) {
        if(c.isScheduled)   return false;
        if(c.isVisited) return true;
        c.isVisited = true;
        for(Course prereq : c.pre) {
            if(findCycle(results, prereq))  return true;
        }
        results[currPos] = c.id;
        c.isScheduled = true;
        currPos++;
        return false;
    }
}
