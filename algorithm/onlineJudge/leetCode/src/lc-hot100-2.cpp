#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>>ret={{}};
        for(int i=0;i<nums.size();i++){
            int len=ret.size();
            for(int j=0;j<len;j++){
                ret.push_back(ret[j]);
                ret.back().push_back(nums[i]);
            }
        }
        return ret;
    }
};

int main(){
    vector<int>nums_in={1,2,3};
    vector<vector<int>>out=Solution().subsets(nums_in);
    for(int i=0;i<out.size();i++){
        for(int j=0;j<out[i].size();j++){
            cout<<out[i][j]<<' ';
        }
        cout<<endl;
    }
    return 0;
}