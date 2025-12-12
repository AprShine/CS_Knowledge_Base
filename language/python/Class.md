# Class


## method

+ 实例方法，无装饰器，第一个形参应该是 `self`（对象本身），用于修改实例的状态
+ 类方法，装饰器为 `@classmethod`，通常用于作为备选的构造函数，第一个参数为 `cls`（类本身），用于修改类的状态。
>**tips：**
>类方法通常用于做**备选**的构造函数
### static method

可以直接声明在 class 外部，也可以使用 `@staticmethod` 注解在class 内部进行显式声明，本质上相同，只是调用方式上不一致：
+ 外部方法在类内部可以直接使用函数名调用
+ `staticmethod` 则需要使用 self 进行调用

>**tips：**
>两种方法在功能执行上是一致的，他们都不需要 self 参数，也不依赖类的实例的状态，只在代码组织和命名空间上有差异

```python
# 定义在函数外部，通常表明所有人都可以用
def mtd():
	...
	
class my_class():
	# 定义在函数内部，通常是某主函数的辅助函数，或与该类相关的函数，可以保持 namespace 的清洁
	@staticmethod
	def mtd_inner():
		...
```

### class method

```python
class cat:
	...
	@classmethod
	def create_hjm(cls, name):
		return cls(name)
```

### magic method

除此之外，python 中还有很多魔术方法，以双下划线开头和结尾，可以在特定的时刻自动触发：
+ `__str__`：决定了 `print(obj)` 时显示的内容
+ `__init__`：默认的构造函数，用于初始化
+ `__repr__`：开发者视角的控制台字符串显示
+ 运算符重载：
	+ `__add__`
	+ `__sub__`
	+ `__eq__`：对应 `==`
	+ `__lt__`：对应 `<`
	+ etc.
+ 容器与集合，旨在使你的对象像列表或字典一样工作：
	+ `__len__(self)`
	+ `__getitem__(self, key)`
+ etc.