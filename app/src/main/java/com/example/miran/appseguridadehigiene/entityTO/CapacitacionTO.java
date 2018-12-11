package com.example.miran.appseguridadehigiene.entityTO;

import java.util.List;

public class CapacitacionTO {
    public int  Matricula;
    public String Nombre;
    public List<String> CapacitacionesEmpleado ;


    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int matricula) {
        Matricula = matricula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public List<String> getCapacitacionesEmpleado() {
        return CapacitacionesEmpleado;
    }

    public void setCapacitacionesEmpleado(List<String> capacitacionesEmpleado) {
        CapacitacionesEmpleado = capacitacionesEmpleado;
    }
}
