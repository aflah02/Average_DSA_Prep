import itertools
from bisect import bisect_left


def LISSolver(input_list):
    if len(input_list) == 0: 
        return 0
    end = [0 for i in range(len(input_list) + 1)]
    length = 1 
    end[0] = input_list[0]
    for i in range(1, len(input_list)):
        if input_list[i] > end[length-1]:
            end[length] = input_list[i]
            length += 1
        else:
            end[bisect_left(end, input_list[i], 0, length-1)] = input_list[i]

    return length

def lengthOfLIS(nums):
    a=[]
    for x in nums:

        n=bisect_left(a,x)#n is index value in list
        if n==len(a):#if index value is last then
            a.append(x)
        else:
            a[n]=x
    return len(a) 
def getPermutations(lst):
    if len(lst) == 0:
        return []
    if len(lst) == 1:
        return [lst]
    l = []
    for i in range(len(lst)):
       m = lst[i]
       remainingList = lst[:i] + lst[i+1:]
       for p in getPermutations(remainingList):
           l.append([m] + p)
    return l
    
for i in range(int(input())):
    x = int(input())
    ls = []
    while (x > 0):
        ls.append(x)
        x-=1
    ls2 = getPermutations(ls)
    k = False
    maxsofar = 0
    maxind = 0
    for i in range(len(ls2)):
        t = lengthOfLIS(ls2[i])
        u = lengthOfLIS(ls2[i][::-1])
        if t == u:
            if t > maxsofar:
                maxsofar = t
                maxind = i
                k = True 
    if (k):
        print('YES')
        print(*ls2[maxind], sep = " ")
        continue
    print('NO')
    
    
