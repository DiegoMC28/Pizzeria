package DAOs;

import java.util.ArrayList;

import Modelo.Usuario;

public class DAOUsuario {

    private static DAOUsuario daoUsuario = null;
    private static ArrayList<Usuario> listaUsuario = null;


    //Singleton, solo se instancia una vez
    public static DAOUsuario getInstance(){
        if(daoUsuario == null){
            daoUsuario = new DAOUsuario();
        }
        if(listaUsuario == null){
            listaUsuario = new ArrayList();
            //listaUsuario.add(new Usuario("diego", "123"));
        }
        return daoUsuario;
    }


    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        DAOUsuario.listaUsuario = listaUsuario;
    }

    public void añadirUsuario(Usuario usuario){

        this.listaUsuario.add(usuario);

    }

}
