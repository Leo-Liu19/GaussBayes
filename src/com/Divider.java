package com;

import com.dataStructure.Data;
import java.util.ArrayList;
import java.util.Random;
/*
Divider 数据分离器
  功能：
  将源数据按照一定的密度分为训练集和测试集
  属性：
  无
  方法：
  1.divideData
    参数列表：
    ArrayList<Data> myArray; 源数据
    float density; 训练集密度（占比）
    返回列表：
    ArrayList<Data>; 前部分为训练集，后部分为测试集，列表中最后一个数据的第一个属性存放了训练集和测试集的分隔点
 */
public class Divider {
    public ArrayList<Data> divideData(ArrayList<Data> myArray, float density) {
        ArrayList<Data> result = new ArrayList<Data>();  // 用于接收最后的结果
        int num = myArray.size();  // 获取数据条数
        int numTrain = (int)(density * num); // 理论的训练集数
        int numTest = num - numTrain;
        System.out.println("理论训练集数量为：" + numTrain + "\n理论测试集数量为：" + numTest + "\n");
        // 将数据分为三种类型,这是为了方便分层抽样
        ArrayList<Data> type1 = new ArrayList<>();
        ArrayList<Data> type2 = new ArrayList<>();
        ArrayList<Data> type3 = new ArrayList<>();
        for(Data i : myArray) {
            switch(i.getClassification()) {
                case "1" :
                    type1.add(i);
                    break;
                case "2" :
                    type2.add(i);
                    break;
                case "3" :
                    type3.add(i);
                    break;
                default:
                    System.out.println("发现不存在的类型，请注意检查数据");
            }
        }
        System.out.println("type1的数量为：" + type1.size() + "\ntype2的数量为：" + type2.size() + "\ntype3的数量为：" + type3.size());
//        for(int i = 0; i < myArray.size(); i++) {
//            System.out.println(myArray.get(i).getClassification());   //测试模块
//        }
        // 对每种类型的数据进行备份
        ArrayList<Data> copyType1 = new ArrayList<Data>(type1);
        for(int i = 0 ; i < type1.size(); i++) {
            Data data = new Data(type1.get(i).getSepalLength(), type1.get(i).getSepalWidth(), type1.get(i).getPetalLength(), type1.get(i).getPetalWidth(), type1.get(i).getClassification());
            copyType1.add(data);
        }
        ArrayList<Data> copyType2 = new ArrayList<Data>(type2);
        for(int i = 0 ; i < type2.size(); i++) {
            Data data = new Data(type2.get(i).getSepalLength(), type2.get(i).getSepalWidth(), type2.get(i).getPetalLength(), type1.get(i).getPetalWidth(), type1.get(i).getClassification());
            copyType2.add(data);
        }
        ArrayList<Data> copyType3 = new ArrayList<Data>(type3);
        for(int i = 0 ; i < type3.size(); i++) {
            Data data = new Data(type3.get(i).getSepalLength(), type3.get(i).getSepalWidth(), type3.get(i).getPetalLength(), type1.get(i).getPetalWidth(), type1.get(i).getClassification());
            copyType3.add(data);
        }
        // 获取每个类型的抽样数
        System.out.println("type1.size()为：" + type1.size() + "\nnum为：" + num + "\nnumTrain为：" + numTrain);
        //int numType1 = (int)type1.size() / num * numTrain; 错误写法
        int numType1 = (int)(type1.size() / (float)num * numTrain);
        int numType2 = (int)(type2.size() / (float)num * numTrain);
        int numType3 = (int)(type3.size() / (float)num * numTrain);
        System.out.println("type1的抽样数为：" + numType1 + "\ntype2的抽样数为：" + numType2 + "\ntype3的抽样数为：" + numType3);
        // 重定义Train和Test集的数量
        numTrain = numType1 + numType2 + numType3; // 实际的训练集数
        numTest = num - numTrain; // 实际的测试集数
        System.out.println("实际训练集数量为：" + numTrain + "\n实际测试集数量为：" + numTest + "\n");

        // 下面开始对每个类型抽取样本
        take(result, type1, copyType1, numType1);
        System.out.println("第一次抽取后结果集大小：" + result.size());
//        for(int i = 0; i < result.size(); i++) {     //该片段为测试片段
//            System.out.println(result.get(i).getClassification());
//        }
        take(result, type2, copyType2, numType2);
        System.out.println("第二次抽取后结果集大小：" + result.size());
        take(result, type3, copyType3, numType3);
        System.out.println("第三次抽取后结果集大小：" + result.size());

        // 下面对将每个类型剩余的数据加入到result中
        addLeft(result, type1, copyType1);
        System.out.println("第一次加入剩余结果集大小：" + result.size());
        addLeft(result, type2, copyType2);
        System.out.println("第二次加入剩余结果集大小：" + result.size());
        addLeft(result, type3, copyType3);
        System.out.println("第三次加入剩余结果集大小：" + result.size());

        // 我们将数据分隔线放在result的最后一个元素的最后一个属性上
        Data data = new Data();
        data.setClassification(Integer.toString(numTrain));
        result.add(data);
        // 查看一下结果是否正确
        System.out.println("结果集的大小为：" + result.size());

        return result;
    }
    static boolean isExist(int[] ints, int ans, int i) {
        for(int j = 0; j < i; j++) {
            if(ints[j] == ans) {
                return true;
            }
        }
        return false;
    }
    // 需要类型数据，抽样数和一个可以不断加入的结果
    static void take(ArrayList<Data> result, ArrayList<Data> type, ArrayList<Data> copyType, int numType) {
        // 下面开始对每个类型抽取样本
        // 这里有个大坑，引用类型数据需要格外小心
        //ArrayList<Data> newType = new ArrayList<>(type);
        ArrayList<Data> newType = new ArrayList<>();
        for(Data i : type) {
            Data data = new Data(i.getSepalLength(),i.getSepalWidth(),i.getPetalLength(),i.getPetalLength(),i.getClassification());
            newType.add(data);
        }
//        System.out.println("测试type和newType");
//        System.out.println("type的类别：" + type.get(0).getClassification() + " newType的类别：" + newType.get(0).getClassification());
//        System.out.println("修改type的类别为-1");
//        type.get(0).setClassification("-1");
//        System.out.println("type的类别：" + type.get(0).getClassification() + " newType的类别：" + newType.get(0).getClassification());
        Random random = new Random();
        int[] ints = new int[numType];
        for(int i = 0; i < numType; i++) {
            int ans = random.nextInt(newType.size());
            while(isExist(ints, ans, i)) {
                ans = random.nextInt(newType.size());
            }
            ints[i] = ans;
        }
        // 将被选中的样本加入到result中
        for(int i = 0; i < ints.length; i++) {
            result.add(newType.get(ints[i]));
            copyType.get(ints[i]).setClassification("-1");
        }
        //return result;
    }
    static void addLeft(ArrayList<Data> result, ArrayList<Data> type, ArrayList<Data> copyType) {
        for(int i = 0; i < type.size(); i++) {
            if(copyType.get(i).getClassification().equals("-1")) {
            } else {
                result.add(type.get(i));
            }
        }
        //return result;
    }
}
