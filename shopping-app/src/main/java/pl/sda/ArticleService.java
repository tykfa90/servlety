package pl.sda;

import java.util.Arrays;
import java.util.Collection;

public class ArticleService {
    private Collection<Article> availableArticles = Arrays.asList(
            new Article(1l, "Beer"),
            new Article(2l, "Mineral water"),
            new Article(3l, "Orange juice"),
            new Article(4l, "Milk")
    );

    Collection<Article> getAvailableArticles() {
        return availableArticles;
    }

    public Article findArticleById(Long articleId) {
        return availableArticles.stream()
                .filter(a -> a.getId().equals(articleId))
                .findFirst()
                .orElse(null);
    }
}
