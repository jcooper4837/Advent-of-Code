def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    entry = entry[:len(entry)-1]
    data = list(entry)
    for i in range(len(data)):
        data[i] = eval(data[i])
    #print(data)
    while True:
        matrix.append(data)
        entry = f.readline()
        if entry == "-1":
            break
        entry = entry[:len(entry)-1]
        data = list(entry)
        for i in range(len(data)):
            data[i] = eval(data[i])
    #print(matrix)
    f.close()
    return matrix

def main():
    n = parseFile("in2.txt")
    gam,eps = [],[]
    for i in range(len(n[0])):
        a,b = 0,0
        for j in range(len(n)):
            if n[j][i] == 0:
                a += 1
            elif n[j][i] == 1:
                b += 1
        if a > b:
            gam.append(0)
            eps.append(1)
        else:
            gam.append(1)
            eps.append(0)
    gam2 = "".join([str(int) for int in gam])
    eps2 = "".join([str(int) for int in eps])
    print(gam2,eps2)
    x = int(gam2,2)
    y = int(eps2,2)
    print(x,y)
    print(x*y)
main()
