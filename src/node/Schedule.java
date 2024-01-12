package node;

public class Schedule {
    String hari;
    String jam;

    public Schedule(String hari, String jam) {
        this.hari = hari;
        this.jam = jam;
    }

    public void viewJadwal(){
        System.out.println("Hari : "+hari);
        System.out.println("Jam  : "+jam);
    }
}
