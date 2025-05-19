//package impleLocal;
//
//import tdaLocal.ConjuntoTDA;
//import tdaLocal.DiccionarioSimpleTDA;
//
//public class DiccionarioSimpleMod implements DiccionarioSimpleTDA {
//    private class NodoClave {
//        int clave;
//        int valor;
//        int modificaciones;
//        NodoClave sigClave;
//    }
//    private NodoClave origen;
//
//    public void inicializarDiccionario(){
//        origen = null;
//    }
//
//    public void agregar(int clave, int valor) {
//        NodoClave nc = Clave2NodoClave(clave);
//        if (nc == null) { // La clave no existe en el diccionario
//            nc = new NodoClave();
//            nc.clave = clave;
//            nc.valor = valor;
//            nc.modificaciones = 0; // Inicializamos el contador de modificaciones a 0
//            nc.sigClave = origen;
//            origen = nc; // Se añade el nuevo nodo al principio de la lista
//        } else { // Si la clave ya existe, actualizamos el valor y las modificaciones
//            nc.valor = valor;
//            nc.modificaciones++; // Aumentamos el contador de modificaciones
//        }
//    }
//    public NodoClave Clave2NodoClave(int clave){
//        NodoClave aux = origen; //el nodo viajero
//        while (aux != null && aux.clave != clave) {
//            aux = aux.sigClave;
//        }
//        return aux;
//    }
//
//    @Override
//    public ConjuntoTDA claves() {
//        ConjuntoTDA c = new ConjuntoDin();
//        c.inicializarConjunto();
//        DiccionarioSimpleDin.NodoClave aux = origen; //el nodo viajero
//        while (aux != null) {
//            c.agregar(aux.clave);
//            aux = aux.sigClave;
//        }
//        return c;
//    }
//}
