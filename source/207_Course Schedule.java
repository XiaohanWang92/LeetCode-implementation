public class Solution {
    class Course{
        int id;
        boolean visited;
        boolean visiting;
        List<Course> preReqList;
        Course(int id){
            this.id = id;
            preReqList = new ArrayList<Course>();
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites.length ==0)    return true;
        Course[] mycourse = new Course[numCourses];
        for(int i = 0; i<numCourses; i++){
            mycourse[i] = new Course(i);
        }
        for(int[] pre : prerequisites){
            mycourse[pre[0]].preReqList.add(mycourse[pre[1]]);
        }
        for(Course c : mycourse){
            if(isCyclic(c)) return false;
        }
        return true;
    }
    private boolean isCyclic(Course c){
        if(c.visited == true)   return false;
        if(c.visiting == true)   return true;
        c.visiting = true;
        for(Course pre : c.preReqList){
            if(isCyclic(pre))   return true;
        }
        c.visited = true;
        return false;
    }
}
