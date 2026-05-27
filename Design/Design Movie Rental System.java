// T.C: O(n(log(n)))
// S.C: O(3n)
class MovieRentingSystem {
    class Node{
        int shop;
        int movie;
        int price;

        Node(int shop, int movie, int price){
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    Map<Integer, TreeSet<Node>> available;
    TreeSet<Node> rented;
    Map<String, Node> map;

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        map = new HashMap<>();

        Comparator<Node> availableComp = (a, b) -> {
            if(a.price != b.price) return Integer.compare(a.price, b.price);

            if(a.shop != b.shop) return a.shop - b.shop;

            return a.movie - b.movie;
        };

        Comparator<Node> rentedComp = (a, b) -> {
            if(a.price != b.price) return a.price - b.price;

            if(a.shop != b.shop) return a.shop - b.shop;

            return a.movie - b.movie;
        }

        rented = new TreeSet<>(rentedComp);

        for(int[] e : entries){
            int shop = e[0];
            int movie = e[1];
            int price = e[2];

            Node node = new Node(shop, movie, price);

            available.computeIfAbsent(movie, k-> new TreeSet<>(availableComp)).add(node);
            map.put(shop + "#" + movie, node);
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> ans = new ArrayList<>();
        if(!available.containsKey(movie)){
            return ans;
        }

        int count = 0;

        for(Node node : available.get(movie)){
            ans.add(node.shop);
            count++;

            if(count == 5) break;
        }
        return ans;
    }
    
    public void rent(int shop, int movie) {
        String key = shop + "#" + movie;
        Node node = map.get(key);

        available.get(movie).remove(node);
        rented.add(node);
    }
    
    public void drop(int shop, int movie) {
        String key = shop + "#" + movie;
        Node node = map.get(key);
        rented.remove(node);
        available.get(movie).add(node);
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>();
        int count = 0;

        for(Node node. rented){
            ans.add(Arrays.asList(node.shop, node.movie));
            count++;

            if(count == 5) break;
        }

        return ans;
    }
}