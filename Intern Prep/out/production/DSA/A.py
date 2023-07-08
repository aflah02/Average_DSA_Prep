counting = True
count = 0
s = "yo|uar|e**|b|e***au|tifu|l"
for i in s:
    if i == '*' and counting:
        count += 1
    elif i == '|':
        counting  = not counting
print(count)

        