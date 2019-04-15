/*
 *  TrainingDataRepository.java
 *  Prediksi-Nilai 
 * 
 *  Created by Agung Pramono on 24/09/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.regresi.dao;

import com.agung.regresi.entity.Nilai;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author agung
 */
public interface TrainingDataRepository {
    
    public void setConnection(Connection con) throws Exception;
    public void saveOrUpdate(Nilai nilai) throws SQLException ;
    public void delete(Nilai nilai) throws SQLException;
    public void deleteAll() throws SQLException;
    public void setDataset(List<Nilai> listData);

    public void setData(List<Nilai> data);

    public List<Nilai> getAllData();

    public Nilai getDataById(int index);
}
