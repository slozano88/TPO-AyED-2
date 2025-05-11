package impleLocal;

import tdaLocal.ConjuntoTDA;

public class ConjuntoEspecial implements ConjuntoTDA {

    private class Nodo { //la c�lula de la estructura
        int info; //el valor almacenado
        Nodo sig; //la referencia al siguiente nodo
    }
    private Nodo c;

    public void inicializarConjunto () {
        c = null;
    } // siempre al iniciar el conjunto el primer nodo (c) apunta a null

    public boolean conjuntoVacio() {
        return (c == null);
    }

    public void agregar(int x) {
            Nodo nuevo = new Nodo(); //el nuevo nodo que se agregara
            nuevo.info = x;
            nuevo.sig = c;
            c = nuevo;  // siempre el nodo agregado sera apuntado por c, osea que va al principio del conjunto
    }

    public int elegir() {return c.info;}

 //   public void sacar(int x) {
 //       if (c != null) {
 //           if (c.info == x) { //es el primero
 //               c = c.sig;  // elimina el nodo
 //           } else { //es alg�n otro; lo buscamos
  //              Nodo aux = c;
  //              while (aux.sig != null && aux.sig.info != x)
  //                  aux = aux.sig;
  //              if (aux.sig != null) //encontrado
  //                  aux.sig = aux.sig.sig;
  //          }
  //      }

    public void sacar(int x){     // elimina todas las apariciones del elemento
        while(c.sig != null && c.info == x){
            c = c.sig;
        }
        Nodo aux = c;
        while (aux != null && aux.sig != null) {
            if (aux.sig.info == x) {
                aux.sig = aux.sig.sig;
            } else {
                aux = aux.sig;
            }
        }
    }
    public boolean pertenece(int x) {
        Nodo aux = c;
        while (aux != null && aux.info != x)
            aux = aux.sig;
        return (aux != null);
        }

    public int cantidadApariciones(int x) {
        Nodo aux = c;
        int cant = 0;
        while (aux != null) {
            if (aux.info == x) {
                cant++;
            }
            aux = aux.sig;
        }
        return cant;
    }


}
