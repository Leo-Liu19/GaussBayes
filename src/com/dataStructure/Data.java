package com.dataStructure;
/*
Data数据结构
  功能：
  用于存放一组样本数据。
  属性：
  1.double:Sepal.Length（花萼长度），单位是cm;
  2.double:Sepal.Width（花萼宽度），单位是cm;
  3.double:Petal.Length（花瓣长度），单位是cm;
  4.double:Petal.Width（花瓣宽度），单位是cm;
  5.String:类别。
  方法：
  1.空的构造方法和一个带全参数的构造方法
  2.每个属性对应的set和get方法
 */
public class Data {
    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;
    private String classification;

    public Data() {
    }

    public Data(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String classification) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.classification = classification;
    }


    public double getSepalLength() {
        return sepalLength;
    }

    public void setSepalLength(double sepalLength) {
        this.sepalLength = sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public void setSepalWidth(double sepalWidth) {
        this.sepalWidth = sepalWidth;
    }

    public double getPetalLength() {
        return petalLength;
    }

    public void setPetalLength(double petalLength) {
        this.petalLength = petalLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public void setPetalWidth(double petalWidth) {
        this.petalWidth = petalWidth;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
