import java.util.*;

public class P13_2
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String str = "";
        ArrayList<Integer> arr = new ArrayList();
        int port = s.nextInt();
        str = s.next();
        while (str.length() > 1)
        {
            String t = str.substring(0, str.indexOf(","));
            str = str.substring(str.indexOf(",")+1);
            if (!t.equals("x"))
            {
                arr.add(Integer.parseInt(t));
            }
            else
            {
                arr.add(0);
            }
            //System.out.println(str);
        }
        ArrayList<Integer> index = new ArrayList();
        index.add(0);
        int add = 0;
        for (int i = 1; i < arr.size(); i++)
        {
            if (arr.get(i) != 0)
            {
                add = i;
                while (add > arr.get(i))
                {
                    add -= arr.get(i);
                }
                index.add(add);
            }
        }
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i) == 0)
            {
                arr.remove(i);
                i--;
            }
        }
        System.out.println(arr);
        System.out.println(index);
        int min = 0, diff = 9999999, max = 0, in = 0, inc = 0, step = 0;
        boolean cont = true;
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr.get(i) != 0)
            {
                //System.out.print(arr.get(i) + ", ");
            }
            if (arr.get(i) > max)
            {
                max = arr.get(i);
                in = i;
            }
        }
        long it = 0, off = 1;
        System.out.println("");
        while (cont)
        {
            if (it < 0)
                System.out.println(it);
            if (arr.get(0) - it % arr.get(0) == arr.get(0))
            {
                if (inc == 0)
                {
                    off = arr.get(0);
                    inc++;
                }
                for (int i = 1; i < arr.size(); i++)
                {
                    if (arr.get(i) != 0 && arr.get(i) - it % arr.get(i) != index.get(i))
                    {
                        break;
                    }
                    if (i == arr.size() - 1)
                    {
                        cont = false;
                    }
                    if (inc <= i)
                    {
                        off *= arr.get(i);
                        inc++;
                        //System.out.println(off);
                    }
                }
            }
            it += off;
            step++;
        }
        it -= off;
        //System.out.println(step);
        System.out.println(it);
    }
}

/*
939
7,13,x,x,59,x,31,19,0

1000390
23,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,383,x,x,x,x,x,x,x,x,x,x,x,x,13,17,x,x,x,x,19,x,x,x,x,x,x,x,x,x,29,x,503,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,37,0
*/