//
// ChartCreator.java
// Aplikasi-Prediksi-Stok 
//
// Created by Agung Pramono on 29/06/2017 
// Copyright (c) 2017 Java Development. All rights reserved.
//
package com.agung.regresi.util;

import com.agung.regresi.entity.Nilai;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

/**
 * kelas untuk memnggambar grafik
 */
public class ChartCreator {

    private static List<Nilai> listLabel;
    private static List<Double> listLabelTarget;

    private static final String TITLE = "Grafik Perbandingan Data Prediksi dan Data Aktual";
    
    public ChartCreator(List<Nilai> listLabel, List<Double> listTarget) {
        ChartCreator.listLabel = listLabel;
        ChartCreator.listLabelTarget = listTarget;
    }

    private static XYDataset dataset() {
        XYSeries xYSeriesPredicted = new XYSeries("Data Aktual");
        XYSeries xYSeriesLabel = new XYSeries("Data Prediksi");

        int n = listLabel.size();
        for (int i = 0; i < n; i++) {
            xYSeriesPredicted.add(i + 1, listLabel.get(i).getNilaiUN());
        }

        int x = listLabelTarget.size();
        for (int y = 0; y < x; y++) {
            xYSeriesLabel.add(y + 1, listLabelTarget.get(y));
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(xYSeriesPredicted);
        dataset.addSeries(xYSeriesLabel);

        return dataset;
    }

    public static ChartPanel getTimeSeriesChart() {
        final XYDataset dataset = dataset();
        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
                TITLE,
                "Bulan",
                "Jumlah Prediksi",
                dataset,
                true,
                true,
                false
        );

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.BLACK);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            //atur warna garis
            renderer.setSeriesPaint(0, Color.BLUE);
            renderer.setSeriesPaint(1, Color.RED);
            //atur ketebalan garis
            renderer.setSeriesStroke(0, new BasicStroke(4.0f));
            renderer.setSeriesStroke(1, new BasicStroke(3.0f));
            //renderer.setBaseShapesVisible(true);
            //renderer.setBaseShapesFilled(true);
            //renderer.setDrawSeriesLineAsPath(true);
            plot.setRenderer(renderer);
        }
        NumberAxis axis = new NumberAxis("Data ke");
        //axis.setRange(new Range(0, 12),true,false);
        axis.setAutoRange(true);
        axis.setTickUnit(new NumberTickUnit(0.5));
        axis.setAutoRangeStickyZero(false);
        axis.setAutoRangeIncludesZero(false);
        plot.setDomainAxis(axis);

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseZoomable(false, false);

        return chartPanel;
    }

    public static ChartPanel getXYLineChart() {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                null, // chart title
                null, // x axis label
                null, // y axis label
                dataset(), // data
                true, // include legend
                true, // tooltips
                false // urls
        );

        chart.setBackgroundPaint(Color.WHITE);
        // get a reference to the plot for further customization...
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
        //DeviationRenderer renderer = new DeviationRenderer(true, false);

        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            //atur warna garis
            renderer.setSeriesPaint(0, Color.BLUE);
            renderer.setSeriesPaint(1, Color.RED);
            //atur ketebalan garis
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            renderer.setSeriesStroke(1, new BasicStroke(2.0f));

            //renderer.setBaseShapesVisible(true);
            //renderer.setBaseShapesFilled(true);

            renderer.setDrawSeriesLineAsPath(true);
            plot.setRenderer(renderer);
        }

        NumberAxis axis = new NumberAxis(null);
        axis.setAutoRangeIncludesZero(true);
        
        plot.setDomainAxis(axis);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseZoomable(true);
        return chartPanel;
    }
}
