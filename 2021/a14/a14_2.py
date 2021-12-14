from collections import Counter

def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = entry[:len(entry)-1]
    matrix.append(entry)
    entry = f.readline()
    entry = f.readline()
    entry = entry[:len(entry)-1]
    entry = entry.split(" -> ")
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        entry = entry.split(" -> ")
    f.close()
    return matrix

def printBoard(b):
    for i in range(len(b)):
        print(b[i])

def main():
    n = parseFile("in2.txt")
    poly = n[0]
    rules = n[1:]
    rules.sort()
    steps = 40
    last = poly[len(poly)-1]
    for i in range(len(rules)):
        for j in range(3):
            rules[i].append(0)
    for i in range(len(rules)):
        p0 = rules[i][0]
        p1 = rules[i][0][0]+rules[i][1]
        p2 = rules[i][1]+rules[i][0][1]
        for j in range(len(rules)):
            if p1 == rules[j][0]:
                rules[i][2] = j
            elif p2 == rules[j][0]:
                rules[i][3] = j
    for i in range(1,len(poly)):
        pair = poly[i-1:i+1]
        for j in range(len(rules)):
            if pair == rules[j][0]:
                rules[j][4] += 1
                break
    inc = []
    for i in range(len(rules)):
        inc.append(0)
    for i in range(steps):
        for j in range(len(rules)):
            inc[j] = rules[j][4]
        for j in range(len(rules)):
            rules[j][4] -= inc[j]
            p1 = rules[j][2]
            p2 = rules[j][3]
            rules[p1][4] += inc[j]
            rules[p2][4] += inc[j]
        if i == steps-1:
            letters,cnt = [],[]
            slot = -1
            for j in range(len(rules)):
                if rules[j][0][0] not in letters:
                    letters.append(rules[j][0][0])
                    if rules[j][0][0] != last:
                        cnt.append(0)
                    else:
                        cnt.append(1)
                    slot += 1
                cnt[slot] += rules[j][4]
    print(max(cnt)-min(cnt))
    
main()
