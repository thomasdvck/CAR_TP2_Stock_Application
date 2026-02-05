package TP2.StockApplication.ctrl;

import org.springframework.stereotype.Controller;
import TP2.StockApplication.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stocks/user")
    public ModelAndView afficherStock() {
        return new ModelAndView("stock", Map.of("articles", stockService.getTousLesArticles()));
    }

    @PostMapping("/reapprovisionner")
    public RedirectView reapprovisionner() {
        stockService.reapprovisionner();
        return new RedirectView("/stocks/user");
    }
}
