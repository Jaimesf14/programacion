import rpg.dao.*;
import rpg.exception.NivelInsuficienteException;
import rpg.logic.GestionMundo;
import rpg.model.ClasesRPG;
import rpg.ui.Menus;

public static void main(String[] args) throws NivelInsuficienteException {
    Menus menus = new Menus();
    menus.cargarMenus();
}
