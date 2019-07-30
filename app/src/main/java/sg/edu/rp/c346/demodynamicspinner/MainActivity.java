package sg.edu.rp.c346.demodynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnUp;
    ArrayList<String> alNumbers;
    ArrayAdapter aaNumbers;
    String[] strEven;
    String[] strOdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUp = findViewById(R.id.btnUpdate);

        alNumbers = new ArrayList<>();
        strEven = getResources().getStringArray(R.array.even_num);
        strOdd = getResources().getStringArray(R.array.odd_num);
        alNumbers.addAll(Arrays.asList(strEven));

        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);


        spn2.setAdapter(aaNumbers);



        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();
                if (pos == 0){
                    alNumbers.addAll(Arrays.asList(strEven));
                }
                else{
                    alNumbers.addAll(Arrays.asList(strOdd));
                }

            }
        });

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alNumbers.clear();
                switch (position){
                    case 0:
                        alNumbers.addAll(Arrays.asList(strEven));
                        spn2.setSelection(2);
                        break;
                    case 1:
                        alNumbers.addAll(Arrays.asList(strOdd));
                        spn2.setSelection(1);
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
