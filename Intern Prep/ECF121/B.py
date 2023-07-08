for i in range(int(input())):
    s = input()
    maxsofar = 0
    maxloc = 0
    for i in range(len(s)-1):
        if (int(s[i])+int(s[i+1])>=maxsofar):
            maxsofar = int(s[i])+int(s[i+1])
            maxloc = i
    if (maxsofar > 9):
        s = s[:maxloc] + str(maxsofar) + s[maxloc+2:]
    else:
        s = s[:maxloc] + str(maxsofar) + s[maxloc+2:]
    if (s.count('0') == len(s)):
        print(0)
    else:
        print(s.lstrip('0'))