import java.util.*;

public class P10_2
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList();
        int t = 0, it = 0, inc = 0, current = 1, max = 0;
        while (true)
        {
            t = s.nextInt();
            arr.add(t);
            if (t == 0)
            {
                break;
            }
        }
        long[] res = new long[arr.size()];
        Collections.sort(arr);
        max = arr.get(arr.size() - 1);
        current = arr.get(1);
        for (int i = 0; i < res.length; i++)
        {
            res[i] = 0;
        }
        res[0] = 1;
        if (current - arr.get(0) <= 3)
        {
            res[1] = res[0];
        }
        current = arr.get(2);
        if (current - arr.get(1) <= 3)
        {
            res[2] += res[1];
        }
        if (current - arr.get(0) <= 3)
        {
            res[2] += res[0];
        }
        for (int i = 3; i < arr.size(); i++)
        {
            current = arr.get(i);
            if (current - arr.get(i-1) <= 3)
            {
                res[i] += res[i-1];
            }
            if (current - arr.get(i-2) <= 3)
            {
                res[i] += res[i-2];
            }
            if (current - arr.get(i-3) <= 3)
            {
                res[i] += res[i-3];
            }
        }
        System.out.println(res[res.length - 1]);
    }
}

/*
16
10
15
5
1
11
7
19
6
12
4
0

28
33
18
42
31
14
46
20
48
47
24
23
49
45
19
38
39
11
1
32
25
35
8
17
7
9
4
2
34
10
3
0

46
63
21
115
125
35
89
17
116
90
51
66
111
142
148
60
2
50
82
20
47
24
80
101
103
16
34
72
145
141
124
14
123
27
62
61
95
138
29
7
149
147
104
152
22
81
11
96
97
30
41
98
59
45
88
37
10
114
110
4
56
122
139
117
108
91
36
146
131
109
31
75
70
140
38
121
3
28
118
54
107
84
15
76
71
102
130
132
87
55
129
83
23
42
69
1
77
135
128
94
0
*/