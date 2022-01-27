for i in range(int(input())):
    n,k,x = map(int, input().split())
    if (x > k):
        print(-1)
        continue
    remaining = n % x
    base_copies = n//x
    # print('REM', remaining)
    # print('B', base_copies)
    ls_base = [i for i in range(x)]
    ls_base = ls_base * base_copies
    ls_base += ls_base[:remaining]
    print(*ls_base, sep = " ")
