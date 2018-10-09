package com.swati.dell.adddeleteedit;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class TaskDbHelper extends SQLiteOpenHelper {


    public TaskDbHelper(Context context) {
        super(context, TaskContrast.DB_NAME, null, TaskContrast.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TaskContrast.TaskEntry.TABLE + " ( " +
                TaskContrast.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TaskContrast.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TaskContrast.TaskEntry.TABLE);
        onCreate(db);
    }

}
