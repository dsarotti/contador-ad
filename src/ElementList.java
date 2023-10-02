import java.util.ArrayList;
import java.util.List;

class ElementList<T> {
    private List<T> elementos;
    private List<Integer> cantidades;

    public ElementList() {
        elementos = new ArrayList<T>();
        cantidades = new ArrayList<Integer>();
    }

    public void count(T elemento) {
        if (!elementos.contains(elemento)) {
            elementos.add(elemento);
            cantidades.add(1);
        } else {
            int index = elementos.indexOf(elemento);
            cantidades.set(index, cantidades.get(index) + 1);
        }
    }

    public void discount(T elemento){
        if(elementos.contains(elemento)){
            int index = elementos.indexOf(elemento);
            //TODO: terminar.
        }
    }

    public int contarElemento(T elemento) {
        if (elementos.contains(elemento)) {
            int index = elementos.indexOf(elemento);
            return cantidades.get(index);
        } else {
            return 0;
        }
    }

    public List<T> obtenerElementosDistintos() {
        return elementos;
    }

    public List<Integer> obtenerNumeroRepeticiones() {
        return cantidades;
    }
}