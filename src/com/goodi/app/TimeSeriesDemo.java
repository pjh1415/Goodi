package com.goodi.app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Log;
import org.jfree.util.PrintStreamLogTarget;

/**
 * An example of a time series chart.  For the most part, default settings are used, except that
 * the renderer is modified to show filled shapes (as well as lines) at each data point.
 *
 */
public class TimeSeriesDemo extends ApplicationFrame {




	public TimeSeriesDemo(String title) {
		super(title);
	}

	public static ChartPanel chartPanel;
	/**
     * A demonstration application showing how to create a simple time series chart.  This
     * example uses monthly data.
     *
     * @param title  the frame title.
     */
/*    public TimeSeriesDemo(String title) {
        
        final XYDataset dataset = createDataset();
       final JFreeChart chart = createChart(dataset);
         chartPanel = new ChartPanel(chart);
       chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
       chartPanel.setMouseZoomable(true, false);
       setContentPane(chartPanel);

   }*/
    public ChartPanel TimeSerie() {
        
         final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
       ChartPanel  chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        chartPanel.setMouseZoomable(true, false);
        setContentPane(chartPanel);
		return chartPanel;

    }
    /**
     * Creates a chart.
     * 
     * @param dataset  a dataset.
     * 
     * @return A chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {

        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "나의 몸무게 & 평균 몸무게",
            "MONTH", "몸무게",
            dataset,
            true,
            true,
            false
        );

        chart.setBackgroundPaint(Color.white);

//        final StandardLegend sl = (StandardLegend) chart.getLegend();
//        sl.setDisplaySeriesShapes(true);

      

        Font labelFont=chart.getTitle().getFont();
        //한글 폰트 만들기
      Font title= new Font("굴림",labelFont.getStyle(),labelFont.getSize());
        //폰트 변경하기
        chart.getTitle().setFont(title);
        System.out.println(labelFont);
        
        //범례
        chart.getLegend().setItemFont(title);
        
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
//        plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
        
        
        //x축 폰트 생성
        Font labelFont2=plot.getDomainAxis().getLabelFont();
        Font xline=new Font("굴림",labelFont2.getStyle(),labelFont2.getSize());
        
        //x축 라벨,도메인 폰트 변경
        plot.getDomainAxis().setLabelFont(xline);
        plot.getDomainAxis().setTickLabelFont(xline);
        
        //y축 폰트 생성
        Font labelFont3=plot.getRangeAxis().getLabelFont();
        Font yline=new Font("굴림",labelFont3.getStyle(),labelFont3.getSize());
        
        //y축 라벨,도메인 폰트 변경
        plot.getRangeAxis().setLabelFont(yline);
        plot.getRangeAxis().setTickLabelFont(yline);
        
        
        final XYItemRenderer renderer = plot.getRenderer();
        if (renderer instanceof StandardXYItemRenderer) {
            final StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
         //   rr.setPlotShapes(true);
          //  rr.setPlotLines(true);
            rr.setShapesFilled(true);
            rr.setItemLabelsVisible(true);
        }
        
        final DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        
        return chart;

    }
    
    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    * 
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************
    
    /**
     * Creates a dataset, consisting of two series of monthly data.
     *
     * @return the dataset.
     */
    private XYDataset createDataset() {
        GregorianCalendar calendar = new GregorianCalendar();

        final TimeSeries s1 = new TimeSeries("나의 몸무게", Month.class);
        s1.add(new Month(calendar.get(Calendar.MONTH)-3, calendar.get(Calendar.YEAR)), 46);
        s1.add(new Month(calendar.get(Calendar.MONTH)-2, calendar.get(Calendar.YEAR)),50);
        s1.add(new Month(calendar.get(Calendar.MONTH)-1, calendar.get(Calendar.YEAR)), 52);
        s1.add(new Month(calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)), 52);
        s1.add(new Month(calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.YEAR)), 49);
        s1.add(new Month(calendar.get(Calendar.MONTH)+2, calendar.get(Calendar.YEAR)), 48);
        s1.add(new Month(calendar.get(Calendar.MONTH)+3, calendar.get(Calendar.YEAR)), 44);
 

        final TimeSeries s2 = new TimeSeries("평균몸무게", Month.class);
        s2.add(new Month(calendar.get(Calendar.MONTH)-3, calendar.get(Calendar.YEAR)), 46);
        s2.add(new Month(calendar.get(Calendar.MONTH)-2, calendar.get(Calendar.YEAR)),46);
        s2.add(new Month(calendar.get(Calendar.MONTH)-1, calendar.get(Calendar.YEAR)),46);
        s2.add(new Month(calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)), 46);
        s2.add(new Month(calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.YEAR)), 46);
        s2.add(new Month(calendar.get(Calendar.MONTH)+2, calendar.get(Calendar.YEAR)), 46);
        s2.add(new Month(calendar.get(Calendar.MONTH)+3, calendar.get(Calendar.YEAR)), 46);


        final TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);

        dataset.setDomainIsPointsInTime(true);

        return dataset;

    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        Log.getInstance().addTarget(new PrintStreamLogTarget());
        final TimeSeriesDemo demo = new TimeSeriesDemo("Time Series Demo 1");
       // demo.pack();
        demo.setSize(800 , 300);
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}

