package de.haw.hamburg.parkassistant;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user_database";
    private static final String TAG = "DBHelper";
    private static final String TABLE_NAME = "login_info";
    private static final String COL1 = "email";
    private static final String COL2 = "password";
    private static final String COL3 = "username";


    public Database(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL1 +" PRIMARY KEY, " + COL2 + COL3 + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addUser(String email, String password, String username){
        System.out.println("here");
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        try{
            ContentValues values = new ContentValues();
            values.put(COL1, email);
            values.put(COL2, password);
            values.put(COL3, username);

            db.insertOrThrow(DATABASE_NAME, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e){
            System.out.println("An error occurred while trying to add a user to the database");
        } finally {
            db.endTransaction();
        }
    }

}
