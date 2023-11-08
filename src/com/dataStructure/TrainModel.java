package com.dataStructure;

import java.util.ArrayList;
/*
TrainModel数据结构
  功能：
  用于存放高斯朴素贝叶斯分离器的训练模型。
  属性：
  1.double[]:Py，每个类别的概率;
  2.ArrayList<TrainData> trainData，不同类别下的各属性特征;
  方法：
  1.空的构造方法
  2.每个属性对应的set和get方法
 */
public class TrainModel {
    private double[] Py;
    private ArrayList<CharData> charData;

    public TrainModel() {
    }

    public double[] getPy() {
        return Py;
    }

    public void setPy(double[] py) {
        Py = py;
    }

    public ArrayList<CharData> getTrainData() {
        return charData;
    }

    public void setTrainData(ArrayList<CharData> charData) {
        this.charData = charData;
    }
}

