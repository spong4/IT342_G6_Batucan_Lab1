package IT342.G6.Batucan.Lab1.Dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
    public String getEmail() {
        return this.email;
    }
}