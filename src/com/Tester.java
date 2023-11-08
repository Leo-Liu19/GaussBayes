package com;

import com.dataStructure.Data;
import com.dataStructure.TrainModel;

import java.util.ArrayList;
/*
Tester 高斯朴素贝叶斯分类模型精度测试器
  功能：
  测试根据训练集“训练”得到高斯朴素贝叶斯分类模型的精度
  属性：
  无
  方法：
  1.test
    参数列表：
    ArrayList<Data> test_data; 测试集数据
    TrainModel trainModel; 根据训练集“训练”得到高斯朴素贝叶斯分类模型
    返回列表：
    无（打印测试结果和测试精度）
  2.gaussian
    参数列表：
    double x; 测试集中的单条数据的单个属性值
    double[] doubles; x对应属性在某分类下的特征（平均值和方差）
    返回列表：
    double g; 高斯分布函数值
  3.function(Data data, TrainModel trainModel)
    参数列表：
    Data data; 测试集中的某条数据
    TrainModel trainModel; 根据训练集“训练”得到高斯朴素贝叶斯分类模型
    返回列表：
    double[]; 该数据预测为不同类别的概率（三种类别）
 */
public class Tester {
    public void test(ArrayList<Data> test_data, TrainModel trainModel) {
        // 用于存储预测结果
        String[] result = new String[test_data.size()];
        int[] resultIndex = new int[test_data.size()];
        // 用于存储测试集预测为不同类别的概率
        double[][] preResult = new double[test_data.size()][3];

        for(int i = 0; i < test_data.size(); i++) {
            // 对每条数据求不同类别的预测概率
            preResult[i] = function(test_data.get(i), trainModel);
        }

        // 对每条数据选取不同类别的预测概率中最大的为该数据的预测类别
        for(int i = 0; i < test_data.size(); i++) {
            double max = preResult[i][0];
            for(int j = 1; j < 3; j++) { // 注:这里还没有考虑不同类别的概率相同的情况，默认以先出现的概率对应的类别为预测类别
                if(preResult[i][j] > max) {
                    max = preResult[i][j];
                    resultIndex[i] = j + 1;
                }
            }
            if(max == preResult[i][0]) {
                resultIndex[i] = 1;
            }
        }

        // 将数字标签改成字符串标签
        for(int i = 0; i < resultIndex.length; i++) {
            result[i] = Integer.toString(resultIndex[i]);
        }

        // 查看实际结果和预测结果
        int sum = 0; // 记录实际结果与预测结果一致的测试条数
        for(int i = 0; i < test_data.size(); i++) {
            System.out.println("实际结果:" +  test_data.get(i).getClassification() + "预测结果：" + result[i]);
            if(result[i].equals(test_data.get(i).getClassification())) {
                sum ++;
            }
        }
        System.out.println("模型精度为：" + (double)sum / test_data.size());

    }
    static double gaussian(double x, double[] doubles) {
        double g = 1 / (Math.sqrt(2 * Math.PI) * doubles[0]) *
                Math.exp(-((x - doubles[0]) * (x-doubles[0])) / (2 * doubles[1] * doubles[1]));
        return g;
    }
    static double[] function(Data data, TrainModel trainModel) {
        double sum;
        double[] result = new double[3];
        for(int i = 0; i < 3; i++) {
            sum = 1;
            sum *= gaussian(data.getSepalLength(), trainModel.getTrainData().get(i).getCharOfAttrib1());
            sum *= gaussian(data.getSepalWidth(), trainModel.getTrainData().get(i).getCharOfAttrib2());
            sum *= gaussian(data.getPetalLength(), trainModel.getTrainData().get(i).getCharOfAttrib3());
            sum *= gaussian(data.getPetalWidth(), trainModel.getTrainData().get(i).getCharOfAttrib4());
            result[i] = sum * trainModel.getPy()[i];
        }
        return result;
    }
}
