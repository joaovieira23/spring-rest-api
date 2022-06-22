package curso.api.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {
    
    /* Serviço RESTful */
    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity init(@RequestParam (value = "nome", required = true, defaultValue = "Nome não informado") String nome, @RequestParam("salario") Long salario) {
        System.out.println("Parâmetro sendo recebido" + nome);

        return new ResponseEntity<>("Olá Usuário REST Spring Boot seu nome é: " + nome + " salario é: " + salario, HttpStatus.OK);
    }
}
