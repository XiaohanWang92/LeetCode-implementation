public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0)    return people;

        // fact: given an ordered Queue and a person, if people in Queue are all taller or equal to this person
        // then this person's position (index) in queue is the k value (number of taller or equal person before him / her)
        // sort people in height descending order, if height is the same then people with smaller k value should stand before larger k value person
        Arrays.sort(people, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] person1, int[] person2) {
                int height1 = person1[0], height2 = person2[0], tallerNum1 = person1[1], tallerNum2 = person2[1];
                if(height1 != height2) {
                    return height2 - height1;
                } else {
                    return tallerNum1 - tallerNum2;
                }
            }
        });
        List<int[]> results = new LinkedList<>();
        for(int[] person : people) {
            int indexOfThisPerson = person[1];
            results.add(indexOfThisPerson, person);
        }
        return results.toArray(new int[people.length][2]);
    }
}
