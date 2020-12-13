import java.util.*;

public class P13
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
            //System.out.println(str);
        }
        Collections.sort(arr);
        int min = 0, diff = 9999999;
        for (int i = 0; i < arr.size(); i++)
        {
            //System.out.println(arr.get(i) - port % arr.get(i));
            if (arr.get(i) - port % arr.get(i) < diff)
            {
                min = arr.get(i);
                diff = arr.get(i) - port % arr.get(i);
            }
        }
        //System.out.println(arr);
        //System.out.println(min + " " + diff);
        System.out.println(min * diff);
    }
}

/*
939
7,13,x,x,59,x,31,19,0

1000390
23,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,383,x,x,x,x,x,x,x,x,x,x,x,x,13,17,x,x,x,x,19,x,x,x,x,x,x,x,x,x,29,x,503,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,37,0
*/