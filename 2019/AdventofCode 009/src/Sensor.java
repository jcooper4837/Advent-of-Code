import java.math.*;
import java.util.*;

public class Sensor
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String values[] = input.split(",");
        BigInteger codes[] = new BigInteger[10000], pos[] = new BigInteger[3], val[] = new BigInteger[3];
        BigInteger num = new BigInteger("0");
        int opcode = 0, k = 0, relative = 0;
        String modesList;
        for (int i = 0; i < values.length; i++)
        {
            codes[i] = new BigInteger(values[i]);
        }
        for (int i = values.length; i < codes.length; i++)
        {
            codes[i] = new BigInteger("0");
        }
        while (k < codes.length)
        {
            num = codes[k];
            opcode = codes[k].mod(BigInteger.valueOf(100)).intValue();
            num = num.divide(BigInteger.valueOf(100));
            modesList = "";
            if (num.compareTo(BigInteger.valueOf(0)) > 0)
                modesList += num;
            System.out.println("opcode = " + opcode);
            System.out.println("modesList = " + modesList);
            System.out.println("k = " + k);
            if (opcode != 99)
            {
                if (opcode == 1 || opcode == 2)
                {
                    pos[0] = codes[k+1];
                    pos[1] = codes[k+2];
                    pos[2] = codes[k+3];
                    /*System.out.println("pos[0] = " + pos[0]);
                    System.out.println("pos[1] = " + pos[1]);
                    System.out.println("pos[2] = " + pos[2]);*/
                    for (int i = 0; i < modesList.length(); i++)
                    {
                        if (modesList.charAt(modesList.length() - i - 1) == '1')
                            val[i] = pos[i];
                        else
                        {
                            if (modesList.charAt(modesList.length() - i - 1) == '2')
                                val[i] = codes[pos[i].intValue() + relative];
                            else
                                val[i] = codes[pos[i].intValue()];
                        }
                    }
                    for (int j = modesList.length(); j < 3; j++)
                        val[j] = codes[pos[j].intValue()];
                    /*System.out.println("val[0] = " + val[0]);
                    System.out.println("val[1] = " + val[1]);
                    System.out.println("val[2] = " + val[2]);*/
                    if (opcode == 1)
                        val[2] = val[0].add(val[1]); 
                    else if (opcode == 2)
                        val[2] = val[0].multiply(val[1]);
                    if (modesList.length() == 3 && modesList.charAt(0) == '2')
                        codes[pos[2].intValue() + relative] = val[2];
                    else
                        codes[pos[2].intValue()] = val[2];
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
                        {
                            if (modesList.charAt(modesList.length() - i - 1) == '2')
                                val[i] = codes[pos[i].intValue() + relative];
                            else
                                val[i] = codes[pos[i].intValue()];
                        }
                    }
                    for (int j = modesList.length(); j < 1; j++)
                        val[j] = codes[pos[j].intValue()];
                    if (opcode == 3)
                    {
                        if (modesList.length() == 1 && modesList.charAt(0) == '2')
                            codes[val[0].intValue() + relative] = new BigInteger(s.next());
                        else
                            codes[val[0].intValue()] = new BigInteger(s.next());
                    }
                    else if (opcode == 4)
                        System.out.println(val[0]);
                    k += 2;
                }
                else if (opcode == 5 || opcode == 6)
                {
                    pos[0] = codes[k+1];
                    pos[1] = codes[k+2];
                    /*System.out.println("pos[0] = " + pos[0]);
                    System.out.println("pos[1] = " + pos[1]);*/
                    for (int i = 0; i < modesList.length(); i++)
                    {
                        if (modesList.charAt(modesList.length() - i - 1) == '1')
                            val[i] = pos[i];
                        else
                        {
                            if (modesList.charAt(modesList.length() - i - 1) == '2')
                                val[i] = codes[pos[i].intValue() + relative];
                            else
                                val[i] = codes[pos[i].intValue()];
                        }
                    }
                    /*
                    System.out.println("val[0] = " + val[0]);
                    System.out.println("val[1] = " + val[1]);*/
                    for (int j = modesList.length(); j < 2; j++)
                        val[j] = codes[pos[j].intValue()];
                    if (opcode == 5)
                    {
                        if (!val[0].equals(BigInteger.ZERO))
                            k = val[1].intValue();
                        else
                            k += 3;
                    }
                    else if (opcode == 6)
                    {
                        if (val[0].equals(BigInteger.ZERO))
                            k = val[1].intValue();
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
                        {
                            if (modesList.charAt(modesList.length() - i - 1) == '2')
                                val[i] = codes[pos[i].intValue() + relative];
                            else
                                val[i] = codes[pos[i].intValue()];
                        }
                    }
                    for (int j = modesList.length(); j < 3; j++)
                        val[j] = codes[pos[j].intValue()];
                    if (opcode == 7)
                    {
                        if (val[0].compareTo(val[1]) < 0)
                            val[2] = BigInteger.ONE;
                        else
                            val[2] = BigInteger.ZERO;
                    }
                    else if (opcode == 8)
                    {
                        if (val[0].equals(val[1]))
                            val[2] = BigInteger.ONE;
                        else
                            val[2] = BigInteger.ZERO;
                    }
                    if (modesList.length() == 3 && modesList.charAt(0) == '2')
                        codes[pos[2].intValue() + relative] = val[2];
                    else
                        codes[pos[2].intValue()] = val[2];
                    k += 4;
                }
                else if (opcode == 9)
                {
                    pos[0] = codes[k+1];
                    for (int i = 0; i < modesList.length(); i++)
                    {
                        if (modesList.charAt(modesList.length() - i - 1) == '1')
                            val[i] = pos[i];
                        else
                        {
                            if (modesList.charAt(modesList.length() - i - 1) == '2')
                                val[i] = codes[pos[i].intValue() + relative];
                            else
                                val[i] = codes[pos[i].intValue()];
                        }
                    }
                    for (int j = modesList.length(); j < 1; j++)
                        val[j] = codes[pos[j].intValue()];
                    if (modesList.length() == 1 && modesList.charAt(0) == '2')
                        relative += val[0].intValue() + relative;
                    else
                        relative += val[0].intValue();
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