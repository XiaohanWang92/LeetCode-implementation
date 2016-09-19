public class Twitter {

    private static int startTime = 0;
    private Map<Integer, User> userMap;
    
    class Tweet {
        int id;
        int postedTime;

        // Uses list to link same user's tweet together
        Tweet previousTweet;
        public Tweet(int id) {
            this.id = id;
            postedTime = startTime++;
            previousTweet = null;
        }
    }
    
    class User {

        int id;
        Tweet newestTweet;
        Set<Integer> followings;

        public User(int id) {
            this.id = id;
            newestTweet = null;
            followings = new HashSet<Integer>();
            followings.add(id);
        }
        
        public void post(int tweetId) {
            Tweet newTweet = new Tweet(tweetId);

            // Updates most recent posted tweet
            newTweet.previousTweet = newestTweet;
            newestTweet = newTweet;
        }
        
        public void follow(int userId) {
            followings.add(userId);
        }
        
        public void unfollow(int userId) {
            followings.remove(userId);
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(userMap.containsKey(userId)) {
            userMap.get(userId).post(tweetId);
        } else {
            User newUser = new User(userId);
            newUser.post(tweetId);
            userMap.put(userId, newUser);
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> results = new ArrayList<>();
        if(!userMap.containsKey(userId))    return results;
        User user = userMap.get(userId);
        PriorityQueue<Tweet> pq = new PriorityQueue(user.followings.size(), new Comparator<Tweet>() {
            
            @Override
            public int compare(Tweet t1, Tweet t2) {
                return t2.postedTime - t1.postedTime;
            }
        });
        for(int followeeId : user.followings) {
            User followee = userMap.get(followeeId);

            // First, just add in each following's most recent tweet (excluding null)
            if(followee.newestTweet != null) {
                pq.add(followee.newestTweet);
            }
        }
        while(results.size() < 10 && pq.size() != 0) {
            Tweet t = pq.poll();
            results.add(t.id);

            // Adds previous tweet for the posibility that this may be also a news feed candidate
            if(t.previousTweet != null) {
                pq.offer(t.previousTweet);
            }
        }
        return results;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {

        // follow/unfollow user him/herself is invalid
        if(followerId == followeeId) {
            return;
        }
        if(!userMap.containsKey(followerId)) {
            User follower = new User(followerId);
            userMap.put(followerId, follower);
        }
        if(!userMap.containsKey(followeeId)) {
            User followee = new User(followeeId);
            userMap.put(followeeId, followee);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        }
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) {
            return;
        }
        userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
 