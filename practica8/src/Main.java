import rpg.dao.CiudadesDAO;
import rpg.dao.ClasesRPGDAO;
import rpg.dao.RazasDAO;
import rpg.model.ClasesRPG;

public static void main(String[] args){
    System.out.println("RAZAS");
    RazasDAO razasDAO = new RazasDAO();
    System.out.println("CLASES");
    ClasesRPGDAO clasesRPGDAO = new ClasesRPGDAO();
    System.out.println("CIUDADES");
    CiudadesDAO ciudadesDAO = new CiudadesDAO();

    razasDAO.getLista_razas();
    clasesRPGDAO.getLista_clases();
    ciudadesDAO.getLista_ciudades();
}
