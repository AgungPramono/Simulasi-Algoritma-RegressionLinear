/*
 *  LookUtil.java
 *  Prediksi-Nilai 
 * 
 *  Created by Agung Pramono on 21/10/2017 
 *  Copyright (c) 2017 Java Development. All rights reserved.
 */
package com.agung.regresi.util;

import com.jgoodies.looks.HeaderStyle;
import com.jgoodies.looks.Options;
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.DesertBlue;
import com.agung.regresi.ui.DataPanel;
import java.util.logging.Level;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author agung
 */
public class LookUtil {

    public static void plasticLaf(JComponent component) {
        try {
            PlasticLookAndFeel laf = new Plastic3DLookAndFeel();
            PlasticLookAndFeel.setCurrentTheme(new DesertBlue());
            component.putClientProperty(Options.HEADER_STYLE_KEY, HeaderStyle.BOTH);
            PlasticLookAndFeel.setTabStyle(PlasticLookAndFeel.BORDER_STYLE_KEY);
            PlasticLookAndFeel.setTabStyle(PlasticLookAndFeel.BORDER_STYLE_KEY);
            Options.setPopupDropShadowEnabled(true);
            UIManager.setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
