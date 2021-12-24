import re

def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    for i in range(2):
        entry = f.readline()
        entry = re.split(r'(-?\d+)',entry)
        entry = ''.join([x for x in entry if x in '1234567890-'])
        entry = [x for x in entry if x]
        entry = [int(str) for str in entry]
        matrix.append(entry[1])
    f.close()
    return matrix

def main():
    n = parseFile("in2.txt")
    s = [0,0]
    d = 1
    it = 0
    while True:
        n[it] = ((n[it]+(d+(d+1)+(d+2))-1)%10)+1
        s[it] += n[it]
        if s[it] >= 1000:
            it = (it+1)%2
            d += 2
            break
        it = (it+1)%2
        d += 3
    print(d*s[it])
    
main()
