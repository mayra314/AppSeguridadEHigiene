package com.example.miran.appseguridadehigiene.ClassHttp;

public class ResponseService {
    private  String usuario;
    private String pwd;

    public  ResponseService(){

    }

    public ResponseService( String usuario, String pwd){
        super();
        this.usuario = usuario;
        this.pwd = pwd;

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
