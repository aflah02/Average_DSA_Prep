for i in range(int(input())):
    n,x = map(int, input().split())
    s = input()
    # print(s)
    for i in range(len(s)):
        # print(i)
        if s[i] == '1':
            temp = s[0:i] + '0' + s[i+1:]
            print(temp)