package weatherapp;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

import java.util.List;

public class Scene2Controller {
    @FXML
    Button backBtn;

    @FXML
    AnchorPane childPane2;

    @FXML
    LineChart<String, Number> minChart, maxChart, afChart;

    @FXML
    BarChart<String, Number> rainChart;

    @FXML
    private NumberAxis afNumberAxis;

//here we create 4 method to setup 4 charts in scene2 by giving values from Scene1Controller
    @FXML
    public void setMinCharts(List<Double> tMin){ //put every year as a series, months as x axis
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        XYChart.Series<String, Number> s1 = new XYChart.Series<String, Number>();
        s1.setName("2011");
        XYChart.Series<String, Number> s2 = new XYChart.Series<String, Number>();
        s2.setName("2012");
        XYChart.Series<String, Number> s3 = new XYChart.Series<String, Number>();
        s3.setName("2013");
        XYChart.Series<String, Number> s4 = new XYChart.Series<String, Number>();
        s4.setName("2014");
        XYChart.Series<String, Number> s5 = new XYChart.Series<String, Number>();
        s5.setName("2015");
        XYChart.Series<String, Number> s6 = new XYChart.Series<String, Number>();
        s6.setName("2016");
        XYChart.Series<String, Number> s7 = new XYChart.Series<String, Number>();
        s7.setName("2017");
        XYChart.Series<String, Number> s8 = new XYChart.Series<String, Number>();
        s8.setName("2018");
        XYChart.Series<String, Number> s9 = new XYChart.Series<String, Number>();
        s9.setName("2019");
        for (int i = 0 ; i < 12; i++){
            s1.getData().add(new XYChart.Data<String, Number>(month[i],tMin.get(i)));
        }
        for (int i = 0, n = 12; i < 12 ; i++, n++){
            s2.getData().add(new XYChart.Data<String, Number>(month[i],tMin.get(n)));
        }
        if (tMin.size()> 30) { //avoid CSVs that less than 30 columns
            for (int i = 0, n = 24; i < 12; i++, n++) {
                s3.getData().add(new XYChart.Data<String, Number>(month[i], tMin.get(n)));
            }
            for (int i = 0, n = 36; i < 12; i++, n++) {
                s4.getData().add(new XYChart.Data<String, Number>(month[i], tMin.get(n)));
            }
            for (int i = 0, n = 48; i < 12; i++, n++) {
                s5.getData().add(new XYChart.Data<String, Number>(month[i], tMin.get(n)));
            }
            for (int i = 0, n = 60; i < 12; i++, n++) {
                s6.getData().add(new XYChart.Data<String, Number>(month[i], tMin.get(n)));
            }
            for (int i = 0, n = 72; i < 12; i++, n++) {
                s7.getData().add(new XYChart.Data<String, Number>(month[i], tMin.get(n)));
            }
            for (int i = 0, n = 84; i < 12; i++, n++) {
                s8.getData().add(new XYChart.Data<String, Number>(month[i], tMin.get(n)));
            }
            for (int i = 0, n = 96; i < 12; i++, n++) {
                s9.getData().add(new XYChart.Data<String, Number>(month[i], tMin.get(n)));
            }
        }
        minChart.getData().add(s1);
        minChart.getData().add(s2);
        minChart.getData().add(s3);
        minChart.getData().add(s4);
        minChart.getData().add(s5);
        minChart.getData().add(s6);
        minChart.getData().add(s7);
        minChart.getData().add(s8);
        minChart.getData().add(s9);
        minChart.setAnimated(false);
    }

    @FXML
    public void setMaxCharts(List<Double> tMax){  //put every year as a series, months as x axis
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        XYChart.Series<String, Number> s1 = new XYChart.Series<String, Number>();
        s1.setName("2011");
        XYChart.Series<String, Number> s2 = new XYChart.Series<String, Number>();
        s2.setName("2012");
        XYChart.Series<String, Number> s3 = new XYChart.Series<String, Number>();
        s3.setName("2013");
        XYChart.Series<String, Number> s4 = new XYChart.Series<String, Number>();
        s4.setName("2014");
        XYChart.Series<String, Number> s5 = new XYChart.Series<String, Number>();
        s5.setName("2015");
        XYChart.Series<String, Number> s6 = new XYChart.Series<String, Number>();
        s6.setName("2016");
        XYChart.Series<String, Number> s7 = new XYChart.Series<String, Number>();
        s7.setName("2017");
        XYChart.Series<String, Number> s8 = new XYChart.Series<String, Number>();
        s8.setName("2018");
        XYChart.Series<String, Number> s9 = new XYChart.Series<String, Number>();
        s9.setName("2019");
        for (int i = 0 ; i < 12; i++){
            s1.getData().add(new XYChart.Data<String, Number>(month[i],tMax.get(i)));
        }
        for (int i = 0, n = 12; i < 12 ; i++, n++){
            s2.getData().add(new XYChart.Data<String, Number>(month[i],tMax.get(n)));
        }
        if (tMax.size()>30) {
            for (int i = 0, n = 24; i < 12; i++, n++) {
                s3.getData().add(new XYChart.Data<String, Number>(month[i], tMax.get(n)));
            }
            for (int i = 0, n = 36; i < 12; i++, n++) {
                s4.getData().add(new XYChart.Data<String, Number>(month[i], tMax.get(n)));
            }
            for (int i = 0, n = 48; i < 12; i++, n++) {
                s5.getData().add(new XYChart.Data<String, Number>(month[i], tMax.get(n)));
            }
            for (int i = 0, n = 60; i < 12; i++, n++) {
                s6.getData().add(new XYChart.Data<String, Number>(month[i], tMax.get(n)));
            }
            for (int i = 0, n = 72; i < 12; i++, n++) {
                s7.getData().add(new XYChart.Data<String, Number>(month[i], tMax.get(n)));
            }
            for (int i = 0, n = 84; i < 12; i++, n++) {
                s8.getData().add(new XYChart.Data<String, Number>(month[i], tMax.get(n)));
            }
            for (int i = 0, n = 96; i < 12; i++, n++) {
                s9.getData().add(new XYChart.Data<String, Number>(month[i], tMax.get(n)));
            }
        }
        maxChart.getData().add(s1);
        maxChart.getData().add(s2);
        maxChart.getData().add(s3);
        maxChart.getData().add(s4);
        maxChart.getData().add(s5);
        maxChart.getData().add(s6);
        maxChart.getData().add(s7);
        maxChart.getData().add(s8);
        maxChart.getData().add(s9);
        maxChart.setAnimated(false);
    }

    @FXML
    public void setAfCharts(List<Integer> af){  //put every year as a series, months as x axis
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        XYChart.Series<String, Number> s1 = new XYChart.Series<String, Number>();
        s1.setName("2011");
        XYChart.Series<String, Number> s2 = new XYChart.Series<String, Number>();
        s2.setName("2012");
        XYChart.Series<String, Number> s3 = new XYChart.Series<String, Number>();
        s3.setName("2013");
        XYChart.Series<String, Number> s4 = new XYChart.Series<String, Number>();
        s4.setName("2014");
        XYChart.Series<String, Number> s5 = new XYChart.Series<String, Number>();
        s5.setName("2015");
        XYChart.Series<String, Number> s6 = new XYChart.Series<String, Number>();
        s6.setName("2016");
        XYChart.Series<String, Number> s7 = new XYChart.Series<String, Number>();
        s7.setName("2017");
        XYChart.Series<String, Number> s8 = new XYChart.Series<String, Number>();
        s8.setName("2018");
        XYChart.Series<String, Number> s9 = new XYChart.Series<String, Number>();
        s9.setName("2019");
        for (int i = 0 ; i < 12; i++){
            s1.getData().add(new XYChart.Data<String, Number>(month[i],af.get(i)));
        }
        for (int i = 0, n = 12; i < 12 ; i++, n++){
            s2.getData().add(new XYChart.Data<String, Number>(month[i],af.get(n)));
        }
        if (af.size()>30) {
            for (int i = 0, n = 24; i < 12; i++, n++) {
                s3.getData().add(new XYChart.Data<String, Number>(month[i], af.get(n)));
            }
            for (int i = 0, n = 36; i < 12; i++, n++) {
                s4.getData().add(new XYChart.Data<String, Number>(month[i], af.get(n)));
            }
            for (int i = 0, n = 48; i < 12; i++, n++) {
                s5.getData().add(new XYChart.Data<String, Number>(month[i], af.get(n)));
            }
            for (int i = 0, n = 60; i < 12; i++, n++) {
                s6.getData().add(new XYChart.Data<String, Number>(month[i], af.get(n)));
            }
            for (int i = 0, n = 72; i < 12; i++, n++) {
                s7.getData().add(new XYChart.Data<String, Number>(month[i], af.get(n)));
            }
            for (int i = 0, n = 84; i < 12; i++, n++) {
                s8.getData().add(new XYChart.Data<String, Number>(month[i], af.get(n)));
            }
            for (int i = 0, n = 96; i < 12; i++, n++) {
                s9.getData().add(new XYChart.Data<String, Number>(month[i], af.get(n)));
            }
        }
        afChart.getData().add(s1);
        afChart.getData().add(s2);
        afChart.getData().add(s3);
        afChart.getData().add(s4);
        afChart.getData().add(s5);
        afChart.getData().add(s6);
        afChart.getData().add(s7);
        afChart.getData().add(s8);
        afChart.getData().add(s9);
        afChart.setAnimated(false);
        afNumberAxis.setTickLabelFormatter(new StringConverter<Number>() {
            @Override
            public String toString(Number number) {
                return String.valueOf(number.intValue());
            }

            @Override
            public Number fromString(String s) {
                Number val = Double.parseDouble(s);
                return val.intValue() ;
            }
        });

    }

    @FXML
    public void setRainCharts(List<Double> rain){  //put every year as a series, months as x axis
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        XYChart.Series<String, Number> s1 = new XYChart.Series<String, Number>();
        s1.setName("2011");
        XYChart.Series<String, Number> s2 = new XYChart.Series<String, Number>();
        s2.setName("2012");
        XYChart.Series<String, Number> s3 = new XYChart.Series<String, Number>();
        s3.setName("2013");
        XYChart.Series<String, Number> s4 = new XYChart.Series<String, Number>();
        s4.setName("2014");
        XYChart.Series<String, Number> s5 = new XYChart.Series<String, Number>();
        s5.setName("2015");
        XYChart.Series<String, Number> s6 = new XYChart.Series<String, Number>();
        s6.setName("2016");
        XYChart.Series<String, Number> s7 = new XYChart.Series<String, Number>();
        s7.setName("2017");
        XYChart.Series<String, Number> s8 = new XYChart.Series<String, Number>();
        s8.setName("2018");
        XYChart.Series<String, Number> s9 = new XYChart.Series<String, Number>();
        s9.setName("2019");
        for (int i = 0 ; i < 12; i++){
            s1.getData().add(new XYChart.Data<String, Number>(month[i],rain.get(i)));
        }
        for (int i = 0, n = 12; i < 12 ; i++, n++){
            s2.getData().add(new XYChart.Data<String, Number>(month[i],rain.get(n)));
        }
        if (rain.size()>30) {
            for (int i = 0, n = 24; i < 12; i++, n++) {
                s3.getData().add(new XYChart.Data<String, Number>(month[i], rain.get(n)));
            }
            for (int i = 0, n = 36; i < 12; i++, n++) {
                s4.getData().add(new XYChart.Data<String, Number>(month[i], rain.get(n)));
            }
            for (int i = 0, n = 48; i < 12; i++, n++) {
                s5.getData().add(new XYChart.Data<String, Number>(month[i], rain.get(n)));
            }
            for (int i = 0, n = 60; i < 12; i++, n++) {
                s6.getData().add(new XYChart.Data<String, Number>(month[i], rain.get(n)));
            }
            for (int i = 0, n = 72; i < 12; i++, n++) {
                s7.getData().add(new XYChart.Data<String, Number>(month[i], rain.get(n)));
            }
            for (int i = 0, n = 84; i < 12; i++, n++) {
                s8.getData().add(new XYChart.Data<String, Number>(month[i], rain.get(n)));
            }
            for (int i = 0, n = 96; i < 12; i++, n++) {
                s9.getData().add(new XYChart.Data<String, Number>(month[i], rain.get(n)));
            }
        }
        rainChart.getData().add(s1);
        rainChart.getData().add(s2);
        rainChart.getData().add(s3);
        rainChart.getData().add(s4);
        rainChart.getData().add(s5);
        rainChart.getData().add(s6);
        rainChart.getData().add(s7);
        rainChart.getData().add(s8);
        rainChart.getData().add(s9);
        rainChart.setAnimated(false);
    }

}
