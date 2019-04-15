/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.regresi.ui;

import com.agung.regresi.Main;
import com.agung.regresi.algorithm.NumericEvaluation;
import com.agung.regresi.algorithm.RegressionLinear;
import com.agung.regresi.entity.Nilai;
import com.agung.regresi.entity.Testing;
import com.agung.regresi.ui.tableModel.DataTableModel;
import com.agung.regresi.ui.tableModel.PrediksiNoLabelTableModel;
import com.agung.regresi.ui.tableModel.PrediksiTableModel;
import com.agung.regresi.util.LookUtil;
import com.agung.regresi.util.TableUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agung
 */
public class ProcessPanel extends javax.swing.JInternalFrame {

    private List<Nilai> listDataTraining = new ArrayList<>();
    private List<Testing> listDataTestingNoLabel = new ArrayList<>();
    private List<Double> listPrediksi;
    private List<Double> listPrediksiNoLabel;
    private DecimalFormat format = new DecimalFormat("##.##");

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessPanel.class);

    public ProcessPanel() {
        initComponents();
        setResizable(true);
        btnLoadData.setEnabled(true);
        btnRun.setEnabled(false);
        btnReset.setEnabled(false);
        btnClose.setEnabled(true);
        LookUtil.plasticLaf(jToolBar1);
        TableUtil.initColumn(tblDataset, jScrollPane1);
        TableUtil.initColumn(tblPrediksi, jScrollPane2);
        TableUtil.initColumn(tblPrediksiNoLabel, jScrollPane3);
    }

    public List<Nilai> getListDataTraining() {
        return listDataTraining;
    }

    public List<Double> getListPrediksi() {
        return listPrediksi;
    }

    private void cekStateButton() {
        if (listDataTraining != null) {
            btnRun.setText("Training");
        } else if (listDataTraining != null && listDataTestingNoLabel != null) {
            btnRun.setText("Testing");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDataset = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPrediksi = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPrediksiNoLabel = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblRmse = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblMse = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNilai = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblPrediksi = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnLoadData = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnRun = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnReset = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnClose = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Training/Testing");
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

        jPanel1.setBackground(new java.awt.Color(164, 157, 157));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.lightGray));
        jPanel1.setLayout(new java.awt.BorderLayout(2, 2));

        jPanel3.setPreferredSize(new java.awt.Dimension(668, 300));

        tblDataset.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Siswa", "Nilai UAS", "Nilai UN"
            }
        ));
        tblDataset.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tblDataset);

        tblPrediksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prediksi Nilai UN"
            }
        ));
        tblPrediksi.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tblPrediksi);

        tblPrediksiNoLabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data UAS BARU"
            }
        ));
        tblPrediksiNoLabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(tblPrediksiNoLabel);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(594, 150));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MSE     :");

        lblRmse.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        lblRmse.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RMSE    :");

        lblMse.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        lblMse.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nilai   :");

        txtNilai.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        txtNilai.setText("85");
        txtNilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNilaiMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Prediksi:");

        lblPrediksi.setBackground(new java.awt.Color(153, 255, 153));
        lblPrediksi.setFont(new java.awt.Font("Courier New", 1, 20)); // NOI18N
        lblPrediksi.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRmse, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMse, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPrediksi, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(412, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel5});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblMse, lblPrediksi, lblRmse, txtNilai});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(lblPrediksi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRmse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMse, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, lblMse, lblPrediksi, lblRmse, txtNilai});

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        btnLoadData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/data_up.png"))); // NOI18N
        btnLoadData.setText("Load");
        btnLoadData.setPreferredSize(new java.awt.Dimension(100, 40));
        btnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLoadData);
        jToolBar1.add(jSeparator2);

        btnRun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/media_play.png"))); // NOI18N
        btnRun.setText("Run");
        btnRun.setPreferredSize(new java.awt.Dimension(100, 40));
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRun);
        jToolBar1.add(jSeparator3);

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/refresh.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.setPreferredSize(new java.awt.Dimension(110, 40));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jToolBar1.add(btnReset);
        jToolBar1.add(jSeparator4);

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/delete.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.setPreferredSize(new java.awt.Dimension(110, 40));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jToolBar1.add(btnClose);

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Training/Testing");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        Main.getMainFrame().testingPanel = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void viewPrediksi(List<Double> dataPrediksi) {
        if (!dataPrediksi.isEmpty() && dataPrediksi != null) {
            tblPrediksi.setModel(new PrediksiTableModel(dataPrediksi));
        }
    }

    private void viewPrediksiNoLabel(List<Double> dataPrediksiNoLabel) {
        if (!dataPrediksiNoLabel.isEmpty() && dataPrediksiNoLabel != null) {
            tblPrediksiNoLabel.setModel(new PrediksiNoLabelTableModel(dataPrediksiNoLabel));
        }
    }

    private void training(RegressionLinear regresiEngine) {
        listPrediksi = new ArrayList<>();
        regresiEngine.setData(listDataTraining);

        for (int i = 0; i < listDataTraining.size(); i++) {
            Double prediksiNilai = regresiEngine.getKoefisienRegA()
                    + regresiEngine.getKoefisienRegB()
                    * listDataTraining.get(i).getNilaiUAS();
            listPrediksi.add(prediksiNilai);
        }
    }

    private void predictDataNoLabel(RegressionLinear regressionLinear) {
        listPrediksiNoLabel = new ArrayList<>();
        regressionLinear.setData(listDataTraining);
        for (int i = 0; i < listDataTestingNoLabel.size(); i++) {
            Double prediksiNilaiNoLabel = regressionLinear.getKoefisienRegA()
                    + regressionLinear.getKoefisienRegB()
                    * listDataTestingNoLabel.get(i).getNilaiUAS();
            listPrediksiNoLabel.add(prediksiNilaiNoLabel);
        }
        listPrediksiNoLabel.forEach((d) -> {
            System.out.println(d);
        });
    }

    private void newCasePrediction(RegressionLinear regresiEngine) {
        Double nilaiAktual = Double.parseDouble(txtNilai.getText());

        if (nilaiAktual != 0) {
            Double nilaiPrediksi = regresiEngine.getKoefisienRegA()
                    + regresiEngine.getKoefisienRegB()
                    * nilaiAktual;

            lblPrediksi.setText(format.format(nilaiPrediksi));
        } else {
            lblPrediksi.setText("0");
        }

    }

    private void showPerformance(List<Nilai> listTraining, List<Double> listPrediksi) {
        double rmse = (double) NumericEvaluation.calcRMSE(listTraining, listPrediksi);
        double mse = (double) NumericEvaluation.calcMSE(listTraining, listPrediksi);

        lblRmse.setText(format.format(rmse / 100));
        lblMse.setText(format.format(mse / 100));
    }

    private Boolean validateData() {
        return listDataTraining != null
                && !listDataTraining.isEmpty();
    }

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        if (validateData()) {
            RegressionLinear regresiEngine = new RegressionLinear();
            training(regresiEngine);
            predictDataNoLabel(regresiEngine);
            newCasePrediction(regresiEngine);
            viewPrediksi(listPrediksi);
            viewPrediksiNoLabel(listPrediksiNoLabel);
            showPerformance(listDataTraining, listPrediksi);
        } else {
            JOptionPane.showMessageDialog(this, "Data Training kosong", "Terjadi Kesalahan",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRunActionPerformed

    private void resetForm() {
        listDataTraining = new ArrayList<>();
        listDataTestingNoLabel = new ArrayList<>();
        listPrediksi = new ArrayList<>();
        listPrediksiNoLabel = new ArrayList<>();
        tblDataset.setModel(new DataTableModel(new ArrayList<>()));
        tblPrediksi.setModel(new PrediksiTableModel(new ArrayList<>()));
        tblPrediksiNoLabel.setModel(new PrediksiNoLabelTableModel(listPrediksiNoLabel));
        lblRmse.setText("0");
        lblMse.setText("0");
        txtNilai.setText("0");
        lblPrediksi.setText("0");
        //regresiEngine = new RegressionLinear();
    }

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetForm();
        btnLoadData.setEnabled(true);
        btnRun.setEnabled(false);
        btnReset.setEnabled(false);
        btnClose.setEnabled(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        resetForm();
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void loadDataSet() {
        resetForm();
        listDataTraining = Main.getDataRepository().getAllData();
        listDataTestingNoLabel = Main.getTestingDataRepository().getAllData();
//        cekStateButton();
        if (listDataTraining != null && !listDataTraining.isEmpty()) {
            tblDataset.setModel(new DataTableModel(listDataTraining));
            btnLoadData.setEnabled(false);
            btnRun.setEnabled(true);
            btnReset.setEnabled(true);
        } else {
            tblDataset.setModel(new DataTableModel(new ArrayList<>()));
            JOptionPane.showMessageDialog(this, "Data belum di Import !!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
        resetForm();
        loadDataSet();
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void txtNilaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNilaiMousePressed
        // TODO add your handling code here:
        txtNilai.selectAll();
    }//GEN-LAST:event_txtNilaiMousePressed

    public JButton getLoadButton() {
        return btnLoadData;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnRun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblMse;
    private javax.swing.JLabel lblPrediksi;
    private javax.swing.JLabel lblRmse;
    private javax.swing.JTable tblDataset;
    private javax.swing.JTable tblPrediksi;
    private javax.swing.JTable tblPrediksiNoLabel;
    private javax.swing.JTextField txtNilai;
    // End of variables declaration//GEN-END:variables
}
