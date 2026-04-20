# Multi-Video Understanding

#Benchmark #Agent #CV 
## 目前已存在的研究（Benchmark）

目前的多视频理解/跨视频理解的 benchmark 主要是为了测试基座模型的在多个视频中准确提取有用信息的能力，说明目前基座模型在得到多个视频输入后存在的一些问题，暂时没有统一的广为认可的测试标准用于测试 Agent 系统，且适用性有待商榷。

### 1. [[MVU-Eval]]

数据集比较小，问题设计侧重于具体的对象识别，涉及推理的问题相对比较少，但也有一些，如 ICL 上下文推理和时间推理
> - 对象识别
> - 空间理解
> - 计数
> - 比较
> - 知识密集型推理
> - 上下文学习（以给出若干视频的评分让模型评估另一个视频评分的方式）
> - 检索增强生成
> - 时间推理（以打乱的视频片段排序的方式）

```python
# 对象识别：输入 3~6 视频，准确识别出所问的对象出现在哪一个视频中
"392": {
        "video_paths": [
            "rmCtqZLnvbQ_000004_000014.mp4",
            "DHg8oQeHjlE_000001_000011.mp4"
        ],
        "question": "In the two videos, which character is reading the newspaper?",
        "options": [
            "A. The little girl in Video 1",
            "B. The man in Video 2",
            "C. The little boy in Video 1",
            "D. The woman in Video 2"
        ],
        "ground_truth": "B",
        "task": "OR"
    }
# 空间理解：输入 3~6 个视频，识别出所询问的某个事件出现在哪一个视频中，与 OR 不同的点就是强调了所处的位置，以下面这个例子为例，其强调了位于户外的运动场的位置信息
"401": {
        "video_paths": [
            "gNHgtx6ecbk_000018_000028.mp4",
            "MB4jL3y7NVk_000046_000056.mp4",
            "ddDSuD4pb18_000000_000010.mp4"
        ],
        "question": "In which of the three video clips is the child swinging at an outdoor playground?",
        "options": [
            "A. Video 1",
            "B. Video 2",
            "C. Video 3"
        ],
        "ground_truth": "A",
        "task": "SU"
    },
# 计数：输入 3~6 个视频，询问哪个视频中出现了最多数量的某个对象
"170": {
        "video_paths": [
            "scene0334_01.mp4",
            "scene0606_00.mp4",
            "scene0356_02.mp4",
            "scene0426_02.mp4"
        ],
        "question": "In which room can you see the most number of chairs?",
        "options": [
            "A. Video 1",
            "B. Video 2",
            "C. Video 3",
            "D. Video 4"
        ],
        "ground_truth": "B",
        "task": "Counting"
    },

# 比较：这类问题该基准设计了两类：
# 1. 给出原视频和经过AI修改之后的视频，询问通过什么操作可以将视频1转换为视频2
# 2. 涉及车载摄像头的不同视角，比较不同视角下对象的状态（视频质量不高）
"1746": {
        "video_paths": [
            "video_editing-video/replace/replace-65/input_video.mp4/input_video.mp4",
            "video_editing-video/replace/replace-65/input_video.mp4/output_video.mp4"
        ],
        "question": "What specific edit operation transforms the Video 1 into the Video 2?",
        "options": [
            "A. Replace the white rope belt with a blue rope belt.",
            "B. Replace the white rope belt with a green rope belt.",
            "C. Replace the white rope belt with a silver rope belt.",
            "D. Replace the white rope belt with a black rope belt.",
            "E. Replace the white rope belt with a purple rope belt.",
            "F. Replace the white rope belt with a bronze rope belt.",
            "G. Replace the white rope belt with a leather belt.",
            "H. Replace the white rope belt with a red rope belt.",
            "I. Replace the white rope belt with a gold rope belt.",
            "J. Replace the white rope belt with a brown rope belt."
        ],
        "ground_truth": "I",
        "task": "Comparison"
    },
"844": {
        "video_paths": [
            "scene-0620_CAM_BACK_LEFT.mp4",
            "scene-0620_CAM_FRONT.mp4",
            "scene-0620_CAM_BACK.mp4",
            "scene-0620_CAM_FRONT_LEFT.mp4",
            "scene-0620_CAM_BACK_RIGHT.mp4",
            "scene-0620_CAM_FRONT_RIGHT.mp4"
        ],
        "question": "Which objects have similar motion trajectories in different views from the left front, front, and right front cameras?",
        "options": [
            "A. A red car",
            "B. A blue truck",
            "C. A pedestrian",
            "D. A bicycle"
        ],
        "ground_truth": "D",
        "task": "Comparison"
    },

# 以上几类问题个人认为通过 子问题（ReAct 问题拆分） + tool call 的方式可以得到初步解决，但是没有特别能体现创新的部分
```

### 2. [[CrossVid]]

数据集相对大
## 目前存在的研究（解决方案）

### 1. VideoForest

### 2. Towards Comprehensive Scene Understanding: Integrating First and Third-Person Views for LVLMs

### 3. 

### 总结

## Long Video Understanding 的研究现状

与 Multi-Video/Cross-Video Understanding 不同，单个 Long Video Understanding 的优化方案可谓是百花齐放，可能有以下几个方面原因：
1. 长视频的数据集质量比较高，目前讨论的长视频理解基本上涉及高质量剪辑视频、电影、讲座、纪录片等等优质信息，其拥有字幕、高质量音频信息等等短视频所没有的优势，所以引入一些模块的效果比较好；
2. 长视频的**逻辑连贯**、信息密度相对不高，可通过间隔采集帧的方式初步获取整个视频的整体信息，并且构造整体的逻辑图也比较方便，一般不会丢失大量信息
3. 相关多模态的视频基准基本上都是单个视频问答的性质，发展成熟，有共同认可的基准，如 Video-MME、LVBench等等

>[!tips] 
>长视频理解中所面对的主要问题十分明确，就是超长视觉上下文无法直接塞入大模型的上下文窗口，而盲目的抽帧则可能会丢失关键信息，由此诞生出一系列的解决方案

### 已知的研究方向

#### 上下文模块强化

上下文模块，也就是所谓的**记忆机制**，即通过预处理的方式（RAG 等）获取长视频的精炼信息，如各个段落摘要、总体摘要，视觉信息、音频信息、对象分割等等，再在推理阶段向 Agent 提供接口供查询，从而提升模型在长视频上的综合能力，这个方向的增量式代表工作相当多：
+ VideoRAG——预处理视频，设计了语音、OCR字幕、SAM分割实体三类数据库，使用 RAG 检索相关信息并回答，暂时停留在 RAG 阶段（自建了字幕时间对齐的视频 benchmark 说明其数据库设置的合理性）
+ AdaVideoRAG——不涉及 ReAct 循环，但是将用户询问分为三级，（训练简单意图分类模型），按照 query 种类决定检索记忆的方式，提高效率（自建了视频长度长短不一的 Video QA benchmark 说明其分级查询的高效）
+ WorldMM——设计了事件-实体关系-视觉的三重记忆机制，具有 ReAct 迭代循环（未自建 benchmark，但在 5 个主流长视频问答基准上超越了目前的 SOTA）（CVPR 2026 2026.2）

> [!tips]
> WorldMM 的核心改进在于设计了一套相对复杂的记忆提取机制：
> 1. 对同一个视频进行**同时、多层级**的滑动窗口切片（比如，最底层是 5 秒一个切片，上一层是 30 秒一个切片，再上一层是 2 分钟一个切片。这些切片在时间上是**重叠包含**的，使用**固定帧数**抽帧）
> 2. 对于每一个切片：
> 	1. 喂给基础视觉模型（VLM），生成这段视频的文本描述Caption（情景记忆）
> 	2. 使用视觉编码器（如 CLIP），提取这段视频的稠密视觉特征向量（视觉记忆）
> 3. 积累一定程度的情境和视觉记忆后，进行一次总结和反思，提取隐性的规律，并将对应的切片连起来
> 4. 在询问时，若出现新的知识，还会对该套记忆系统进行动态更新

#### 迭代机制优化

除了对上下文模块/记忆机制进行增量式改进之外，还有一些针对目前将 ReAct Agent 迁移到 Video Understanding Field 早期出现的迭代机制的优化工作，如：
+ DVD：Deep Video Discovery，最核心的创新点在于发现 Agent 在进行视频推理的多轮 React 时容易陷进某个具体的片段反复进行VQA（称之为认知陷阱），引入了纠正机制（2025.05 NIPS 2025）
+ LVAgent ：首次将**多智能体**辩论与淘汰机制引入 Long Video Understanding 领域（ECCV 2025）
+ etc.