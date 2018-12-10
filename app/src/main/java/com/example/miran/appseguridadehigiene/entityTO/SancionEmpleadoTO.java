package com.example.miran.appseguridadehigiene.entityTO;

import java.util.Date;
import java.util.List;

public class SancionEmpleadoTO {

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


    public SancionEmpleadoTO() {
    }

    public SancionEmpleadoTO(int pkRegSancion, int fkEmpleado, int fkEmpresa, int fkTipoUsuario, Date fecha, String numSancion, String otrasFaltas, String observaciones, int fkSancion, int fkEstatus, int fkUsuarioGral, List<Long> idSancionesFaltas) {
        PkRegSancion = pkRegSancion;
        FkEmpleado = fkEmpleado;
        FkEmpresa = fkEmpresa;
        FkTipoUsuario = fkTipoUsuario;
        Fecha = fecha;
        NumSancion = numSancion;
        OtrasFaltas = otrasFaltas;
        Observaciones = observaciones;
        FkSancion = fkSancion;
        FkEstatus = fkEstatus;
        FkUsuarioGral = fkUsuarioGral;
        IdSancionesFaltas = idSancionesFaltas;
    }

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

    @Override
    public String toString() {
        return "SancionEmpleadoTO{" +
                "PkRegSancion=" + PkRegSancion +
                ", FkEmpleado=" + FkEmpleado +
                ", FkEmpresa=" + FkEmpresa +
                ", FkTipoUsuario=" + FkTipoUsuario +
                ", Fecha=" + Fecha +
                ", NumSancion='" + NumSancion + '\'' +
                ", OtrasFaltas='" + OtrasFaltas + '\'' +
                ", Observaciones='" + Observaciones + '\'' +
                ", FkSancion=" + FkSancion +
                ", FkEstatus=" + FkEstatus +
                ", FkUsuarioGral=" + FkUsuarioGral +
                ", IdSancionesFaltas=" + IdSancionesFaltas +
                '}';
    }
}
