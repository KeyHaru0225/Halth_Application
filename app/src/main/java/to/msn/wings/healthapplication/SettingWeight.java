package to.msn.wings.healthapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class SettingWeight extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        mSetting_main_screen_weight_button1 = (Button) findViewById(R.id.setting_main_screen_weight_button1);
        //TODO  OK CANCEL入れる？

        // 画面遷移 前に戻る
        mSetting_main_screen_weight_button1.setOnClickListener(view -> {
            Intent intent_msw = new Intent(getApplication(), SettingMainScreen.class);
            startActivity(intent_mws);
        });
        // TODO OK CANCEL入れる？

    }
}