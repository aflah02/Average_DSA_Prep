for i in range(int(input())):
    n,m,r,c = map(int, input().split())
    r = r-1
    c = c-1
    ls = []
    countblack = 0
    bool = False
    for i in range(n):
        ls.append(input())
        if (i == r):
            if 'B' in ls[i]:
                bool = True
        if (ls[i][c] == 'B'):
            bool = True
        if countblack == 0 and 'B' in ls[i]:
            countblack+=1
    print(ls)
    if (ls[r][c] == 'B'):
        print(0)
    elif countblack == 0:
        print(-1)
    elif not bool:
        print(2)
    else:
        print(1)