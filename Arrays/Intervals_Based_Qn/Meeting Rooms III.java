//Approach-1 (Brute Force - Do as said)
//T.C : O(mlogm +m*n) , where Let n = number of rooms, m =  number of meetings
//S.C : O(n)
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int m = meetings.length;

        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));

        long[] lastAvailableAt = new long[n];
        int[] roomsUsedCount = new int[n];

        for(int[] meet:meetings){
            int start = meet[0];
            int end = meet[1];
            int duration = end - start;
            boolean found = false;

            long earlyEndRoomTime = Long.MAX_VALUE;
            int earlyEndRoom = 0;

            for(int room = 0;room<n;room++){
                if(lastAvailableAt[room] <= start){
                    lastAvailableAt[room] = end;
                    roomsUsedCount[room]++;
                    found = true;
                    break;
                }

                if(lastAvailableAt[room] < earlyEndRoomTime){
                    earlyEndRoomTime = lastAvailableAt[room];
                    earlyEndRoom = room;
                }
            }

            if(!found){
                lastAvailableAt[earlyEndRoom] += duration;
                roomsUsedCount[earlyEndRoom]++;
            }
        }

        int resultRoom = -1;
        int maxUse = 0;
        for(int room=0;room<n;room++){
            if(roomsUsedCount[room] > maxUse){
                maxUse = roomsUsedCount[room];
                resultRoom = room;
            }
        }

        return resultRoom;
    }
}


//Approach-2 (Use priority Queue to find the first available meeting room)
//T.C : O(mlogm + m*log(n)) , where Let n = number of rooms, m =  number of meetings
//S.C : O(n)
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int m = meetings.length;

        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        int[] roomUsedCount = new int[n];

        PriorityQueue<long[]> usedRooms = 
        new PriorityQueue<>((a,b)-> a[0] != b[0] ? 
        Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        for(int room=0;room<n;room++){
            availableRooms.add(room);
        }

        for(int[] meet:meetings){
            int start = meet[0];
            int end = meet[1];
            int duration = end-start;

            while(!usedRooms.isEmpty() && usedRooms.peek()[0] <= start){
                int room = (int) usedRooms.poll()[1];
                availableRooms.add(room);
            }

            if(!availableRooms.isEmpty()){
                int room = availableRooms.poll();
                usedRooms.add(new long[]{end,room});
                roomUsedCount[room]++;
            }
            else{
                int room = (int) usedRooms.peek()[1];
                long endTime = usedRooms.peek()[0];

                usedRooms.poll();
                usedRooms.add(new long[]{endTime+duration, room});
                roomUsedCount[room]++;
            }
        }

        int resultRoom = -1;
        int maxUse = 0;
        for(int room=0;room<n;room++){
            if(roomUsedCount[room] > maxUse){
                maxUse = roomUsedCount[room];
                resultRoom = room;
            }
        }

        return resultRoom;
    }
}