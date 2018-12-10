package com.example.miran.appseguridadehigiene.entityTO;

import java.util.Date;
import java.util.List;

public class ReporteSancionTO {
    public String Fecha ;
    public String NumeroSancion ;
    public String sancionAplica ;
    public List<String> FaltasCometidas ;
    public String Supervisor ;


    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getNumeroSancion() {
        return NumeroSancion;
    }

    public void setNumeroSancion(String numeroSancion) {
        NumeroSancion = numeroSancion;
    }

    public String getSancionAplica() {
        return sancionAplica;
    }

    public void setSancionAplica(String sancionAplica) {
        this.sancionAplica = sancionAplica;
    }

    public List<String> getFaltasCometidas() {
        return FaltasCometidas;
    }

    public void setFaltasCometidas(List<String> faltasCometidas) {
        FaltasCometidas = faltasCometidas;
    }

    public String getSupervisor() {
        return Supervisor;
    }

    public void setSupervisor(String supervisor) {
        Supervisor = supervisor;
    }


    @Override
    public String toString() {
        return "ReporteSancionTO{" +
                "Fecha='" + Fecha + '\'' +
                ", NumeroSancion='" + NumeroSancion + '\'' +
                ", sancionAplica='" + sancionAplica + '\'' +
                ", FaltasCometidas=" + FaltasCometidas +
                ", Supervisor='" + Supervisor + '\'' +
                '}';
    }
}
