package com.example.fatmancosmetic.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

import com.example.fatmancosmetic.DBManager.DBManager;
import com.example.fatmancosmetic.Info.RoleInfo;

import java.util.ArrayList;

public class RoleModel extends DBManager {

    ArrayList<RoleInfo> listRole;

    //Roles table 5 columns
    private static final String TABLE_ROLE_NAME = "Roles";
    private static final String ID = "ID";
    private static final String ROLE_ID = "roleID";
    private static final String ROLE_NAME = "roleName";
    private static final String ROLE_DESCRIPTION = "roleDescription";
    private static final String ROLE_STATUS = "Status";


    public RoleModel(@Nullable Context context) {super(context);}

    // Function Get role from table to array
    public ArrayList<RoleInfo> getAllRole() {

        ArrayList<RoleInfo> roleList = new ArrayList<>();

        // Get data from database
        String query = "SELECT * FROM " + TABLE_ROLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            do {
                RoleInfo roleInfo = new RoleInfo();
                roleInfo.setID(cursor.getInt(0));
                roleInfo.setRoleID(cursor.getString(1));
                roleInfo.setRoleName(cursor.getString(2));
                roleInfo.setRoleDescription(cursor.getString(3));
                roleInfo.setStatus(cursor.getInt(4));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return  roleList;
    }

    // Function add new role
    public void addRole(RoleInfo roleInfo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(ROLE_ID, roleInfo.getRoleID());
        content.put(ROLE_NAME, roleInfo.getRoleName());
        content.put(ROLE_DESCRIPTION, roleInfo.getRoleDescription());
        content.put(ROLE_STATUS, roleInfo.getStatus());

        db.insert(TABLE_ROLE_NAME,null,content);
        db.close();
    }

    // Function update role
    public void updateRole (RoleInfo roleInfo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROLE_ID, roleInfo.getRoleID());
        contentValues.put(ROLE_NAME, roleInfo.getRoleName());
        contentValues.put(ROLE_DESCRIPTION, roleInfo.getRoleDescription());
        contentValues.put(ROLE_STATUS, roleInfo.getStatus());
        db.update(TABLE_ROLE_NAME,contentValues,ID + "= ? ",new String[] {String.valueOf(roleInfo.getID())});
        db.close();
    }

    // Function delete Role
    public void deleteRole(int id) {
        String sqlQuery = " UPDATE " + ROLE_STATUS + "= 0 FROM " + TABLE_ROLE_NAME + "WHERE " + ID + "= " + id;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sqlQuery);
        db.close();
    }

}
