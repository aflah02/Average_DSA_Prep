for i in range(int(input())):
    n = int(input())
    s = input()
    if n % 2 == 1:
        print('NO')
        continue
    x = list(s)
    x.sort()
    c = 0
    t = x[0]
    ls = []
    for i in range(len(x)):
        if i==t:
            pass
        else:
            ls.append(c)
            c = 0
            t = x[i]
        c+=1
    ls.append(c)
    check = False
    for i in ls:
        if i > n//2:
            check = True
            print("NO")
            break
    if not check:
        print("YES")
        res = x[:int(n/2)] + list(reversed(x[int(n/2):]))
        print(''.join(res))