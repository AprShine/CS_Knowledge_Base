#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int>h;
		for(int i=0;i<nums.size();i++){
			if(h.find(target-nums[i])!=h.end()){
				return {h[target-nums[i]],i};
			}
			h[nums[i]]=i;
		}
		return {};
    }
};

int main(){
	vector<int> num_in={2,7,11,15};
	int target=9;
	vector<int> o=Solution().twoSum(num_in,target);
	for(int i=0;i<o.size();i++) cout<<o[i]<<' ';
}