// **************************************************** JAVA *******************************************************

// T.C: O(f log f)
// S.C: O(t+f)
class Twitter {
    int count;
    Map<Integer, List<int[]>> tweetMap;
    Map<Integer, Set<Integer>> followMap;
    public Twitter() {
        this.count = 0;
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId,new ArrayList<>());
        tweetMap.get(userId).add(new int[]{count, tweetId});
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>
        ((a,b)->b[0] - a[0]);
        
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for(int followeeId : followMap.get(userId)){
            if(tweetMap.containsKey(followeeId)){
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size()-1;

                int[] lastTweet = tweets.get(index);

                maxHeap.offer(new int[]{
                    lastTweet[0],
                    lastTweet[1],
                    followeeId,
                    index-1
                });
            }
        }

        while(!maxHeap.isEmpty() && result.size() < 10){
            int[] top = maxHeap.poll();

            int count = top[0];
            int tweetId = top[1];
            int followeeId = top[2];
            int nextIndex = top[3];

            result.add(tweetId);

            if(nextIndex >= 0){
                int[] nextTweet = tweetMap.get(followeeId).get(nextIndex);

                maxHeap.offer(new int[]{
                    nextTweet[0],
                    nextTweet[1],
                    followeeId,
                    nextIndex -1
                });
            }
        }
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
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