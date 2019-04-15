/*
 *  TestingDao.java
 *  Prediksi-Nilai 
 * 
 *  Created by Agung Pramono on 30/09/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.regresi.dao;

import com.agung.regresi.entity.Testing;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agung
 */
public class TestingDao implements TestingDataRepository {

    private List<Testing> data = new ArrayList<>();
    private Connection con;

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteAllStatement;

    @Override
    public void setConnection(Connection con) throws Exception {
        this.con = con;
        insertStatement = this.con.prepareStatement(SqlHelper.INSERT_QUERY_TESTING, 
                                                        Statement.RETURN_GENERATED_KEYS);
        updateStatement = this.con.prepareStatement(SqlHelper.UPDATE_QUERY_TESTING);
        deleteStatement = this.con.prepareStatement(SqlHelper.DELETE_QUERY_TESTING);
        deleteAllStatement = this.con.prepareStatement(SqlHelper.DELETE_ALL_QUERY_TESTING);
        selectAllStatement = this.con.prepareStatement(SqlHelper.GET_ALL_QUERY_TESTING);
    }

    @Override
    public void setDataset(List<Testing> listData) {
        this.data = listData;
    }

    @Override
    public void setData(List<Testing> data) {
        this.data = data;
    }

    @Override
    public List<Testing> getAllData() {
        try {
            List<Testing> result = new ArrayList<>();
            
            ResultSet rs = selectAllStatement.executeQuery();
            while (rs.next()) {
                Testing t = resultSetMapper(rs);
                result.add(t);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(TrainingDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TrainingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private Testing resultSetMapper(ResultSet rs) throws Exception {
        Testing t = new Testing();

        t.setId(rs.getInt("id"));
        t.setNilaiUAS(rs.getDouble("uas"));
        return t;
    }

    @Override
    public Testing getDataById(int index) {
        return this.data.get(index);
    }

    @Override
    public void saveOrUpdate(Testing testing) throws SQLException {
        if (testing.getId() == null) {
            insertStatement.setDouble(1, testing.getNilaiUAS());
            int id = insertStatement.executeUpdate();
            testing.setId(id);

        } else {
            updateStatement.setDouble(1, testing.getNilaiUAS());
            updateStatement.setInt(2, testing.getId());
            updateStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Testing testing) throws SQLException {
        deleteStatement.setInt(1, testing.getId());
        deleteStatement.executeUpdate();
    }

    @Override
    public void deleteAll() throws SQLException {
        deleteAllStatement.executeUpdate();
    }
}
