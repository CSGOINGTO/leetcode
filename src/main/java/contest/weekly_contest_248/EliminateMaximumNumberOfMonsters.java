package contest.weekly_contest_248;

import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters {

    public static void main(String[] args) {
        EliminateMaximumNumberOfMonsters e = new EliminateMaximumNumberOfMonsters();
        System.out.println(e.eliminateMaximum(new int[]{3, 5, 7, 4, 5}, new int[]{2, 3, 6, 3, 2}));
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int len = dist.length;
        int[] div = new int[len];
        for (int i = 0; i < len; i++) {
            div[i] = (int) Math.ceil((float) dist[i] / speed[i]);
        }
        Arrays.sort(div);

        int index = 0;
        int count = 0;
        int round = 1;
        while (index < len) {
            if (round++ <= div[index++]) count++;
            else return count;
        }
        return count;
    }
}
