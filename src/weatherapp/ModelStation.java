package weatherapp;

public class ModelStation {
    String datemax, datemin;
    Double tmax, tmin, rainfl;
    int airfo;
    public ModelStation(double tmax, double tmin, int airfo, double rainfl, String datemax, String datemin){
        this.tmax = tmax;
        this.tmin = tmin;
        this.airfo = airfo;
        this.rainfl = rainfl;
        this.datemax = datemax;
        this.datemin = datemin;
    }


    public int getAirfo() {
        return airfo;
    }

    public void setAirfo(Integer airfo) {
        this.airfo = airfo;
    }

    public Double getRainfl() {
        return rainfl;
    }

    public void setRainfl(Double rainfl) {
        this.rainfl = rainfl;
    }

    public Double getTmax() {
        return tmax;
    }

    public void setTmax(Double tmax) {
        this.tmax = tmax;
    }

    public Double getTmin() {
        return tmin;
    }

    public void setTmin(Double tmin) {
        this.tmin = tmin;
    }

    public void setDatemax(String datemax) {
        this.datemax = datemax;
    }

    public void setDatemin(String datemin) {
        this.datemin = datemin;
    }

    public String getDatemax() { return datemax; }

    public String getDatemin() { return datemin; }

    public String toString(){
        return datemax+ ":" + tmax + ", " + datemin+ ":" + tmin + ", " + airfo + ", " + rainfl;
    }
}
