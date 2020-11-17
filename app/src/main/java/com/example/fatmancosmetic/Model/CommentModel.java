package com.example.fatmancosmetic.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.fatmancosmetic.DBManager.DBManager;
import com.example.fatmancosmetic.Info.CommentInfo;
import com.example.fatmancosmetic.Info.ItemInfo;

import java.util.ArrayList;

public class CommentModel extends DBManager {

    private static final String TABLE_COMMENT_NAME = "Comments";
    private static final String ID = "ID";
    private static final String COMMENT_ID = "commentID";
    private static final String COMMENT_CUSTOMER_ID = "customerID";
    private static final String COMMENT_ITEM_ID = "itemID";
    private static final String COMMENT_DATE = "commentDate";
    private static final String COMMENT_CONTENT = "Content";
    private static final String COMMENT_STATUS = "Status";

    public CommentModel(@Nullable Context context) {
        super(context);
    }

    public ArrayList<CommentInfo> getAllComments() {
        ArrayList<CommentInfo> listComments = new ArrayList<>();
        try {
            // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_COMMENT_NAME;

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    CommentInfo commentInfo = new CommentInfo();
                    commentInfo.setID(cursor.getInt(0));
                    commentInfo.setCommentID(cursor.getString(1));
                    commentInfo.setCustomerID(cursor.getString(2));
                    commentInfo.setItemID(cursor.getString(3));
                    commentInfo.setCommentDate(cursor.getString(4));
                    commentInfo.setContent(cursor.getString(5));
                    commentInfo.setStatus(cursor.getInt(6));
                    listComments.add(commentInfo);
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
        return listComments;
    }

    public ArrayList<CommentInfo> getAllCommentByItemID(String itemID) {
        ArrayList<CommentInfo> listComments = new ArrayList<>();
        try {
            // Select All Query
            String selectQuery = "SELECT  * FROM " + TABLE_COMMENT_NAME + " WHERE Comments.itemID = '" + itemID + "'";

            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.moveToFirst()) {
                do {
                    CommentInfo commentInfo = new CommentInfo();
                    commentInfo.setID(cursor.getInt(0));
                    commentInfo.setCommentID(cursor.getString(1));
                    commentInfo.setCustomerID(cursor.getString(2));
                    commentInfo.setItemID(cursor.getString(3));
                    commentInfo.setCommentDate(cursor.getString(4));
                    commentInfo.setContent(cursor.getString(5));
                    commentInfo.setStatus(cursor.getInt(6));
                    listComments.add(commentInfo);
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
        return listComments;
    }

    public void addComment(CommentInfo commentInfo) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COMMENT_ID, commentInfo.getCommentID());
            contentValues.put(COMMENT_CUSTOMER_ID, commentInfo.getCustomerID());
            contentValues.put(COMMENT_ITEM_ID, commentInfo.getItemID());
            contentValues.put(COMMENT_DATE, commentInfo.getCommentDate());
            contentValues.put(COMMENT_CONTENT, commentInfo.getContent());
            contentValues.put(COMMENT_STATUS, commentInfo.getStatus());
            db.insert(TABLE_COMMENT_NAME, null, contentValues);
            db.close();
        } catch (Exception e) {
            Log.e("Exception: ", e.getMessage());
        }
    }
}
