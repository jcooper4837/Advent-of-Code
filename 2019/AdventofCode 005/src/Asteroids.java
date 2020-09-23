import java.util.*;

public class Asteroids
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String values[] = input.split(",");
        int codes[] = new int[values.length], pos[] = new int[3], val[] = new int[3];
        int opcode, k = 0, num;
        String modesList;
        for (int i = 0; i < codes.length; i++)
            codes[i] = Integer.parseInt(values[i]);
        while (k < codes.length)
        {
            num = codes[k];
            opcode = codes[k] % 100;
            num /= 100;
            modesList = "";
            if (num > 0)
                modesList += num;
            if (opcode != 99)
            {
                if (opcode == 1 || opcode == 2)
                {
                    pos[0] = codes[k+1];
                    pos[1] = codes[k+2];
                    pos[2] = codes[k+3];
                    for (int i = 0; i < modesList.length(); i++)
                    {
                        if (modesList.charAt(modesList.length() - i - 1) == '1')
                            val[i] = pos[i];
                        else
                            val[i] = codes[pos[i]];
                    }
                    for (int j = modesList.length(); j < 3; j++)
                        val[j] = codes[pos[j]];
                    if (opcode == 1)
                        val[2] = val[0] + val[1]; 
                    else if (opcode == 2)
                        val[2] = val[0] * val[1];
                    codes[pos[2]] = val[2];
                    k += 4;
                }
                else if (opcode == 3 || opcode == 4)
                {
                    pos[0] = codes[k+1];
                    for (int i = 0; i < modesList.length(); i++)
                    {
                        if (modesList.charAt(modesList.length() - i - 1) == '1')
                            val[i] = pos[i];
                        else
                            val[i] = codes[pos[i]];
                    }
                    for (int j = modesList.length(); j < 1; j++)
                        val[j] = codes[pos[j]];
                    if (opcode == 3)
                        codes[pos[0]] = s.nextInt();
                    else if (opcode == 4)
                        System.out.println(val[0]);
                    k += 2;
                }
            }
            else
                break;
        }
        for (int i = 0; i < codes.length; i++)
            System.out.print(codes[i] + ",");
    }
}