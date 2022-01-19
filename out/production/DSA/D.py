s = "**|**|***|"
queries = [[2,5],[5,9]]
ls = []
pre0 = queries[0][0]
post0 = queries[0][1]
pre1 = queries[1][0]
post1 = queries[1][1]
ls_pre = []
ls_post = []
precount = 0
postcount = 0
count1 = 0
count2 = 0
for i, val in enumerate(s[queries[0][0]: queries[0][1]]):
    if val == "|":
        precount+=1
        ls_pre.append(-1)
    else:
        ls_pre.append(precount)
    
for i, val in enumerate(reversed(s[queries[0][0]: queries[0][1]])):
    if val == "|":
        postcount+=1
        ls_post.append(-1)
    else:
        ls_post.append(postcount)
ls_post = list(reversed(ls_post))
ls_pre1 = []
ls_post1 = []
precount1 = 0
postcount1 = 0
for i, val in enumerate(s[queries[1][0]: queries[1][1]]):
    if val == "|":
        precount1+=1
        ls_pre1.append(-1)
    else:
        ls_pre1.append(precount1)
    
for i, val in enumerate(reversed(s[queries[1][0]: queries[1][1]])):
    if val == "|":
        postcount1+=1
        ls_post1.append(-1)
    else:
        ls_post1.append(postcount1)
print(ls_pre, ls_post)
ls_post1 = list(reversed(ls_post1))
for i in range(len(ls_pre)):
    if (ls_pre[i] > 0 and ls_post[i]>0):
        count1+=1
for i in range(len(ls_pre1)):
    if (ls_pre1[i] > 0 and ls_post1[i]>0):
        count2+=1
print(count1, count2)