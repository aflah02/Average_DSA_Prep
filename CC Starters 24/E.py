import string
import sys
def isSubsequence(s, t):
	l = len(s)
	place = 0
	for x in t:
		if place < l and x == s[place]:
			place += 1
	return l <= place
for i in range(int(input())):
    n = int(input())
    s = input()
    m = int(input())
    if (m > 26):
        x = string.ascii_lowercase*int(m/26)+string.ascii_lowercase[0:m%26]
    else:
        x = string.ascii_lowercase[0:m]
    if (m > n):
        print(-1)
        continue
    indexes = [x for x, v in enumerate(s) if v == 'a']
    if not indexes:
        print(-1)
        continue
    # indexes = [x for x, v in enumerate(s) if v == 'a']
    minsofar = maxSize = sys.maxsize
    if (len(indexes)==1):
        print('here')
        if (isSubsequence(x, s)):
            print('her2')
            print(m-indexes[i+1]+indexes[i]+1)
            continue
    else:
        for i in range(len(indexes)-1):
            if (isSubsequence(s[indexes[i]:indexes[i+1]], x)):
                minf = m-indexes[i+1]+indexes[i]+1
                print('minf', minf)
                if minf < minsofar and minf > 0:
                    minsofar = minf
    print(minsofar)