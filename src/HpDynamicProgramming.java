import java.util.Arrays;

// Source = https://www.geeksforgeeks.org/hamiltonian-path-using-dynamic-programming/

public class HpDynamicProgramming {

    boolean hasHamiltonianPath(int adj[][])
    {
        int N = adj.length;

         //inisiasi table dp ukuran N x 2^N (bit mask)
         //dp[i][j] = true jika ada path dari yang berakhir di verteks i yang melalui semua node yang ada di subset j

        boolean dp[][] = new boolean[N][(1 << N)];

        // Selalu ada path dari suatu verteks ke dirinya sendiri
        for(int i = 0; i < N; i++)
            dp[i][(1 << i)] = true;

        // Iterasi semua subset dari 0 (subset kosong) - 2^N (subset dengan semua verteks dilalui)
        for(int i = 0; i < (1 << N); i++)
        {
            for(int j = 0; j < N; j++)
            {
                // jika verteks j ada di subset i
                if ((i & (1 << j)) != 0)
                {
                    // Cek apakah verteks j dapat dimasukkan ke path dengan
                    // mencari K, tetangga dari j yang juga ada di subset i
                    // dan belum melalui j
                    for(int k = 0; k < N; k++)
                    {
                        if ((i & (1 << k)) != 0 &&
                                adj[k][j] == 1 && j != k &&
                                dp[k][i ^ (1 << j)])
                        {
                            dp[j][i] = true;
                            break;
                        }
                    }
                }
            }
        }

        // Cek tiap kemungkinan hamiltonian path, berakhir di verteks i
        for(int i = 0; i < N; i++)
        {
            if (dp[i][(1 << N) - 1]){
                return true;
            }
        }
        return false;
    }
}
