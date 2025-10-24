public class ejercicio11 {
    public static void main(String[] args) {
        //Escribe un programa java que invierta el orden de los valores de un array.
        // Por invertir el orden de los valores de un array, me refiero que el último pasa a ser el primero,
        // el penúltimo el segundo y así sucesivamente. PRUEBA CON UN ARRAY DE TAMAÑO 6.
        int[] array = {1,2,3,4,5,6};
        int[] invertido = new int[array.length];
        System.out.println("Array original: ");
        for (int i = 0; i< array.length; i++){
        System.out.print(array[i] + " ");
        }
        System.out.println(" ");
        System.out.println("Array invertido: ");
        for (int i = 0; i< array.length; i++){
            invertido[i] = array[array.length - 1 - i];
            System.out.print(invertido[i] + " ");
        }
    }
}
