Class Solutions {
    /** 
     * Method: HasLoop
     * SC: O(1)
     * TC: O(n) 
     */
    public boolean hasLoop(Node start) {
        Node p1 = start; Node p2 = start.next;
        while(!p1.equals(p2) || (p1 != null && p2 != null)) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1.equals(p2);
    }

    /** 
     * Method: GetHorizionalSums
     * SC: O((2^n) - 1) 
     * TC: O(2^n)
     */
    public List<Integer> getHorizontalSums(Node root) {
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> l = new ArrayList<Integer>();
        q.add(root.data);
        q.add(null);
        int sum = 0;

        while(!q.isEmpty()) {
            Node temp = q.remove();
            if(temp) {
                sum += temp.value;
                // add children 
                if(temp.left) {
                    q.add(temp.left);
                }

                if(temp.right) {
                    q.add(temp.right)
                }
                // add signal ending loop
                if(!q.peek()) {
                    l.add(sum);
                    sum = 0;
                }
            } 
        }
    }

    /** 
     * Method: GetVerticalSum
     * SC: O(n) 
     * TC: O(n2^n)
     */
    public Map<Integer, Integer> getVerticalSum(Node root) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        m = getVerticalSumHelper(m, root, 0);
    }

    private Map<Integer, Integer> getVerticalSumHelper(Map<Integer, Integer> m, Node current, int distance) {
        if(current) {
            // add value 
            if(m.containsKey(distance)) {
                m.put(distance, current.data + m.getKey(distance));
            } else {
                m.put(distance, current.data);
            }
            // go left
            m = getVerticalSumHelper(m, current.left, distance - 1);

            // go right
            m = getVerticalSumHelper(m, current.right, distance + 1);

            return m;
        } 
    }
}