import java.util.*;

public class Image
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int[] pic = new int[15000];
        int count = 0, min = 15000, row = 0, two = 0, one = 0;
        String input = s.next();
        for (int i = 0; i < 15000; i++)
        {
            pic[i] = Integer.parseInt(input.substring(i, i + 1));
        }
        for (int i = 0; i < 100; i++)
        {
            for (int j = 0; j < 150; j++)
            {
                if (pic[i*100+j] == 0)
                {
                    count++;
                }
            }
            if (count < min)
            {
                min = count;
                row = i;
            }
            count = 0;
        }
        for (int i = 0; i < 150; i++)
        {
            if (pic[row*100+i] == 1)
            {
                one++;
            }
            else if (pic[row*100+i] == 2)
            {
                two++;
            }
        }
        System.out.println(one*two);
    }
}