package com.pack.networking.bean;

public class Lineas {
        private String nombre;

        private String precio;

        private String cantidad;

        public String getNombre ()
        {
            return nombre;
        }

        public void setNombre (String nombre)
        {
            this.nombre = nombre;
        }

        public String getPrecio ()
        {
            return precio;
        }

        public void setPrecio (String precio)
        {
            this.precio = precio;
        }

        public String getCantidad ()
        {
            return cantidad;
        }

        public void setCantidad (String cantidad)
        {
            this.cantidad = cantidad;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [nombre = "+nombre+", precio = "+precio+", cantidad = "+cantidad+"]";
        }
    }
