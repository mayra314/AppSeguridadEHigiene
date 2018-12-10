package com.example.miran.appseguridadehigiene.entityTO;


import java.io.Serializable;

public class EmpleadoTO  implements Serializable {
    public int PkEmpleado;
    public int FkEmpresa ;
    public int FkTipoUsuario;
    public String Nombre ;
    public String ApellidoPaterno;
    public String ApellidoMaterno;
    public String Puesto;

    public int getPkEmpleado() {
        return PkEmpleado;
    }

    public void setPkEmpleado(int pkEmpleado) {
        PkEmpleado = pkEmpleado;
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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        ApellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        ApellidoMaterno = apellidoMaterno;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String puesto) {
        Puesto = puesto;
    }

    @Override
    public String toString() {
        return "EmpleadoTO{" +
                "PkEmpleado=" + PkEmpleado +
                ", FkEmpresa=" + FkEmpresa +
                ", FkTipoUsuario=" + FkTipoUsuario +
                ", Nombre='" + Nombre + '\'' +
                ", ApellidoPaterno='" + ApellidoPaterno + '\'' +
                ", ApellidoMaterno='" + ApellidoMaterno + '\'' +
                ", Puesto='" + Puesto + '\'' +
                '}';
    }
}
