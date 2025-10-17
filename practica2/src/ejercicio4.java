public class ejercicio4 {
    public static void main(String[] args) {
        //Crea un array de números de 100 posiciones, que contendrá los números del 1 al 100.
        //Obtén la suma de todos ellos y la media.

        int[] array = new int[100];
        int suma = 0;
        double media = 0;
        for (int i = 0; i< array.length; i++) {
            array[i] = i + 1;
            //Calculamos la suma
            suma = suma + array[i];
            //Calculamos la media
            media = (double) suma / array.length;
        // Imprimimos el resultado
        } System.out.println("Resultado de la suma del 1 al 100 = " + suma + ". Resultado de la media del 1 al 100 =" + media);
    }
}
