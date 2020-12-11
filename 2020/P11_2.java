import java.util.*;

public class P11_2
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList();
        while (true)
        {
            String t = s.nextLine();
            if (t.equals("0"))
            {
                break;
            }
            arr.add(t);
        }
        char[][] ch = new char[arr.size()][arr.get(0).length()];
        boolean done = false, check = false;
        int filled = 0, iold = 0, jold = 0, iter = 0;
        while (!done)
        {
            System.out.println("");
            for (int i = 0; i < ch.length; i++)
            {
                for (int j = 0; j < ch[0].length; j++)
                {
                    ch[i][j] = arr.get(i).charAt(j);
                    System.out.print(ch[i][j]);
                }
                System.out.println("");
            }
            done = true;
            for (int i = 0; i < ch.length; i++)
            {
                for (int j = 0; j < ch[0].length; j++)
                {
                    if (ch[i][j] == 'L')
                    {
                        check = true;
                        iold = i;
                        jold = j;
                        if (check)
                        {
                            j = jold;
                            for (i = iold; i < ch.length - 1; i++)
                            {
                                if (ch[i+1][j] == '#')
                                {
                                    check = false;
                                    break;
                                }
                                if (ch[i+1][j] == 'L')
                                {
                                    break;
                                }
                            }
                        }
                        if (check)
                        {
                            j = jold;
                            for (i = iold; i > 0; i--)
                            {
                                if (ch[i-1][j] == '#')
                                {
                                    check = false;
                                    break;
                                }
                                if (ch[i-1][j] == 'L')
                                {
                                    break;
                                }
                            }
                        }
                        if (check)
                        {
                            i = iold;
                            for (j = jold; j < ch[0].length - 1; j++)
                            {
                                if (ch[i][j+1] == '#')
                                {
                                    check = false;
                                    break;
                                }
                                if (ch[i][j+1] == 'L')
                                {
                                    break;
                                }
                            }
                        }
                        if (check)
                        {
                            i = iold;
                            for (j = jold; j > 0; j--)
                            {
                                if (ch[i][j-1] == '#')
                                {
                                    check = false;
                                    break;
                                }
                                if (ch[i][j-1] == 'L')
                                {
                                    break;
                                }
                            }
                        }
                        if (check)
                        {
                            i = iold;
                            j = jold;
                            while (i < ch.length-1 && j < ch[0].length-1)
                            {
                                if (ch[i+1][j+1] == '#')
                                {
                                    check = false;
                                    break;
                                }
                                if (ch[i+1][j+1] == 'L')
                                {
                                    break;
                                }
                                i++;
                                j++;
                            }
                        }
                        if (check)
                        {
                            i = iold;
                            j = jold;
                            while (i > 0 && j < ch[0].length-1)
                            {
                                if (ch[i-1][j+1] == '#')
                                {
                                    check = false;
                                    break;
                                }
                                if (ch[i-1][j+1] == 'L')
                                {
                                    break;
                                }
                                i--;
                                j++;
                            }
                        }
                        if (check)
                        {
                            i = iold;
                            j = jold;
                            while (i < ch.length-1 && j > 0)
                            {
                                if (ch[i+1][j-1] == '#')
                                {
                                    check = false;
                                    break;
                                }
                                if (ch[i+1][j-1] == 'L')
                                {
                                    break;
                                }
                                i++;
                                j--;
                            }
                        }
                        if (check)
                        {
                            i = iold;
                            j = jold;
                            while (i > 0 && j > 0)
                            {
                                if (ch[i-1][j-1] == '#')
                                {
                                    check = false;
                                    break;
                                }
                                if (ch[i-1][j-1] == 'L')
                                {
                                    break;
                                }
                                i--;
                                j--;
                            }
                        }
                        i = iold;
                        j = jold;
                        if (check)
                        {
                            arr.set(i, arr.get(i).substring(0, j) + "#" + arr.get(i).substring(j+1));
                            done = false;
                        }
                    }
                    if (ch[i][j] == '#')
                    {
                        filled = 0;
                        iold = i;
                        jold = j;
                        j = jold;
                        for (i = iold; i < ch.length - 1; i++)
                        {
                            if (ch[i+1][j] == '#')
                            {
                                filled++;
                                break;
                            }
                            if (ch[i+1][j] == 'L')
                            {
                                break;
                            }
                        }
                        j = jold;
                        for (i = iold; i > 0; i--)
                        {
                            if (ch[i-1][j] == '#')
                            {
                                filled++;
                                break;
                            }
                            if (ch[i-1][j] == 'L')
                            {
                                break;
                            }
                        }
                        i = iold;
                        for (j = jold; j < ch[0].length - 1; j++)
                        {
                            if (ch[i][j+1] == '#')
                            {
                                filled++;
                                break;
                            }
                            if (ch[i][j+1] == 'L')
                            {
                                break;
                            }
                        }
                        i = iold;
                        for (j = jold; j > 0; j--)
                        {
                            if (ch[i][j-1] == '#')
                            {
                                filled++;
                                break;
                            }
                            if (ch[i][j-1] == 'L')
                            {
                                break;
                            }
                        }
                        i = iold;
                        j = jold;
                        while (i < ch.length-1 && j < ch[0].length-1)
                        {
                            if (ch[i+1][j+1] == '#')
                            {
                                filled++;
                                break;
                            }
                            if (ch[i+1][j+1] == 'L')
                            {
                                break;
                            }
                            i++;
                            j++;
                        }
                        i = iold;
                        j = jold;
                        while (i > 0 && j < ch[0].length-1)
                        {
                            if (ch[i-1][j+1] == '#')
                            {
                                filled++;
                                break;
                            }
                            if (ch[i-1][j+1] == 'L')
                            {
                                break;
                            }
                            i--;
                            j++;
                        }
                        i = iold;
                        j = jold;
                        while (i < ch.length-1 && j > 0)
                        {
                            if (ch[i+1][j-1] == '#')
                            {
                                filled++;
                                break;
                            }
                            if (ch[i+1][j-1] == 'L')
                            {
                                break;
                            }
                            i++;
                            j--;
                        }
                        i = iold;
                        j = jold;
                        while (i > 0 && j > 0)
                        {
                            if (ch[i-1][j-1] == '#')
                            {
                                filled++;
                                break;
                            }
                            if (ch[i-1][j-1] == 'L')
                            {
                                break;
                            }
                            i--;
                            j--;
                        }
                        i = iold;
                        j = jold;
                        if (filled >= 5)
                        {
                            arr.set(i, arr.get(i).substring(0, j) + "L" + arr.get(i).substring(j+1));
                            done = false;
                        }
                    }
                }
            }
            iter++;
        }
        int count = 0;
        for (int i = 0; i < arr.size(); i++)
        {
            for (int j = 0; j < arr.get(i).length(); j++)
            {
                if (arr.get(i).charAt(j) == '#')
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static boolean inBound(int n, int s, int d)
    {
        if (d == 0)
            return n - 1 >= 0 && n + 1 < s;
        else if (d == 1)
            return n + 1 < s;
        else if (d == -1)
            return n - 1 >= 0;
        return false;
    }
}

/*
L.LL.LL.LL
LLLLLLL.LL
L.L.L..L..
LLLL.LL.LL
L.LL.LL.LL
L.LLLLL.LL
..L.L.....
LLLLLLLLLL
L.LLLLLL.L
L.LLLLL.LL
0

LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.L.LLLLL.LLLL.LLLLLLLLL..LLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLL.LLLLLL
LLLLLLLLLL.L.LLLLLLL.LL.LLLLLLL.LLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLL.LLLLLL
LLLLLLLL.L.LLLLLLLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLL.LLLLLL
.LLLLLLLLLLLLLLLLL.LLLL.LLLLLLL.LLLLLL.LLLLL.LLL.LLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLL.LLLLL.LLLLLL
LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLL.LLLLL.LL.LLLLLLLLL.LLLL.LLLLLL.LLLLLLLL.LLLLLLL.LLLL.LLLLLL
LLL.LL..L..L.LL.L.L........L.............LLL....LL...L..L.L.....L..L.L.......L..L......LLLL.L.L
LLLLLLLLLLLLLLLLL..LLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLLL.LLLL.LLLLLLLLLLLLLLL.LLLLLLL.LLLLL.LLLLL
LLLLLLLLLL.LLLL.LL.LLLL.LLLLLLLLLLLLLLLLLL.L.LLLLLLLLL.LLLL.L.L.LL.LLLLLLLLLLLLL.LL.LLLLLLLLLLL
LLLLLLLLLLLLLLLLL.LLLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLLLLLLL.LL.LLLLLLLLL.LLLLL.
LLLLLLLLLLLLLLLLL..LLL.LLLLLLLLLLLLLLL.LLLLL.LLLLLLLLL.LLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLL.LLLLLL
LLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLLLLL
LLLLLLLLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLL.LLL.L..LLLLLLLL.LLLL.LLLLLL..LLLLLLLLLLLLLLL.LLLL.LLLLLL
L.LLLLLLLL..LLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLL.LLLLLLL.LLLL.LLLLLL
.LLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLL
LL.L..LL...LL..L..L.L.L.....L..LL...L.LLL......L.L...L.LL...L.L.L.........L.LL....L.LL.LL...LL.
LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLL.L.LLLLLLLLLLLLLL.LLL..LLLLLL
LLLLL.LLLL.LLLL.LLLLLLLLLLLLLLL.LLLLLL.L.LLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLL.LLLLLLL
LLL.LLLLLL.LLLLLLL.LLLL.LLL.LLL.LLLL.L.LL.LLLLLLLLLLLL.LLLL.LLL.LL.LLLLLLLLLLLLLLLLLLLLL.LL.LLL
LLLLLLLLLL.LLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLL.LLLL.LLLLLL
...L...L..L.L...L..L......L.......L.L...L...L...L.....L...L...L....L...LL..L..L.............LL.
LLL..LLLLL.LLLLLLLLLLLL.LLLLLLL.LLLLLL.LLLLLLLLLLL.LLL.LLLL.LLLLLL.LLLLLLLLLLLLLLLL.LLLLL.LLLLL
LLLLLLLLLL.LLL..LLLLLLL.L.LLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLL.LLL.LLLLLLLLLLLLLLLLLLLLLLLL
LLLLLL.L.L.L.LLLLLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLL.LLLL.LLLLL.
LLLLLL.LLL.LLLLLLLLLLLL.LLLLLLL.L.LLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLL.LLL.LLLL.LLLLLLL.LLLL.LLLLL.
LLLLLLLLLL.LLLLLLL.LLLL.LLLLLLL.LLLLLL.LLLLL.LLL.LLLLL.L.LL.LLLLLL.LLLLLLLL..LLLLLLLLLLL.LLLLLL
LLLLLL.LLL.LLLLLLL.LLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLL
LLLLLLLLLL.LLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLL.LLLLLLL..LLLLLLLLL.LL.LLLLLL
LLLLLLLLLLLLLLLLLLLLLL..LLLLLLL.LLLLLL.LLLLL.LL.LLLLLL.LLLLLLLLLLL.LLLLL.L.LLLLLLLLLLLLL.LLLLLL
LLLLLLLLLL.LLLLLLLLLLLL.LLLLLLL.LLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLL.LL.LLLL.LLLL.LLLLLL
.L......L..L........LL..LLL...LL.L.....L..L.L..LLL..LLL..LL.LL...LLL.......L...LL...........LLL
LLLLLLLLLL.LL.LLLL.LLLL.LLLLLLL.LLLLL.LLLLLL.LLLLLLLLL.LLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLL.LLLLLL
LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLL.LLLLLL
LLLLLLLLLL.LLLLLLL.LLLL.LLLLLL..LLLLLL.LLLLLLLLLLLLLLL.LL.L.L.LLLLLLLLLLLLL.LLLLLLL.LLL..LLLLLL
LLLLLL.LLL.LLLLLLL.LLLLLLLLL.LL.LLLLLL.LLLLLLLLLLLLLLL.LLLL.LLLLLL.LLL.LLLL.LLLLLLL.LLLL.LLLLLL
LLLLLLLLLLLLLLLL.L.LLLL.LLLLLL..LLLLLLLLLLLL.LLLLLLL.L.LLLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLL..LLLLL
LLLLLLLLLL.LLLLLLL.LLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLL.LL.LLLLL.LL.L.LL.LLLLLLLLLLL
LLLLLL.LLL.LLLLLLL.LLLLLLL.LLLL.LLLLLLLLLLLL.LLLLLLLLL.LLL.LLLLLLL.LLLLLLLLLLLLLLL..LLLL.LLLLLL
LL.LLLLLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLL.LLLLLLLL.LLLLLLLLLLLLLL.LLLL
LLLLLLLLLL.LLLLLLL.LLLL.LLL.LLL.LLLLLL.LLLL..LLLLLLLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLL.LLLL.LLLLLL
........LL.L..LLLL..L..LLLL..LLL.........L.L......LL.LL..L........L...L..LL..LLLL.L.L.....L.LL.
LL.LLLLLLL.LLLLLLL.LLLL.LLLL.LL.LLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLL..LLLLLLLLLLLLLLLL.LLLLL.L..LL
LLLLLLLLL.LLLLLLLL.LLL..LLLLLLL.LLLLLL.LLLLL.LLLLLLLLL.LLLL.LLLLLLLLLL.LLLL.LLLL.LLLLLLLLLLLLLL
LL.LLLLLLL.LLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLL..LLL.LLLLLLLLLL.LLLL
LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLL.LLL.LLL..LLLLLLL.LLLL.LLLLLL
LLL.LLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLL..LLL.LLLLLLLLLL.LLLL.LLLLLL.LLLLLLLLLLLLLLLL.LLLL.LLLL.L
LLLLLLLLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLL.LLLLLL.LL.LLLL..LLLLLLLLLLLLLLLLLLL
..LL..LLL.....LL......L..L.L.LLL........LL......LLL...L......L.LL..L.LL.LL.L.......LL....LL...L
.LL.LLLLLLLLLLLLLL.L.LL.LLLLLLL.LLL.LL...L.L.LLLLLLLLL.LLLLLLLLLLLLL.LLLLLL.LLLLLLL.LLLL.LLLLLL
L.LLLLLLLLLLLL.LLL.LLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLL.LLL.LLLL.LLL.LLL.LLLL.LLLLLL
LLLLLLLLLL.LLLLLLL.LLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLL..L.LLLL.LLLLLLLL..LLL.LLLLLLL.LLLLLL
.LLLLLLLLL.LLL.LLL.LLLL.LLL..LLLLLLLLLLLLLLLLLLLLLLLLLL.LLL.LLLLLL.LLLLLLLL.LLLLLLL.LLLL.LLLLLL
L..L...LL...L.LL....L.LL.L..LL.L.........L.........LLLL..L.L..LL...L.L.L....LLL.....L..L.L...LL
.LLLLLLLLL.LLLL.LL.LLLL.LLLLLLLLL.LLLL.LLLLL.LLL.LLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLL
LLLLLLLLLL.L..LLLL.LLLL.LLLLLLL..LLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLL
LLLLLLLLLL.LLLLLLL.LLLL.LLLLLLL.LLLLLL.LLLLLLLL.LLLLL.LLLLLLLLLLLL.LLLLLLLL.LLLLLLL.LL.LLLLL.LL
LLLLLLLLLL.LLLLLLL.LLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLL
L.LLLLLLLL.LLLLLLLLLLLL.LLLL.LL..LLLLL.LLLL.LLLLLL.LLLLLLLL.LLL.LLLLLLLLLLLLLLLLL.L.LLLL.LLLLLL
LLLLLLLLLL..LLLLLL.LLLLLLLLLLLL.L.LLLL.LLLLLLLLLLLLLLL.LLLL.LLLLLL..LL.LLLL.LLLLLLL.LLLL.LLLLLL
LLL.LLLLLLLLLLLLLL.LLLLLLLLLLLL.LL.LLL.LLLLL.LLLLL.LLL.LLLL.LLLLLL.LL.LLLL..LLLLLLL.LLLLLLLLLLL
LLLLLLLLLL.LLLLLLLLLLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLL..LLLL.LLLLLLLLLLLLLLL.LLLLL.LLLLLL.LLLLLL
L.L...L...L..L..L....L...L..LLL..L....L..LL...LLL.LL.L...L.L..L.LLL..L....L.L...LL..L..L.L..L.L
LLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLL.LLLLLLLL.LLLLLLL.LLLL.LLLLLL
LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLL.L
LLLLLLLLLL.LLLLL.L.LLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLLL
L..LLLLLLLLL.LLLLL.L.LLLLLL.LLL.LLLLLL.LLLLLLLLLLLLLLL.LLLL.LLLLLL.LL.LLLLLLLLLLLLL.LLLLLLLLLLL
LLLLL.LLLL.LLLL.LL.LLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LL.L.LLL.LLLLLLLLL.LL.LLLL.LLLLLL
....L....L..L.....L....L..LL....L.L..L..LL.LLL...L.....L.LLL.L.LL.....L....L.L........L.LLL....
L.L.LL.LLL.LLLLL.L.LLLL.LLLLLLL.LLLLLL.LLLLL.LLLLLLLLL.LLLL.LLLLLLLL.LLLLLLLLLLL.LL.LLLL.LLLLLL
LLLLLLLLL.LLLLLLLL.LLLL.LLLLLLL.LLLLLL.LLLLL.LL.LLLLLL.LLLL.LLLLLL.LLLLLLL.LLLLLLLL.LLLL.LLLLLL
LLLLLLLLL.LL.LLLLLLLLLL.LLLL.LLLL.LLLLLLLLLLLLLLLLLLLL..LLL.L..LLL.LLL.L.LL.LLLLLL..LLLL.LLLLLL
LLLLLLLLLL.LLLLLLL.LLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLL
LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLLLL.LL.LLLLLLL.LLLL.LLLLLL
.....LL.LL.L.....LL.LL..L...L...LLLLL......L.L....LL...LLL...LLLLL..LL..L....L......L.......L.L
LLLLLLLLLL.LLLL.LL.LLLL.L.LLLLL.LLLLLL.LL.LL.LLLLLLLLL.LLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLL
LLLLLLLLLL.LLLLLLL.LLLL.LLLLLLL.LLL.LL.LLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLL.L
LLLL.LLLLL.LLLLLLL.LLLL.LLLLLLL.LLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLL.LLLLLL
LLLLLLLLL..LLLLLLL.L.LL..LLLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLL.LLL.LL.LLLLLLLL.LLLL.LLLLLLLLLLLLLL
LLLLLLLLLLLLL.LLLLLLLLL.LLLLLL..LLLLLL.LLLLL.LLLLLLLLLLL.LLLLLLLLLL.LLLLLLL.LLLLLLL.LLLLLLLLLLL
..LLL..L..L...L..L..L.L.....L............L.....L..L....L.LL......L.....L..LLL..L.L..L..........
LLL.LLLLLL.LLLLLLLLLLLL.LL.LLLLLLLLLLL.LLLLLL.LLLLLLL..LLLL.LLLL.L.L.LLLL.LLLLLLLLLLLLLLLLLLLLL
LLLLLLLLLL.LLLLLLL.LLLL.LLLLLLL.LLLLLL.LL.LL.LLLLLLLLLL.LLL.LL.LLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLL
.LLLLLLLLL.LLLL.LLLLLLLLLLLLL...LL.L.LLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLL.L.LLLLLL
LLLL.LLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLL.LLLLL.LLL.LLLL.LLLLLLLLLLLL.LLLLL.LLLLLLLLLLLLLLLL
LLLLLLLLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLL.LLLLL.LLLLLLLLL.LLLLL.LLL.L.LLLLLLLL.LLLLLL..LLLLLLLLLLL
.LLLLLLLLL.LLLLLLL.LLLL.LLLLLL..LLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLL.LLLL.LLLLLL
.L.....LL......L........L.L....LLL......L...L.LL...L...L..LL................L...L..L...........
LLLLLLLLLL.LLLLLLL.LLLL.LLLL.LL.LLLLLL.LLLL..LLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLL.LL.LLL.LLLLLLL
LLLLLL.LLL.LLLLLL..LLL..LLLLLL..LLLLLL.LLLL..LLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLL..LLLLLLLLLL
LLLLLL..LL.LLLLLLL.LLLL.LLLL.LL.LLL.LL.LLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLL
LLLLLLLLLL.LLLLLLL.LLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLL.LL.L.LLLLLL.L.LLLLLL.LLLLLLLLLLLLLLLL.LL
LLLLLLLLLL.LLLLLL.LLLLLLL.LLLLL.LLLLL.LLLLLL.L.LLLLLLL.LL.LLLLLLLLLLL.LLLLLLLLLLLLL.LLLLLLLLLLL
LLLLLLLLLL.LLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLL..LLLLLLLLL.LLLLLLLLLLLLL.LLLLLL.LLLLLLL.LL.L.LLLLLL
LLLLL.LLLL.LLLLLLL..LLLLLLLLLLL.LLLLLL.LLL.L.L.LLLLLLLLLLLL.LLLL.L.LLLLLLLL.LLLLLLL.LLLLLLLLLLL
....LLL...LLL.....L.L...LL...L..L....LL...L.L.LLLLL....L......LLLL......L..LLLLL.L.LL...LL..LLL
LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLL.LL.LLL.LLLLL.LLLLLLLLL.LLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLL.LLLLLL
LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLL.LLLLL.LLLLLLLLL.LLLL.LLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLL
.LLLLLLLLL.L..LLLLLLLLLLLLLLLLL.LLLLLL.LLLL..LLLLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLL
LLLLLLLLLL.LLLLLLL.LLLL.L.L.LLLLLLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLL.LLL.LLLL.LLL.LLLLLL
LLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLL.LLLLLLLL..LLLLLL.LLLL.L.LLLL
0
*/