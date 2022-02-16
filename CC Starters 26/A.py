from re import X


for i in range(int(input())):
    n,x,y = map(int, input().split())
    busppc = x/100
    carppc = y/100
    allbuscost = (n/100 + 1)*x
    allcarcost = (n/4 + 1)*y
    netcost = 0
    while (n > 100):
        netcost += x
        n-=100
    while (n > 4):
        netcost += y
        n-=4
    