package weatherapp;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class txtingData {
    public String[] station = new String[]{"Aberporth", "Armagh", "Ballypatrick Forest", "Bradford", "Braemar", "Camborne", "Cambridge NIAB", "Cardiff Bute Park",
            "Chivenor", "Cwmystwyth", "Dunstaffnage", "Durham", "Eastbourne", "Eskdalemuir", "Heathrow", "Hurn", "Lerwick",
            "Leuchars", "Lowestoft", "Manston", "Nairn", "Newton Rigg", "Oxford", "Paisley", "Ringway", "Ross-on-Wye",
            "Shawbury", "Sheffield", "Southampton", "Stornoway Airport", "Sutton Bonington", "Tiree", "Valley", "Waddington",
            "Whitby", "Wick Airport", "Yeovilton"};

    public void writeTXT() throws IOException {
        List<ModelStation> modelStations = readCSV(); //call readCSV() and get a list of stations
        File file = new File("station.txt");
        FileWriter fw = new FileWriter(file, false);
        PrintWriter pw = new PrintWriter(fw);

        //looping to write txt
        for (int i = 0 ; i < station.length ; i++){
            pw.println("Number: " + (i+1));
            pw.println("Station: " + station[i]);
            pw.println("Highest: " + "("+ modelStations.get(i).getDatemax()+")" + modelStations.get(i).getTmax());
            pw.println("Lowest: " + "("+ modelStations.get(i).getDatemin()+")" + modelStations.get(i).getTmin());
            pw.println("Average annual af: " + modelStations.get(i).getAirfo());
            pw.println("Average annual rainfall:" + modelStations.get(i).getRainfl());
            pw.println("");

        }

        pw.close();

    }

    //Method to read all the CSVs and return a list of Model Station
    public List<ModelStation> readCSV(){
        List<ModelStation> modelStations = new ArrayList<>();
        try {
            //looping 37 stations to read each csv
            for (int i = 0; i <=36 ; i++){
                String csvPath = "weather_data/" + station[i] + ".csv";
                File file = new File(csvPath);
                Scanner inputStream = new Scanner(file);
                Scanner secondStream = new Scanner(file);
                List<Double> list_tmax = new ArrayList<Double>();
                List<Double> list_tmin = new ArrayList<Double>();
                int airfo = 0;
                double rainfl = 0;
                int counter = 0;
                while(inputStream.hasNext()){
                    String line = inputStream.next();
                    String[] fields = line.split(",");
                    list_tmax.add(Double.parseDouble(fields[2])); //here we get all the tmax data
                    list_tmin.add(Double.parseDouble(fields[3])); //here we get all the tmin data
                    airfo += Integer.parseInt(fields[4]); //here we get addition of air frost days
                    rainfl += Double.parseDouble(fields[5]); //here we get addition of rainfall
                    counter += 1;
                }
                if (counter > 0) {
                    double tmax = getMax(list_tmax); //getting the maximum tmax
                    double tmin = getMin(list_tmin); //getting the minimum tmax
                    int ave_airfo = airfo / counter; // getting the average air frost days
                    double tmp_rainfl = rainfl / counter; // getting the average rainfall days
                    String datemax = null;
                    String datemin = null;
                    BigDecimal bd = new BigDecimal(tmp_rainfl).setScale(2, RoundingMode.HALF_UP);
                    double ave_rainfl = bd.doubleValue(); // round to the number of average rainfall days of 2 decimal places

                    while (secondStream.hasNext()){ //here we get the related year/month by the tmax and tmin we just got
                        String line = secondStream.next();
                        String[] fields  = line.split(",");
                        if (tmax == Double.parseDouble(fields[2])) {
                            datemax = fields[0] + "." + fields[1];
                        }
                        if (Double.parseDouble(fields[3]) == tmin) {
                            datemin = fields[0] + "." + fields[1];
                        }
                    }
                    ModelStation modelStation_tmp = new ModelStation(tmax, tmin, ave_airfo, ave_rainfl,datemax,datemin);
                    modelStations.add(modelStation_tmp);

                }
                else {
                    //there are empty CSVs we put 0 as the value
                    ModelStation modelStation_tm = new ModelStation(0,0,0,0,"","");
                    modelStations.add(modelStation_tm);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return modelStations;
    }

    public static double getMax(List<Double> inputArray){
        double maxValue = inputArray.get(0);
        for(int i=1;i < inputArray.size();i++){
            if(inputArray.get(i) > maxValue){
                maxValue = inputArray.get(i);
            }
        }
        return maxValue;
    }

    // Method for getting the minimum value
    public static double getMin(List<Double> inputArray) {
        double minValue = inputArray.get(0);
        for (int i = 1; i < inputArray.size(); i++) {
            if (inputArray.get(i) < minValue) {
                minValue = inputArray.get(i);
            }
        }
        return minValue;
    }

}
