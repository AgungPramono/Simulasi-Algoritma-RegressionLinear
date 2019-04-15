/*
 *  RegressionLinear.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 08/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.regresi.algorithm;

import com.agung.regresi.dao.TrainingDao;
import com.agung.regresi.entity.Nilai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agung
 */
public class RegressionLinear {

    private List<Nilai> listData = new ArrayList<>();
    private TrainingDao dataDao;

//    public RegressionLinear(List<Nilai> listDatas) {
//      this.listData = listDatas;
//    }
    
    public void setData(List<Nilai> listDatas){
        this.listData = listDatas;
    }

    public Double getTotalSuhu() {
        Double jumlah = 0.0;
        for (int i = 0; i < listData.size(); i++) {
            jumlah += listData.get(i).getNilaiUAS();
        }
        return jumlah;
    }

    public Double getTotalCacatProduk() {
        Double jumlah = 0.0;
        for (int i = 0; i < listData.size(); i++) {
            jumlah += listData.get(i).getNilaiUN();
        }
        return jumlah;
    }

    private List<Double> listDataX = new ArrayList<>();

    private void countX() {
        for (int i = 0; i < listData.size(); i++) {
            Nilai dx = listData.get(i);
            Double x = Math.pow(dx.getNilaiUAS(), 2);
            listDataX.add(x);
        }
    }

    private Double getTotalX() {
        countX();
        Double jumlahVarX = 0.0;
        for (int i = 0; i < listData.size(); i++) {
            jumlahVarX += listDataX.get(i);
        }
        return jumlahVarX;
    }

    private List<Double> listDataY = new ArrayList<>();

    private void countY() {
        for (int i = 0; i < listData.size(); i++) {
            Nilai dx = listData.get(i);
            Double x = Math.pow(dx.getNilaiUN(), 2);
            listDataY.add(x);
        }
    }

    private Double getTotalY() {
        countY();
        Double jumlahVarY = 0.0;
        for (int i = 0; i < listData.size(); i++) {
            jumlahVarY += listDataY.get(i);
        }
        return jumlahVarY;
    }

    private List<Double> listDataXY = new ArrayList<>();

    private void countXY() {
        for (int i = 0; i < listData.size(); i++) {
            Double jumlahXY = listData.get(i).getNilaiUAS() * listData.get(i).getNilaiUN();
            listDataXY.add(jumlahXY);
        }
    }

    private Double getTotalXY() {
        countXY();
        Double jumlahVarXY = 0.0;
        for (int i = 0; i < listData.size(); i++) {
            jumlahVarXY += listDataXY.get(i);
        }
        return jumlahVarXY;
    }

    public Double getKoefisienRegA() {
        Double a = (double) (((getTotalCacatProduk()) * (getTotalX()))
                - ((getTotalSuhu()) * (getTotalXY())))
                / ((listData.size() * (getTotalX())) - (Math.pow(getTotalSuhu(), 2)));
        return a;
    }

    public Double getKoefisienRegB() {
        Double b = (double) ((listData.size() * (getTotalXY()))
                - ((getTotalSuhu()) * (getTotalCacatProduk())))
                / ((listData.size() * (getTotalX())) - (Math.pow(getTotalSuhu(), 2)));
        return b;
    }
}
