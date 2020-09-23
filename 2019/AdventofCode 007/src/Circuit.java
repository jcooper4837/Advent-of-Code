import java.util.*;

public class Circuit
{
    static int count = 0;
    static String[] cases = new String[120];
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String values[] = input.split(",");
        int memory[] = new int[values.length], pos[] = new int[3], val[] = new int[3];
        int opcode, k = 0, num;
        String modesList;
        for (int i = 0; i < memory.length; i++)
            memory[i] = Integer.parseInt(values[i]);
        int codes[] = new int[memory.length], amp[] = new int[5], thrust[] = new int[5];
        int in = 0, max = 0, a;
        boolean newval = true;
        for (int i = 0; i < amp.length; i++)
            amp[i] = i;
            //amp[i] = s.nextInt();
        perms("01234", "");
        for (int c = 0; c < 1; c++)
        {
            amp[0] = Integer.parseInt(cases[c].substring(0, 1));
            amp[1] = Integer.parseInt(cases[c].substring(1, 2));
            amp[2] = Integer.parseInt(cases[c].substring(2, 3));
            amp[3] = Integer.parseInt(cases[c].substring(3, 4));
            amp[4] = Integer.parseInt(cases[c].substring(4));
            amp[0] = 3;
            amp[1] = 1;
            amp[2] = 4;
            amp[3] = 2;
            amp[4] = 0;
            a = 0;
            while (a < 5)
            {
                for (int i = 0; i < memory.length; i++)
                    codes[i] = memory[i];
                k = 0;
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
                            {
                                if (newval)
                                {
                                    System.out.println("apple");
                                    codes[pos[0]] = amp[a];
                                    newval = false;
                                }
                                else
                                {
                                    System.out.println("banana");
                                    codes[pos[0]] = in;
                                    newval = true;
                                }
                            }
                            else if (opcode == 4)
                            {
                                System.out.println("output called");
                                System.out.println(val[0]);
                                //System.out.println("k = " + k);
                                //System.out.println("length = " + codes.length);
                                in = val[0];
                                a++;
                            }
                            k += 2;
                        }
                        else if (opcode == 5 || opcode == 6)
                        {
                            pos[0] = codes[k+1];
                            pos[1] = codes[k+2];
                            for (int i = 0; i < modesList.length(); i++)
                            {
                                if (modesList.charAt(modesList.length() - i - 1) == '1')
                                    val[i] = pos[i];
                                else
                                    val[i] = codes[pos[i]];
                            }
                            for (int j = modesList.length(); j < 2; j++)
                                val[j] = codes[pos[j]];
                            if (opcode == 5)
                            {
                                if (val[0] != 0)
                                    k = val[1];
                                else
                                    k += 3;
                            }
                            else if (opcode == 6)
                            {
                                if (val[0] == 0)
                                    k = val[1];
                                else
                                    k += 3;
                            }
                        }
                        else if (opcode == 7 || opcode == 8)
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
                            if (opcode == 7)
                            {
                                if (val[0] < val[1])
                                    val[2] = 1;
                                else
                                    val[2] = 0;
                                codes[pos[2]] = val[2];
                            }
                            else if (opcode == 8)
                            {
                                if (val[0] == val[1])
                                    val[2] = 1;
                                else
                                    val[2] = 0;
                                codes[pos[2]] = val[2];
                            }
                            k += 4;
                        }
                    }
                    else
                    {
                        System.out.println("a = " + a);
                        //System.out.println("hit opcode 99!");
                        //System.out.println("k = " + k);
                        //System.out.println("length = " + codes.length);
                        break;
                    }
                }
            }
            //System.out.println("in = " + in);
            if (in > max)
            {
                //System.out.println("new max! old max = " + max + ", new max = " + in);
                max = in;
                for (int i = 0; i < 5; i++)
                {
                    thrust[i] = amp[i];
                }
            }
            in = 0;
            //System.out.println(max);
        }
        //for (int i = 0; i < codes.length; i++)
            //System.out.print(codes[i] + ",");
        System.out.println(max);
        for (int i = 0; i < 5; i++)
        {
            System.out.print(thrust[i] + ",");
        }
    }
    public static void perms(String str, String ans)
    {
        if (str.length() == 0)
        { 
            //System.out.print(ans + " ");
            cases[count] = ans;
            count++;
            return; 
        } 
  
        for (int i = 0; i < str.length(); i++)
        { 
            char ch = str.charAt(i); 
            String ros = str.substring(0, i) + str.substring(i + 1); 
            perms(ros, ans + ch); 
        }
    }
}