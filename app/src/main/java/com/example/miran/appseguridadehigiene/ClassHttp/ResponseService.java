package com.example.miran.appseguridadehigiene.ClassHttp;

public class ResponseService {
    private  int usuario;
    private String pwd;

    public  ResponseService(){

    }

    public ResponseService(int usuario, String pwd){
        super();
        this.usuario = usuario;
        this.pwd = pwd;

    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
