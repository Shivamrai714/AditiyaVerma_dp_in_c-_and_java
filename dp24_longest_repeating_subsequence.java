public class dp24_longest_repeating_subsequence {

    public static int t[][] = new int[1001][1001];

    public static int LCS(String x, String y, int n, int m) {
        //initailization :
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) t[i][j] = 0;
            }
        }

        // looping condition : choosing the char which are equal in tw0 string but at different index , so they are repeting.
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //
                if (   x.charAt(i - 1) == y.charAt(j - 1))
                {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        return t[n][m];
    }


    public static void main(String[] args) {
        System.out.println("Finding the Longest repeating Subsequence");


        String x = "ABDCEABD";           // ans : ABD  ( clue : abd is repeated twice , ie LCS with two different index of each elements )

        //ans= ABD
        System.out.println("The logic is that the longest_repeating_subsequence is here , which has the two index for the character ");

        // we will use the same code of the LCS , and add the constraint condition while checking the if char equal are differnt index, then include them , otherwise exlude it

        String y = x;
        int n = x.length();
        int m = y.length();

        int repeating = LCS(x, y, n, m);
        System.out.println("The length of the LCS is :  " + repeating);
        System.out.println("The repeating subsequence is : ");
        print_lcs(x, y, n, m);
    }


    public static void print_lcs(String x, String y, int n, int m) {
        int i = n;
        int j = m;
        String fin = "";
        while (i > 0 && j > 0) {
            if (  i!=j &&  x.charAt(i - 1) == y.charAt(j - 1))
            {
                fin+= x.charAt(i - 1);
                i--;
                j--;
            }
            else {
                if (t[i-1][j] > t[i][j-1]) i--;
                else j--;
            }

        }

        String ans = reverseit(fin);
        System.out.println(ans);

    }

    public static String reverseit(String temp) {
        char arr[] = temp.toCharArray();
      int n=temp.length();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            char v = arr[i];
            arr[i] = arr[j];
            arr[j] = v;
        }

        return String.valueOf(arr);

    }
}