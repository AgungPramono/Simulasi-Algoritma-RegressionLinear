/*
 *  TestingDataRepository.java
 *  Prediksi-Nilai 
 * 
 *  Created by Agung Pramono on 30/09/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */

package com.agung.regresi.dao;

import com.agung.regresi.entity.Testing;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author agung
 */
public interface TestingDataRepository {
    public void setConnection(Connection con) throws Exception;
    public void saveOrUpdate(Testing testing) throws SQLException ;
    public void delete(Testing testing) throws SQLException;
    public void deleteAll() throws SQLException;
    public void setDataset(List<Testing> listData);

    public void setData(List<Testing> data);

    public List<Testing> getAllData();

    public Testing getDataById(int index);
}
