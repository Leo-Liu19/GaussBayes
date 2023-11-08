package com;

import com.dataStructure.Data;
import com.dataStructure.CharData;
import com.dataStructure.TrainModel;

import java.util.ArrayList;
/*
Trainer 高斯朴素贝叶斯分类训练器
  功能：
  根据训练集“训练”高斯朴素贝叶斯分类模型
  属性：
  无
  方法：
  1.train
    参数列表：
    ArrayList<Data> train_data; 训练集数据
    返回列表：
    TrainModel trainModel; 高斯朴素贝叶斯分类模型
  2.getChar
    参数列表：
    ArrayList<Data> myData; 需要提取特征的数据
    返回列表：
    TrainData trainData; 特征信息
 */
public class Trainer {
    public TrainModel train(ArrayList<Data> train_data) {
        // 存放三种类别的特征信息
        CharData charData1;
        CharData charData2;
        CharData charData3;
        // 存放特征信息列表
        ArrayList<CharData> charArray = new ArrayList<CharData>();
        // 存放联合学习
        TrainModel trainModel = new TrainModel();
        // 将数据分为三种类型,这是为了方便提取特征
        ArrayList<Data> type1 = new ArrayList<>();
        ArrayList<Data> type2 = new ArrayList<>();
        ArrayList<Data> type3 = new ArrayList<>();
//        System.out.println("现在检查训练集中是否有-1标签");
//        for(Data i : train_data) {
//            if(i.getClassification().equals("-1")) {
//                System.out.println("存在-1");
//                break;
//            }
//        }
//        System.out.println("没有-1");
        for(Data i : train_data) {
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
        // 对于每种类型提取其各自不同属性的特征
        charData1 = getChar(type1);
        charData2 = getChar(type2);
        charData3 = getChar(type3);
        // 整合特征
        charArray.add(charData1);
        charArray.add(charData2);
        charArray.add(charData3);
        // 提取概率
        double[] doubles = new double[3];
        doubles[0] = (double)type1.size() / train_data.size();
        doubles[1] = (double)type2.size() / train_data.size();
        doubles[2] = (double)type3.size() / train_data.size();
        // 联合数据
        trainModel.setPy(doubles);
        trainModel.setTrainData(charArray);

        return trainModel;
    }

    static CharData getChar(ArrayList<Data> myData) {
        double[] doubles = new double[2];
        CharData charData = new CharData();
        double avr = 0;
        double vari = 0;
        double sum = 0;
        // 提取特征1
        for(Data j : myData) {
            sum += j.getSepalLength();
        }
        avr = sum / myData.size();
        doubles[0] = avr;
        sum = 0;
        for(Data j : myData) {
            sum += (j.getSepalLength() - doubles[0]) * (j.getSepalLength() - doubles[0]);
        }
        vari = Math.sqrt(sum / myData.size());
        doubles[1] = vari;
        charData.setCharOfAttrib1(doubles);

        // 提取特征2
        doubles = new double[2];
        avr = 0;
        vari = 0;
        sum = 0;
        for(Data j : myData) {
            sum += j.getSepalWidth();
        }
        avr = sum / myData.size();
        doubles[0] = avr;
        sum = 0;
        for(Data j : myData) {
            sum += (j.getSepalWidth() - doubles[0]) * (j.getSepalWidth() - doubles[0]);
        }
        vari = Math.sqrt(sum / myData.size());
        doubles[1] = vari;
        charData.setCharOfAttrib2(doubles);

        // 提取特征3
        doubles = new double[2];
        avr = 0;
        vari = 0;
        sum = 0;
        for(Data j : myData) {
            sum += j.getPetalLength();
        }
        avr = sum / myData.size();
        doubles[0] = avr;
        sum = 0;
        for(Data j : myData) {
            sum += (j.getPetalLength() - doubles[0]) * (j.getPetalLength() - doubles[0]);
        }
        vari = Math.sqrt(sum / myData.size());
        doubles[1] = vari;
        charData.setCharOfAttrib3(doubles);

        // 提取特征4
        doubles = new double[2];
        avr = 0;
        vari = 0;
        sum = 0;
        for(Data j : myData) {
            sum += j.getPetalWidth();
        }
        avr = sum / myData.size();
        doubles[0] = avr;
        sum = 0;
        for(Data j : myData) {
            sum += (j.getPetalWidth() - doubles[0]) * (j.getPetalWidth() - doubles[0]);
        }
        vari = Math.sqrt(sum / myData.size());
        doubles[1] = vari;
        charData.setCharOfAttrib4(doubles);

        charData.setType(myData.get(0).getClassification());

        return charData;
    }
}
