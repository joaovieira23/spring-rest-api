package curso.api.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {
    
    /* Serviço RESTful */
    // @GetMapping(value = "/", produces = "application/json")
    // public ResponseEntity init(@RequestParam (value = "nome", required = true, defaultValue = "Nome não informado") String nome, @RequestParam("salario") Long salario) {
    //     System.out.println("Parâmetro sendo recebido" + nome);

    //     return new ResponseEntity<>("Olá Usuário REST Spring Boot seu nome é: " + nome + " salario é: " + salario, HttpStatus.OK);
    // }

    @Autowired /* Se fosse CDI seria @Inject */
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Usuario> init(@PathVariable (value = "id") Long id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
        // return ResponseEntity.ok(usuarios);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Usuario>> usuarios () {
        List<Usuario> list = usuarioRepository.findAll();

        return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
    }

    @PostMapping(value = "/{iduser}/idvenda/{idvenda}", produces = "application/json")
    public ResponseEntity cadastrarVenda(@PathVariable Long iduser, @PathVariable Long idvenda) {

        /* Aqui seria o processo de venda */
        // Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new ResponseEntity("Id user: " + iduser + "Id venda" + idvenda, HttpStatus.OK);
    }
}
