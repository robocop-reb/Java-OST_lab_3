package sample;

public class Record {
    private String date;
    private String cityname;
    private int lenghtofTalk;
    private int tarif;
    private String phoneNumber;

    public Record(String date, String cityname, int lenghtofTalk, int tarif, String phoneNumber) {
        this.date = date;
        this.cityname = cityname;
        this.lenghtofTalk = lenghtofTalk;
        this.tarif = tarif;
        this.phoneNumber = phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        cityname = cityname;
    }

    public int getLenghtofTalk() {
        return lenghtofTalk;
    }

    public void setLenghtofTalk(int lenghtofTalk) {
        this.lenghtofTalk = lenghtofTalk;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
