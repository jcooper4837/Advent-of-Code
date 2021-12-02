def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = eval(f.readline())
    print(entry)
    while entry != -1:
        matrix.append(entry)
        entry = eval(f.readline())
    f.close()
    return matrix

def main():
    n = parseFile("in2.txt")
    total = 0
    for i in range(len(n)-1):
        if n[i+1] > n[i]:
            total += 1
    print(total)

main()
