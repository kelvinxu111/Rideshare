package model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.List;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {
    @Id
    //Not sure how to generate this
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "userId", columnDefinition = "varchar(255)")
    private UUID UserID;
    @Column(name = "userName")
    private String Username;
    @Column(name = "displayName")
    private String DisplayName;
    @Column(name = "phoneNumber")
    private String PhoneNumber;
    @Column(name = "email")
    private String Email;
    @Column(name = "password")
    private String Password;
    @Column(name = "role")
    private String Role;
    @Column(name = "licenseNumber")
    private String LicenseNumber;
    @OneToMany(mappedBy = "user")
    private List<Vehicles> vehicles;
    @Column(name = "created")
    private LocalDateTime Created;
    @Column(name = "updated")
    private LocalDateTime Updated;
    @Column(name = "deleted")
    private LocalDateTime Deleted;
    @Column(name = "isActivated")
    private boolean IsActivated;
    @Lob
    @Column(name = "profilePicture")
    private byte[] ProfilePicture;
    public Users(){

    }
    public Users(String username, String displayName, String phoneNumber, String email, String password, String role, String licenseNumber) {
        this.Username = username;
        this.DisplayName = displayName;
        this.PhoneNumber = phoneNumber;
        this.Email = email;
        this.Password = password;
        this.Role = role;
        this.LicenseNumber = licenseNumber;
        this.Created = LocalDateTime.now();
        this.IsActivated = false;
    }


}
