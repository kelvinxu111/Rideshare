@Entity
@Table(name = "Users")
public class Users{
    public int UserID{get;set;}
    public string Username {get;set;}
    public string DisplayName{get;set;}
    public string PhoneNumber{get;set;}
    public string Email{get;set;}
    public string Password{get;set;}
    public string Role{get;set;}
    public string LicenseNumber{get;set;}
    public int VehicleInfoID{get;set;}
    public DateTime Created{get;set;}
    public DateTime Updated{get;set;}
    public DateTime DeleteDate{get;set;}
    public boolean IsActivated{get;set;}
    // profile picture...?
}