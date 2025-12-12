# List


## attribute

## function

+ 初始化列表长度

```python
# 通过乘法操作符
zero_list=[0] * 5

# 通过列表推导式
init_list=[i**2 for i in range(5)]
zero_list=[0 for _ in range(5)]
```

+ 切片

```python
# 切片可以灵活的取用列表中的连续的部分元素（子元素组）
if(text.startswith(prefix)):
	text=text[len(prefix):]
```

+ 遍历

```python
# 使用索引
for i in range(len(my_list)):
	my_list[i]+=1

# 使用 enum，更加 pythonic
for i,v in enumerate(my_list):
	my_list[i]=v+1
```

+ 排序

基于 `list` 自带的实例方法 `sort()`

通过 `key` 形参对列表进行排序，默认数字升序，字符串使用字典序（如果使用字符串作为 `key` 请一定要考虑这一点）

> **tips：**
> `key` 可以使用元组（Tuple）进行表达，元组中的顺序代表了 `key` 的优先级

```python
# 1个key作为依据
list.sort(key=lambda x: x[1])

# 2个key作为依据
list.sort(key=lambda x: (x[1],x[2]))

# 针对字符串(三元表达式)
list.sort(key=lambda x: 0 if x== 's1' else 1)

# 字典映射
# 定义优先级
priority={"s1":1,"s2":2}
list.sort(key=lambda x: priority.get(x[1],2))
```
