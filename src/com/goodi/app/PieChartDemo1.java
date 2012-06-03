
/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2011, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * ------------------
 * PieChartDemo1.java
 * ------------------
 * (C) Copyright 2003-2011, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   ;
 *
 * Changes
 * -------
 * 09-Mar-2005 : Version 1, copied from the demo collection that ships with
 *               the JFreeChart Developer Guide (DG);
 *
 */

package com.goodi.app;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a pie chart using
 * data from a {@link DefaultPieDataset}.
 */

public class PieChartDemo1 extends ApplicationFrame {

	 Statement st;
	 ResultSet rs;
	
	 Connection con;
	PreparedStatement ps;
	
	
	//static double cal=2600.0;
//	static String TANSU;
    private static final long serialVersionUID = 1L;

    {
        // set a theme using the new shadow generator feature available in
        // 1.0.14 - for backwards compatibility it is not enabled by default
  //      ChartFactory.setChartTheme(new StandardChartTheme("JFree/Shadow",
    //            true));
    }

    /**
     * Default constructor.
     *
     * @param title  the frame title.
     */
    public PieChartDemo1(String title) {
        super(title);
        setContentPane(createDemoPanel());
        JButton button1=new JButton();
        
        try {
			Class.forName(DbProperties.DRIVER_NAME);
			con=DriverManager.getConnection(DbProperties.URL, DbProperties.ID,DbProperties.PWD);
		} catch (ClassNotFoundException e) {
			System.out.println("로드실패");
		}catch(SQLException ae){
			System.out.println("연결실패");
		}
        
    }

    /**
     * Creates a sample dataset.
     *
     * @return A sample dataset.
     */
    private static PieDataset createDataset() {
    	WeightCon wc=new WeightCon();
    	wc.kcal();
    	double tan=wc.t_kcal*0.6;
    	tan=Math.round(tan*100)/100.0;
    	double gi=wc.t_kcal*0.2;
    	gi=Math.round(gi*100)/100.0;
    	double dan=wc.t_kcal*0.2;
    	dan=Math.round(dan*100)/100.;
    	System.out.println("칼로리넣기");
    	///여기에 칼로리값 받아와서 탄수화물 단백질 지방으로 나뉜다.

    	System.out.println("tan="+tan);
    	System.out.println("gi="+gi);
    	System.out.println("dan="+dan);
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("탄수화물="+tan+"cal", new Double(60.0));
        dataset.setValue("단백질="+gi+"cal", new Double(20.0));
        dataset.setValue("지방="+dan+"cal", new Double(20.0));
        return dataset;
    }

    /**
     * 
     * Creates a chart.
     *
     * @param dataset  the dataset.
     *
     * @return A chart.
     */
    private static JFreeChart createChart(PieDataset dataset) {
    	
        JFreeChart chart = ChartFactory.createPieChart(
            "권장영양섭취량",  // chart title
           dataset,             // data
            true,                // include legend
            true,
            false
        );
        
       

        System.out.println(chart.getTitle().getFont().getName());
        

        PiePlot plot = (PiePlot) chart.getPlot();
        
        //차트 내부 배경색 변경.
        plot.setBackgroundPaint(Color.white);

      
        //제목 한글로 변경
        Font labelFont=chart.getTitle().getFont();
        chart.getTitle().setFont(new Font("굴림",labelFont.getStyle(),labelFont.getSize()));
        
        //범례 한글로 변경
        chart.getLegend().setItemFont(new Font("굴림",labelFont.getStyle(),labelFont.getSize()));
        
        //라벨 한글폰트 변경
        Font labelFont2= plot.getLabelFont();
        plot.setLabelFont(new Font("돋움",labelFont.getStyle(),labelFont2.getSize()));
        plot.setSectionOutlinesVisible(false);
        plot.setNoDataMessage("No data available");
        return chart;

    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        
        //차트 외부 배경색 변경
        chart.setBackgroundPaint(Color.WHITE);
        
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
     
        return panel;
    }
    
 

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(String[] args) {

        // ******************************************************************
        //  More than 150 demo applications are included with the JFreeChart
        //  Developer Guide...for more information, see:
        //
        //  >   http://www.object-refinery.com/jfreechart/guide.html
        //
        // ******************************************************************

        PieChartDemo1 demo = new PieChartDemo1("Pie Chart Demo 1");
       // demo.pack();
        demo.setSize(200, 200);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }


}

