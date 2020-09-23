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
            if (orbit.get(i).contains("YOU"))
            {
                count += countOrbits(orbit, i, count) - 2;
                break;
            }
        System.out.println(count);
    }
    public static int countOrbits(ArrayList<String> orb, int index, int num)
    {
        int count = 0;
        String orbiter = orb.get(index).substring(orb.get(index).indexOf(")")+1);
        String value = orb.get(index).substring(0, orb.get(index).indexOf(")"));
        orb.remove(index);
        if (orbiter.equals("SAN"))
            return num;
        for (int i = 0; i < orb.size(); i++)
        {
            if (value.equals(orb.get(i).substring(orb.get(i).indexOf(")")+1)) || orbiter.equals(orb.get(i).substring(0, orb.get(i).indexOf(")"))))
            {
                count += countOrbits(orb, i, num + 1);
                i--;
            }
        }
        return count;
    }
}