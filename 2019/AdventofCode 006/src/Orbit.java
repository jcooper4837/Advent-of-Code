import java.util.*;

public class Orbit
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int count = 0;
        ArrayList<String> orbit = new ArrayList<>();
        while (true)
        {
            String input = s.nextLine();
            if (input.equals("0"))
                break;
            orbit.add(input);
        }
        for (int i = 0; i < orbit.size(); i++)
            count += countOrbits(orbit, i);
        System.out.println(count);
    }
    public static int countOrbits(ArrayList<String> orb, int index)
    {
        int count = 0;
        String value = orb.get(index).substring(0, orb.get(index).indexOf(")"));
        for (int i = 0; i < orb.size(); i++)
            if (value.equals(orb.get(i).substring(orb.get(i).indexOf(")")+1)))
                count += countOrbits(orb, i);
        return count + 1;
    }
}