package com.example.miran.appseguridadehigiene.entityTO;

import java.io.Serializable;

public class CatTipoFaltasTO implements Serializable {
    public int PkTipoFalta;
    public String DescTipoFalta;

    public int getPkTipoFalta() {
        return PkTipoFalta;
    }

    public void setPkTipoFalta(int pkTipoFalta) {
        PkTipoFalta = pkTipoFalta;
    }

    public String getDescTipoFalta() {
        return DescTipoFalta;
    }

    public void setDescTipoFalta(String descTipoFalta) {
        DescTipoFalta = descTipoFalta;
    }

    @Override
    public String toString() {
        return "CatTipoFaltasTO{" +
                "PkTipoFalta=" + PkTipoFalta +
                ", DescTipoFalta='" + DescTipoFalta + '\'' +
                '}';
    }
}
