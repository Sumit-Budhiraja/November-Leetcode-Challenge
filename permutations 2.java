class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> results = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums)
                map.put(n, map.getOrDefault(n, 0) + 1);
            permuteUniqueHelper(map, new Integer[nums.length], 0, results);
            return results;
        }

        private void permuteUniqueHelper(Map<Integer, Integer> map, Integer[] p, int i, List<List<Integer>> result) {
            if (i == p.length)
                result.add(Arrays.asList(Arrays.copyOf(p, p.length)));
            for (int key : map.keySet()) {
                if (map.get(key) > 0) {
                    map.put(key, map.get(key) - 1);
                    p[i] = key;
                    permuteUniqueHelper(map, p, i + 1, result);
                    map.put(key, map.get(key) + 1);
                }
            }
        }
    }