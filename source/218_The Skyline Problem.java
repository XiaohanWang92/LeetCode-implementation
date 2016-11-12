public class Solution {
    
    public List<int[]> getSkyline(int[][] buildings) {

        // the point is in order by its x coordinate
        Map<Integer, List<int[]>> buildingTwoPoints = new TreeMap<>();
        for(int[] b : buildings) {
            buildingTwoPoints.putIfAbsent(b[0], new ArrayList<int[]>());
            buildingTwoPoints.putIfAbsent(b[1], new ArrayList<int[]>());
            buildingTwoPoints.get(b[0]).add(b);
            buildingTwoPoints.get(b[1]).add(b);
        }

        // maxHeightHeap for the currently active buildings        
        PriorityQueue<int[]> maxHeightHeap = new PriorityQueue<>(new Comparator<int[]>(){

            @Override
            public int compare(int[] b1, int[] b2) {
               return Integer.compare(b2[2], b1[2]);
           } 
        });

        List<int[]> results = new ArrayList<>();

        // loop from left to right over the building left and right contour points
        for(Map.Entry<Integer, List<int[]>> entry : buildingTwoPoints.entrySet()) {
            int xCoor = entry.getKey();
            List<int[]> buildingsOnCurrentXCoor = entry.getValue();
            
            for(int[] b : buildingsOnCurrentXCoor) {

                // check if now we are seating on left edge of building
                if(xCoor == b[0]) {

                    // put it into current active buildings
                    maxHeightHeap.add(b);

                // check if now we are seating on right edge of building
                } else {

                    // remove it out of current active buildings
                    maxHeightHeap.remove(b);
                }
            }
            
            if(maxHeightHeap.isEmpty()) {

                // if the maxHeightHeap is empty, we reach the end point
                results.add(new int[] {xCoor, 0});
            } else {

                // get current height
                int h = maxHeightHeap.peek()[2];
                if(results.isEmpty() || results.get(results.size() - 1)[1] != h) {

                    // only add the highest rectangle iff it is different than before or it is the first leftmost point
                    //  1 _____3
                    //   |     |
                    //   |  2__|____
                    //   |  |       |
                    //
                    // we add at point 1, not add at point 2 because results.get(results.size() - 1)[1] equals currentHeight
                    results.add(new int[] {xCoor,  h});
                }
            }
        }
        
        return results;
    }
}
