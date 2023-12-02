package github.sh1rsh1n.task2;

import java.util.UUID;

@Table(name = "users")
public class Employee {

    @Column(name = "id", primaryKey = true)
    @ColumId
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    public UUID getId() {
        return id;
    }

    public Employee(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
