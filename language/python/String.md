# String

## function

+ 分割操作

基于 string 实例方法：`split()`

用于处理有规范化间隔的字符串，将格式化字符串转化为列表，甚至可以忽略不规范的空格

也可以传递参数，取决于分割的符号是什么，默认为空格，处理不规范的字符串不要显式的传递单个空格参数，否则忽略不规范空格的功能不生效，除非你确认分隔符就是一个空格

```python
text="id-1 id-2 id-3"

items_list=text.spilt()

items_list=text.split(" ")
```