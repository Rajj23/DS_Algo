// TLE
// Approach (Simulation)
//T.C. : O(num)
//S.C. : O(1)
class Robot {
    int width = 0;
    int height = 0;

    int dir;
    int[] dirX;
    int[] dirY;

    int x, y;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;

        dirX = new int[]{1, 0, -1, 0};
        dirY = new int[]{0, 1, 0, -1};
        dir = 0;

        x = 0;
        y = 0;
    }
    
    public void step(int num) {
        while(num > 0){
            int stepsToCorner;
            if(dir == 0) stepsToCorner = width-1-x;
            else if(dir == 1) stepsToCorner = height -1 - y;
            else if(dir == 2) stepsToCorner = x;
            else stepsToCorner = y;

            if(num <= stepsToCorner){
                x = x + num * dirX[dir];
                y = y + num * dirY[dir];
                num = 0;
            }
            else{
                x += stepsToCorner * dirX[dir];
                y += stepsToCorner * dirY[dir];
                num = num - stepsToCorner;

                dir = (dir+1)%4;
            }

        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        if(dir == 0){
            return "East";
        }
        else if(dir == 1){
            return "North";
        }
        else if(dir == 2){
            return "West";
        }
        else{
            return "South";
        }
    }
}



// Approach (Simulation)
//T.C. : O(width+height) for Constructor, O(1) for other methods
//S.C. : O(width+height)
class Robot {
    List<int[]> pos;
    int idx;
    boolean isMoved;

    public Robot(int width, int height) {
        pos = new ArrayList<>();

        idx = 0;
        isMoved = false;

        pos.add(new int[]{0, 0, 3});

        for(int x = 1; x < width; x++){
            pos.add(new int[]{x, 0, 0});
        }

        for(int y = 1; y < height; y++){
            pos.add(new int[]{width-1, y, 1});
        }

        for(int x = width-2; x >= 0; x--){
            pos.add(new int[]{x, height-1, 2});
        }

        for(int y = height - 2; y > 0; y--){
            pos.add(new int[]{0, y, 3});
        }

    }
    
    public void step(int num) {
        isMoved = true;
        idx = (idx + num) % pos.size();
    }
    
    public int[] getPos() {
        return new int[]{pos.get(idx)[0], pos.get(idx)[1]};
    }
    
    public String getDir() {
        if(!isMoved) return "East";

        int d = pos.get(idx)[2];

        if(d == 0) return "East";
        else if(d == 1) return "North";
        else if(d == 2) return "West";
        else return "South";
    }
}