package co.edu.ue.appkelly.model;

import java.util.ArrayList;

public class ResponseRegistros {
    public ArrayList<Registros> registros;
    public ArrayList<Registros> getRegistros(){
        return registros;
    }
    public void setRegistros(ArrayList<Registros> registros){this.registros = registros;}
}
