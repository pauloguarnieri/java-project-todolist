package io.github.pauloguarnieri.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController  // = criar uma rota
@RequestMapping("/primeiraRota") //define o acesso a essa controller
//http://localhost:8088/ -------------- 
public class minhaPrimeiraController {

    // Metodos de requisição http
    // GET - buscar
    // POST - adicionar
    // PUT - editar mais de uma propriedade
    // DELETE - deletar
    // PATCH - alterar uma propriedades

    // metodo (funcionalidade) da classe
    @GetMapping("/primeiroMetodo") // define o acesso a essa rota do controller
    public  String primeiraMensagem(){
        return "Funcionou";
    }
}
