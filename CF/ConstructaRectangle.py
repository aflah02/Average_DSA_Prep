for i in range(int(input())):
    a,b,c = map(int, input().split())
    if ((a+b+c)%2==0):
        print("YES")
        continue
    print("NO")