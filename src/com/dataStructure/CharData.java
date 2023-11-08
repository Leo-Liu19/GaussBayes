package com.dataStructure;
/*
TrainData数据结构
  功能：
  用于存放某个划分下各属性的特征值（平均值和方差）
  属性：
  1.double[]:charOfAttrib1，Sepal.Length（花萼长度）的特征;
  2.double[]:charOfAttrib2，Sepal.Width（花萼宽度）的特征;
  3.double[]:charOfAttrib3，Petal.Length（花瓣长度）的特征;
  4.double[]:charOfAttrib4，Petal.Width（花瓣宽度）的特征;
  5.String:类别。
  方法：
  1.空的构造方法
  2.每个属性对应的set和get方法
 */
public class CharData {
    private double[] charOfAttrib1 = new double[2];
    private double[] charOfAttrib2 = new double[2];
    private double[] charOfAttrib3 = new double[2];
    private double[] charOfAttrib4 = new double[2];
    private String type;

    public CharData() {
    }

    public double[] getCharOfAttrib1() {
        return charOfAttrib1;
    }

    public void setCharOfAttrib1(double[] charOfAttrib1) {
        this.charOfAttrib1 = charOfAttrib1;
    }

    public double[] getCharOfAttrib2() {
        return charOfAttrib2;
    }

    public void setCharOfAttrib2(double[] charOfAttrib2) {
        this.charOfAttrib2 = charOfAttrib2;
    }

    public double[] getCharOfAttrib3() {
        return charOfAttrib3;
    }

    public void setCharOfAttrib3(double[] charOfAttrib3) {
        this.charOfAttrib3 = charOfAttrib3;
    }

    public double[] getCharOfAttrib4() {
        return charOfAttrib4;
    }

    public void setCharOfAttrib4(double[] charOfAttrib4) {
        this.charOfAttrib4 = charOfAttrib4;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
