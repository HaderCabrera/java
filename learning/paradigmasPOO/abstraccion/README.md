# Aprendizaje de abstraccion en JAVA

1. Note que los metodos deben ser *abstractos* para poder reescribirlos en las clases derivadas.
    ```java
        public abstract String describeVehicle();
    ```
1. Los atributos de la clase abstracta deben de ser *protected* si es que se desean usar en las clases derivadas.
    ```java
        protected String marca;
        protected String modelo;
        private int año;
    ```
1. Por buenas practicas al querer instanciar clases derivadas de la abtracta se debe invocar a la clase principal 
    ```java
        Vehicle moto = new Moto();
        Vehicle auto = new Auto();
    ```
