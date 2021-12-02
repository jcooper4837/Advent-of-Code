def parseFile(name):
    try:
        f = open(name)
    except FileNotFoundError:
        print("\nfile not found.")
        return -1
    matrix = []
    entry = f.readline()
    data = entry.split(" ")
    data[1] = eval(data[1][:len(data[1])-1])
    #print(data)
    while True:
        matrix.append(data)
        entry = f.readline()
        data = entry.split(" ")
        if len(data) == 1:
            break
        data[1] = eval(data[1][:len(data[1])-1])
    #print(matrix)
    f.close()
    return matrix

def main():
    n = parseFile("in2.txt")
    x,y,a = 0,0,0
    for i in range(len(n)):
        if n[i][0] == "forward":
            y += n[i][1]*a
            x += n[i][1]
        elif n[i][0] == "up":
            a -= n[i][1]
        elif n[i][0] == "down":
            a += n[i][1]
        #print(x,y,a)
    print(x,y)
    print(x*y)

main()
