package com;
import com.dataStructure.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
DataReader 文本读取器
  功能：
  读取txt文本中的数据，并根据一定的方式对数据进行解析。
  最后解析的每条数据存放在Data数据结构中，所有数据存放在ArrayList<Data>数据结构中。
  属性：
  无
  方法：
  1.readData
    参数列表：
    String:filePath; txt文本文件的地址
    返回列表：
    ArrayList<Data>; 解析并利用自定义数据结构存放的源数据
 */
public class DataReader {
    public ArrayList<Data> readData(String filePath) {
        ArrayList<Data> myArray = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 使用逗号分隔数据行
                String[] parts = line.split(",");
                Data data = new Data();
                // 确保数据行包含至少5个部分
                if (parts.length >= 5) {
                    // 解析前四个浮点数
                    data.setSepalLength(Double.parseDouble(parts[0]));
                    data.setSepalWidth(Double.parseDouble(parts[1]));
                    data.setPetalLength(Double.parseDouble(parts[2]));
                    data.setPetalWidth(Double.parseDouble(parts[3]));

                    // 解析最后一个字符串
                    data.setClassification(parts[4]);

                    // 将每条数据加入到数据列表中
                    myArray.add(data);
//                    System.out.println("Data: " + data.getSepalLength() + ", " + data.getSepalWidth() + ", " + data.getPetalLength() + ", " + data.getPetalWidth());
//                    System.out.println("Label: " + data.getClassification());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 为了方便，将原有类别映射到1、2、3中
        for(Data i : myArray) {
            switch(i.getClassification()) {
                case "Iris-setosa" :
                    i.setClassification("1");
                    break;
                case "Iris-versicolor" :
                    i.setClassification("2");
                    break;
                case "Iris-virginica" :
                    i.setClassification("3");
                    break;
                default:
                    System.out.println("该类别不存在，请检查数据");
            }
        }
//        Data data = myArray.get(149);
//        System.out.println("Data: " + data.getSepalLength() + ", " + data.getSepalWidth() + ", " + data.getPetalLength() + ", " + data.getPetalWidth());
//        System.out.println("Label: " + data.getClassification());
        System.out.println("读取到的数据数量为：" + myArray.size());
        return myArray;
    }
}
