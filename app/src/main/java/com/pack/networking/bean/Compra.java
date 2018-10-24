package com.pack.networking.bean;

public class Compra {

    private Lineas[] lineas;

    private String cliente;

    private String tipo;

    private String monto;


    public Lineas[] getLineas() {
        return lineas;
    }

    public void setLineas(Lineas[] lineas) {
        this.lineas = lineas;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }
}
