class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      if(n==1)
        return Arrays.asList(0);
      
      //create a map
      List<Integer>[] map = new List[n];
      for(int i=0;i<n;i++)
        map[i] = new ArrayList<>();
      
      int[] indegree = new int[n];
        
      for(int edge[]:edges){
        int a=edge[0], b=edge[1];
        map[a].add(b);indegree[a]++;
        map[b].add(a);indegree[b]++;
      }
      
      Queue<Integer> queue = new LinkedList<>();
      
      for(int i=0;i<n;i++)
        if(indegree[i]==1)
          queue.add(i);
       
      List<Integer> result = new ArrayList<>();
      
      while(!queue.isEmpty()){
        result = new ArrayList<>();
        int size = queue.size();
        while(size--!=0){
          int node = queue.remove();
          result.add(node);
          for(int nebour: map[node]){
            if(--indegree[nebour]==1)
              queue.add(nebour);
          }
        }
      }
      
      return result;
    }
}