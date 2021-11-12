package to.msn.wings.healthapplication;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.sql.Blob;

public class HealthAppDB extends SQLiteOpenHelper {
    static final private String DBNAME = "health.sqlite";
    static final private int VERSION = 1;

    // コンストラクタ
    public HealthAppDB(Context context) { super(context, DBNAME, null, VERSION); }

    @Override
    public void onOpen(SQLiteDatabase db) { super.onOpen(db); }

    // height_weightFragment DB
    @Override
    public void onCreate(SQLiteDatabase db) {
        // テーブル作成
        db.execSQL("CREATE TABLE heightweight (" +
                "height PRIMARY KEY, weight DOUBLE)");
        db.execSQL("INSERT INTO heightweight(height, weight)" +
                " VALUES(height_weightFragment.mHeight, height_weightFragment.mWeight)");


        // initial_screenFragment DB
        db.execSQL("CREATE TABLE initial (" +
                "date PRIMARY KEY, before_weight DOUBLE, today_weight DOUBLE, ratio DOUBLE, morning_image BLOB, lunch_image BLOB, dinner_image BLOB, snack_image BLOB, memo TEXT)");
        String[] date = {};
        Double[] before_weight = {};
        Double[] ratio = {};
        Blob[] morning_image = {};
        Blob[] lunch_image = {};
        Blob[] dinner_image = {};
        Blob[] snack_image = {};
        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO initial(date, before_weight, ratio, morning_image, lunch_image, dinner_image, snack_image) VALUES(?, ?, ?, ?, ?, ?, ?)");
            for (int i = 0; i < date.length; i++) {
                sql.bindString(1, date[i]);
                sql.bindDouble(2, before_weight[i]);
                sql.bindDouble(3, ratio[i]);
                sql.bindBlob(4, morning_image[i]);
                sql.bindBlob(5, lunch_image[i]);
                sql.bindBlob(6, dinner_image[i]);
                sql.bindBlob(7, snack_image[i]);
                sql.executeInsert();
            }
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }


        // calendarFragment DB
        db.execSQL("CREATE TABLE calendar(" +
                "calendar_date PRIMARY KEY, weight_mini DOUBLE)");
        String[] calendar_date = {};
        Double[] weight_mini = {};
        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO calendar(calendar_date, weight_mini) VALUES(?, ?)");
            for (int i = 0; i < calendar_date.length; i++) {
                sql.bindString(1, calendar_date[i]);
                sql.bindDouble(2, weight_mini[2]);
                sql.executeInsert();
            }
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }


        // GraphFragment DB


        // TaskList DB
        //TODO CHECKを修正
        db.execSQL("CREATE TABLE task(" +
                "task_date PRIMARY KEY, check CHECK, task_list TEXT, memo TEXT, achivement TEXT)");
        String[] task_date = {};
        // check
        String[] memo = {};
        String[] achivement = {};
        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO task(task_date, , memo, achivement) VALUES(?, ?, ?, ?)");
            for(int i=0; i < task_date.length; i++) {
                sql.bindString(1, task_date[i]);
                // check
                sql.bindString(3, memo[i]);
                sql.bindString(4, achivement[i]);
            }
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }


        // FoodList DB
        db.execSQL("CREATE TABLE foodlist (" +
                "food_date TEXT PRIMARY KEY, morning_image BLOB, morning_memo TEXT, lunch_image BLOB, lunch_memo TEXT, dinner_image BLOB, dinner_memo TEXT, snack_image BLOB, snack_memo TEXT)");
        String[] food_date = {};
        Blob[] morning_image = {};
        String[] morning_text = {};
        Blob[] lunch_image = {};
        String[] lunch_text = {};
        Blob[] dinner_image = {};
        String[] dinner_text = {};
        Blob[] snack_image = {};
        String[] snack_text = {};
        db.beginTransaction();
        try {
            SQLiteStatement sql = db.compileStatement(
                    "INSERT INTO foodlist(food_date, morning_image, morning_text, lunch_image, lunch_text, dinner_image, dinner_text, snack_image, snack_text) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            for(int i=0; i < food_date.length; i++) {
                sql.bindString(1, food_date[i]);
                sql.bindBlob(2, morning_image[i]);
                sql.bindString(3, morning_text[i]);
                sql.bindBlob(4, lunch_image[i]);
                sql.bindString(5, lunch_text[i]);
                sql.bindBlob(6, dinner_image[i]);
                sql.bindString(7, dinner_text[i]);
                sql.bindBlob(8, snack_image[i]);
                sql.bindString(9, snack_text[i]);
                sql.executeInsert();
            }
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }


        // SettingHeight DB  上書き更新
        db.execSQL("CREATE TABLE setting_height (" +
                "setting_height DOUBLE PRIMARY KEY)");
        Double[] setting_height = {};



        // SettingWeight DB 　上書き更新

        db.execSQL("INSERT INTO initial(date, before_weight, today_weight, ratio, morning_image, lunch_image, dinner_image, snack_image)" +
                "VALUES()");
    }









    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS heightweight");
        onCreate(db);
    }
}
