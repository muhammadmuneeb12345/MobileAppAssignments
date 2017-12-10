package com.example.muhammadzahid.todolistappyoutube;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Muhammad Zahid on 11/4/2017.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_Name="taskapplication.db";
    public static final String DB_Table="Task";
    public static final String DB_Column="TaskName";

    public DBHelper(Context context) {
        super(context, DB_Name, null, 1);
       // SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+ DB_Table + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,TaskName TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ DB_Table);
        onCreate(sqLiteDatabase);
    }
    public boolean insertNewTask(String k) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DB_Column, k);
       Long result = db.insert(DB_Table,null,contentValues);
        //db.close();
        if(result == -1){
            return  false;
        }
        else {
            return  true;
        }
    }
    public void deleteTask(String task){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_Table,DB_Column + " = ?",new String[]{task});
      //  db.rawQuery("DELETE FROM "+ DB_Table+ " WHERE "+DB_Column+"= "+task,null);


    }
    public ArrayList<String> getTaskList(){
        ArrayList<String> tasklist = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
       // Cursor cursor = db.query(DB_Table,new String[]{"TaskName"},null,null,null,null,null);
        Cursor cursor = db.rawQuery("select * from "+DB_Table,null);
        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex("TaskName");
            tasklist.add(cursor.getString(index));
        }

        return tasklist;
    }
}
