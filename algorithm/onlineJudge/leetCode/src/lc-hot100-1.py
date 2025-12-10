class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        h=dict()
        for i,num in enumerate(nums):
            if target-num in h:
                return [h[target-num],i]
            h[num]=i

if __name__=="__main__":
    nums_in=[2,7,11,15]
    target_in=9
    print(Solution().twoSum(nums_in,target_in))
