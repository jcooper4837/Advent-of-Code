import java.util.*;

public class P10
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList();
        int t = 0, it = 0, inc = 1, current = 1, max = 0, one = 0, three = 0;
        while (true)
        {
            t = s.nextInt();
            if (t == 0)
            {
                break;
            }
            arr.add(t);
        }
        Collections.sort(arr);
        max = arr.get(arr.size() - 1);
        while (it < arr.size())
        {
            if (arr.get(it) != current)
            {
                inc += 2;
                current += 2;
            }
            if (inc == 1)
            {
                one++;
            }
            else if (inc == 3)
            {
                three++;
            }
            inc = 1;
            current++;
            it++;
        }
        three++;
        System.out.println(one + " " + three);
        System.out.println(one * three);
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