import impleLocal.*;
import tdaLocal.ConjuntoTDA;

public class Main {
    public static void main(String[] args) {

        PilaDin pila = new PilaDin();
        pila.apilar(3);
        pila.apilar(2);
        pila.apilar(1);
        pila.apilar(12);
        pila.apilar(15);
        pila.apilar(4);
        System.out.println(elementosPares(pila));
        System.out.println(pila.tope());




    }
    public static int elementosPares(PilaDin p){       // Punto 3: recibe una pila y retorna elementos pares de la misma
        PilaDin pilaAux = new PilaDin();
        pilaAux.inicializarPila();
        int cantPares = 0;
         while(!p.pilaVacia()){
             int valor = p.tope();
             if(valor % 2 == 0){
                 cantPares++;
             }
             pilaAux.apilar(valor);
             p.desapilar();
         }
         while (!pilaAux.pilaVacia()){
             p.apilar(pilaAux.tope());
             pilaAux.desapilar();
         }
         return cantPares;

    }
//    public static ConjuntoDin elementosRepetidos(PilaDin p){   // Punto 4: devolver conjunto con elementos repetidos de la pila
//        ConjuntoDin visitados = new ConjuntoDin();
//        ConjuntoDin repetidos = new ConjuntoDin();
//        PilaDin pilaAux = new PilaDin();
//        visitados.inicializarConjunto();
//        pilaAux.inicializarPila();
//
//        while(!p.pilaVacia()){
//            int valor = p.tope();
//            pilaAux.apilar(valor);
//            visitados.agregar(valor);
//            p.desapilar();
//        }
//
//
//
//
//    }
    public static DiccionarioSimpleDin pilaDiccionario(PilaDin pila){  // Punto 5: recibe una pila y devuelve un diccionario
        DiccionarioSimpleDin d = new DiccionarioSimpleDin();           // con los elementos como clave y las apariciones como valor
        d.inicializarDiccionario();
        PilaDin pilaAux = new PilaDin();
        pilaAux.inicializarPila();

        while (!pila.pilaVacia()){
            int elem = pila.tope();
            pila.desapilar();
            ConjuntoDin claves = d.claves();

            if(claves.pertenece(elem)){
                int actual = d.recuperar(elem);
                d.agregar(elem, actual + 1);
            }else d.agregar(elem, 1);
            pilaAux.apilar(elem);
        }
        while (!pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.tope());
            pilaAux.desapilar();
        }
        return d;
    }

    public static ColaDin diccionarioPila(DiccionarioMultipleDin dic) {   // Punto 6: recibe un diccionario multiple y retorna una cola
        ColaDin cola = new ColaDin();                                     // con elementos no repetidos
        cola.inicializarCola();
        ConjuntoTDA claves = dic.claves();
        ConjuntoTDA valoresAgregados = new ConjuntoDin();
        valoresAgregados.inicializarConjunto();

        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);
            ConjuntoTDA valores = dic.recuperar(clave);
            while (!valores.conjuntoVacio()) {
                int valor = valores.elegir();
                valores.sacar(valor);

                if (!valoresAgregados.pertenece(valor)) {
                    cola.acolar(valor);
                    valoresAgregados.agregar(valor);
                }
            }
        }
        return cola;
    }
}