package com.skilledanswers.skilledanswers.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.skilledanswers.skilledanswers.Model.AroundTheWebModel;
import com.skilledanswers.skilledanswers.Model.TopNewsModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nishanth on 3/10/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "task.db";
    private static final int DATABASE_VERSION = 1;
    /////////////////////////////
    public static final String NEWS_FEEDS_TABLE = "newsfeedstable";
    ////// col
    public static final String FEEDS_SLNO = "feedsslno";
    public static final String FEEDS_IMAGE = "feedsimage";
    public static final String FEEDS_HEADING = "feedsheading";
    public static final String FEEDS_SHORT_DESC = "feedsshortdesc";
    public static final String FEEDS_DESC = "feedsdesc";
    public static final String FEEDS_TIMESTAMP = "feedstimestamp";
    public static final String FEEDS_SEEN = "feedsseen";
    public static final String CASE = "caseee";
    ////////////////////////////////////////////////////////////////
    public static final String AROUND_THE_WEB_TABLE = "aroundthewebtable";
    //// col
    public static final String AROUND_SLNO = "arroundslno";
    public static final String AROUND_IMAGE = "aroundimage";
    public static final String ARROUND_HEADING = "aroundheading";
    ////////////////////////////////////////////////////////////////


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NEWS_FEEDS_TABLE = "CREATE TABLE " + NEWS_FEEDS_TABLE + "("
                + FEEDS_SLNO + " INTEGER PRIMARY KEY ," + FEEDS_IMAGE + " BLOB,"
                + FEEDS_HEADING + " TEXT," + FEEDS_SHORT_DESC + " TEXT," +FEEDS_DESC +" TEXT," +FEEDS_TIMESTAMP +" TEXT," +FEEDS_SEEN +" INTEGER," +CASE +" INTEGER" + ");";
        db.execSQL(CREATE_NEWS_FEEDS_TABLE);
        String CREATE_AROUND_THE_WEB_TABLE = "CREATE TABLE " + AROUND_THE_WEB_TABLE + "("
                + AROUND_SLNO + " INTEGER PRIMARY KEY ," + AROUND_IMAGE + " BLOB,"
                + ARROUND_HEADING + " TEXT" + ");";
        db.execSQL(CREATE_AROUND_THE_WEB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NEWS_FEEDS_TABLE);
        onCreate(db);

    }

    public void addFeedsItems(TopNewsModel items) {

            SQLiteDatabase database = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(FEEDS_SLNO, items.get_slno());
            values.put(FEEDS_IMAGE, items.get_newsImage());
            values.put(FEEDS_HEADING, items.get_newsHeading());
            values.put(FEEDS_SHORT_DESC, items.get_newsShortDesriprition());
            values.put(FEEDS_DESC, items.get_newsDescription());
            values.put(FEEDS_TIMESTAMP, items.get_timestamp());
            values.put(FEEDS_SEEN , items.get_seen());
            values.put(CASE, items.get_case());
            database.insert(NEWS_FEEDS_TABLE, null, values);
            database.close();

    }


    public  int getFeedsCount()
    {
        String query = "SELECT * FROM "+NEWS_FEEDS_TABLE;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(query,null);
        // cursor.close();
        return  cursor.getCount();

    }

    public TopNewsModel getSingleFeeds(int slno) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(NEWS_FEEDS_TABLE, new String[]{FEEDS_SLNO, FEEDS_IMAGE, FEEDS_HEADING, FEEDS_SHORT_DESC, FEEDS_DESC, FEEDS_TIMESTAMP, FEEDS_SEEN, CASE},
                FEEDS_SLNO + "=?", new String[]{String.valueOf(slno)}, null, null, null, null);
        if (cursor != null)

            cursor.moveToFirst();
        TopNewsModel model = new TopNewsModel(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),Integer.parseInt(cursor.getString(6)),Integer.parseInt(cursor.getString(7)));
        return model;
    }

    public List<TopNewsModel> getAllFeeds()
    {
        List<TopNewsModel>  itemsListStaffModels = new ArrayList<>();
        // select all qurey
        String selectQuery = "SELECT * FROM "+NEWS_FEEDS_TABLE;

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        ///// looping with all rows and adding it to list
        if(cursor.moveToFirst())
        {
            do {
                {
                    TopNewsModel model = new TopNewsModel();
                    model.set_slno(Integer.parseInt(cursor.getString(0)));
                    model.set_newsImage(Integer.parseInt(cursor.getString(1)));
                    model.set_newsHeading(cursor.getString(2));
                    model.set_newsShortDesriprition(cursor.getString(3));
                    model.set_newsDescription(cursor.getString(4));
                    model.set_timestamp(cursor.getString(5));
                    model.set_seen(Integer.parseInt(cursor.getString(6)));
                    model.set_case(Integer.parseInt(cursor.getString(7)));
                    itemsListStaffModels.add(model);
                }
            }while (cursor.moveToNext());
        }

        return  itemsListStaffModels;
    }
    //// updating the seen
    public  int upDateSeen(int slno , int newvalue)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FEEDS_SEEN,newvalue);
        return database.update(NEWS_FEEDS_TABLE , values, FEEDS_SLNO + " = '" + slno + "'", null);
    }

    ///////////////////////////////////////////////////////////////////////////////////
    //around the web
    public void addAroundTheWeb(AroundTheWebModel items) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AROUND_SLNO, items.get_Slno());
        values.put(AROUND_IMAGE, items.get_image());
        values.put(ARROUND_HEADING, items.get_heading());
        database.insert(AROUND_THE_WEB_TABLE, null, values);
        database.close();
    }

    public AroundTheWebModel getSingleAroundTheWeb(int slno) {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(AROUND_THE_WEB_TABLE, new String[]{AROUND_SLNO, AROUND_IMAGE, ARROUND_HEADING},
                AROUND_SLNO + "=?", new String[]{String.valueOf(slno)}, null, null, null ,null);
        if (cursor != null)
            cursor.moveToFirst();
        AroundTheWebModel model = new AroundTheWebModel(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)),cursor.getString(2));
        return model;
    }
}
