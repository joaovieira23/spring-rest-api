package curso.api.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {
    
    /* Serviço RESTful */
    // @GetMapping(value = "/", produces = "application/json")
    // public ResponseEntity init(@RequestParam (value = "nome", required = true, defaultValue = "Nome não informado") String nome, @RequestParam("salario") Long salario) {
    //     System.out.println("Parâmetro sendo recebido" + nome);

    //     return new ResponseEntity<>("Olá Usuário REST Spring Boot seu nome é: " + nome + " salario é: " + salario, HttpStatus.OK);
    // }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> init() {

        Usuario usuario = new Usuario();
        usuario.setId(50L);
        usuario.setLogin("joaovictorvieira.23@hotmail.com");
        usuario.setNome("João Victor Vieira");
        usuario.setSenha("5454458");

        Usuario usuario2 = new Usuario();
        usuario2.setId(50L);
        usuario2.setLogin("jones.23@hotmail.com");
        usuario2.setNome("Jones Andrade");
        usuario2.setSenha("1564863");

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario);
        usuarios.add(usuario2);

        return new ResponseEntity<>(usuarios, HttpStatus.OK);
        // return ResponseEntity.ok(usuarios);
    }
}
