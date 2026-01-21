# Str

在 python 中给处理文本数据使用 [[Str]] 对象，也称为字符串，字符串是由 Unicode 编码构成的不可变 [[Sequence]]，字符串字面值有多种不同写法：

+ 单引号，允许包含有双引号
+ 双引号，允许嵌入单引号
+ 三重引号，支持三重双引号和三重单引号

使用三重引号的字符串可以跨越多行，其中所有的空白字符都包含在该字符串字面值中。

>**tips：**
>
>字符串字面量即用单引号或双引号括起来的文本

字符串字面量之**前**有一个可选的**前缀**，该前缀会影响字面量内容的解析方式，不冲突的前缀可以联合使用。
## 字符串前缀

### 字节串字面量：b

字节串字面量带有 b or B 的前缀，他们会产生 bytes 类型而不是 [[Str]] 类型的实例，他们只能包含 ASCII 字符，数值为 128 或者以上的字节必须使用转义序列。

```python
str_bytes=b"\x89PNG\r\n\x1a\n"
print(list(str_bytes))
[137, 80, 78, 71, 13, 10, 26, 10]
```

### 原始字符字面量：r

字符串和字节串都可以选择带有字符 r or R 作为前缀，成为原始字符串字面量，在原始字符串字面量中，**转义序列**不会被特殊对待，而是直接加入到字符串中，当然，对应的反斜杠会增加一个表明其转义字符身份：

```python
>>> r"\d"
'\\d'
```

### 格式字符串字面量：f

> 在 3.6 版本加入。

> 3.7 版本后支持在 f-字符串中使用异步操作符；3.12 版本后支持嵌套字符串、注释和反斜杠

使用 f or F 作为前缀，内嵌表达式的字符串字面值，可以在 f-字符串中内嵌表达式，以操纵输出格式，替换字段使用花括号 `{}` 括起来，替换字段可以在运行时进行求值，任何替换字段外出现的成对花括号将被替换为成对的单个花括号。

替换字段外的其他字符会像普通字符串一样进行处理。

```python
who = 'nobody'
nation = 'china'
print(f"{who.title()} knows {nation} better than me!")

# 成对花括号替换
print("{{...}}")
{...}

# 三引号也可以使用 f 字符串，并且可以包含换行符：
print(f'''Three shall be the number of the counting
and the number of the counting shall be three.''')
Three shall be the number of the counting
and the number of the counting shall be three.

# 
```


## function

+ 格式化：`str.format()`


+ 分割操作：`str.spilt()`

用于处理有规范化间隔的字符串，将格式化字符串转化为列表，甚至可以忽略不规范的空格

也可以传递参数，取决于分割的符号是什么，默认为空格，处理不规范的字符串不要显式的传递单个空格参数，否则忽略不规范空格的功能不生效，除非你确认分隔符就是一个空格

```python
text="id-1 id-2 id-3"

items_list=text.spilt()

items_list=text.split(" ")
```