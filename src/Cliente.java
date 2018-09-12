public class Cliente {
    public static int idCount = 0;
    private int id;

    public Cliente() {
        idCount++;
        this.id = idCount;
        System.out.println("inserido cliente " + this.id);
    }

    public int getId() {
        return id;
    }
}
