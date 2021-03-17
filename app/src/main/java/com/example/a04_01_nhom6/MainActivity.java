package com.example.a04_01_nhom6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    {
    private EditText e1,e2;
    private Button btAdd;
    private Spinner spOp;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        spOp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                try{
                    double n1=Double.parseDouble(e1.getText().toString());
                    double n2=Double.parseDouble(e2.getText().toString());
                    String op=spOp.getSelectedItem().toString();

                    result.setText("Sum:"+(n1+n2));
                }catch(NumberFormatException e){
                    System.out.println(e);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //btAdd.setOnClickListener(this);
//        btAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try{
//                    double n1=Double.parseDouble(e1.getText().toString());
//                    double n2=Double.parseDouble(e2.getText().toString());
//                    result.setText("Sum:"+(n1+n2));
//                }catch(NumberFormatException e){
//                    System.out.println(e);
//                }
//            }
//        });
    }

    private void initView() {
        e1=findViewById(R.id.n1);
        e2=findViewById(R.id.n2);
        btAdd=findViewById(R.id.btAdd);
        spOp=findViewById(R.id.spOp);
        result=findViewById(R.id.txtResult);
        String [] st=getResources().getStringArray(R.array.op);
        ArrayAdapter<String > adapter=new ArrayAdapter<String >(this,
                R.layout.spinner_item,st);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spOp.setAdapter(adapter);
    }
    public void add(View v){
        try {
            double n1 = Double.parseDouble(e1.getText().toString());
            double n2 = Double.parseDouble(e2.getText().toString());
            result.setText("Sum:" + (n1 + n2));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
//    @Override
//    public void onClick(View v) {
//        if(v==btAdd) {
//            try {
//                double n1 = Double.parseDouble(e1.getText().toString());
//                double n2 = Double.parseDouble(e2.getText().toString());
//                result.setText("Sum:" + (n1 + n2));
//            } catch (NumberFormatException e) {
//                System.out.println(e);
//            }
//        }

   // }
}
