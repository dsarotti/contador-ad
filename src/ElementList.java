import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
* Lista de elementos de cualquier tipo T.
* Guarda una lista de elementos y el número de repeticiones que lecorresponde.
* Guarda cada elemento una sola vez y lleva la cuenta de cuántos se han guardado en un momento dado.
*/
class ElementList<T> {

    private ArrayList<T> elementos;
    private ArrayList<Integer> cantidades;

    public ElementList() {
        elementos = new ArrayList<T>();
        cantidades = new ArrayList<Integer>();
    }

    /**
    * Registra en elemento en la lista.
    * Si no existe el elemento lo guarda en la lista y se pone elcontador a 1 en la misma posición.
    * Si ya existe el elemento simplemente incrementa el contador en la posición correspondiente.
    * @param elemento El elemento a guardar.
    */
    public void count(T elemento){
        if (!elementos.contains(elemento)) {
            elementos.add(elemento);
            cantidades.add(1);
        } else {
            int index = elementos.indexOf(elemento);
            cantidades.set(index, cantidades.get(index) + 1);
        }
    }

    /**
    * Quita un elemento de la lista
    * Si existe más de un elemento registrado, decrementa el contador
    * Si solo existe un elemento, lo elimina y elimina también la entrada del contador.
    * @param elemento
    * @throws NoSuchElementException si no existe el elemento
    */
    public void discount(T elemento) throws NoSuchElementException{
        int index = elementos.indexOf(elemento);
        if(index > -1){
            if (cantidades.get(index)==1){
                cantidades.remove(index);
                elementos.remove(index);
            }else{
                cantidades.set(index, cantidades.get(index)-1);
            }
        }else{
            throw new NoSuchElementException("No existe el elemento " +
            elemento);
        }
    }

    /**
    * Elimina el elemento de la lista sin importar la cantidad que tenga.
    * Elimina también la entrada correspondiente del contador.
    * @param elemento
    * @throws NoSuchElementException si no existe el elemento en lalista.
    */
    public void delete (T elemento) throws NoSuchElementException{
        int index = elementos.indexOf(elemento);
        if (elementos.size() > -1 ){
            elementos.remove(index);
            cantidades.remove(index);
        }else{
            throw new NoSuchElementException("No existe el elemento " +
            elemento);
        }
    }

    /**
    * Devuelve la cuenta con el formato "[elem: num, elem: num]".
    * @return String
    */
    @Override
    public String toString(){
        String stringFinal;
        String stringTemporal = "";
        for (int i = 0;i< elementos.size();i++){
            stringTemporal = stringTemporal+elementos.get(i)+":"+cantidades.get(i);
            if (i<elementos.size()-1){
                stringTemporal = stringTemporal + ", ";
            }
        }
        stringFinal="["+stringTemporal+"]";
        return stringFinal;
    }
}