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

def main():
    n = parseFile("in2.txt")
    poly = n[0]
    rules = n[1:]
    steps = 10
    for i in range(steps):
        ch = 1
        while ch < len(poly):
            pair = poly[ch-1:ch+1]
            for j in range(len(rules)):
                if pair == rules[j][0]:
                    poly = poly[:ch]+rules[j][1]+poly[ch:]
            ch += 2
    o = Counter(poly)
    uni = len(Counter(poly).keys())
    most = o.most_common()[0][1]
    least = o.most_common()[uni-1][1]
    print(most-least)
    
main()
