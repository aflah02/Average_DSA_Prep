n = int(input())
ls = list(map(int, input().split()))
for i in range(1, n+1):
    if i not in ls:
        print(i)
        break