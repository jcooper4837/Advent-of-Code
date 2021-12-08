def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = entry[:len(entry)-1]
    entry = entry.split(" ")
    entry.remove(entry[10])
    while True:
        matrix.append(entry)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        entry = entry.split(" ")
        entry.remove(entry[10])
    f.close()
    return matrix

def main():
    n = parseFile("in2.txt")
    total = 0
    for i in range(len(n)):
        for j in range(10,len(n[i])):
            if len(n[i][j]) <= 4 or len(n[i][j]) == 7:
                total += 1
    print(total)
    
main()
