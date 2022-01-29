for i in range(int(input())):
    N ,K = map(int, input().split())
    if (N==1):
        if (K==1):
            print(1)
            continue
        else:
            print(-1)
            continue
    if (N > 1 and K > 1):
        print(-1)
        continue
    ls = [i for i in range(1,K)]
    ls.extend([i for i in range(N, K-1, -1)])
    print(*ls, sep = " ")
