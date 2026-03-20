class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int l = 0;
                if ((height[i] > height[j]) && (i != j)) {
                    l = height[i];
                } else
                    l = height[j];
                int b = 0;
                if (j > i)
                    b = j - i;
                else
                    b = i - j;
                int val = l * b;
                if (max < val)
                    max = val;
            }
        }
        return max;
    }
}
