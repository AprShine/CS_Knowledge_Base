# RAG

## Intro

>你怎么能直接 client.chat.completions.create 去调大模型啊？！企业级 RAG 系统里不是这样！你应该先通过 ETL 流水线把 PDF 和 PPT 清洗一遍，跑一遍 OCR 和 Layout Analysis 提取图片里的图表信息。
>
>接着你要用 Recursive Character Text Splitter 按照语义完整性做 Chunking，并调用 CLIP 或者 BGE-M3 模型生成多模态 Embeddings。
>
>然后你要把这些高维向量存进 Milvus 或者 Weaviate，构建好 HNSW 索引。接着用户提问的时候，你要先做 Query Rewriting，生成多路查询，去走一遍 Hybrid Search，同时结合 BM25 关键词和 Dense Vector 召回 Top-K 文档。然后你要过一遍 Cross-Encoder 的 Reranker 模型，把 Relevancy Score 低的脏数据过滤掉。
>
>之后你把这些图文切片按照 Token Limit 精心塞进 Prompt Template 的 Context Window 里，并严格要求模型基于引用回答。在生成 Response 之前，你要跑一遍 Guardrails 甚至用 RAGAS 框架做一轮评估，检查有没有幻觉，确保 Faithfulness 和 Answer Relevance 分数达标。
>
>等 Grounding Check 全部通过，并且没有触发 Sensitive Word Filter 之后，我才会考虑把 token 一个个 stream 推回给前端，等待用户反馈。你怎么直接上来就想裸调 API 靠模型瞎编？！
>RAG 根本不是这样！我拒绝生成！

