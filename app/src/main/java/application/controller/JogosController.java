package application.controller;

import application.model.Jogos;
import application.repository.JogosRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/jogos")
public class JogosController {
    @Autowired
    private JogosRepository JogosRepo;

    @GetMapping
    public Iterable<Jogos> list(){
        return JogosRepo.findAll();
    }

    @PostMapping
    public Jogos insert(@RequestBody Jogos jogos){
         if(jogos.getNome().isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Você deve inserir uma descrição valida"
            );
        } 
        return JogosRepo.save(jogos);
    }

    @GetMapping("/{id}")
    public Jogos details(@PathVariable long id){
        Optional<Jogos> resultado = JogosRepo.findById(id);
        if(resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Tarefa não Encontrada"
            );
        }
        return resultado.get();
    }

    @PutMapping("/{id}")
    public Jogos put(
        @PathVariable long id,
        @RequestBody Jogos novosJogos){
        Optional<Jogos> resultado =  JogosRepo.findById(id);

        if(resultado.isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Tarefa não encontrada"
            );
        }

        if(novosJogos.getNome().isEmpty()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Você deve passar uma nome correto"
            );
        }

        resultado.get().setNome(novosJogos.getNome());
        resultado.get().setPlataforma(novosJogos.getPlataforma());
        resultado.get().setGostei(novosJogos.getGostei());
        resultado.get().setZerado(novosJogos.getZerado());


        return JogosRepo.save(resultado.get());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        if(!JogosRepo.existsById(id)){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Essa tarefa não existe"
            );
        }

        JogosRepo.deleteById(id);
    }

}
