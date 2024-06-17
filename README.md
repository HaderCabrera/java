### Comandos

- Verificar version de java
```
    java --version
```
- El IDE Propio de JAVA es NetBeans.

- Extension de JAVA Para VSC : **Extension Pack for Java**

- ctrl + shift + p => (Abrir consola de busqueda)
- java new project (Crear nuevo proyecto JAVA)
- Definir nombre del proyecto y ubicacion

- Compleatado de la clase *MAIN*
```
pvsm
```
## VARIABLES EN JAVA: De declaracion.
- Para formatear o interpolar lo hacemos con el metodo MessageFormat
```
MessageFormat.format("{0} tiene {1} años", nombre, edad);
```
## VARIABLES DE ENTRADA SCAN
Si o si se debe hacer el import para tomar variables de entrada
```
import java.util.Scanner;
```

## ESATRUCTURAS CICLO
1. Condicional simple
```
if (condicion) {
    //bloque then
}
```
2. If else
```
if (condiciòn) {
    // Bloque then
} else {
    // Bloque then
}
```
3. Elif
```
if (condicion) {

} else if (condicion) {

} else {

}
```
4. Switch
```
switch (expresion) {
    case valor1:
        bloque1;
        break;
    case valor2:
        bloque2;
        break;
    default:
        bloque_por_defecto;
}
```

## for / while / do-while / forEach
1. while
```
while(condicion) {
    bloque then;
}
```
2. DO WHILE
```
do {

} while (condicion);
```

3. FOR
```
for (inicializacion, condicion, salida) {

}
```
- PARA SACAR DE UN CONSICIONAL WHILE lo hacemos con un condicional (if) y usamos el break/continue segun necesidad.

## CADENAS DE STRING
1. Metodo leng: oBJETO DE TIPO CADENA
```
cadena.charAt(indice);
"abc".charAt(1);
//Evaluar dos cadenas
String cadena1 = "pepe";
String cadena2 = "juan";
if(cadena1.equals(cadena2))
//Convertir cadena a valor numerico
String piStr = "3.14159";
float pi = Float.valueOf(piStr);
//Extraer subcadenas de una cadena
String str = "El lenguaje Java";
String subStr = str.subString(12, indexFinal(opc));

```
## Conversiones explicita e implicita

## Arreglos (Array)
```
tipo_dato nombre_array[];
nombre_array = new tipo_dato[tamanio];
//EJMPLO
int [] numeros = {1,2,3,4,6};
String [] nombre = new String[3];
```