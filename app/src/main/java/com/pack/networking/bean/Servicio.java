package com.pack.networking.bean;

public class Servicio {

    private String idservicio;
    private String nb_servicio;
    private String nb_corto_servicio;
    private String ca_maxima;
    private String nb_archivo;
    private String nb_empresa;
    private String nb_categoria;

    public String getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(String idservicio) {
        this.idservicio = idservicio;
    }

    public String getNb_servicio() {
        return nb_servicio;
    }

    public String getNb_corto_servicio() {
        return nb_corto_servicio;
    }

    public void setNb_corto_servicio(String nb_corto_servicio) {
        this.nb_corto_servicio = nb_corto_servicio;
    }

    public void setNb_servicio(String nb_servicio) {
        this.nb_servicio = nb_servicio;
    }

    public String getCa_maxima() {
        return ca_maxima;
    }

    public void setCa_maxima(String ca_maxima) {
        this.ca_maxima = ca_maxima;
    }

    public String getNb_archivo() {
        return nb_archivo;
    }

    public void setNb_archivo(String nb_archivo) {
        this.nb_archivo = nb_archivo;
    }

    public String getNb_empresa() {
        return nb_empresa;
    }

    public void setNb_empresa(String nb_empresa) {
        this.nb_empresa = nb_empresa;
    }

    public String getNb_categoria() {
        return nb_categoria;
    }

    public void setNb_categoria(String nb_categoria) {
        this.nb_categoria = nb_categoria;
    }

    }
