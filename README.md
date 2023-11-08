**高斯朴素贝叶斯分类器**
笔者近期精力有限，目前只编写了该项目的中文版，英文版会在不久的将来推出
Due to the author's limited energy in the near future, only the Chinese version of the project has been written, and the English version will be launched in the future

# 项目说明

<ul>
    <li>本项目为笔者的智能系统课程作业，实现了一个高斯朴素贝叶斯分类器</li>
    <li>以数据集大小为150的鸢尾分类数据集为原始数据</li>
    <li>在只调用Java库文件的情况下实现了该高斯朴素贝叶斯分类器</li>
</ul>

# 编译环境

<ul>
    <li>语言：Java</li>
    <li>开发工具：IntelliJ IDEA 2023.2.2</li>
</ul>

# 原理阐释

贝叶斯原理

![image](https://github.com/Leo-Liu19/GaussBayes/blob/master/picture/2.jpg)

![image](https://github.com/Leo-Liu19/GaussBayes/blob/master/picture/2.jpg)

对于贝叶斯原理上面的内容已经将得很详细，下面对我们当前面对的数据进行分析（每条数据有五个值，前四个值为连续型数值，最后一个值为分类型数值）

![image](https://github.com/Leo-Liu19/GaussBayes/blob/master/picture/3.jpg)

因为属性值$$X_{i}$$为离散型数值，因此我们需要用以下的高斯公式去描述$$P(X_{i}|C_{j})$$

![image](https://github.com/Leo-Liu19/GaussBayes/blob/master/picture/4.jpg)

# 待解决的问题

<ul>
    <li>该模型尚不能处理当数据以相同概率被分类到不同的类别时应该选取哪个类别作为预测类别,默认使用第一个类别为预测类型。</li>
    <li>代码的健壮性可以进一步优化，如是否可以通过修改一个属性使得该模型应用于不同属性大小的数据。</li>
</ul>



# 更新日志

<ul>
    <li>2023.11.08 1.0版本</li>
    <li>2023.11.08 1.1版本<br />对错误使用引用类型数据进行了修改，模型的精度正常，不再像以往异常的低，更多问题和优化有待进一步发现和更新</li>
</ul>




