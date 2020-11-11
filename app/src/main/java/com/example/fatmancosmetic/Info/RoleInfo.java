package com.example.fatmancosmetic.Info;

public class RoleInfo {

    //Roles table 4 columns
    private int ID;
    private String roleID;
    private String roleName;
    private String roleDescription;
    private int Status;

    //Constructor null
    public RoleInfo() {
    }

    //Constructor have ID
    public RoleInfo(int ID, String roleID, String roleName, String roleDescription, int status) {
        this.ID = ID;
        this.roleID = roleID;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        Status = status;
    }

    //Constructor haven't ID
    public RoleInfo(String roleID, String roleName, String roleDescription, int status) {
        this.roleID = roleID;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        Status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
