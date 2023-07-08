for i in range(int(input())):
    n = int(input())
    print(0, n, int('1' + str(bin(n))[2:],2))
    # x = n-1
    # if (x % 2 == 1):
    #     print(0, n, int('1' + str(bin(n))[2:],2))
    # else:
    #     print(0, n, int('1' + str(bin(n))[2:],2))