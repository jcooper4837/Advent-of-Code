import java.util.*;

public class Wires
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String input1 = s.nextLine(), input2 = s.nextLine();
        String[] comm1 = input1.split(","), comm2 = input2.split(",");
        char current;
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0, spaces, distance = 9999999, steps1 = 0, steps2 = 0, temp;
        int x1h[] = new int[comm1.length];
        int y1h[] = new int[comm1.length];
        int x2h[] = new int[comm2.length];
        int y2h[] = new int[comm2.length];
        int s1[] = new int[comm1.length];
        int s2[] = new int[comm2.length];
        for (int i = 0; i < comm1.length; i++)
        {
            current = comm1[i].charAt(0);
            spaces = Integer.parseInt(comm1[i].substring(1));
            switch (current)
            {
                case 'U': y1 += spaces; break;
                case 'D': y1 -= spaces; break;
                case 'R': x1 += spaces; break;
                case 'L': x1 -= spaces; break;
            }
            x1h[i] = x1;
            y1h[i] = y1;
            steps1 += spaces;
            s1[i] = steps1;
        }
        for (int i = 0; i < comm2.length; i++)
        {
            current = comm2[i].charAt(0);
            spaces = Integer.parseInt(comm2[i].substring(1));
            switch (current)
            {
                case 'U': y2 += spaces; break;
                case 'D': y2 -= spaces; break;
                case 'R': x2 += spaces; break;
                case 'L': x2 -= spaces; break;
            }
            x2h[i] = x2;
            y2h[i] = y2;
            steps2 += spaces;
            s2[i] = steps2;
        }
        for (int i = 0; i < comm1.length - 1; i++)
        {
            for (int j = 0; j < comm2.length - 1; j++)
            {
                if ((x1h[i] == x1h[i+1] && y2h[j] == y2h[j+1] && (((y1h[i] >= y2h[j] && y1h[i+1] <= y2h[j]) || (y1h[i] <= y2h[j] && y1h[i+1] >= y2h[j])) && ((x2h[j] >= x1h[i] && x2h[j+1] <= x1h[i]) || (x2h[j] <= x1h[i] && x2h[j+1] >= x1h[i])))))
                {
                    temp = s1[i+1] - (Math.abs(y1h[i+1] - y2h[j])) + s2[j+1] - (Math.abs(x2h[j+1] - x1h[i]));
                    if (temp < distance)
                        distance = temp;
                }
                else if ((y1h[i] == y1h[i+1] && x2h[j] == x2h[j+1] && (((x1h[i] >= x2h[j] && x1h[i+1] <= x2h[j]) || (x1h[i] <= x2h[j] && x1h[i+1] >= x2h[j])) && ((y2h[j] >= y1h[i] && y2h[j+1] <= y1h[i]) || (y2h[j] <= y1h[i] && y2h[j+1] >= y1h[i])))))
                {
                    temp = s1[i+1] - (Math.abs(x1h[i+1] - x2h[j])) + s2[j+1] - (Math.abs(y2h[j+1] - y1h[i]));
                    if (temp < distance)
                        distance = temp;
                }
            }
        }
        System.out.println(distance);
    }
}