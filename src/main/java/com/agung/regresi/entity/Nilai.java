/*
 *  Nilai.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 08/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */

package com.agung.regresi.entity;

/**
 *
 * @author agung
 */
public class Nilai {
    
    private Integer id;
    private Double nilaiUAS;
    private Double nilaiUN;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNilaiUAS() {
        return nilaiUAS;
    }

    public void setNilaiUAS(Double nilaiUAS) {
        this.nilaiUAS = nilaiUAS;
    }

    public Double getNilaiUN() {
        return nilaiUN;
    }

    public void setNilaiUN(Double nilaiUN) {
        this.nilaiUN = nilaiUN;
    }
    
    
}
