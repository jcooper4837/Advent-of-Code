import java.util.*;

public class Rocket
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int fuel = 0, input;
        while (true)
        {
            input = s.nextInt();
            if (input == 0)
                break;
            fuel += getFuel(input / 3 - 2);
        }
        System.out.println(fuel);
    }
    public static int getFuel(int fuel)
    {
        if (fuel < 9)
            return fuel;
        else
            return fuel + getFuel(fuel / 3 - 2);
    }
}