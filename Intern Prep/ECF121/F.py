n, a0, x, y, k, m = map(int, input().split())
ls = [a0]
t = a0
for i in range(1, n):
    ls.append((ls[i-1]*x+y)%m)
    t += ls[i]
print((t % m)%998244353)


    
