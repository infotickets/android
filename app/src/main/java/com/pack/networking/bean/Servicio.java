package com.pack.networking.bean;

public class Servicio {

    private String idServicio;
    private String nbServicio;
    private String nbCortoServicio;
    private String caMaxima;
    private String nbArchivo;
    private String nbEmpresa;
    private String nbCategoria;
    private Integer caDias;

    private String[] dias;

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getNbServicio() {
        return nbServicio;
    }

    public void setNbServicio(String nbServicio) {
        this.nbServicio = nbServicio;
    }

    public String getNbCortoServicio() {
        return nbCortoServicio;
    }

    public void setNbCortoServicio(String nbCortoServicio) {
        this.nbCortoServicio = nbCortoServicio;
    }

    public String getCaMaxima() {
        return caMaxima;
    }

    public void setCaMaxima(String caMaxima) {
        this.caMaxima = caMaxima;
    }

    public String getNbArchivo() {
        return nbArchivo;
    }

    public void setNbArchivo(String nbArchivo) {
        this.nbArchivo = nbArchivo;
    }

    public String getNbEmpresa() {
        return nbEmpresa;
    }

    public void setNbEmpresa(String nbEmpresa) {
        this.nbEmpresa = nbEmpresa;
    }

    public String getNbCategoria() {
        return nbCategoria;
    }

    public void setNbCategoria(String nbCategoria) {
        this.nbCategoria = nbCategoria;
    }

    public Integer getCaDias() {
        return caDias;
    }

    public void setCaDias(Integer caDias) {
        this.caDias = caDias;
    }

    public String[] getDias() {
        return dias;
    }

    public void setDias(String[] dias) {
        this.dias = dias;
    }
}
