s = input()

def getSS(s):
    ans = []
    for i in range(2**len(s)):
        binary = str(bin(i))[2:]
        print(binary)
        x = ""
        if len(binary) < len(s):
            binary = '0'*(len(s)-len(binary)) + binary
        for i in range(len(binary)):
            if binary[i] == '1':
                x += s[i]
        ans.append(x)
    return ans
    #Write your code here
    
ans = getSS(s)

print("["+', '.join(ans) + "]")