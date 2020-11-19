package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="Users")
public class Users {
    @Id
    //Not sure how to generate this
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long UserID;
    private String Username;
    private String DisplayName;
    private String PhoneNumber;
    private String Email;
    private String Password;
    private String Role;
    private String LicenseNumber;
    @OneToOne(cascade = CascadeType.ALL)
    //????
    @JoinColumn(name ="VehicleID",referencedColumnName = "VehicleID")
    private Vehicles VehicleInfoID;
    private LocalDateTime Created;
    private LocalDateTime Updated;
    private LocalDateTime Deleted;
    private boolean IsActivated;
    @Lob
    private byte[] ProfilePicture;
    public Users(String username, String displayName, String phoneNumber, String email, String password,String role, String licenseNumber){
        this.Username=username;
        this.DisplayName=displayName;
        this.PhoneNumber=phoneNumber;
        this.Email=email;
        this.Password=password;
        this.Role=role;
        this.LicenseNumber=licenseNumber;
        this.Created=LocalDateTime.now();
        this.IsActivated=false;
    }

    public void setActivated(boolean activated) {
        IsActivated = activated;
    }

    public void setCreated(LocalDateTime created) {
        Created = created;
    }

    public void setDeleted(LocalDateTime deleted) {
        Deleted = deleted;
    }

    public void setLicenseNumber(String licenseNumber) {
        LicenseNumber = licenseNumber;
    }

    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setProfilePicture(byte[] profilePicture) {
        ProfilePicture = profilePicture;
    }

    public void setRole(String role) {
        Role = role;
    }

    public void setUpdated(LocalDateTime updated) {
        Updated = updated;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setVehicleInfoID(Vehicles vehicleInfoID) {
        VehicleInfoID = vehicleInfoID;
    }

    public long getUserID() {
        return UserID;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public String getEmail() {
        return Email;
    }

    public String getLicenseNumber() {
        return LicenseNumber;
    }

    public String getPassword() {
        return Password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getRole() {
        return Role;
    }

    public String getUsername() {
        return Username;
    }

    public Vehicles getVehicleInfoID() {
        return VehicleInfoID;
    }

    public byte[] getProfilePicture() {
        return ProfilePicture;
    }

    public LocalDateTime getCreated() {
        return Created;
    }

    public LocalDateTime getDeleted() {
        return Deleted;
    }

    public LocalDateTime getUpdated() {
        return Updated;
    }
}
