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

public class SettingInformation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_information);

        mSetting_information_button1 = (Button) findViewById(R.id.setting_information_button1);
        //TODO 他の遷移まだ

        // 画面遷移 前に戻る
        mSetting_information_button1.setOnClickListener(view -> {
            Intent intent_mib = new Intent(getApplication(), SettingMain.class);
            startActivity(intent_mib);
        });
        // TODO 他の遷移まだ

    }
}
