/*
 *  TrainingDao.java
 *  template-maven 
 * 
 *  Created by Agung Pramono on 08/08/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */

package com.agung.regresi.dao;

import com.agung.regresi.Main;
import com.agung.regresi.entity.Nilai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author agung
 */
public class TrainingDao implements TrainingDataRepository{
    private Connection con;

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteAllStatement;

    @Override
    public void setConnection(Connection con) throws Exception {
        this.con = con;
        insertStatement = this.con.prepareStatement(SqlHelper.INSERT_QUERY_RESULT, 
                                                        Statement.RETURN_GENERATED_KEYS);
        updateStatement = this.con.prepareStatement(SqlHelper.UPDATE_QUERY);
        deleteStatement = this.con.prepareStatement(SqlHelper.DELETE_QUERY);
        deleteAllStatement = this.con.prepareStatement(SqlHelper.DELETE_ALL_QUERY);
        selectAllStatement = this.con.prepareStatement(SqlHelper.GET_ALL_QUERY_RESULT);
    }
    
    @Override
    public void saveOrUpdate(Nilai nilai) throws SQLException {
        if (nilai.getId() == null) {
            insertStatement.setDouble(1, nilai.getNilaiUAS());
            insertStatement.setDouble(2, nilai.getNilaiUN());
            int id = insertStatement.executeUpdate();
            nilai.setId(id);
            
        } else {
            updateStatement.setDouble(1, nilai.getNilaiUAS());
            updateStatement.setDouble(2, nilai.getNilaiUN());
            updateStatement.setInt(3, nilai.getId());
            updateStatement.executeUpdate();
           
        }
    }
    
    public void delete(Nilai nilai) throws SQLException {
        deleteStatement.setInt(1, nilai.getId());
        deleteStatement.executeUpdate();
        JOptionPane.showMessageDialog(Main.getMainFrame(), "Data Berhasil dihapus");
    }
    
    public void deleteAll() throws SQLException {
        deleteAllStatement.executeUpdate();
    }
    
    private List<Nilai> data = new ArrayList<>();
    
    @Override
    public void setDataset(List<Nilai> listData){
        this.data  = listData;
    }
    
    @Override
    public void setData(List<Nilai> data){
        this.data = data;
    }
    
    @Override
    public List<Nilai> getAllData(){
        try {
            List<Nilai> result = new ArrayList<>();
            
            ResultSet rs = selectAllStatement.executeQuery();
            while (rs.next()) {
                Nilai n = resultSetMapper(rs);
                result.add(n);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(TrainingDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(TrainingDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public Nilai getDataById(int index){
        return this.data.get(index);
    }

     private Nilai resultSetMapper(ResultSet rs) throws Exception {
        Nilai n = new Nilai();

        n.setId(rs.getInt("id"));
        n.setNilaiUAS(rs.getDouble("uas"));
        n.setNilaiUN(rs.getDouble("un"));
        return n;
    }
    
}
