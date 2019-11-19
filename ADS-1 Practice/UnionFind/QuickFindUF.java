class QuickFindUF {
    int[] id;
    int count;

    QuickFindUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        pid = id[p];
        qid = id[q];
        for (int i = 0; i < count; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }
    }

    public static void main(String[] args)
    {
        // Scanner sc = new Scanner();
        // int N = sc.readInt();
        QuickFindUF uf = new QuickFindUF(8);
        while (!sc.isEmpty())
        {
            int p = sc.readInt();
            int q = sc.readInt();
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}