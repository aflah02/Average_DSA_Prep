from turtle import position


def next(arr, target, scale):
    start = 0
    end = len(arr) - 1
    # Minimum size of the array should be 1
    if (end == 0):
        return -1
    '''
    If target lies beyond the max element, than the index of strictly smaller
    value than target should be (end - 1)
    '''
    if (target > arr[end]*scale):
        return end
   
    ans = -1
    while (start <= end):
        mid = (start + end) // 2
   
        # Move to the left side if target is
        # smaller
        if (arr[mid]*scale >= target):
            end = mid - 1
   
        # Move right side
        else:
            ans = mid
            start = mid + 1
 
    return ans
spells = [15,8,19]
potions = [38,36,23]
potions.sort()
target = 328
ls = []
l = len(potions)
for i in spells:
    nindex = next(potions, target, i)
    print(potions, target, i)
    print(nindex)
    if nindex == -1:
        ls.append(l)
    else:
        ls.append(l-nindex-1)
print(ls)