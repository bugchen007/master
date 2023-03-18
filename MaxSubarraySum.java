public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] values = new int[args.length];
        for (int i = 0; i < args.length; ++i) {
            values[i] = Integer.parseInt(args[i]);
        }

        int result = solve(values);
        System.out.println(result);
    }

    public static int solve(int[] values) {
        int max = values[0], sum = 0;

        for (int value : values) {
            sum += value;

            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }
}