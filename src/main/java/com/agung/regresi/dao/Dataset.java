/*
 *  Dataset.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 08/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */

package com.agung.regresi.dao;

import com.agung.regresi.entity.Nilai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author agung
 */
public class Dataset {

    public static List<Nilai> loadData(){
        List<Nilai> hasil = new ArrayList<>();
        
        Nilai d1 = new Nilai();
        d1.setId(1);
        d1.setNilaiUAS(24.0);
        d1.setNilaiUN(10.0);
        hasil.add(d1);
        
        Nilai d2 = new Nilai();
        d2.setId(2);
        d2.setNilaiUAS(22.0);
        d2.setNilaiUN(5.0);
        hasil.add(d2);
        
        Nilai d3 = new Nilai();
        d3.setId(3);
        d3.setNilaiUAS(21.0);
        d3.setNilaiUN(6.0);
        hasil.add(d3);
        
        Nilai d4 = new Nilai();
        d4.setId(4);
        d4.setNilaiUAS(20.0);
        d4.setNilaiUN(3.0);
        hasil.add(d4);
        
        Nilai d5 = new Nilai();
        d5.setId(5);
        d5.setNilaiUAS(22.0);
        d5.setNilaiUN(6.0);
        hasil.add(d5);
        
        Nilai d6 = new Nilai();
        d6.setId(6);
        d6.setNilaiUAS(19.0);
        d6.setNilaiUN(4.0);
        hasil.add(d6);
        
        Nilai d7 = new Nilai();
        d7.setId(7);
        d7.setNilaiUAS(20.0);
        d7.setNilaiUN(5.0);
        hasil.add(d7);
        
        Nilai d8 = new Nilai();
        d8.setId(8);
        d8.setNilaiUAS(23.0);
        d8.setNilaiUN(9.0);
        hasil.add(d8);
        
        Nilai d9 = new Nilai();
        d9.setId(9);
        d9.setNilaiUAS(24.0);
        d9.setNilaiUN(11.0);
        hasil.add(d9);
        
        Nilai d10 = new Nilai();
        d10.setId(10);
        d10.setNilaiUAS(25.0);
        d10.setNilaiUN(13.0);
        hasil.add(d10);
        
        return hasil;
    }
}
