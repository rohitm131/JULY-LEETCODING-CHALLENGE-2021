//since array is given sorted so we will use two pointer approach
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        int low = 0, high = arr.length-1;
        
        while(high-low >= k) {
            if(Math.abs(arr[low]-x) > Math.abs(arr[high]-x)) low++;
            else high--;
        }
        
        for(int i=low; i<=high; i++) {
            ans.add(arr[i]);
        }
        
        return ans;
        
    }
}

//another approach is to use priority queue

private class Node {
  private int index;
  private int diff;
  Node(int index, int diff) {
    this.index = index;
    this.diff = diff;
  }
}

public List<Integer> findClosestElements(int[] arr, int k, int x) {
  PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> ((b.diff==a.diff) ? (b.index - a.index) : (b.diff - a.diff)));
  
  for(int i=0; i<arr.length; i++) {
    pq.offer(new Node(i, Math.abs(arr[i]-x)));
    if(pq.size()>k) {
      pq.poll();
    }
  }
  
  List<Integer> ans = new ArrayList<>();
  while(!pq.isEmpty()) {
    ans.add(arr[pq.poll().index]);
  }
  
  Collections.sort(ans);
  return ans;
}
