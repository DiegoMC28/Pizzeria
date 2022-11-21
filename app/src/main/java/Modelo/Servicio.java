package Modelo;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.pizzeria.ActivityInicioSesion;

import java.util.ArrayList;

import DAOs.DAOPedidos;
import DAOs.DAOPizza;
import DAOs.DAOUsuario;

public class Servicio {
    private AdaptadorBD bbdd;

    public Servicio(Context context) {


        bbdd = new AdaptadorBD(context);
        bbdd.registrarUsuario("diego", "123");

        DAOPedidos.getInstance();
        HistorialInicioSesion.getInstance();
    }


    public ArrayList<ArrayList<Pizza>> getServicioPedido() {
        return DAOPedidos.getInstance().getListaPedidos();
    }

    public void setServicioPedido(ArrayList<ArrayList<Pizza>> servicioPedido) {
        DAOPedidos.getInstance().setListaPedidos(servicioPedido);
    }

    public ArrayList<Pizza> getServicioPizzas() {
        return bbdd.obtenerPizzas();
    }




    public void añadirPedido( ArrayList<Pizza> array){

         DAOPedidos.getInstance().añadirPedido(array);


    }
    public ArrayList<Usuario> getServicioUsuario() {
        return bbdd.obtenerUsuarios();
    }



    public void añadirUsuario(Usuario usuario){

        bbdd.registrarUsuario(usuario.getUsuario(), usuario.getContraseña());

    }

    public int obtenerUltimoIndice(){

        return DAOPedidos.getInstance().getListaPedidos().size()-1;
    }

    public ArrayList<Usuario> getServicioHistorial() {
        return HistorialInicioSesion.getInstance().getArrayHistorial();
    }

    public void setServicioHistorial(ArrayList<Usuario> servicioHistorial) {
        HistorialInicioSesion.getInstance().setArrayHistorial(servicioHistorial);
    }

    public void añadirAlHistorial(Usuario usuario){

        HistorialInicioSesion.getInstance().añadirUsuario(usuario);

    }

    public Usuario obtenerUltimoUsuarioIniciado(){

        return HistorialInicioSesion.getInstance().getArrayHistorial().get(HistorialInicioSesion.getInstance().getArrayHistorial().size()-1);


    }
}
