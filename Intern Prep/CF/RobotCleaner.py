for i in range(int(input())):
    n, m, rb, cb, rd, cd = map(int, input().split())
    dr = 1
    dc = 1
    k = 0
    if (rb == rd or cb == cd):
        print(0)
    if (rb > rd and cb > cd):
        print(min(n-rb+n-rd,m-cb+m-cd))
    elif (rb > rd and cb < cd):
        print(min(n-rb+n-rd, cd-cb))
    elif (rb < rd and cb > cd):
        print(min(rd-rb, m-cb+m-cd))
    else:
        print(min(rd-rb, cd-cb))
        