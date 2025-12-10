# LC-hot100-1. 两数之和



## 分析





## 代码

### C++

```c++
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int>h;
		vector<int>ret;
		for(int i=0;i<nums.size();i++){
			if(h.count(target-nums[i])){
				ret.push_back(h[target-nums[i]]);
				ret.push_back(i);
				return ret;
			}
			h[nums[i]]=i;
		}
		return ret;
    }
};
```

#### 优化

+ 判断 hash table 中是否存在对应的 key 可用 find 方法：

```c++
if(h.find(target-nums[i])!=h.end())
```

相比 h.count 更快一些，find 返回一个迭代器，如果是 end，则未查询到。

+ 返回一个 vector，可以用大括号构造：

```c++
return {h[target-nums[i]],i};
```

#### 优化后

```c++
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
```

### python

```python
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
    s=Solution()
    print(s.twoSum(nums_in,target_in))

```

#### 优化

+ 可以使用匿名临时实例调用该方法

```python
print(Solution().twoSum(nums_in,target_in))
```

#### 优化后



### java

```java
import java.lang.Integer;
import java.util.HashMap;
import java.util.Map;
public class lcHot100_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(h.containsKey(target-nums[i])) return new int[]{h.get(target-nums[i]),i};
            h.put(nums[i],i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums_in={2,7,11,15};
        int target=9;
        lcHot100_1 l=new lcHot100_1();
        int[] out=l.twoSum(nums_in, target);
        for(int i=0;i<out.length;i++) System.out.print(Integer.toString(out[i])+' ');
    }
    
}

```

