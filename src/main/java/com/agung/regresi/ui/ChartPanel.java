/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.regresi.ui;

import com.agung.regresi.Main;
import com.agung.regresi.entity.Nilai;
import com.agung.regresi.util.ChartCreator;
import com.agung.regresi.util.LookUtil;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agung
 */
public class ChartPanel extends javax.swing.JInternalFrame {

    private static Logger LOGGER = LoggerFactory.getLogger(ChartPanel.class);

    public ChartPanel() {
        initComponents();
        showLineChart(new ArrayList<>(), new ArrayList<>());
        LookUtil.plasticLaf(jToolBar1);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlChart = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        btnRefresh = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Grafik Prediksi");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/colors_cmyk.png"))); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(158, 151, 151));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlChart.setLayout(new java.awt.BorderLayout());
        jPanel1.add(pnlChart, java.awt.BorderLayout.CENTER);
        jPanel1.add(jSeparator1, java.awt.BorderLayout.PAGE_START);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/nav_refresh_yellow.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRefresh);
        jToolBar1.add(jSeparator2);

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Grafik Perbandingan");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 532, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showLineChart(List<Nilai> listLabel, List<Double> listLabelTarget) {
        pnlChart.removeAll();
//        pnlChart.add(new ChartCreator(this.listLabel,this.listLabelTarget)
//                .getTimeSeriesChart());
        pnlChart.add(new ChartCreator(listLabel, listLabelTarget)
                .getXYLineChart());
        pnlChart.repaint();
        pnlChart.updateUI();
    }
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        try {
            
            List<Nilai>listLabel = Main.getMainFrame().testingPanel.getListDataTraining();
            List<Double>listLabelTarget = Main.getMainFrame().testingPanel.getListPrediksi();
            showLineChart(listLabel, listLabelTarget);
            
            if (listLabel != null && listLabelTarget != null) {
                showLineChart(listLabel, listLabelTarget);
                
            } else if (listLabel == null || listLabelTarget == null) {
                
                showLineChart(new ArrayList<Nilai>(), new ArrayList<>());
                JOptionPane.showMessageDialog(this, "Gagal menampilkan grafik, lakukan testing!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException e) {
            LOGGER.debug("[{}]", e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnRefreshActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Main.getMainFrame().chartPanel = null;
    }//GEN-LAST:event_formInternalFrameClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel pnlChart;
    // End of variables declaration//GEN-END:variables
}
