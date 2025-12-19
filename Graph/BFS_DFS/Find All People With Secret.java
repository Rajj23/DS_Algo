class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer,List<int[]>> timeMeetings = new TreeMap<>();
        for(int[] meeting:meetings){
            int person1 = meeting[0];
            int person2 = meeting[1];
            int time = meeting[2];

            timeMeetings.computeIfAbsent(time,
            k-> new ArrayList<>()).add(new int[]{person1,person2});
        }
        boolean[] knowsSecret = new boolean[n];
        knowsSecret[0] = true;
        knowsSecret[firstPerson] = true;

        for(Map.Entry<Integer,List<int[]>> entry : timeMeetings.entrySet()){

            int t = entry.getKey();
            List<int[]> meets = entry.getValue();

            Map<Integer,List<Integer>> adj = new HashMap<>();
            Set<Integer> alreadyAdded = new HashSet<>();

            for(int[] person : meets){
                int person1 = person[0];
                int person2 = person[1];
                adj.computeIfAbsent(person1, k-> new ArrayList<>()).add(person2);
                adj.computeIfAbsent(person2, k-> new ArrayList<>()).add(person1);
                

                if(knowsSecret[person1]){
                    alreadyAdded.add(person1);
                }
                if(knowsSecret[person2]){
                    alreadyAdded.add(person2);
                }
            }
            
            Queue<Integer> q = new LinkedList<>(alreadyAdded);
            while(!q.isEmpty()){
                int person = q.poll();
                for(int nextPerson : adj.getOrDefault(person,new ArrayList<>())){
                    if(!knowsSecret[nextPerson]){
                        knowsSecret[nextPerson] = true;
                        q.offer(nextPerson);
                    }
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(knowsSecret[i]){
                result.add(i);
            }
        }
        return result;
    }
}

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] meeting : meetings) {
            int person1 = meeting[0];
            int person2 = meeting[1];
            int time = meeting[2];

            adj.computeIfAbsent(person1, k -> new ArrayList<>()).add(new int[]{person2, time});
            adj.computeIfAbsent(person2, k -> new ArrayList<>()).add(new int[]{person1, time});
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{firstPerson, 0});
        int[] earlySecretTime = new int[n];
        Arrays.fill(earlySecretTime, Integer.MAX_VALUE);
        earlySecretTime[0] = 0;
        earlySecretTime[firstPerson] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int person = current[0];
            int time = current[1];

            for (int[] ngbr : adj.getOrDefault(person, Collections.emptyList())) {
                int nextPerson = ngbr[0];
                int t = ngbr[1];

                if (t >= time && earlySecretTime[nextPerson] > t) {
                    earlySecretTime[nextPerson] = t;
                    queue.offer(new int[]{nextPerson, t});
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (earlySecretTime[i] != Integer.MAX_VALUE) {
                result.add(i);
            }
        }

        return result;
    }
}



class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] meeting : meetings) {
            int person1 = meeting[0];
            int person2 = meeting[1];
            int time = meeting[2];

            adj.computeIfAbsent(person1, k -> new ArrayList<>()).add(new int[]{person2, time});
            adj.computeIfAbsent(person2, k -> new ArrayList<>()).add(new int[]{person1, time});
        }

        int[] earlySecretTime = new int[n];
        Arrays.fill(earlySecretTime, Integer.MAX_VALUE);
        earlySecretTime[0] = 0;
        earlySecretTime[firstPerson] = 0;

        // Do DFS
        dfs(0, 0, adj, earlySecretTime);
        dfs(firstPerson, 0, adj, earlySecretTime);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (earlySecretTime[i] != Integer.MAX_VALUE) {
                result.add(i);
            }
        }

        return result;
    }

    private void dfs(int person, int time, Map<Integer, List<int[]>> adj, int[] earlySecretTime) {
        for (int[] ngbr : adj.getOrDefault(person, Collections.emptyList())) {
            int nextPerson = ngbr[0];
            int t = ngbr[1];

            if (t >= time && earlySecretTime[nextPerson] > t) {
                earlySecretTime[nextPerson] = t;
                dfs(nextPerson, t, adj, earlySecretTime);
            }
        }
    }
}

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // For every person, we store the meeting time and label of the person met.
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            int person1 = meeting[0];
            int person2 = meeting[1];
            int time    = meeting[2];
            graph.computeIfAbsent(person2, k -> new ArrayList<>()).add(new int[]{time, person1});
            graph.computeIfAbsent(person1, k -> new ArrayList<>()).add(new int[]{time, person2});
        }
        
        // Priority Queue for BFS. It will store (time of knowing the secret, person)
        // We will pop the person with the minimum time of knowing the secret.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        pq.offer(new int[]{0, firstPerson});

        // Visited array to mark if a person is visited or not.
        // We will mark a person as visited after it is dequeued
        // from the queue.
        boolean[] visited = new boolean[n];

        // Do BFS, but pop minimum.
        while (!pq.isEmpty()) {
            int[] timePerson = pq.poll();
            int time = timePerson[0], person = timePerson[1];
            if (visited[person]) {
                continue;
            }
            visited[person] = true;
            for (int[] nextPersonTime : graph.getOrDefault(person, new ArrayList<>())) {
                int t = nextPersonTime[0], nextPerson = nextPersonTime[1];
                if (!visited[nextPerson] && t >= time) {
                    pq.offer(new int[]{t, nextPerson});
                }
            }
        }
        
        // Since we visited only those people who know the secret
        // we need to return indices of all visited people.
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (visited[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}