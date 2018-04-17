package com.carlitox.elsalvadorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Datos data;

    EditText edtU, edtP;
    Button btnVerificarLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        data=new Datos(getApplicationContext());

        edtU=(EditText)findViewById(R.id.edtU);
        edtP=(EditText)findViewById(R.id.edtP);
        btnVerificarLog=(Button)findViewById(R.id.btnVerificarLog);

        btnVerificarLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreU=edtU.getText().toString().trim();
                String claveU=edtP.getText().toString().trim();

                boolean valido = data.validarIngreso(nombreU,claveU);
                if(valido){
                    Intent objLogueado=new Intent(getApplicationContext(),Municipios.class);
                    startActivityForResult(objLogueado,2);
                }else{
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
