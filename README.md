 # 数据结构与算法 -- 365天
 
一、数据的逻辑结构：指反映数据元素之间的逻辑关系的数据结构，其中的逻辑关系是指数据元素之间的前后件关系，而与他们在计算机中的存储位置无关。逻辑结构包括：
1. 集合
数据结构中的元素之间除了“同属一个集合” 的相互关系外，别无其他关系；
2. 线性结构
数据结构中的元素存在一对一的相互关系；
3. 树形结构
数据结构中的元素存在一对多的相互关系；
4. 图形结构
数据结构中的元素存在多对多的相互关系。

二、数据的物理结构：指数据的逻辑结构在计算机存储空间的存放形式。 [1] 
数据的物理结构是数据结构在计算机中的表示（又称映像），它包括数据元素的机内表示和关系的机内表示。由于具体实现的方法有顺序、链接、索引、散列等多种，所以，一种数据结构可表示成一种或多种存储结构。
数据元素的机内表示（映像方法）： 用二进制位（bit）的位串表示数据元素。通常称这种位串为节点（node）。当数据元素有若干个数据项组成时，位串中与个数据项对应的子位串称为数据域（data field）。因此，节点是数据元素的机内表示（或机内映像）。
关系的机内表示（映像方法）：数据元素之间的关系的机内表示可以分为顺序映像和非顺序映像，常用两种存储结构：顺序存储结构和链式存储结构。顺序映像借助元素在存储器中的相对位置来表示数据元素之间的逻辑关系。非顺序映像借助指示元素存储位置的指针（pointer）来表示数据元素之间的逻辑关系。

## 1. 线性表
### 1.1 线性表的逻辑结构

线性表是一种最简单的线性结构

线性结构的基本特征：线性结构是一个有序（次序）集。
1. 集合中必存在唯一的一个 第一元素  
2. 集合中必存在唯一的一个 最后元素  
3. 除最后元素外，均有唯一的后继 
4. 除第一个元素外，均有唯一的前驱

用最简单的一句话总结线表的逻辑关系：节点之间是一对一的关系

抽象数据类型线性表的定义：（数据集；关系集；操作集合）
> ADT List{
> 
> **数据对象**
> D = {ai | ai ∈ElemSet，i = 1，2，....n,n>=0} 
> {称n为线性表的表长，n=0时的线性表为空表，i为ai在线性表中的位序 }
> 
> **数据关系：**
> R1={<ai-1,ai> | ai-1,ai 属于D，i=2,....an} ai-1是ai的直接前驱，ai是ai-1的直接后继
> {
> 设线性表为（a1,a2....,ai,....,an）,
> 称i为ai在线性表中的 **位序**
> 
> }
>
> **基本操作：**
>      结构初始化操作
>      结构销毁操作
>      引用型操作
>      加工型操作
> 
>     
> }ADT List





