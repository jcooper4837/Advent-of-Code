import re

def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = re.split(r'(-?\d+)',entry)
    for i in range(len(entry)):
        entry[i] = ''.join([x for x in entry[i] if x in '1234567890-'])
    entry = [x for x in entry if x]
    entry = [int(str) for str in entry]
    f.close()
    return entry

def main():
    n = parseFile("in2.txt")
    print(int(abs(n[2]*(abs(n[2])-1)/2)))
    
main()
