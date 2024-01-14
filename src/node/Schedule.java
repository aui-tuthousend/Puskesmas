package node;

public class Schedule {
    String hari;
    String jam;
    String namaDoketer;

    public Schedule(String hari, String jam, String namaDoketer) {
        this.hari = hari;
        this.jam = jam;
        this.namaDoketer = namaDoketer;
    }

    public void viewJadwal(){
        System.out.println("Hari : "+hari);
        System.out.println("Jam  : "+jam);
    }
}
