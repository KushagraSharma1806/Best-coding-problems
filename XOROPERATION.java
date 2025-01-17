class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        // Case 1: Assume original[0] = 0
        boolean validWithZero = isValid(derived, 0);
        // Case 2: Assume original[0] = 1
        boolean validWithOne = isValid(derived, 1);
        // Return true if either case is valid
        return validWithZero || validWithOne;
    }

    private boolean isValid(int[] derived, int initial) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = initial;
        // Compute the rest of the original array
        for (int i = 0; i < n - 1; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }
        // Check if the last condition matches
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }
}
