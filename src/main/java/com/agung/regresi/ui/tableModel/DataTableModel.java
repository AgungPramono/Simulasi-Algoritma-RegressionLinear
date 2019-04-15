/*
 *  DataTableModel.java
 *  Prediksi-Nilai 
 * 
 *  Created by Agung Pramono on 18/09/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.regresi.ui.tableModel;

import com.agung.regresi.entity.Nilai;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author agung
 */
public class DataTableModel extends AbstractTableModel {

    private List<Nilai> listData = new ArrayList<>();
    private String[] header = {"ID", "Nilai UAS", "Nilai UN(Class/Label)"};

    public DataTableModel(List<Nilai> listData) {
        this.listData = listData;
    }

    @Override
    public int getRowCount() {
        return listData.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Nilai d = listData.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getId();
            case 1:
                return d.getNilaiUAS();
            case 2:
                return d.getNilaiUN();
            default:
                return new Nilai();
        }
    }
}
