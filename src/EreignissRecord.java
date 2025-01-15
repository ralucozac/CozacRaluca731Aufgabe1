import java.util.Date;

public class EreignissRecord {
    private int id;
    private String mitgliedsname;
    private Casa casa;
    private String ereignis;
    private Date datum;

    public EreignissRecord(int id, String mitgliedsname, Casa casa, String ereignis, Date datum) {
        this.id = id;
        this.mitgliedsname = mitgliedsname;
        this.casa = casa;
        this.ereignis = ereignis;
        this.datum = datum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMitgliedsname() {
        return mitgliedsname;
    }

    public void setMitgliedsname(String mitgliedsname) {
        this.mitgliedsname = mitgliedsname;
    }

    public Casa getCasa() {
        return casa;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public String getEreignis() {
        return ereignis;
    }

    public void setEreignis(String ereignis) {
        this.ereignis = ereignis;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
