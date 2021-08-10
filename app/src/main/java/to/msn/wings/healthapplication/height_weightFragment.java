package to.msn.wings.healthapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;


public class height_weightFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.height_weight);

        mHeight = (EditText) findViewById(R.id.height);  // ユーザーが入力するフィールド(身長)
        mWeight = (EditText) findViewById(R.id.weight); //　ユーザーが入力するフィールド(体重)
        mText_bmi = (TextView) findViewById(R.id.text_bmi); // BMI値
        mHeight_weight_button = (Button) findViewById(R.id.height_weight_button);  //　ボタン

        ViewPager pager = findViewById(R.id.)
    }




    //
    private EditText mHeight;
    private EditText mWeight;
    private double mText_bmi = (double) mWeight / mHeight / mHeight; //　BMI=体重÷身長÷身長


    public void height_weight_button_onClick(View view) {
        // ボタンが押された時の処理　→　画面遷移
        String inputText =
    }




    
    public void btnSend_onClick(View view) {
        EditText txtName = findViewwById(R.id)
    }

}
