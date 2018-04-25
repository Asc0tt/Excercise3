package pro.ascott.excercise3;

import java.util.ArrayList;
import java.util.List;

public class CatRepository {
    private static final CatRepository ourInstance = new CatRepository();

    public static CatRepository getInstance() {
        return ourInstance;
    }

    private final List<Cat> _cats = new ArrayList<>();

    private CatRepository() {
        _cats.add(new Cat("https://mtdata.ru/u28/photo96CE/20466331848-0/original.jpg"));
        _cats.add(new Cat("http://bipbap.ru/wp-content/uploads/2017/08/5114e7b13c84a77355cbec162ca7ff45.jpg"));
        _cats.add(new Cat("http://bipbap.ru/wp-content/uploads/2017/09/2189909404.jpg"));
        _cats.add(new Cat("http://kakzachem.ru/wp-content/uploads/2018/01/Bez-imeni-2-8.jpg"));
        _cats.add(new Cat("https://static2.shop033.com/resources/18/160536/picture/5D/85442141.jpg"));
        _cats.add(new Cat("https://gloss.ua/file/t/17/11/28/bqeye_640x360.jpg"));
        _cats.add(new Cat("https://obovsem.pp.ua/wp-content/uploads/kotiki-31.jpg"));
        _cats.add(new Cat("https://www.telegraph.co.uk/content/dam/pets/2017/01/06/1-JS117202740-yana-two-face-cat-news_trans_NvBQzQNjv4BqJNqHJA5DVIMqgv_1zKR2kxRY9bnFVTp4QZlQjJfe6H0.jpg?imwidth=450"));
        _cats.add(new Cat("https://www.kedisahiplendirme.com/wp-content/uploads/2018/04/Scottish-Fold.jpg"));
        _cats.add(new Cat("http://honesttopaws.com/wp-content/uploads/sites/5/2017/05/banana-cat-1.png"));
        _cats.add(new Cat("http://www.catster.com/wp-content/uploads/2017/10/A-kitten-meowing-with-his-mouth-open.jpg"));
        _cats.add(new Cat("https://static.euronews.com/articles/432451/603x339_432451.jpg"));
    }

    public List<Cat> GetCats()
    {
        return _cats;
    }
}
