package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private Button eastButton;
    private Button southButton;
    private Button westButton;
    private Button northButton;
    private Button navigateButton;
    private EditText editText;



    private EastButtonClickListener eastButtonClickListener = new EastButtonClickListener();
    private class EastButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String eastClicks = editText.getText().toString();
            eastClicks = eastClicks + ",EAST";
            editText.setText(eastClicks);
        }
    }

    private WestButtonClickListener westButtonClickListener = new WestButtonClickListener();
    private class WestButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String westClicks = editText.getText().toString();
            westClicks = westClicks + ",WEST";
            editText.setText(westClicks);
        }
    }

    private SouthButtonClickListener southButtonClickListener = new SouthButtonClickListener();
    private class SouthButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String southClicks = editText.getText().toString();
            southClicks = southClicks + ",SOUTH";
            editText.setText(southClicks);
        }
    }

    private NorthButtonClickListener northButtonClickListener = new NorthButtonClickListener();
    private class NorthButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String northClicks = editText.getText().toString();
            northClicks = northClicks + ",NORTH";
            editText.setText(northClicks);
        }
    }

    private NavigateButtonClickListener navigateButtonClickListener = new NavigateButtonClickListener();
    private class NavigateButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01SecondaryActivity.class);
            String numberOfClicks = editText.getText().toString();
            intent.putExtra("numberOfClicks", numberOfClicks);
            startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);
        editText = (EditText)findViewById(R.id.center_edit_text);
        editText.setText(String.valueOf(""));
        eastButton = (Button)findViewById(R.id.east_button);
        eastButton.setOnClickListener(eastButtonClickListener);
        northButton = (Button)findViewById(R.id.north_button);
        northButton.setOnClickListener(northButtonClickListener);
        southButton = (Button)findViewById(R.id.south_button);
        southButton.setOnClickListener(southButtonClickListener);
        westButton = (Button)findViewById(R.id.west_button);
        westButton.setOnClickListener(westButtonClickListener);
        navigateButton = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
        navigateButton.setOnClickListener(navigateButtonClickListener);

    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("count", editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("count")) {
            editText.setText(savedInstanceState.getString("count"));
        } else {
            editText.setText(String.valueOf(""));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "Activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}
