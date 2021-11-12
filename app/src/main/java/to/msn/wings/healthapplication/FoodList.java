package to.msn.wings.healthapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.content.Intent;
import android.provider.MediaStore;
import android.net.Uri;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;



public class FoodList extends AppCompatActivity {
    private boolean flg = true;
    private ImageView mImage_view_morning;
    private ImageView mImage_view_lunch;
    private ImageView mImage_view_evening;
    private ImageView mImage_view_snack;
    private ImageButton mImageView_calendar;
    private ImageButton mImageView_graph;
    private ImageButton mImageView_food;
    private ImageButton mImageView_exercise;
    
    // 端末内の画像を取得
    private static final int RESULT_PICK_IMAGEFILE = 1000;
    private ImageView FoodMooningImg;
    private ImageView FoodLunchImg;
    private ImageView FoodDinnerImg;
    private ImageView FoodSnackImg;

    private TextView mFood_date;

    private Button mFood_button1;
    private Button mFood_button2;

    private EditText mFood_morning_txt;
    private EditText mFood_lunch_txt;
    private EditText mFood_dinner_txt;
    private EditText mFood_snack_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_list);

        mImage_view_morning = (ImageView) findViewById(R.id.image_view_morning);
        mImage_view_lunch = (ImageView) findViewById(R.id.image_view_lunch);
        mImage_view_evening = (ImageView) findViewById(R.id.image_view_evening);
        mImage_view_snack = (ImageView) findViewById(R.id.image_view_snack);

        // イメージボンを設定
        mImageView_calendar = (ImageButton) findViewById(R.id.imageView_calendar);
        mImageView_graph = (ImageButton) findViewById(R.id.imageView_graph);
        mImageView_food = (ImageButton) findViewById(R.id.imageView_food);
        mImageView_exercise = (ImageButton) findViewById(R.id.imageView_exercise);
        // 各食事ボタンを設定
        FoodMooningImg = (ImageView)findViewById(R.id.food_morning_img);
        FoodLunchImg = (ImageView)findViewById(R.id.food_lunch_img);
        FoodDinnerImg = (ImageView)findViewById(R.id.food_dinner_img);
        FoodSnackImg = (ImageView)findViewById(R.id.food_snack_img);

        mFood_date = (TextView) findViewById(R.id.food_date);

        mFood_button1 = (Button) findViewById(R.id.food_button1);
        mFood_button2 = (Button) findViewById(R.id.food_button2);

        mFood_morning_txt = (EditText) findViewById(R.id.food_morning_txt);
        mFood_lunch_txt = (EditText) findViewById(R.id.food_lunch_txt);
        mFood_dinner_txt = (EditText) findViewById(R.id.food_dinner_txt);
        mFood_snack_txt = (EditText) findViewById(R.id.food_snack_txt);


        // 画像フォルダの読み込みを設定
        findViewById(R.id.food_morning_btn).setOnClickListener(v -> {
            Intent intent_m = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent_m.addCategory(Intent.CATEGORY_OPENABLE);
            intent_m.setType("image/*");
            startActivityForResult(intent_m, RESULT_PICK_IMAGEFILE);
        });
        findViewById(R.id.food_lunch_btn).setOnClickListener(v -> {
            Intent intent_l = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent_l.addCategory(Intent.CATEGORY_OPENABLE);
            intent_l.setType("image/*");
            startActivityForResult(intent_l, RESULT_PICK_IMAGEFILE);
        });
        findViewById(R.id.food_dinner_btn).setOnClickListener(v -> {
            Intent intent_d = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent_d.addCategory(Intent.CATEGORY_OPENABLE);
            intent_d.setType("image/*");
            startActivityForResult(intent_d, RESULT_PICK_IMAGEFILE);
        });
        findViewById(R.id.food_snack_btn).setOnClickListener(v -> {
            Intent intent_s = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent_s.addCategory(Intent.CATEGORY_OPENABLE);
            intent_s.setType("image/*");
            startActivityForResult(intent_s, RESULT_PICK_IMAGEFILE);
        });


        // 画像パスからBitmapを作成、各ImageViewに格納　　　
        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
            if(requestCode == RESULT_PICK_IMAGEFILE && resultCode == RESULT_OK) {
                Uri uri = null;
                if(resultData != null) {
                    uri = resultData.getData();

                    try {
                        Bitmap bmp = getBitmapFromUri(uri);
                        FoodMooningImg.setImageBitmap(bmp);
                        FoodLunchImg.setImageBitmap(bmp);
                        FoodDinnerImg.setImageBitmap(bmp);
                        FoodSnackImg.setImageBitmap(bmp);
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private Bitmap getBitmapFromUri(Uri uri) throws IOException {
            ParcelFileDescriptor parcelFileDescriptor =
                    getContentResolver().openFileDescription(uri, "r");
            FileDescription fileDescription = parcelFileDescriptor.getFileDescriptor();
            Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
            parcelFileDescriptor.close();
            return image;
        }


        // 現在日時の取得
        public static String getNowDate() {
            final DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            final Date mFood_date = new Date(System.currentTimeMillis());
            return df.format(mFood_date);
        }



        // 各画面へ遷移(イメージボタンから)
        mImageView_calendar.setOnClickListener(v -> {
            if (flg) {
                Intent intent_c = new Intent(getApplication(), calendarFragment.class);
                startActivity(intent_c);
            }
        });
        mImageView_graph.setOnClickListener(v -> {
            if (flg) {
                Intent intent_g = new Intent(getApplication(), GraphFragment.class);
                startActivity(intent_g);
            }
        });
        mImageView_food.setOnClickListener(v -> {
            if (flg) {
                Intent intent_f = new Intent(getApplication(), FoodList.class);
                startActivity(intent_f);
            }
        });
        mImageView_exercise.setOnClickListener(v -> {
            if (flg) {
                Intent intent_e = new Intent(getApplication(), TaskList.class);
                startActivity(intent_e);
            }
        });

    }

    // 現在日時の取得
    public class GetDate {

        public static void main(String[] args) {
            // TODO 自動生成されたメソッド・スタブ

            // 当日
            Date nowDate = new Date();

            System.out.println(nowDate.toString());

            // yyyy-MM-dd形式へ
            String strDate = new SimpleDateFormat("yyyy-MM-dd").format(nowDate);


            Calendar cal = Calendar.getInstance();

            // 翌日
            cal.setTime(nowDate);
            cal.add(Calendar.DAY_OF_MONTH, 1);

            // yyyy-MM-dd形式へ
            String strNextDate = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());


            // 前日
            cal.setTime(nowDate);
            cal.add(Calendar.DAY_OF_MONTH, -1);


            // yyyy-MM-dd形式へ
            String strPreviousDate = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());


            // 前々日
            cal.setTime(nowDate);
            cal.add(Calendar.DAY_OF_MONTH, -2);


            // yyyy-MM-dd形式へ  Dby=day before yesterday
            String strDbyviousDate = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());

        }

    }

    // 前日　ボタン選択による画面遷移
    private void mInitial_button1_OnClick(View v) {
        FoodTestOpenHelper helper = new FoodTestOpenHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        // 朝食
        String morningimg_sql = "select morning_blob from initial_db where strPreviousDate";
        mImage_view_morning = (ImageView) morningimg_sql;
        // 昼食
        String lunchimg_sql = "select lunch_blob from initial_db where strPreviousDate";
        mImage_view_lunch = (ImageView) lunchimg_sql;
        // 夕食
        String dinnerimg_sql = "select dinner_blob from initial_db where strPreviousDate";
        mImage_view_evening = (ImageView) dinnerimg_sql;
        // 間食
        String snackimg_sql = "select snack_blob from initial_db where strPreviousDate";
        mImage_view_snack = (ImageView) snackimg_sql;
        // 朝食メモ
        String mormemo_sql = "select txt_one from initial_db where strPreviousDate";
        mFood_morning_txt = (EditText) mormemo_sql;
        // 昼食メモ
        String lunmemo_sql = "select txt_two from initial_db where strPreviousDate";
        mFood_lunch_txt = (EditText) lunmemo_sql;
        // 夕食メモ
        String dinmemo_sql = "select txt_three from initial_db where strPreviousDate";
        mFood_dinner_txt = (EditText) dinmemo_sql;
        // 間食メモ
        String snackmemo_sql = "select txt_four from initial_db where strPreviousDate";
        mFood_snack_txt = (EditText) snackmemo_sql;
    }

}