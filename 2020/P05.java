import java.util.*;

public class P05
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int rs = 128, cs = 8, high, low, max = 0, t, row, col;
        char c;
        while (true)
        {
            String str = s.nextLine();
            if (str.length() < 8)
            {
                break;
            }
            high = 127;
            low = 0;
            for (int i = 0; i < str.length() - 3; i++)
            {
                c = str.charAt(i);
                if (c == 'F')
                {
                    high = (low + high) / 2;
                }
                else if (c == 'B')
                {
                    low = (low + high) / 2 + 1;
                }
                //System.out.println(low + " " + high);
            }
            row = low;
            high = 7;
            low = 0;
            for (int i = str.length() - 3; i < str.length(); i++)
            {
                c = str.charAt(i);
                if (c == 'L')
                {
                    high = (low + high) / 2;
                }
                else if (c == 'R')
                {
                    low = (low + high) / 2 + 1;
                }
                //System.out.println(low + " " + high);
            }
            col = high;
            t = row * 8 + col;
            if (t > max)
            {
                max = t;
            }
        }
        System.out.println(max);
    }
}

/*
BFFFBBFRRR
FFFBBBFRRR
BBFFBBFRLL
0

FFBBBBBLLR
BFBFBBBRLL
FBFFFFBLRL
BFFBFBBRLR
FFBBFFFRRL
FBFBFFBLLR
BFFBFBFLLR
BFFBBBBRRL
FBBBFBFLRL
BFFBFBBRLL
FFBBFBBRRR
BBFBBBBLRL
FFBFBBFLRL
BBFFFBBLLR
FFBBBFFRLL
FBFBFFBLRL
BFFFBFBLRL
FFBFBFFRRL
BBBFFFBRRR
BBFFBBFLLL
BFBBBFBLRR
FBFBFFBRRL
FFFBBFBLLR
FBBFBFFRLR
FBFFFFBRRL
BBFFFFFLLR
BFBFFBBLLR
FFBFBBBRRR
FFBBBBBRLR
BBFFBFFRLR
BBFBBBBRRL
FFBFFFFLLL
BBBFFBFRRL
FFBFFFFLRR
FBBBBBFLLR
BFBFBBBLRL
BFBBBFFRRL
FBFFBBFRRR
BBFFFFBRLR
FFBFBBFRLL
FFBFBFBLLL
FBBBFBFRRR
FFFBBBFRLL
BFFFBBBLLR
FBFFBFBRLR
FFBFBBBLLL
BFBBBFFLLL
BFFBFBFLRR
BFFBFBBRRR
BFBBBFBLLL
FBFFBFFLRL
BBFFFBBRRL
FFFBFBBRLR
BBFBBBFLLR
FFBBBBBLRR
BFFFFBFRRL
BFFFBBBRLR
BFBBBBBLLR
FBFBBFFRRL
BFFBFFBLLR
FFBBFFFRLR
FBBFFFBLLL
FFFBBFFLRR
BBFFFFBRLL
BFFFFFFRLR
BFFBBBFLLR
BFBBBFBRRL
FBFBBFFRRR
BFBFBFFLRR
BBFBFFFLLL
BBBFFBFLLL
FFBBFBFRRL
FBBFFFBLRL
BFBBBBFLLR
BFBFBBBLRR
BFBBBBBRLR
BFFFBFFRRL
BFFFBFFLLL
BFBBBBBRLL
BBFFBFBRLL
FBBBBBFRLR
BBFFBFFLLR
FBBFFFFRLR
FBFFFBFLRL
BBFBFBBRLR
BFFBBFBRRL
FBFFFFFRRR
BFBFBBFLLL
FBBFBBFRLR
BFBBFBBRRR
FFFBBBFLRL
BFFBFFBRRL
FBFBFBBLLR
BBFBFFFLRL
FFFBFBBRRR
BBFFBBFRRL
BFBFBFBLRR
BFFBBBBRLR
FBBFFFFLLR
FBBBFFBLLR
FBBBBFFLRL
FBBBBFFLLL
BBFFBBFRLR
FFBBFBFLRL
BFBFFBBRLL
FBFBBFFLRR
BFFFFFBRLL
BBFBFBBRRL
FBBBBBBLLR
BBFBFBFLLL
BFFFFBBRLL
BFBFFBFRRL
FFBFFBFLLL
BFFFBFBLLR
FBBFBFFRRR
FBBFFBFRLR
FBBFBFBRRR
FBFBBFBRLR
FFFBBFBRRL
FBBBBFBLRR
FBBFBBFLRR
BBBFFBFRRR
BFFBBBBLLL
FBFBFBFLRL
FFBFFBFLRL
FFFBBFBLLL
FBBFFBFLLR
FBBBFBBRRR
FBBBBFBRLR
FBBFFFFRRR
FFFBFBFLLR
FFBFFFFRRR
BFBBBBFRLR
BFFBFBFRRR
BBFBBFFRLL
BFFBFFFLLR
FBBBFBBRLL
BBFBFFFRRR
FFBFBBBRRL
FBBBFBFLLL
FBBBFBBLRR
BFBFBBFRLL
BFBFBFBRLL
FBFFBBBLRL
FBBBBFFRRL
BBFFBFBRLR
BBFFBFFRRR
FFFBFBFLRR
FFFBFBBLLR
FBBBFFFRLL
FBFBBBFLLL
FBFBBFFRLL
BFBBFFBLLR
FFBFFFFRLR
BFFFBBFRRL
BFBBFBFLLL
FBFFFBFLLR
BBBFFBFRLR
BFFBBFFLLL
FFBBBBBRRL
BBFFBFBLLL
BFFFBFFLLR
BBBFFBFLRL
BFBFFBFLLL
FBFFBFFRLR
FFBFBBBLRL
FBBFBFBLLR
FBBFBBFLRL
FFBBFFBLRL
FFBBBBFRLR
FFBFFFFRLL
FFBBBFBRLL
BFFFBBFLRL
FFFBBBFRRL
BFBFBFFLLR
FFFBFBFRLR
BBFBFBFRLR
FBBBFFBRRL
FFBBBBFLLL
FFBBFFBRLL
FBBFFFBRRR
FFFBBBBRLL
FBFFFBFRRR
BFBBBFFLLR
BBFBBFBLRR
FFBFBBBLLR
BFBFBBBRRR
BBFFFBBLRR
FBFBFFBLRR
FFFBFBBLLL
FFBFFBFRRL
FFFBFBBRRL
BFBBBFBRLL
BFBFFFFLLL
BFBFBBBRRL
FFFBBFBRLR
BBFBBBBRLL
FBFBBBFLRL
FFBFFBFRLR
BFBBBBFLLL
FFBBBBFLRL
BFFBFBFRRL
BFFFBBFLLR
BFFFBBFRRR
BFBFBFBLLL
BFFFFFBLLR
BFFFBBFLLL
BFBBBBFRRL
BBFFBBFLRR
BBBFFFFLRR
FFBFBFFLLR
FBFFBFFLLR
BFBFFFFRLR
FFBFFBFRLL
FFBFBFBLRL
BFFBBFFRRR
BFFFBBFLRR
FBFBFBBLRL
BFFBFFFLRL
FBFFBBBLRR
FBBFFFFLRL
BBBFFFBLRR
FBFFFBBRLL
BFBBFFFRLL
FFFBBBBLRR
BFBBBBBRRR
FBBBBBFRLL
BFBFFBBRLR
BFFFBFFLRL
FBFBFBFRRL
FBFFBFFRRR
FFBBFFBLRR
FFBFFBBRLR
FBBBFFFRLR
BFFBBBBLRR
FBFFFFBLRR
BFBBFFFLLR
FBFFBBBLLR
FBFFFBBRRR
BFFBFBBLLL
FFBBBBBRRR
BFBBFFBRRR
FBBBBBBRRL
BFBBFBFLRR
BBFBFFBRLL
FBFFFFBRLL
BFBFBBFLRL
BFBFFFFLLR
BFFFBBBLRL
BBFFFFFRLL
BBBFFBBRLR
BBFBBFBLRL
BBFBFFBLLR
BBFBFBFLRR
FFBBFFBRRL
FFBFBBBRLR
BBFFFFBRRR
BFBFFFBRLR
BBFFFFBLLR
BBFFBFFLRR
FBBFBFBRLR
FFBBBFFLRR
BFBBFFBRLL
FBFBBBBLLR
FBBFFFBRLL
FBBFFFBLRR
FBFFFBBLLR
BBFFFBBRLL
BBFBBBFRRR
FFBBFFFLLL
BFBBBFFRLR
BFBBFBBRLL
BFFFFFBLRR
BFBFBFBRLR
BFBFFBFLRL
FFBFBFBRLL
BBFFFBFLLR
FFBFBFBRLR
FFFBBBBLLR
FBFBBBBRRR
BBFBBBFLRL
BBFBBBFRRL
FBFFBBFLLR
FBFFBFBLRL
BBFBBFBRLR
BFFFFBBRLR
BBFFFBFRLL
BFBFFBBLRL
FFFBFBBLRL
FFBBBBFLLR
BBFBBFBRRL
BFBBFBFLRL
BBFFBBFLRL
BFBFFBFRLL
BFFFFBBRRR
BFFFFBFRLL
FFBBFFBLLL
BFBBBBBLRL
FBBBFFBRLL
FBBFFFFRLL
BFFBFFFRLR
BFBBFBBLRR
BBFBFFBLRR
FBBBBBBLRL
BBBFFFFLRL
FFBBFBBRLR
FFFBBBFRRR
FBFFFFBRLR
BBFFFFBLLL
BFBBBFBRRR
FFFBBBBLRL
FFBFBFFLRR
BBFBFBFLRL
BFBBBBBLRR
BBFFBFBRRL
FBBFBBFRRL
BFFFFFBLRL
FFBFBBFLLL
BFFBBFFLRL
BBBFFFFLLR
BFBFFBBRRL
FBBBBFBLLL
BBFFBBBLRL
FBFBFFFRLR
FFBBFFFLRL
BFFBBFBRLL
FBBFBBFRRR
FBFBBBFRRR
BFBFBBFRRL
FBBBFBFRRL
FBBBBBBRLL
FBFFFFBLLR
FBFBFBBRRR
BFBBBBFRRR
BBFFFFBLRL
BFBBFBBLRL
BFFBBFBRLR
BFFBFBBLLR
BFFFBBBRLL
FBBFFBFRRR
BFFBFBBLRR
FFBFFFFLRL
BFBBFBBRRL
FBBBFFFLRL
FFBFBFBLRR
FBFFFBBLLL
FBBFFBBLLL
BFBBBBBLLL
FFBBBFBRRR
FBBBBBBLLL
FBFFBBFRLR
FBFBBBBLRR
FFBBFFFRRR
BBBFFBBRRL
FBBBFBFRLL
BFFFBBBLRR
FFBFFBBLRR
BFFBBFFRLL
BFFBBBFRLL
BFFBFFFRLL
BFFFFFFLLR
FFBFFFBLLL
FBBFBFFRRL
FFBBFBBLRL
FFBBBBFRRL
FBBBFBBLLR
FFBFBFFLRL
FBFFBFBLRR
BFBBFFBLLL
BFFFBBFRLL
FBFFBBFRRL
BFFBFBBLRL
BFFFBFBRRR
FFFBBBFLLL
BBFFFFFLRR
BBFFFBFLLL
FBFFFFFRRL
BFBFFFFRRR
FFBFFFBLLR
FFFBBFBLRL
FBFFFBFLLL
FBBBBFBRRR
FBBFFFBRRL
FBBFFBFRLL
FBBBBFFRLL
BFBFFFBRRR
BFBBBFBRLR
FBBBFFBLLL
BBFFFBFLRR
BFBBFFBRRL
BBFBBBFRLR
BFFFBFFRLR
FBBBFBFLLR
FBFBFBFRLL
FBFBBBFRLL
FFBFFBBRLL
FBFFFBFRRL
BBFBFFBRLR
FBFFFFFLRL
BFFBBBFLRL
FFBFFBBLLL
FFFBFBFLLL
BFBBBFFLRR
BBBFFBBRLL
BBBFFBFRLL
FBBFBFBLLL
BFBFFFFRLL
FBFBFFBRLR
FFFBBFBRRR
FBBFFFBRLR
FFFBBBFLRR
BFBFFFBLLR
BFBBBFFRLL
BFBBFFBRLR
BFFFFBFRLR
BFFFFBBLRR
BBBFFFBLRL
FBBBFFBRRR
BFBBFFFLRR
FBBBBFBRLL
BBFFBFFRRL
FFFBBFFLRL
FBBBBFFRRR
FBBFBFFLRL
BFBBFBFRLL
FBFFFBFRLL
FBFBBFFLLL
BFFFBBFRLR
BFFFBFFLRR
FFFBFBFLRL
FBFFFFFRLL
FFBFFFFRRL
FFBBFBFLRR
FFBFBBFRLR
FBFBFBFRLR
FBFBFFFRLL
FFBFFBFLRR
BFBFFBFRLR
BFFBFFFLRR
BBFBFBBLLR
FBFBFBBRRL
BFFBBBBLRL
BBFFBBBRRR
FBFFBBFRLL
BFFFBBBRRL
FBBFFFBLLR
BFFBBFBLRR
BFBBBBFLRL
FBFFBFBLLR
BFFBFFBRLR
FBBBBBFLRL
FBFFFBBLRL
BBFBFFFRLR
BFFBFFBLRL
FBBBBFBLLR
FFBBFFFLRR
BBFBBFBLLL
BBFFFBBLLL
FBBFBBBRLR
FBBFBBBLLR
BFFFFBFLRR
FBBBFFBLRR
FBFBFFBRLL
BFFBBBBRRR
BFFFFFFRLL
FBFBBBBLRL
FFBFBBFLLR
BFBBFBBLLL
BBFBFBBRRR
BFFFBFBLLL
BFBBFFBLRL
FBBBFFFLLR
FFBFFBBRRR
BBFBBBFRLL
FBBFBBBLLL
FBFBBBFLRR
BFBBFBFRRR
BFFFBFBRRL
BBFFBBBLRR
FBBFBFFLRR
BFFBFFBRLL
BFBFFFBLLL
BBFBBBFLLL
BFBBFFFRRL
FFBFBFBRRR
BFFBBFFRRL
BFFBFBFRLR
FFBFFFBRRL
BFFFBFBLRR
FBFBFFBLLL
FBFBFBFLLR
BFFBBBBLLR
FBBFFBBLLR
FBBFFBFLLL
BBBFFFBRLR
FBFFFBFRLR
BBFFBFFLRL
BFBFBBBLLL
FBFFFFBRRR
BFFBFFBRRR
FFBBBBBLLL
BBFFFBFRLR
BFFFFFBLLL
FBFBFBBLRR
FBFFBBBRRL
FBBBBBFLRR
BBBFFBFLRR
FBFBFFFLRR
FBBBBBBRRR
BFFBBFBRRR
BFFBFBFLLL
BFBBFFBLRR
BBFFBFFLLL
BFFFFFFLRR
BFFFBFBRLL
FBFFBFBRLL
FBFFBBBRLR
BBFFBFFRLL
FFBBFBBLRR
FBBBBBBLRR
FBBBBFBRRL
BFFFFBBRRL
FFBFFFBLRR
FBBFBFFLLL
BBFFFBBLRL
BBFBFFBLRL
BBFBFBBRLL
FBFFFBBLRR
BFBBFBBLLR
FFFBBBFRLR
FBFBFBBLLL
FBFFFFFLRR
BFBFBFBRRR
FBBFBBBLRL
BBFBBFBRLL
FBBFFBBLRR
BBFFBBBLLR
FBBFFBBLRL
FBFBFFFRRR
BBFFFBBRLR
BFFFFFFRRR
BBFFBBFRRR
FBFFBBFLRL
FFBBFBFLLL
FBFBFFBRRR
BFBBBBFRLL
FBBFBFBLRR
FBFBFFFLRL
FBBFFFFLRR
BFBFBFFRRL
BBFFBFBLRL
FBFFFFBLLL
FFBBFFFLLR
FBBFBBBRRR
FBBBBBBRLR
BBFFFFFRLR
FFBBBFFLLL
FBBBBBFRRR
BFFBFFBLLL
BBFBBBBRLR
FFBBFBBLLR
FBFBFFFLLR
FBBFBFFRLL
FFBBFBBRRL
FBBFBFBRLL
FBBBBFBLRL
FFBBFFBLLR
BBFFBFBRRR
BFBFFFFRRL
BFFBFFFRRR
FBFBBFFLLR
FFFBBFBRLL
FFBBBBFRLL
FBBFBBFLLL
FBBFFBFLRL
FBFFBFBRRR
FFBBBFBLLL
FFBBBFFRRL
FBBFFBFLRR
FFFBFBFRRR
FFBBFBFRLL
BBFFBBBLLL
FBBBFFFRRL
BFBBFBFLLR
BBFBFFBRRR
FFBBBFBLRL
FFBFBBBRLL
FBFBFBBRLL
FFBFFFBLRL
BBFBFFFLLR
FBFFBFFLLL
FFBBBFFRRR
FBBFBFFLLR
BBFBFFBRRL
BBFBBBBRRR
FFBFFBFRRR
BFBFBFFLLL
BBFBFBFRLL
BBFBFBBLRL
BFBBFBBRLR
FBFFBBBRLL
FBBBBFFLRR
FFFBBBFLLR
BBFFFFBLRR
BBFFFFFRRL
FBFFBFFLRR
BFFFFFFLLL
FFFBBBBRRR
BFFFBFFRLL
FFBFBFFRLL
FFFBBBBLLL
FFBFFBBRRL
FFBFBBFRRR
BFBFBFBLRL
FBFFFFFRLR
BBFBFBFRRL
FFFBFBFRLL
BBBFFBBLLR
FFBFBBFRRL
BBBFFFFRRR
BBFBBFFRRL
FBBFBBBRLL
FFFBFBBRLL
FFBBBBBLRL
FFBBBFFLLR
BFBFFBBLLL
BFFBBFBLLR
BBFBBBFLRR
BBBFFBFLLR
FBBFFBFRRL
BBFFFBFLRL
FFBFBBFLRR
BFBBBFFLRL
BFFBFFFRRL
BBFBBFBLLR
BBFBFBBLLL
BFFBBFFRLR
FBBFFFFRRL
FBFBFBFLRR
BFFBFBBRRL
FFFBBFFRLL
FFBBBFBRLR
FFBBBBBRLL
BBFBFBFRRR
FBBFBBFRLL
BBBFFFBRLL
BFFBBBFRLR
BBFBBFFLLL
FBFFBBFLLL
BFFBBBBRLL
BBBFFFBLLR
BFBFFFFLRR
FBBFBBFLLR
FBBBFFBRLR
FBFBBFBRLL
FBFBFBFLLL
FBFBBBFRLR
BBBFFFFRLL
FBFFBBFLRR
FBBBFBBRLR
FFBBBFFRLR
BBFFBFBLRR
FFFBBBBRRL
BFBFFFBRRL
BFBFBFBLLR
FFBBBFBRRL
FBFBBBBRLL
BBFFBFBLLR
FFBFFFFLLR
FBBFBBBRRL
FBFBBBBLLL
BFBFFBFLRR
FFBFFFBRRR
FFFBBFFRRR
BBBFFBBLRR
FBFFBFFRRL
BFFFBFBRLR
BFFBBFFLRR
FBBBBFFRLR
BFBBFFFLRL
FBFFFBFLRR
FFBBFBFRLR
FBBBFBFLRR
BBBFFFBLLL
BBBFFBBLLL
FBBBFFFRRR
BBFFFFFLLL
FBBBBBFLLL
FFFBBFFRRL
FFFBFBBLRR
FBBBBFFLLR
BFBFFFBLRR
FBBBFBBLRL
BFBBBFFRRR
BFBFFBBRRR
BFFFFBFLRL
BFBBBBFLRR
BFFFFFFRRL
BBFBBFFRRR
FFBFBFFRLR
BBFBBFFLLR
BFBFBFFRLR
FFFBFBFRRL
FFBFFBBLLR
FBFBBFBLLR
BFBFBFBRRL
FFBBFBFRRR
FFBFBFBRRL
FBBFBBBLRR
FBBFFBBRLR
BFFFFBFLLL
BFBFFBBLRR
BBFFFBFRRL
BBFBBFFRLR
BFBBFFFRLR
FBFFFFFLLL
BBFFFFBRRL
BFBFBFFLRL
BBFFBBFRLL
BFFBFBFLRL
FBFBBBFLLR
FBBFBFBRRL
FFFBBBBRLR
BFBFFFBLRL
BFFFFFBRRR
BBFBFBBLRR
BFFFFFBRRL
BBBFFFFRRL
BFFBBBFRRL
FBFFBFBLLL
FBBBFFFLLL
FFBBBBFLRR
FFBFFBFLLR
BFBFBFFRRR
FBFBBFBLLL
BFFBBFBLRL
BFFBBBFLRR
FFBFBFFLLL
BFFFBFFRRR
FBFFFFFLLR
BBFBBFFLRR
FFBFFFBRLR
BFBFFFBRLL
BFFBFBFRLL
FFBBFFFRLL
FBFFFBBRRL
BFFFBBBRRR
FBFBBBBRRL
FBBFFFFLLL
FBBBFFBLRL
FBFFBFFRLL
FFFBBFFRLR
BFBFBBFRRR
BFBBFFFRRR
FFBBBFFLRL
BBFFFFFLRL
FFBFBBBLRR
BFFFFFBRLR
FBBFFBBRLL
FBFBBFFRLR
FFBBBFBLRR
FBBFBFBLRL
FBBFFBBRRR
FFFBBFBLRR
BFBFBBFLLR
BBBFFBBLRL
BFFFBBBLLL
BBFFFFFRRR
FFBBBBFRRR
FBFBFBFRRR
FFBFBFFRRR
FFBBFFBRRR
BFBFBFFRLL
BFBFFBFRRR
BBFFFBFRRR
BFFFFBBLLR
FFBBFBBLLL
FBFBBBBRLR
FBFBBFBLRR
BFBFBBFRLR
FBBBFBBRRL
FBFBFFFLLL
FFBBFBBRLL
BBFBBBBLRR
FBBFFBBRRL
BFBBBFBLLR
FFFBBFFLLR
FBBBBBFRRL
BFBBFFFLLL
BBFBBBBLLL
BFBFBBBRLR
BFFBBBFLLL
BFBBFBFRRL
BBFBFFFRRL
FFBBBFBLLR
FBFBBFBLRL
BBBFFFBRRL
BBFBFFBLLL
BBFBFFFLRR
FFBFBFBLLR
BFBFFFFLRL
BFBBBBBRRL
BBFFFBBRRR
BBFFBBFLLR
FBFFBBBLLL
BFFFFFFLRL
FBFBFBBRLR
FBBBFFFLRR
BBBFFFFRLR
FFBBFFBRLR
BBFBFFFRLL
BBFBFBFLLR
BFFFFBFLLR
FBFBFFFRRL
BFFFFBBLLL
FFFBBFFLLL
BFFFFBFRRR
FBBBFBFRLR
FBBBFBBLLL
BFFFFBBLRL
FBFFBFBRRL
BBFBBBBLLR
BFBBBFBLRL
FBFBBFFLRL
BFBFBBBLLR
FFBBFBFLLR
FFBFFFBRLL
BFFBFFBLRR
BFFBFFFLLL
BFFBBFFLLR
BBFFBBBRLR
BFFBBFBLLL
FBFBBFBRRL
FBFFFBBRLR
BFFBBBFRRR
FFBFFBBLRL
FBFBBFBRRR
BBFFBBBRRL
FBFBBBFRRL
BBFBBFBRRR
BBBFFFFLLL
BFBFBBFLRR
FBFFBBBRRR
BFBBFBFRLR
BBFBBFFLRL
BBFFBBBRLL
0
*/