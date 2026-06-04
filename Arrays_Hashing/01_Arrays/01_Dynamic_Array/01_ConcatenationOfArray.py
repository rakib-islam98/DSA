def getConcatenation(nums,k):
        #Solution: k Pass
        ans=[]
        for i in range(k):
            for num in nums:
                ans.append(num)
        
        # Solution: 1 Pass
        # n=len(nums)
        # ans=[0]*(2*n)

        # for i,num in enumerate(nums):
        #     ans[i]=ans[i+n]=num

        return ans

if __name__=="__main__":
      arr=[4,5,6]
      new_arr=getConcatenation(arr,3)
      print(new_arr)