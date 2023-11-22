/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.dionisio.consumoapi;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

public class Api {
     private  List<Estudiante> estudiantes = new ArrayList<>();
    public  List<Estudiante>  GET(  ){
        try{
             estudiantes.clear();
           //solicitar una peticion 
            URL url = new URL("http://localhost/Quinto/api.php");
             //Usamos un objeto de conecccion para brir la conexion 
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
             //Luego solicitamos a travez de un metodo la conexion 
            con.setRequestMethod("GET");
            //luego nos conectamos 
            con.connect();

    //Comporbar si a peticion es correcta 
    int response = con.getResponseCode();
     //Si es correcta abrir un scanner que ela el flujo de datos 
     
    if(response!=200){
        throw new RuntimeException("Ocurrio un error");//error en tiempo de ejecucion
    }else{
        //abrir un scanner para que lea los datos 
        StringBuilder information = new StringBuilder();
        Scanner sc= new Scanner(con.getInputStream());// aqui va a leer el flujo de dtaos que envie la api
        while(sc.hasNext()){
            information.append(sc.nextLine());// aqui vamso agregando la infromacion 
        }
        sc.close();
         //mostrar la infromacion obtenida por consola        
//        System.out.println(information);
           JSONArray jsonArray = new JSONArray(information.toString());
          for (int i = 0; i < jsonArray.length(); i++)
             {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String cedula = jsonObject.getString("cedula");
                String nombre = jsonObject.getString("nombre");
                String apellido = jsonObject.getString("apellido");
                String direccion = jsonObject.getString("direccion");
                String telefono = jsonObject.getString("telefono");
                // Crear un objeto Estudiante
                Estudiante estudiante = new Estudiante(cedula, nombre, apellido, direccion, telefono);

                // Agregar el objeto Estudiante a la lista
                estudiantes.add(estudiante);

            }
                  con.disconnect();     
       return estudiantes;
    }
        }catch(Exception e){
            System.out.println("Error en el método GET");
            return null;
        }
    }
//    HttpClient:
//HttpClient es una biblioteca para realizar solicitudes HTTP en Java. En este 
//código, se utiliza para enviar solicitudes POST, PUT y DELETE a una API REST. 
//Se crea una instancia de HttpClient utilizando HttpClientBuilder.create().build().
//
//Commons Logging:
//Commons Logging es una interfaz de registro (logging) utilizada por las 
//    bibliotecas de Apache Commons, incluida HttpClient

    
// Http Core:
//Http Core es la biblioteca principal subyacente de Apache HttpComponents. 
//Proporciona las clases y métodos fundamentales para trabajar con HTTP. 
//En este código, las clases como HttpPost, BasicNameValuePair, y 
//        UrlEncodedFormEntity pertenecen a Http Core.
     public void insertar(String cedula , String nombre , String apellido , String telefono , String direccion) {
        try{
            String url = "http://localhost/Quinto/api.php";
            //proporciona métodos para configurar y construir instancias de 
            //HttpClient
            HttpClient cliente = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(url);
            // es una clase que utiliza una interfaz y utiliza la clave y valor
            //, se utiliza para representar los campos de un formulario  
            ArrayList<BasicNameValuePair> parametros = new ArrayList<BasicNameValuePair>();
            parametros.add(new BasicNameValuePair("cedula",cedula));
            parametros.add(new BasicNameValuePair("nombre",nombre));
            parametros.add(new BasicNameValuePair("apellido",apellido));
            parametros.add(new BasicNameValuePair("direccion",direccion));
            parametros.add(new BasicNameValuePair("telefono",telefono));
            //Es un método de la clase HttpPost que se utiliza para establecer la entidad
            //Está creando una instancia de UrlEncodedFormEntity que
            //representa el cuerpo de la solicitud en formato de formulario codificado. 
            post.setEntity(new UrlEncodedFormEntity(parametros));
            cliente.execute(post);
         //   mostrarDatos();
        }catch(Exception e){
            System.out.println("Error  : "+e);
        }
        
    }
     
     

    public void editar(String cedula , String nombre , String apellido , String telefono , String direccion) {
        try{
        String apiUrl="http://localhost/Quinto/api.php";
        String urlParametros="cedula="+cedula+"&nombre="+nombre+"&apellido="+apellido+"&direccion="+direccion+"&telefono="+telefono;
        
        URL url = new URL(apiUrl+"?"+urlParametros);
        //abrimos la conexion http
        HttpURLConnection connection =(HttpURLConnection) url.openConnection();
           connection.setRequestMethod("PUT");
          int respuesta= connection.getResponseCode();
            System.out.println(respuesta);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
   
       public void eliminar(String cedula) {
        try{
        String apiUrl="http://localhost/Quinto/api.php";
        String urlParametros="cedula="+cedula;
        
        URL url = new URL(apiUrl+"?"+urlParametros);
        HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
           connection.getResponseCode();
   
        
        
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
    