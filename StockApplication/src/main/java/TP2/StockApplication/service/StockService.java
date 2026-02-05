package TP2.StockApplication.service;


import TP2.StockApplication.entity.Article;
import TP2.StockApplication.entity.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    private final ArticleRepository articleRepository;

    public StockService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Iterable<Article> getTousLesArticles() {
        return articleRepository.findAll();
    }

    public void reapprovisionner() {
        modifierStock("Table", 2);
        modifierStock("Chaise", 5);
    }

    public void modifierStock(String nom, int quantiteModif) {
        Article a = articleRepository.findById(nom)
                .orElse(new Article(nom, 0));
        a.setQuantite(a.getQuantite() + quantiteModif);
        articleRepository.save(a);
    }
}
