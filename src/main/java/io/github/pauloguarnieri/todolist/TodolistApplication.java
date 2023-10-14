package io.github.pauloguarnieri.todolist;
//nome do pacote atual acima? 


//importação 'import + nome.do.pacote + . + NomeDaClasse + ;'
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //anotation /decorator
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}
