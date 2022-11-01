package utils;

import models.UserBuilderModel;
import models.UserModel;
import pages.PimPage;

public class Builder {

    public static UserModel buildBasicUser(){
        UserModel userModel = UserBuilderModel.instanceUserObject()
                .withFirstName("Jimena")
                .withLastName("Uran")
                .build();
        return userModel;
    }

    public static UserModel buildUserWithLoginInfo(){
        UserModel userModel = UserBuilderModel.instanceUserObject()
                .withFirstName("Sebastian")
                .withLastName("Garcia")
                .withUserName("sebastian.garcia")
                .withPassword("Admin123*")
                .build();
        return userModel;
    }

    public static UserModel buildUserWithWrongData(){
        UserModel userModel = UserBuilderModel.instanceUserObject()
                .withFirstName("")
                .withLastName("Garcia")
                .build();
        return userModel;
    }

    public static void createBasicUser(PimPage pimPage, UserModel userModel){
        basicInfo(pimPage, userModel);
        pimPage.saveBtn.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createWuser(PimPage pimPage, UserModel userModel){
        pimPage.addBtn.click();
        pimPage.firstName.sendKeys("");
        pimPage.lastName.sendKeys(userModel.getLastName());
        pimPage.saveBtn.click();
    }

    public static void createUser(PimPage pimPage, UserModel userModel){
        basicInfo(pimPage, userModel);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pimPage.createDetails.click();
        pimPage.username.sendKeys(userModel.getUserName());
        pimPage.password.get(0).sendKeys(userModel.getPassword());
        pimPage.password.get(1).sendKeys(userModel.getPassword());
        pimPage.saveBtn.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void basicInfo(PimPage pimPage, UserModel userModel){
        pimPage.addBtn.click();
        pimPage.firstName.sendKeys(userModel.getFirstName());
        pimPage.lastName.sendKeys(userModel.getLastName());
    }
}
