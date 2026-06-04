class DynamicArray:
    
    def __init__(self, capacity: int):
        self.capacity=capacity  #Actual capacity of arr
        self.length=0   #utilzed or used capacity
        self.arr=[0]*self.capacity

    def get(self, i: int) -> int:
        return self.arr[i]

    def set(self, i: int, n: int) -> None:
        self.arr[i]=n

    def pushback(self, n: int) -> None:
        #Check if the capacity is full, if full then resize
        if self.length==self.capacity:
            self.resize()
        self.arr[self.length]=n
        self.length+=1

    def popback(self) -> int:
        val=self.arr[self.length-1]
        # soft delete
        self.length-=1
        return val

    def resize(self) -> None:
        self.capacity*=2
        new_arr=[0]*self.capacity

        for i in range(self.length):
            new_arr[i]=self.arr[i]
        self.arr=new_arr

    def getSize(self) -> int:
        return self.length
    
    def getCapacity(self) -> int:
        return self.capacity
    
    def __str__(self) -> str:
        return str(self.arr[:self.length])

if __name__=="__main__":
    da = DynamicArray(2)
    da.pushback(10)
    da.pushback(20)
    da.pushback(30)

    print(da)   # calls __str__ internally