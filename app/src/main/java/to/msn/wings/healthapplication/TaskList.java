package to.msn.wings.healthapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.provider.MediaStore;

import androidx.appcompat.app.AppCompatActivity;

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

        // イメージボダンを設定
        mImageView_calendar = (ImageButton) findViewById(R.id.imageView_calendar);
        mImageView_graph = (ImageButton) findViewById(R.id.imageView_graph);
        mImageView_food = (ImageButton) findViewById(R.id.imageView_food);
        mImageView_exercise = (ImageButton) findViewById(R.id.imageView_exercise);



        // 各画面へ遷移
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



    // 現在日時の取得
    public static String getNowDate() {
        final DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        final Date mTask_date = new Date(System.currentTimeMillis());
        return df.format(mTask_date);
    }


    // チェックボックス判定
    @Override
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
}