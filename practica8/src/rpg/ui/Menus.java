package rpg.ui;

import rpg.exception.NivelInsuficienteException;

public class Menus {
    private MenuPersonaje menuPersonaje = new MenuPersonaje();
    private MenuViaje menuViaje = new MenuViaje();

    public void cargarMenus() {
        //menuPersonaje.crearPersonaje();
        menuViaje.viajarCiudad();

    }
}
