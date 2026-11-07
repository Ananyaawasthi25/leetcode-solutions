class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Long.compare(a[0], b[0]);
            if (a[1] != b[1])
                return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);
        });

        int n = servers.length;
        int[] ans = new int[tasks.length];

        for (int i = 0; i < n; i++) {
            free.offer(new int[]{servers[i], i});
        }

        long time = 0;

        for (int i = 0; i < tasks.length; i++) {
            time = Math.max(time, i);

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] s = busy.poll();
                free.offer(new int[]{(int) s[2], (int) s[1]});
            }

            if (free.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    long[] s = busy.poll();
                    free.offer(new int[]{(int) s[2], (int) s[1]});
                }
            }

            int[] s = free.poll();

            ans[i] = s[1];

            busy.offer(new long[]{
                time + tasks[i],
                s[1],
                s[0]
            });
        }

        return ans;
    }
}