import java.util.Arrays;

public class HpBacktracking {

    int N;
    int path[];

    // pos = index verteks baru yang ingin ditambahkan ke path
    boolean isSafe(int v, int graph[][], int path[], int pos)
    {
        if (pos == 0)
            return true;

        // cek apakah ada edge dari verteks terakhir di path ke verteks v
        if (graph[path[pos - 1]][v] == 0){
            return false;
        }

        // cek apakah verteks v sudah ada di path
        for (int i = 0; i < pos; i++)
            if (path[i] == v){
                return false;
            }


        return true;
    }

    /* A recursive utility function to solve hamiltonian
       cycle problem */
    boolean hamPathBacktrack(int graph[][], int path[], int pos)
    {
        // base case : jika semua verteks sudah masuk path
        if (pos == N)
        {
            return true;
        }

        for (int v = 0; v < N; v++)
        {
            // cek apakah verteks v bisa dimasukkan ke path
            if (isSafe(v, graph, path, pos))
            {
                path[pos] = v;

                // lanjut menyusun path dengan setelah menambahkan verteks v
                if (hamPathBacktrack(graph, path, pos + 1) == true)
                    return true;

                // backtrack jika penambahan verteks v tidak menghasilkan solusi
                path[pos] = -1;
            }
        }

        return false;
    }

    boolean hasHamiltonianPath(int graph[][])
    {
        N = graph.length;
        path = new int[N];

        // inisiaisasi path dengan -1 (belum ada verteks yang masuk)
        for (int i = 0; i < N; i++)
            path[i] = -1;


        return hamPathBacktrack(graph, path, 0);
    }


}
