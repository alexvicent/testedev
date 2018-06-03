package br.com.testedev.controller;

import br.com.testedev.domain.Disco;
import br.com.testedev.service.DiscoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("categorias/{categoriaId}/discos")
public class DiscoController {

    @Autowired
    private DiscoService discoService;

    @GetMapping("/listar")
    public ModelAndView listar(@PathVariable("categoriaId") long categoriaId, ModelMap model) {
        model.addAttribute("discos", discoService.recuperarPorCategoria(categoriaId));
        model.addAttribute("categoriaId", categoriaId);
        return new ModelAndView("/disco/list", model);
    }

    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("disco") Disco disco, @PathVariable("categoriaId") long categoriaId) {
        return "/disco/add";
    }

    @PostMapping("/salvar")
    public String salvar(@PathVariable("categoriaId") long categoriaId, @Valid @ModelAttribute("disco")
            Disco disco, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/disco/add";
        }

        discoService.salvar(disco, categoriaId);
        attr.addFlashAttribute("mensagem", "Disco salvo com sucesso.");
        return "redirect:/categorias/" + categoriaId + "/discos/listar";
    }

    @GetMapping("/{discoId}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("categoriaId") long categoriaId, @PathVariable("discoId")
            long discoId, ModelMap model) {
        Disco disco = discoService.recuperarPorCategoriaIdEDiscoId(categoriaId, discoId);
        model.addAttribute("disco", disco);
        model.addAttribute("categoriaId", categoriaId);
        return new ModelAndView("/disco/add", model);
    }

    @PutMapping("/salvar")
    public ModelAndView atualizar(@PathVariable("categoriaId") long categoriaId, @Valid @ModelAttribute("disco")
            Disco disco, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("/disco/add");
        }

        discoService.atualizar(disco, categoriaId);
        attr.addFlashAttribute("mensagem", "Disco atualizada com sucesso.");
        return new ModelAndView("redirect:/categorias/" + categoriaId + "/discos/listar");
    }

    @GetMapping("/{discoId}/remover")
    public String remover(@PathVariable("categoriaId") long categoriaId, @PathVariable("discoId")
            long discoId, RedirectAttributes attr) {
        discoService.excluir(categoriaId, discoId);
        attr.addFlashAttribute("mensagem", "Disco excluído com sucesso.");
        return "redirect:/categorias/" + categoriaId + "/discos/listar";
    }
}
