package weatherapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadData {
    //here to readCSV and return a list for setting up table view
    public ObservableList<ModelTable> readCSV(String csv_name) {
        BufferedReader br;
        String[] fields;
        double tmax = 0;
        double tmin = 0;
        int airfo = 0;
        double rainfl = 0;
        double finalRainfl = 0;
        try {
            br = new BufferedReader(new FileReader(csv_name));
            String line = null;
            int lineNumber;
            List<Double> list_tmax = new ArrayList<Double>();
            List<Double> list_tmin = new ArrayList<Double>();

            //only read 2019 data
            for (lineNumber = 1; lineNumber < 109; lineNumber++) {
                if ((line = br.readLine()) != null){
                    if (lineNumber >= 97) {
                        fields = line.split(",");
                        list_tmax.add(Double.parseDouble(fields[2])); //here we get all the tmax data
                        list_tmin.add(Double.parseDouble(fields[3])); //here we get all the tmin data
                        airfo += Integer.parseInt(fields[4]); //here we get addition of air frost days
                        rainfl += Double.parseDouble(fields[5]); //here we get addition of rainfall
                        String year = fields[0];
                    } else { line.split(","); }
                } else { //return empty list if there is no data
                    return FXCollections.observableArrayList(new ModelTable("2019", 0, 0, 0, 0));
                }
                }

            tmax = getMax(list_tmax); //get the maximum tmax
            tmin = getMin(list_tmin); //get the minimum tmin
            BigDecimal bd = new BigDecimal(rainfl).setScale(2, RoundingMode.HALF_UP); //keep 2 decimal places
            finalRainfl = bd.doubleValue();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return FXCollections.observableArrayList(new ModelTable("2019", tmax, tmin, airfo, finalRainfl));
    }

    // Method for getting the maximum value in a list
    public static double getMax(List<Double> inputArray){
        double maxValue = inputArray.get(0);
        for(int i=1;i < inputArray.size();i++){
            if(inputArray.get(i) > maxValue){
                maxValue = inputArray.get(i);
            }
        }
        return maxValue;
    }

    // Method for getting the minimum value in a list
    public static double getMin(List<Double> inputArray){
        double minValue = inputArray.get(0);
        for(int i=1;i<inputArray.size();i++){
            if(inputArray.get(i) < minValue){
                minValue = inputArray.get(i);
            }
        }
        return minValue;
    }
    static List<Double> allMin = new ArrayList<Double>();
    static List<Double> allMax = new ArrayList<Double>();
    static List<Integer> allAf = new ArrayList<Integer>();
    static List<Double> allRain = new ArrayList<Double>();

    //Method for getting all values that scene2's charts needed
    public static void getAllMin(String name) {
        String csvPath = "weather_data/" + name + ".csv";

        String line;
        allMin.clear();
        allMax.clear();
        allAf.clear();
        allRain.clear();
        try {
            File file = new File(csvPath);
            Scanner inputStream = new Scanner(file);
            while (inputStream.hasNext()){
                line = inputStream.next();
                String[] fields = line.split(",");
                allMin.add(Double.parseDouble(fields[2]));
                allMax.add(Double.parseDouble(fields[3]));
                allAf.add(Integer.parseInt(fields[4]));
                allRain.add(Double.parseDouble(fields[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}


