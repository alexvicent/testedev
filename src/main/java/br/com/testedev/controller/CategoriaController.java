package br.com.testedev.controller;

import br.com.testedev.domain.Categoria;
import br.com.testedev.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping("/listar")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("categorias", categoriaService.recuperar());
        return new ModelAndView("/categoria/list", model);
    }

    @GetMapping("/cadastro")
    public String preSalvar(@ModelAttribute("categoria") Categoria categoria) {
        return "/categoria/add";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("categoria") Categoria categoria, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "/categoria/add";
        }

        categoriaService.salvar(categoria);
        attr.addFlashAttribute("mensagem", "Categoria criada com sucesso.");
        return "redirect:/categorias/listar";
    }

    @GetMapping("/{id}/atualizar")
    public ModelAndView preAtualizar(@PathVariable("id") long id, ModelMap model) {
        Categoria categoria = categoriaService.recuperarPorId(id);
        model.addAttribute("categoria", categoria);
        return new ModelAndView("/categoria/add", model);
    }

    @PutMapping("/salvar")
    public ModelAndView atualizar(@Valid @ModelAttribute("categoria") Categoria categoria, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("/categoria/add");
        }

        categoriaService.atualizar(categoria);
        attr.addFlashAttribute("mensagem", "Categoria atualizada com sucesso.");
        return new ModelAndView("redirect:/categorias/listar");
    }

    @GetMapping("/{id}/remover")
    public String remover(@PathVariable("id") long id, RedirectAttributes attr) {
        categoriaService.excluir(id);
        attr.addFlashAttribute("mensagem", "Categoria excluida com sucesso.");
        return "redirect:/categorias/listar";
    }
}