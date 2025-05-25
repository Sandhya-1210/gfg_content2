

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        // Step 1: Square all elements and store in the set
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
            set.add(arr[i]);
        }

        // Step 2: Check every pair (i, j) and see if their sum exists in the set
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (set.contains(sum)) {
                    return true;
                }
            }
        }

        return false;
    }
}
