public class Cliente {
    public static int idCount = 0;
    private int id;

    public Cliente() {
        idCount++;
        this.id = idCount;
    }

    public int getId() {
        return id;
    }
}
