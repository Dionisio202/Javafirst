/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.dionisio.consumoapi;
public class Estudiante {
    private String cedula;
    private String nombre;
    private String apellido;
    private String dirreccion;
    private String telefono;

    public Estudiante(String cedula, String nombre, String apellido, String dirreccion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dirreccion = dirreccion;
        this.telefono = telefono;
    }
    public Estudiante(String nombre, String apellido, String dirreccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dirreccion = dirreccion;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Estudiante"+"\n" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", dirreccion=" + dirreccion + ", telefono=" + telefono ;
    }
    
    
}
