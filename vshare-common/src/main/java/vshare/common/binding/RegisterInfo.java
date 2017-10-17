package vshare.common.binding;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RegisterInfo {
    @NotNull(message = "Email cannot be null")
    @NotEmpty
    private String userEmail;
    @NotNull
    @NotEmpty
    private String userName;
    @NotNull
    @NotEmpty
    private String userPassword;
    @NotNull
    @NotEmpty
    private String userConfirmPassword;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserConfirmPassword() {
        return userConfirmPassword;
    }

    public void setUserConfirmPassword(String userConfirmPassword) {
        this.userConfirmPassword = userConfirmPassword;
    }
}
