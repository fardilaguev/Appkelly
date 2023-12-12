package co.edu.ue.appkelly.model;

import java.util.ArrayList;

import co.edu.ue.appkelly.Adapter.RegistrosAdapter;

public class ResponseRegistros {
    public ArrayList<Registros> registros;
    public ArrayList<Registros> getRegistros(){
        ArrayList<Registros> Registros;
        return registros;
    }
    public void setRegistros(ArrayList<Registros> registros){this.registros = registros;}
}
