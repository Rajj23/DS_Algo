// Approach 1
// T.C: O(n*l + nlogn+ n)
// S.C: O(n)
class Solution {
    boolean valid(String s){
        if(s.length()==0) return false;
        for(char c:s.toCharArray()){
            if(!Character.isLetterOrDigit(c) && c!='_'){
                return false;
            }
        }
        return true;
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> electronics = new ArrayList<>();
        List<String> grocery = new ArrayList<>();
        List<String> pharmacy = new ArrayList<>();
        List<String> restaurant = new ArrayList<>();
        int n = code.length;

        for(int i=0;i<n;i++){
            if(!isActive[i]) continue;
            if(!valid(code[i])) continue;

            String business = businessLine[i];
            if(business.equals("electronics")){
                electronics.add(code[i]);
            }
            else if(business.equals("grocery")){
                grocery.add(code[i]);
            }
            else if(business.equals("pharmacy")){
                pharmacy.add(code[i]);
            }
            else if(business.equals("restaurant")){
                restaurant.add(code[i]);
            }
        }
        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);
        for(String gro:grocery){
            electronics.add(gro);
        }
        for(String phar:pharmacy){
            electronics.add(phar);
        }
        for(String rest:restaurant){
            electronics.add(rest);
        }
        return electronics;
    }
}


// Approach 2
//T.C : O(n*l + nlogn) where n = code.size() and l = average length of codes
//S.C : O(n)
class Solution {
    class Pair implements Comparable<Pair>{
        int order;
        String code;
        
        Pair(int order,String code){
            this.order = order;
            this.code = code;
        }

        @Override
        public int compareTo(Pair other){
            if(this.order != other.order){
                return Integer.compare(this.order,other.order);
            }

            return this.code.compareTo(other.code);
        }
    }
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive){
        
        int n = code.length;
        List<Pair> list = new ArrayList<>();
        Map<String,Integer> mp = new HashMap<>();
        mp.putIfAbsent("electronics",0);
        mp.putIfAbsent("grocery",1);
        mp.putIfAbsent("pharmacy",2);
        mp.putIfAbsent("restaurant",3);

        for(int i=0;i<n;i++){
            if(isValid(code[i]) && mp.containsKey(businessLine[i]) && isActive[i]){
                list.add(new Pair(mp.get(businessLine[i]), code[i]));
            }
        }
        Collections.sort(list);

        List<String> result = new ArrayList<>();
        for(Pair p:list){
            result.add(p.code);
        }
        return result;
    }
    boolean isValid(String s){
        if(s.length()==0) return false;

        for(char c:s.toCharArray()){
            if(!Character.isLetterOrDigit(c) && c!='_'){
                return false;
            }
        }
        return true;
    }
}