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
    for i in range(max(n)):
        total = 0
        for j in range(len(n)):
            inc = abs(n[j]-i)
            total += int(inc*(inc+1)/2)
        b.append(total)
    print(min(b))
    
main()
