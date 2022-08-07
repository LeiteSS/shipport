package io.github.leitess.shipport.Controller;

import io.github.leitess.shipport.Model.entity.Conteiner;
import io.github.leitess.shipport.Model.entity.enums.CategoriaConteiner;
import io.github.leitess.shipport.Model.service.ConteinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConteinerController {

    @Autowired
    private ConteinerService service;

    @GetMapping("/") //localhost:8080/
    public String paginaPrincipal(@Param(value = "palavraChave") String palavraChave, Model model) {
        model.addAttribute("lista", service.listaConteineres(palavraChave));
        model.addAttribute("importacao", service.totalCategoria(CategoriaConteiner.IMPORTACAO));
        model.addAttribute("exportacao", service.totalCategoria(CategoriaConteiner.EXPORTACAO));
        model.addAttribute("movimentacao", service.totalMovimentacao());

        return "index";
    }

    @GetMapping("/cadastro") //localhost:8080/cadastro
    public String paginaCadastro(Model model) {
        Conteiner conteiner = new Conteiner();
        model.addAttribute("conteiner", conteiner);

        return "cadastro";
    }

    @GetMapping("/atualiza/{id}") //localhost:8080/atualizar/8
    public String paginaAtualiza(@PathVariable(value = "id") Long id, Model model) {
        Conteiner conteiner = service.encontraConteinerPeloId(id);

        model.addAttribute("conteiner", conteiner);

        return "atualiza";
    }


    @PostMapping("/salvar")
    public String salvaConteiner(@ModelAttribute("conteiner") Conteiner conteiner) throws Exception {
        service.salvarConteiner(conteiner);

        return "redirect:/";
    }

    @PostMapping("/atualizar")
    public String atualizarConteiner(@ModelAttribute("conteiner") Conteiner conteiner) throws Exception {
        service.atualizarCOnteinr(conteiner);

        return "redirect:/";
    }

    @GetMapping("/deleta/{id}") // DeleteMapping
    public String deletarConteiner(@PathVariable(value = "id") Long id) {
        service.deletaPeloId(id);

        return "redirect:/";
    }
}
