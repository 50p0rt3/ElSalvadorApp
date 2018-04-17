package com.carlitox.elsalvadorapp;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.Arrays;

public class Datos {
    Context contexto;
    Resources misRecursos;

    ArrayList arrayUsuarios, arrayClaves;

    public Datos(Context contexto){
        this.contexto = contexto;
        misRecursos  = this.contexto.getResources();
        arrayUsuarios = new ArrayList(Arrays.asList(misRecursos.getStringArray(R.array.usuarios)));
        arrayClaves = new ArrayList(Arrays.asList(misRecursos.getStringArray(R.array.claves)));
    }

    public boolean validarIngreso(String usuario, String clave){
        int indxU=arrayUsuarios.indexOf(usuario);
        int indxC=arrayClaves.indexOf(clave);

        if(indxU==indxC && indxU != -1 && indxC != -1){
            return true;
        }else{
            return false;
        }
    }
    public ArrayList getUsuarios(){

        return  arrayUsuarios;
    }
    public ArrayList getClaves(){

        return arrayClaves;
    }

}
