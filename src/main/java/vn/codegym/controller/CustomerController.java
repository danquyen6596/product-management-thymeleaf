package vn.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;
import vn.codegym.service.ProductSeviceImpl;

@Controller
public class CustomerController {
    private ProductService productService = new ProductSeviceImpl();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("product/save")
    public String save(Product product, RedirectAttributes redirect) {
        product.setCode((int)(Math.random() * 10000));
        productService.save(product);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/edit/{code}")
    public String edit(@PathVariable int code, Model model) {
        model.addAttribute("product", productService.findByCode(code));
        return "edit";
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getCode(), product);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/delete/{code}")
    public String delete(@PathVariable int code, Model model) {
        model.addAttribute("product", productService.findByCode(code));
        return "delete";
    }

    @PostMapping("/product/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.delete(product.getCode());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/view/{code}")
    public String view(@PathVariable int code, Model model) {
        model.addAttribute("product", productService.findByCode(code));
        return "view";
    }
}
