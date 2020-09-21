package com.whittaker.rectanglecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements OnEditorActionListener {

    private EditText editWidth;
    private EditText editHeight;
    private TextView numArea;
    private TextView numPerimeter;
    private String  widthString = "";
    private String  heightString = "";
    private String  areaString = "";
    private String  perimString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editHeight = findViewById(R.id.editHeight);
        editWidth = findViewById(R.id.editWidth);
        numArea = findViewById(R.id.numArea);
        numPerimeter = findViewById(R.id.numPerimeter);

        editHeight.setOnEditorActionListener(this);

        calcAndDisplay();
    }

    @Override
    public void onPause() {

        super.onPause();
    }

    @Override
    public void onResume() {

        super.onResume();

        calcAndDisplay();
    }

    public void calcAndDisplay()    {
        widthString = editWidth.getText().toString();
        heightString = editHeight.getText().toString();
        float widthFloat;
        float heightFloat;
        float area;
        float perimeter;

        if(widthString.equals("") || heightString.equals("")){
            widthFloat = 0;
            heightFloat = 0;
        }   else {
            widthFloat = Float.parseFloat(widthString);
            heightFloat = Float.parseFloat(heightString);
        }

        //calculates area and perimeter
        area = widthFloat * heightFloat;
        perimeter = (2 * widthFloat) + (2 * heightFloat);

        //sets strings to correctly formatted floats
        areaString = String.format(Locale.US, "%.2f", area);
        perimString = String.format(Locale.US, "%.2f", perimeter);

        //displays strings
        numArea.setText(areaString);
        numPerimeter.setText(perimString);

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE ||
                actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calcAndDisplay();
        }
        return false;
    }
}
