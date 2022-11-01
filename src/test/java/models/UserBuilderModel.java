package models;

public class UserBuilderModel {

    private final UserModel userModel;

    private UserBuilderModel() {
        this.userModel = new UserModel();
    }

    public static UserBuilderModel instanceUserObject() {
        return new UserBuilderModel();
    }

    public UserBuilderModel withFirstName(String firstName) {
        this.userModel.setFirstName(firstName);
        return this;
    }

    public UserBuilderModel withEmployeeId(String employeeId) {
        this.userModel.setEmployeeId(employeeId);
        return this;
    }

    public UserBuilderModel withLastName(String lastName) {
        this.userModel.setLastName(lastName);
        return this;
    }

    public UserBuilderModel withUserName(String userName) {
        this.userModel.setUserName(userName);
        return this;
    }

    public UserBuilderModel withPassword(String password) {
        this.userModel.setPassword(password);
        return this;
    }

    public UserModel build() {
        return userModel;
    }
}
