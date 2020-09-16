package weatherapp;

public class ModelTable {
    String year;
    Double tmax, tmin, rainfl;
    int airfo;
    public ModelTable(String year, double tmax, double tmin, int airfo, double rainfl){
        this.year = year;
        this.tmax = tmax;
        this.tmin = tmin;
        this.airfo = airfo;
        this. rainfl = rainfl;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
}
