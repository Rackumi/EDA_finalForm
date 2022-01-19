package examenes.ordinaria_2017_2018;

import structures.notOrderedMapsAndDictionaries.dictionaries1.*;

public class EfficientDict<K,V> {

    Dictionary<K, V> dictionary = new HashTableDictionarySC<>();
    //el diccionario ke implementamos a raiz de la practica 2 del año 2021_2022 es O(1).
    //en el ejercicio se entiende k lo k kiere es un diccionario no ordenado para que tenga complejidad O(1)
    //el problema es que usa listas por lo que sera liego O(m) en base al numero de elementos con la misma clave
    //aun asi eso lo podriamos solucionar con un Set si luego no nos importa el orden con el que metimos elementos repetidos

}