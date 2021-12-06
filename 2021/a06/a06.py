import re

def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = re.split(r'\D+',entry)
    entry = [int(i) for i in entry]
    f.close()
    return entry

def main():
    n = parseFile("in2.txt")
    days = 80
    for i in range(days):
        new = 0
        for j in range(len(n)):
            if n[j] != 0:
                n[j] -= 1
            else:
                n[j] = 6
                new += 1
            j += 1
        for j in range(new):
            n.append(8)
    print(len(n))
    
main()
