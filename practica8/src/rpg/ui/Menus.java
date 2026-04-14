package rpg.ui;

import rpg.exception.NivelInsuficienteException;

public class Menus {
    private MenuPersonaje menuPersonaje = new MenuPersonaje();
    private MenuViaje menuViaje = new MenuViaje();

    public void cargarMenus() throws NivelInsuficienteException {
        //menuPersonaje.crearPersonaje();
        menuViaje.viajarCiudad();
    }
}
