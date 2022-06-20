nums = [1,1,1] 
k = 5
subArraySums = [nums[0]]
for i in range(1,len(nums)):
    subArraySums.append(subArraySums[i-1]+nums[i])
print(subArraySums)
# Compute Subarrays whose sum * length is less than K
count = 0
for i in range(len(subArraySums)):
    for j in range(i+1,len(subArraySums)):
        print(j-i)
        calc = (subArraySums[j] - subArraySums[i] + nums[i]) * (j-i+1)
        if calc < k and calc > 0:
            count += 1
print(count)
