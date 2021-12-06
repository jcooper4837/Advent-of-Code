def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = entry.split(",")
    entry = [int(i) for i in entry]
    f.close()
    return entry

def main():
    n = parseFile("in2.txt")
    b = []
    for i in range(9):
        b.append(n.count(i))
    days = 256
    for i in range(days):
        t = b[0]
        for j in range(8):
            b[j] = b[j+1]
        b[6] += t
        b[8] = t
    print(sum(b))
    
main()
