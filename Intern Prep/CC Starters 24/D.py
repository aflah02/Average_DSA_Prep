for i in range(int(input())):
    x,a,b = map(int, input().split())
    if (x > a and a == b == 1) or (int(x*b/a)!=x*b/a) or (x%a)!=0:
        print(-1)
    else:
        print(int(x*b/a))