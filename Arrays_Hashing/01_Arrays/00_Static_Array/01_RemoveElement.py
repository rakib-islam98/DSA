def removeElement(nums,val):
    # temp=[]
    # for i in range(len(nums)):
    #     if nums[i]!=val:
    #         temp.append(nums[i])
    # idx=0
    # for i in range(len(temp)):
    #     nums[idx]=temp[i]
    #     idx+=1
    # return idx

    idx=0
    for i in range(len(nums)):
        if nums[i]!=val:
            if(nums[idx]==val):
                nums[idx]=nums[i]
            idx+=1
    return idx

if __name__=="__main__":
    arr=[1,2,5,2,6,3,2,5]
    val=2

    print(arr)
    newSize=removeElement(arr,val)

    for i in range(newSize):
        print(arr[i],end=" ")