# OpenAI

## 安装

```shell
pip install openai
```

## 使用

## primary usage

```python
from openai import OpenAI

client = OpenAI(
	api_key="sk-123",
)

response = client.response.create(
	model="model_name",
	instructions="role",
	input="prompt",	
)

# 早期标准
response = client.completions.create(
	model="model_name",
	{
            "role": "user",
            "content": "How do I check if a Python object is an instance of a class?",
    },	
)
```