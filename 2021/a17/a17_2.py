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
    ans = []
    for i in range(n[1]+1):
        for j in range(n[2],(-n[2])+1):
            pt = [0,0]
            vi,vf = [i,j],[i,j]
            while True:
                pt[0] += vf[0]
                pt[1] += vf[1]
                if (pt[0] >= n[0] and pt[0] <= n[1] and
                    pt[1] >= n[2] and pt[1] <= n[3]):
                    ans.append(vi)
                    break
                if pt[1] < n[2]:
                    break
                if vf[0] > 0:
                    vf[0] -= 1
                vf[1] -= 1
    print(len(ans))
    
main()
