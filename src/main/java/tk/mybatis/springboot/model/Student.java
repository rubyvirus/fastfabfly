package tk.mybatis.springboot.model;

/**
 * Created by rubyvirusqq@gmail.com on 2017-2-5.
 */
public class Student {
    private int id;

    private String name;

    private Boolean isGood;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGood() {
        return isGood;
    }

    public void setGood(Boolean good) {
        isGood = good;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isGood=" + isGood +
                '}';
    }
}
