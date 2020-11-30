class Solution {
 public List<List<Integer>> getSkyline(int[][] buildings) {
	return merge(buildings, 0, buildings.length - 1);
}

private LinkedList<List<Integer>> merge(int[][] buildings, int lo, int hi) {
	LinkedList<List<Integer>> res = new LinkedList<>();
	if (lo > hi) {
		return res;
	} else if (lo == hi) {
		res.add(Arrays.asList(buildings[lo][0], buildings[lo][2]));
		res.add(Arrays.asList(buildings[lo][1], 0));
		return res;
	}
	int mid = lo + (hi - lo) / 2;

	LinkedList<List<Integer>> left = merge(buildings, lo, mid);
	LinkedList<List<Integer>> right = merge(buildings, mid + 1, hi);

	merge(res, left, right);
	return res;
}

private void merge(LinkedList<List<Integer>> res, LinkedList<List<Integer>> left, LinkedList<List<Integer>> right) {
	int leftH = 0, rightH = 0;
	while (!left.isEmpty() || !right.isEmpty()) {
		long x1 = left.isEmpty() ? Long.MAX_VALUE : left.peekFirst().get(0);
		long x2 = right.isEmpty() ? Long.MAX_VALUE : right.peekFirst().get(0);
		int x = 0;
		if (x1 < x2) {
			List<Integer> temp = left.pollFirst();
			x = temp.get(0);
			leftH = temp.get(1);
		} else if (x1 > x2) {
			List<Integer> temp = right.pollFirst();
			x = temp.get(0);
			rightH = temp.get(1);
		} else {
			x = left.peekFirst().get(0);
			leftH = left.pollFirst().get(1);
			rightH = right.pollFirst().get(1);
		}
		int h = Math.max(leftH, rightH);
		if (res.isEmpty() || h != res.peekLast().get(1)) {
			res.add(Arrays.asList(x, h));
		}
	}
}
}