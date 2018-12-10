package com.example.miran.appseguridadehigiene.entityTO;

import java.io.Serializable;

public class ResponseUserTO implements Serializable {
    public int idUser ;
    public String Usuario;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }
}
