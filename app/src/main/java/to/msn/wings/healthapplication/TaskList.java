package to.msn.wings.healthapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TaskList extends AppCompatActivity {
    private EditText mTask1;
    private EditText mTask2;
    private EditText mTask3;
    private EditText mTask_txt1;
    private EditText mTask_txt2;
    private EditText mTask_txt3;
    private CheckBox mCheckBox1;
    private CheckBox mCheckBox2;
    private CheckBox mCheckBox3;
    private TextView mTask_date;
    private TextView mTask_achievement;
    private ImageButton mImageView_calendar;
    private ImageButton mImageView_graph;
    private ImageButton mImageView_food;
    private ImageButton mImageView_exercise;
    private Button mTask_button1;

    private boolean flg = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task);

        mTask1 = (EditText) findViewById(R.id.task1);
        mTask2 = (EditText) findViewById(R.id.task2);
        mTask3 = (EditText) findViewById(R.id.task3);
        mTask_txt1 = (EditText) findViewById(R.id.task_txt1);
        mTask_txt2 = (EditText) findViewById(R.id.task_txt2);
        mTask_txt3 = (EditText) findViewById(R.id.task_txt3);

        mCheckBox1 = (CheckBox) findViewById(R.id.checkBox1);
        mCheckBox2 = (CheckBox) findViewById(R.id.checkBox2);
        mCheckBox3 = (CheckBox) findViewById(R.id.checkBox3);

        mTask_date = (TextView) findViewById(R.id.task_date);
        mTask_achievement = (TextView) findViewById(R.id.task_achievement);

        // ??????????????????????????????
        mImageView_calendar = (ImageButton) findViewById(R.id.imageView_calendar);
        mImageView_graph = (ImageButton) findViewById(R.id.imageView_graph);
        mImageView_food = (ImageButton) findViewById(R.id.imageView_food);
        mImageView_exercise = (ImageButton) findViewById(R.id.imageView_exercise);

        mTask_button1 = (Button) findViewById(R.id.task_button1);



        // ??????????????????
        mImageView_calendar.setOnClickListener(view -> {
            if (flg) {
                Intent intent_c = new Intent(getApplication(), calendarFragment.class);
                startActivity(intent_c);
            }
        });
        mImageView_graph.setOnClickListener(view -> {
            if (flg) {
                Intent intent_g = new Intent(getApplication(), GraphFragment.class);
                startActivity(intent_g);
            }
        });
        mImageView_food.setOnClickListener(view -> {
            if (flg) {
                Intent intent_f = new Intent(getApplication(), FoodList.class);
                startActivity(intent_f);
            }
        });
        mImageView_exercise.setOnClickListener(view -> {
            if (flg) {
                Intent intent_e = new Intent(getApplication(), TaskList.class);
                startActivity(intent_e);
            }
        });

    }



    // ?????????????????????
    public static String getNowDate() {
        final DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        final Date mTask_date = new Date(System.currentTimeMillis());
        return df.format(mTask_date);
    }


    // ??????????????????????????????
    public void onClick(View view) {
        if(mCheckBox1.isChecked() == true && mCheckBox2.isChecked() == true && mCheckBox3.isChecked() == true) {
            mTask_achievement.setText("3/3 !!!");
        } else if ((mCheckBox1.isChecked() == true && mCheckBox2.isChecked() == true && mCheckBox3.isChecked() == false) ||
                (mCheckBox1.isChecked() == true && mCheckBox2.isChecked() == false && mCheckBox3.isChecked() == true) ||
                (mCheckBox1.isChecked() == false && mCheckBox2.isChecked() == true && mCheckBox3.isChecked() == true)) {
            mTask_achievement.setText("2/3 !!");
        } else if ((mCheckBox1.isChecked() == true && mCheckBox2.isChecked() == false && mCheckBox3.isChecked() == false) ||
                (mCheckBox1.isChecked() == false && mCheckBox2.isChecked() == true && mCheckBox3.isChecked() == false) ||
                (mCheckBox1.isChecked() == false && mCheckBox2.isChecked() == false && mCheckBox3.isChecked() == true)) {
            mTask_achievement.setText("1/3 !");
        } else {
            mTask_achievement.setText("0/3");
        }
    }


    // ?????????????????????
    public class GetDate {

        public void main(String[] args) {
            // ?????????????????????????????????????????????

            // ??????
            Date nowDate = new Date();

            System.out.println(nowDate.toString());

            // yyyy-MM-dd?????????
            String strDate = new SimpleDateFormat("yyyy-MM-dd").format(nowDate);


            Calendar cal = Calendar.getInstance();

            // ??????
            cal.setTime(nowDate);
            cal.add(Calendar.DAY_OF_MONTH, 1);

            // yyyy-MM-dd?????????
            String strNextDate = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());


            // ??????
            cal.setTime(nowDate);
            cal.add(Calendar.DAY_OF_MONTH, -1);


            // yyyy-MM-dd?????????
            String strPreviousDate = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());


            // ?????????
            cal.setTime(nowDate);
            cal.add(Calendar.DAY_OF_MONTH, -2);


            // yyyy-MM-dd?????????  Dby=day before yesterday
            String strDbyviousDate = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

        }

    }



    // ??????????????????????????????????????????????????????
    // ??????
    private void mInitial_button1_OnClick(View v) {
        InitialTestOpenHelper helper = new InitialTestOpenHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        // ????????????????????????
        String weight_sql = "select initial_weight from mInitial_date where strNextDate";
        mInitial_message2 = weight_sql;
    }

    // ??????
    private void mInitial_button2_OnClick(View v) {
        InitialTestOpenHelper helper = new InitialTestOpenHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        // ????????????????????????
        String weight_sql = "select initial_weight from initial_db where strPreviousDate";
        mInitial_weight = (EditText) weight_sql;
    }


    // ??????
    private void mTask_button1_OnClick(View v) {
        TaskTestOpenHelper helper = new TaskTestOpenHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        // ????????????(??????)
        String taskone_sql = "select task_one from task_db where strPreviousDate";
        mTask1 = (EditText) taskone_sql;
        // ????????????(??????)
        String tasktwo_sql = "select task_two from task_db where strPreviousDate";
        mTask2 = (EditText) tasktwo_sql;
        // ????????????(??????)
        String taskthree_sql = "select task_three from task_db where strPreviousDate";
        mTask3 = (EditText) taskthree_sql;
        // ?????????(??????)
        String memoone_sql = "select memo_one from task_db where strPreviousDate";
        mTask_txt1 = (EditText) memoone_sql;
        // ?????????(??????)
        String memotwo_sql = "select memo_two from task_db where strPreviousDate";
        mTask_txt2 = (EditText) memotwo_sql;
        // ?????????(??????)
        String memothree_sql = "select memo_three from task_db where strPreviousDate";
        mTask_txt3 = (EditText) memothree_sql;
        // ?????????(??????)
        String achieve_sql = "select achievement from task_db where strPreviousDate";
        mTask_achievement = (TextView) achieve_sql;
    }
}