package node;

public class Schedule {
    public int idSchedule;
    public String hari;
    public String jam;
    public String namaDoketer;

    public Schedule(int id, String hari, String jam, String namaDoketer) {
        this.idSchedule = id;
        this.hari = hari;
        this.jam = jam;
        this.namaDoketer = namaDoketer;
    }
}
