n = int(input())
ls = []
while (n!=1):
    ls.append(int(n))
    if (n%2==0):
        n = n/2
    else:
        n = 3*n+1
ls.append(1)
print(*ls)