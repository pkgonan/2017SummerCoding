public class Sticker {
    public static void main(String[] args) {
        int[] s = { 14, 6, 5, 11, 3, 9, 2, 10};
        System.out.println(solution(s));
    }

    static int solution(int[] sticker){
        int N = sticker.length;
        int MAX = 0;

        int cnt = 0;
        while (cnt < N){
            int[][] dp = new int[N][2];

            dp[cnt%N][1] = sticker[cnt%N];
            int i=0, start = cnt%N;
            for(i=cnt%N; i<(cnt%N)+N; i++) {
                if (i%N != start) {
                    dp[i%N][0] = Math.max(dp[(i-1)%N][0], dp[(i-1)%N][1]);
                    dp[i%N][1] = dp[(i-1)%N][0] + sticker[i%N] - dp[(i+1)%N][1];
                }
            }
            MAX = Math.max(MAX, Math.max(dp[(i-1)%N][0], dp[(i-1)%N][1]));
            cnt++;
        }
        return MAX;
    }
}