package tdaLocal;

public interface DiccionarioSimpleModTDA {
    void inicializarDiccionario();
    void agregar(int clave, int valor); //diccionario inicializado
    void eliminar(int clave); //diccionario inicializado
    int recuperar(int clave); //diccionario inicializado y	clave existente
    public int recuperarMod(int clave); //devuelve la cantidad de
    //modificaciones que sufrió el valor relacionado a dicha clave, que se
    //supone existente
    ConjuntoTDA claves(); //diccionario inicializado
}
