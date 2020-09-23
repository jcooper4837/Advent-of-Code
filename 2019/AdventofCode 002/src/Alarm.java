import java.util.*;

public class Alarm
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String values[] = input.split("[^0-9']+");
        int codes[] = new int[values.length];
        int opcode, pos1, pos2, soln;
        for (int i = 0; i < codes.length; i++)
            codes[i] = Integer.parseInt(values[i]);
        for (int i = 0; i < codes.length; i+=4)
        {
            opcode = codes[i];
            pos1 = codes[i+1];
            pos2 = codes[i+2];
            soln = codes[i+3];
            if (opcode != 99)
            {
                if (opcode == 1)
                    codes[soln] = codes[pos1] + codes[pos2];
                else if (opcode == 2)
                    codes[soln] = codes[pos1] * codes[pos2];
            }
            else
                i = codes.length - 4;
        }
        for (int i = 0; i < codes.length; i++)
            System.out.print(codes[i] + ",");
    }
}