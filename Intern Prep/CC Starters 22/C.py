import math
for i in range(int(input())):
    x = int(input())
    if (x % 2 == 1):
        print(0)
        continue
    t = x
    while (t % 2 == 0):
        t = t/2
    factor = t
    k = math.log(x/t,2)
    print(int(k))