package to.msn.wings.healthapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
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
import androidx.print.PrintHelper;

public class SettingData extends AppCompatActivity {

    private Button mSetting_button_data1;
    private Button mSetting_data_button2;

    private PrintManager printManager;
    private Object PrintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_data);

        mSetting_button_data1 = (Button) findViewById(R.id.setting_button_data1);
        mSetting_data_button2 = (Button) findViewById(R.id.setting_data_button2);



        mSetting_data_button2.setOnClickListener(v ->
            // PDFで印刷　41～73行目
            PrintManager printManager = (PrintManager) context.getSystemService(Context.PRINT_SERVICE);
            PrintDocumentAdapter adapter = new TestPrintDocumentAdapter(this);
            printManager.print("job_name", adapter, null);

            // WebView印刷
            private void printWebView(WebView webView) {
                PrintDocumentAdapter adapter = webView.createPrintDocumentAdapter();
                PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);
                printManager.print("job_name", adapter, null);
            }

            // Bitmap印刷
            private void printBitmap(Bitmap bitmap) {
                PrintHelper printHelper = new PrintHelper(context);
                printHelper.setColorMode(PrintHelper.COLOR_MODE_COLOR);
                printHelper.setScaleMode(PrintHelper.SCALE_MODE_FIT);
                printHelper.printBitmap("job_name", bitmap);
            }

            // Viewの内容を印刷
            private void printWindow() {
                View view = getWindow().getDecorView();
                Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                view.draw(canvas);

                PrintHelper printHelper = new PrintHelper(this);
                printHelper.setColorMode(PrintHelper.COLOR_MODE_COLOR);
                printHelper.setScaleMode(PrintHelper.SCALE_MODE_FIT);
                printHelper.printBitmap("view", bitmap);
            }

        }



        // 画面遷移 前に戻る
        mSetting_button_data1.setOnClickListener(v -> {
            Intent intent_d1 = new Intent(getApplication(), SettingMain.class);
            startActivity(intent_d1);
        });
    }
}
