/*
 *  Main.java
 *  Prediksi-Nilai 
 * 
 *  Created by Agung Pramono on 17/09/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.regresi;

import com.jgoodies.looks.Options;
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.DesertBlue;
import com.agung.regresi.dao.TestingDao;
import com.agung.regresi.dao.TestingDataRepository;
import com.agung.regresi.dao.TrainingDao;
import com.agung.regresi.dao.TrainingDataRepository;
import com.agung.regresi.helper.ConnectionHelper;
import com.agung.regresi.ui.MainFrame;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agung
 */
public class Main {

    private static MainFrame mainFrame;
    private static TrainingDataRepository dataRepository;
    private static TestingDataRepository testingDataRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static TrainingDataRepository getDataRepository() {
        return dataRepository;
    }

    public static TestingDataRepository getTestingDataRepository() {
        return testingDataRepository;
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    private static void initObject() {
        try {
            dataRepository = new TrainingDao();
            testingDataRepository = new TestingDao();
            dataRepository.setConnection(ConnectionHelper.getDataSource().getConnection());
            testingDataRepository.setConnection(ConnectionHelper.getDataSource().getConnection());
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void nativeLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | UnsupportedLookAndFeelException e) {
            LOGGER.debug(e.getMessage());
        }
    }

    private static void JTattoLookAndFell() {
        try {
            PlasticLookAndFeel laf = new Plastic3DLookAndFeel();
            PlasticLookAndFeel.setCurrentTheme(new DesertBlue());
            Options.setPopupDropShadowEnabled(true);
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        initObject();
        nativeLookAndFeel();
//        JTattoLookAndFell();
        SwingUtilities.
                invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        mainFrame = new MainFrame();
                        mainFrame.setVisible(true);
                    }
                });
    }
}
