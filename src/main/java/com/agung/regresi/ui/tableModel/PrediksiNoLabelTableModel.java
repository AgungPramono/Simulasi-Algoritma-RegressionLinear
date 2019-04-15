/*
 *  PrediksiNoLabelTableModel.java
 *  Prediksi-Nilai 
 * 
 *  Created by Agung Pramono on 30/09/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */

package com.agung.regresi.ui.tableModel;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author agung
 */
public class PrediksiNoLabelTableModel extends AbstractTableModel {
    
    private List<Double> listPrediksi = new ArrayList<>();
    private String[]header = {"#","Prediksi Nilai UN"};
    private DecimalFormat format = new DecimalFormat("##.##");
    
    public PrediksiNoLabelTableModel(List<Double> listPrediksi) {
        this.listPrediksi = listPrediksi;
    }
    
    @Override
    public int getRowCount() {
        return listPrediksi.size();
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
        Double hasil = listPrediksi.get(rowIndex);
        switch(columnIndex){
            case 0:return rowIndex+1;
            case 1:return format.format(hasil);
            default:return 0.0;
        }
    }
    
}
