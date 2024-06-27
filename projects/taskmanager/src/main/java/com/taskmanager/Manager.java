package com.taskmanager;

public interface Manager {
    void toDo();
}
    class addTask implements Manager {
        private String tarea;
        @Override

        public void toDo() {
           //llamar clase agregar
        }
    }
    class showTask implements Manager {
        @Override
        public void toDo() {
           //llamar clase listar
        }
    }
    class findTask implements Manager {
        private String tarea;
        @Override
        public void toDo() {
           //llamar clase encontrar
        }
    }
    class removeTask implements Manager {
        private String tarea;

        @Override
        public void toDo() {
           //llamar clase encontrar
        }
    }

