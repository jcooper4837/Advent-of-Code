import java.util.*;

public class Image
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int[] pic = new int[15000];
        int count = 0, min = 15000;
        int[] image = new int[150];
        String input = s.next();
        for (int i = 0; i < 15000; i++)
        {
            pic[i] = Integer.parseInt(input.substring(i, i + 1));
        }
        for (int i = 0; i < 150; i++)
        {
            image[i] = 2;
        }
        for (int i = 0; i < 100; i++)
        {
            for (int j = 0; j < 150; j++)
            {
                if (image[j] == 2 && (pic[i*150+j] == 0 || pic[i*150+j] == 1))
                {
                    image[j] = pic[i*150+j];
                    count++;
                }
            }
        }
        System.out.println("");
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 25; j++)
            {
                if (image[i*25+j] == 2 || image[i*25+j] == 0)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print(image[i*25+j]);
                }
            }
            System.out.println("");
        }
        System.out.println("");
        for (int i = 0; i < 150; i++)
        {
            System.out.print(image[i]);
        }
    }
}