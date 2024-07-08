# Aprendizaje de HERENCIA en JAVA

1. Si queremos que una clase derivada acceda a sus metodos y los de la principal se bebe instanciar la clase derivada y no la principal.
    ```java
            Perro dalmata = new Perro();
            Animal dalmata = new Perro(); //ACA NO PODRIAMOS ACCEDER A LOS METODOS DE LA CLASE PERRO, UNICAMENTE A LOS DE ANIMAL.
    ```
2. Note que la diferencia entre la **abstraccion** y herencia es principalmente que desde la abstraccion reescribo metodos de la clase principal, y **herencia** no reescribo metodos mas sim embargo puedo acceder a metodos de la principal y crear otros desde las derivadas.