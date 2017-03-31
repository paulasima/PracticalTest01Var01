package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by student on 31.03.2017.
 */

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity{



    private TextView numberOfClicksTextView = null;
    private Button registerButton = null;
    private Button cancelButton = null;

    private RegisterButtonClickListener registerbuttonClickListener = new RegisterButtonClickListener();
    private class RegisterButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            setResult(RESULT_OK, null);
            finish();
        }
    }

    private CancelButtonClickListener cancelbuttonClickListener = new CancelButtonClickListener();
    private class CancelButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            setResult(RESULT_CANCELED, null);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);




        numberOfClicksTextView = (TextView)findViewById(R.id.number_of_clicks_text_view);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("numberOfClicks")) {
            String numberOfClicks = intent.getStringExtra("numberOfClicks");
            numberOfClicksTextView.setText(String.valueOf(numberOfClicks));
        }

        registerButton = (Button)findViewById(R.id.register_button);
        registerButton.setOnClickListener(registerbuttonClickListener);
        cancelButton = (Button)findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(cancelbuttonClickListener);
    }
}
