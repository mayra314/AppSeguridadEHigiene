package com.example.miran.appseguridadehigiene.entityTO;

import java.util.Date;
import java.util.List;

public class SancionTO {

    public int PkRegSancion;
    public int FkEmpleado;
    public int FkEmpresa;
    public int FkTipoUsuario;
    public Date Fecha;
    public String NumSancion;
    public String OtrasFaltas;
    public String Observaciones;
    public int FkSancion;
    public int FkEstatus;
    public int FkUsuarioGral;
    public List<Long> IdSancionesFaltas;


    public int getPkRegSancion() {
        return PkRegSancion;
    }

    public void setPkRegSancion(int pkRegSancion) {
        PkRegSancion = pkRegSancion;
    }

    public int getFkEmpleado() {
        return FkEmpleado;
    }

    public void setFkEmpleado(int fkEmpleado) {
        FkEmpleado = fkEmpleado;
    }

    public int getFkEmpresa() {
        return FkEmpresa;
    }

    public void setFkEmpresa(int fkEmpresa) {
        FkEmpresa = fkEmpresa;
    }

    public int getFkTipoUsuario() {
        return FkTipoUsuario;
    }

    public void setFkTipoUsuario(int fkTipoUsuario) {
        FkTipoUsuario = fkTipoUsuario;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public String getNumSancion() {
        return NumSancion;
    }

    public void setNumSancion(String numSancion) {
        NumSancion = numSancion;
    }

    public String getOtrasFaltas() {
        return OtrasFaltas;
    }

    public void setOtrasFaltas(String otrasFaltas) {
        OtrasFaltas = otrasFaltas;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public int getFkSancion() {
        return FkSancion;
    }

    public void setFkSancion(int fkSancion) {
        FkSancion = fkSancion;
    }

    public int getFkEstatus() {
        return FkEstatus;
    }

    public void setFkEstatus(int fkEstatus) {
        FkEstatus = fkEstatus;
    }

    public int getFkUsuarioGral() {
        return FkUsuarioGral;
    }

    public void setFkUsuarioGral(int fkUsuarioGral) {
        FkUsuarioGral = fkUsuarioGral;
    }

    public List<Long> getIdSancionesFaltas() {
        return IdSancionesFaltas;
    }

    public void setIdSancionesFaltas(List<Long> idSancionesFaltas) {
        IdSancionesFaltas = idSancionesFaltas;
    }


}
