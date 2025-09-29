class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        rets=[[]]
        for num in nums:
            rets+=[ret+[num] for ret in rets]
        return rets

if __name__ == "__main__":
    nums=[1,2,3]
    print(Solution().subsets(nums))