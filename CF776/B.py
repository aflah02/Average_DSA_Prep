for i in range(int(input())):
    n, m = map(int, input().split())
    if (n % 2 == 1 and m % 2 == 1):
        print(n-1)
    for i in range(4):
        print(n-1+m-1-3)
    for i in range(8):
        print(n-1+m-1-2)
    for i in range(8):
        print(n-1+m-1-1)
    for i in range(4):
        print(n-1+m-1)
