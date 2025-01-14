package modelRezolvat.src;

public class StudentRecord {
    private int id;
    private String name;
    private House house;
    private String authority;
    private int points;

    public StudentRecord(int id, String name, House house, String authority, int points) {
        this.id = id;
        this.name = name;
        this.house = house;
        this.authority = authority;
        this.points = points;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public House getHouse() { return house; }
    public String getAuthority() { return authority; }
    public int getPoints() { return points; }
}