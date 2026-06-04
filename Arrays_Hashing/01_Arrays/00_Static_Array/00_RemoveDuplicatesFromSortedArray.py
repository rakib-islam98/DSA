def remove_duplicates(nums):
    n=len(nums)
    if(n<=1): return n

    #Solution 1: Using HashSet
    # seen=set()
    # idx=0
    # for i in range(len(nums)):
    #     if nums[i] not in seen:
    #         nums[idx]=nums[i]
    #         idx+=1
    #         seen.add(nums[i])
    # return idx

    #Solution 2: Using Pointer
    idx=0
    for i in range(1,len(nums)):
        if nums[i]!=nums[i-1]:
            nums[idx+1]=nums[i]
            idx+=1
    return idx+1


if __name__=='__main__':
    arr=[1,2,2,3,4,5,5,5,6,7]
    print(arr)
    new_size=remove_duplicates(arr)
    for i in range(new_size):
        print(arr[i],end=", ")