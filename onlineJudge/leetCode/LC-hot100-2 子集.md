# LC-hot100-2 子集



## 分析

思考求一个集合求全部子集的过程，发现其具有类似递归的性质，即可以缩减规模为一个子问题，每新增一个元素，可以在原来子集的基础上进行新增，因此想到迭代法的思路

## 代码



### C++

```c++
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>>ret={{}};
        for(int i=0;i<nums.size();i++){
            int len=ret.size();
            for(int j=0;j<len;j++){
                vector<int>temp=ret[j];
                temp.push_back(nums[i]);
                ret.push_back(temp);
            }
        }
        return ret;
    }
};
```

#### c++语法优化

+ 临时变量 temp 可以优化，先将对应的 vector 加入 ret，在使用 back() 函数在其后将 num[i] 引入：

```c++
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
```

### python

```python
class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        rets=[[]]
        for num in nums:
            rets_temp=rets[:]
            for ret in rets:
                new_ret=ret.copy()
                new_ret.append(num)
                rets_temp.append(new_ret)
            rets=rets_temp
        return rets
```

> **tips：**
>
> python 的赋值操作符默认是引用赋值，即所有的 pointer 全部指向同一个实例，这就会导致修改后的污染，即使使用了浅拷贝的模式如 copy()、切片等，其内的子列表仍然是引用类型，如果想要构造一个完全独立的复杂的嵌套实例，请新建或者使用深拷贝。

#### python语法优化

+ 可以使用语法糖——列表推导式

```python
result = [expression for item in iterable if condition]
# 等价于
result = []
for item in ierable:
    if condition:
        result.append(expression)
        
# 优化后
class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        rets=[[]]
        for num in nums:
            rets+=[ret+[num] for ret in rets]
        return rets
```

### java

```java
import java.util.ArrayList;
import java.util.List;

public class lcHot100_2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rets=new ArrayList<>();
        rets.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int rets_len=rets.size();
            for(int j=0;j<rets_len;j++){
                List<Integer> temp=new ArrayList<>(rets.get(j));
                temp.add(nums[i]);
                rets.add(temp);
            }
        }
        return rets;
    }
    public static void main(String[] args) {
        int[] nums_in = {1,2,3};
        List<List<Integer>> out=new lcHot100_2().subsets(nums_in);
        for(int i=0;i<out.size();i++){
            for(int j=0;j<out.get(i).size();j++){
                if(out.get(i).isEmpty()) System.out.print(' ');
                else System.out.print(Integer.toString(out.get(i).get(j))+' ');
            }
            System.out.println();
        }
    }
}
```

> java 代码像老太太的裹脚布（）



