package com.example.miran.appseguridadehigiene.entityTO;

import java.io.Serializable;

public class CatSancionTO{
    public int PkSancion ;
    public String DescSancion;

    public int getPkSancion() {
        return PkSancion;
    }

    public void setPkSancion(int pkSancion) {
        PkSancion = pkSancion;
    }

    public String getDescSancion() {
        return DescSancion;
    }

    public void setDescSancion(String descSancion) {
        DescSancion = descSancion;
    }

}
