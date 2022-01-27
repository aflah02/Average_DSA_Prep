def helper(first,second,debug):
    if (debug == 0):
        print("Here")
    for i in range(20):
        if second & (1<<i):
            first ^= (1<<i)
    return first
for t in range(int(input())):
    n = int(input())
    ans = []
    first = 0
    count = 1
    hashset = set()
    hashset.add(0)
    k = False
    for i in range(n):
        while helper(first,count,1) in hashset:
            count+=1
        k = True
        first = helper(first,count,1)
        ans.append(count)
        hashset.add(first)
        count+=1
    if (k):
        print(*ans, sep = " ")