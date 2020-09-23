import java.util.*;

public class Container
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        String split[] = input.split("-");
        int range[] = new int[split.length];
        for (int i = 0; i < range.length; i++)
            range[i] = Integer.parseInt(split[i]);
        if (range[0] >= 111111 && range[0] <= 999999 && range[1] >= 111111 && range[1] <= 999999)
        {
            int vals[] = new int[6], temp, count = 0;
            boolean isValid = true, adj = false;
            for (int i = range[0]; i <= range[1]; i++)
            {
                int adjNums[] = new int[10];
                temp = i;
                for (int j = vals.length - 1; j >= 0; j--)
                {    
                    vals[j] = temp % 10;
                    temp /= 10;
                }
                for (int j = 1; j < vals.length; j++)
                {
                    if (vals[j] < vals[j-1])
                        isValid = false;
                    else if (vals[j] == vals[j-1])
                    {
                        adj = true;
                        adjNums[vals[j]]++;
                    }
                }
                if (!adj)
                    isValid = false;
                if (isValid)
                {
                    for (int j = 0; j < adjNums.length; j++)
                    {
                        if (adjNums[j] == 1)
                        {
                            count++;
                            break;
                        }
                    }
                }
                isValid = true;
                adj = false;
            }
            System.out.println(count);
        }
    }
}