/*
 *  MLPData.java
 *  Prediksi-Nilai 
 * 
 *  Created by Agung Pramono on 24/09/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.regresi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author agung
 */
public class MLPData {

    private String[] classtype = {"Bike", "Cars", "Bus", "Truck"};

    public MLPData() throws IOException {
        Random rand = new Random(System.nanoTime());
        BufferedWriter out = null;
            out = new BufferedWriter(new FileWriter("vehicledata.csv"));
            out.write("wheels,chassis,pax,vtype\n");
            for (int i = 0; i <= 100; i++) {
                StringBuilder sb = new StringBuilder();
                switch (rand.nextInt(3)) {
                    case 0:
                        sb.append((rand.nextInt(1) + 1) + ",");
                        sb.append((rand.nextInt(1) + 1) + ",");
                        sb.append((rand.nextInt(1) + 1) + ",");
                        sb.append(classtype[0] + "\n");
                        break;
                    case 1:
                        sb.append((rand.nextInt(2) + 4) + ",");
                        sb.append((rand.nextInt(4) + 1) + ",");
                        sb.append((rand.nextInt(4) + 1) + ",");
                        sb.append(classtype[1] + "\n");
                        break;
                    case 2:
                        sb.append((rand.nextInt(6) + 4) + ",");
                        sb.append((rand.nextInt(12) + 12) + ",");
                        sb.append((rand.nextInt(30) + 10) + ",");
                        sb.append(classtype[2] + "\n");
                        break;
                    case 3:
                        sb.append("18,");
                        sb.append((rand.nextInt(10) + 20) + ",");
                        sb.append((rand.nextInt(2) + 1) + ",");
                        sb.append(classtype[3] + "\n");
                        break;
                    default:
                        break;
                }
                out.write(sb.toString());
            }
            out.close();
    }
    
    public static void main(String[] args) throws IOException {
        MLPData mlpd = new MLPData();
    }
}