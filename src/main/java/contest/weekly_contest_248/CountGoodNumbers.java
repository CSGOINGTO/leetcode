package contest.weekly_contest_248;

public class CountGoodNumbers {

    public static void main(String[] args) {
        CountGoodNumbers c = new CountGoodNumbers();
        System.out.println(c.countGoodNumbers1(2));
    }

    public int countGoodNumbers(long n) {
        long num = 0;
        for (long i = 1; i <= n; i++) {
            num = num * 10 + 9;
        }
        int res = 0;
        for (long i = 0; i <= num; i++) {
            if (isOk(i)) {
                res++;
                System.out.println(i);
            }
        }
        return res % (109 + 7);
    }

    private boolean isOk(long n) {
        String nStr = String.valueOf(n);
        for (int i = 0; i < nStr.length(); i++) {
            if (i % 2 == 0) {
                if (isO(nStr.charAt(i) - '0')) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (isJ(nStr.charAt(i) - '0')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isO(int n) {
        return n % 2 == 0;
    }

    private boolean isJ(int n) {
        if (n == 2 || n == 3 || n == 5 || n == 7) {
            return true;
        }
        return false;
    }

    private static int count = 0;

    public static int countGoodNumbers1(long n) {
        dfs(0,(int)n,new StringBuilder());
        return count;
    }
    public static void dfs(int i, int n, StringBuilder sb) {
        if (i >= n) {
            String s = sb.toString();
            for (int j = 0; j < n; j++) {
                int a = s.charAt(j) - '0';
                if (j % 2 == 0) {
                    if (a % 2 != 0) {
                        break;
                    }
                } else {
                    if (a != 2 && a != 3 && a != 7 && a != 5) {
                        break;
                    }
                }
                if (j == n - 1) {
                    count++;
                    System.out.println(j);
                }
            }
        } else {
            int N = 10;
            for (int j = 0; j < N; j++) {
                StringBuilder ss = new StringBuilder(sb);
                ss.append((char) ('0' + j));
                dfs(i + 1, n, ss);
            }
        }
    }
}
