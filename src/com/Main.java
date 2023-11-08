package com;

import java.util.ArrayList;

import com.dataStructure.Data;
import com.dataStructure.TrainModel;

public class Main {
    public static void main(String[] args) {
        // 属性
        ArrayList<Data> data; // 原始数据
        ArrayList<Data> trainData = new ArrayList<>(); // 训练数据
        ArrayList<Data> testData = new ArrayList<>(); // 测试数据
        DataReader dataReader = new DataReader(); // 文本读取器
        Divider divider = new Divider(); // 分类器
        Trainer trainer = new Trainer(); // 训练器
        Tester tester = new Tester(); // 测试器
        float density = 0.7f; // 训练集占比
        String filePath = "src/com/data.txt"; // 数据地址

        // 读取数据
        data = dataReader.readData(filePath);

        // 将数据按密度分为训练集和测试集
        data = divider.divideData(data, density);
        for(int i = 0; i < Integer.parseInt(data.get(data.size() - 1).getClassification()); i++) {
            trainData.add(data.get(i));  // trainData的类别值全是-1,有问题
        }

        for(int i = Integer.parseInt(data.get(data.size() - 1).getClassification()); i < data.size() - 1; i++) {
            testData.add(data.get(i));
        }
        System.out.println("训练集大小：" + trainData.size() + "\n测试集大小：" + testData.size());

        // 对训练集进行训练
        TrainModel trainModel = new TrainModel();
        trainModel = trainer.train(trainData);

        // 使用测试集进行测试
        tester.test(testData, trainModel);
    }
}