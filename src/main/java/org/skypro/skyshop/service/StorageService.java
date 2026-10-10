package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.*;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;

    public StorageService() {
        this.productStorage = new HashMap<>();
        this.articleStorage = new HashMap<>();
        addData();
    }

    public Collection<Product> getProductStorage() {
        return productStorage.values();
    }

    public Collection<Article> getArticleStorage() {
        return articleStorage.values();
    }

    public List<Searchable> getAllItems(){
        List<Searchable> allItems = new LinkedList<>();
        allItems.addAll( productStorage.values());
        allItems.addAll( articleStorage.values());
        return allItems;
    }

    private void addData(){

        Product tomato = new SimpleProduct("Tomato", 50);
        Product cheese = new DiscountedProduct("Cheese", 100, 30);
        Product sausage = new FixPriceProduct("Sausage");
        Product onion = new SimpleProduct("Onion", 40);
        Product mushroom = new SimpleProduct("Mushroom", 70);
        Product cucumber = new SimpleProduct("Cucumber", 60);
        Product bread = new SimpleProduct("Bread", 30);
        Product chocolate = new SimpleProduct("Сhocolate", 70);
        Product water = new SimpleProduct("Water", 40);

        productStorage.put(tomato.getId(),tomato);
        productStorage.put(cheese.getId(),cheese);
        productStorage.put(sausage.getId(),sausage);
        productStorage.put(onion.getId(),onion);
        productStorage.put(mushroom.getId(),mushroom);
        productStorage.put(cucumber.getId(),cucumber);
        productStorage.put(bread.getId(),bread);
        productStorage.put(chocolate.getId(),chocolate);
        productStorage.put(water.getId(),water);


        Article f1 = new Article("Гран-при Монако: битва титанов на улицах княжества",
                "Обзор захватывающей гонки Формулы-1 в Монако, стратегии пилотов, неожиданные обгоны и борьба за чемпионские очки в самом престижном этапе сезона.");
        Article rally = new Article("Дакар-2025: экстремальный марафон через пустыни и горы",
                "Репортаж о легендарном ралли-рейде Дакар, сложнейшие этапы по пескам Саудовской Аравии, технические поломки и героизм экипажей на пределе возможностей.");
        Article nascar = new Article("Дайтона-500: 200 кругов адреналина на овале скорости",
                "Анализ главной гонки NASCAR, тактика драфтинга, массовые аварии на высокой скорости и борьба за победу в самой престижной гонке Америки.");
        Article drift = new Article("Короли заноса: чемпионат мира по дрифту в Японии",
                "Репортаж с этапа D1 Grand Prix, техника управляемого заноса, оценка судей за стиль и точность, интервью с пилотами о мастерстве контроля автомобиля.");
        Article lemans = new Article("24 часа Ле-Мана: марафон выносливости для машин и пилотов",
                "Хроника легендарной гонки на выносливость, смена экипажей, ночные заезды, борьба прототипов LMP1 и GT-классов за победу в самом сложном испытании автоспорта.");
        Article moto = new Article("MotoGP: королевский класс мотоциклетных гонок",
                "Обзор сезона MotoGP, противостояние заводских команд, невероятные наклоны в поворотах и скорость свыше 350 км/ч на прямых участках трасс.");
        Article karting = new Article("От картинга до Формулы-1: где рождаются чемпионы",
                "Исследование роли картинга как стартовой площадки для будущих звезд автоспорта, методики тренировок юных пилотов и развитие гоночных навыков с детства.");
        Article gtClass = new Article("Нюрбургринг-24: адская гонка на Северной петле",
                "Репортаж о суточной гонке на легендарной трассе Нюрбургринг, сложнейшие погодные условия, плотный трафик из 200 машин и борьба за выживание на трассе.");
        Article electric = new Article("Формула-E: тихая революция в мире автоспорта",
                "Анализ развития электрических гоночных серий, особенности стратегии с управлением энергией, городские трассы и привлечение новой аудитории к автоспорту.");
        Article historicle = new Article("Гудвудский фестиваль скорости: путешествие в прошлое автоспорта",
                "Обзор знаменитого фестиваля в Гудвуде, подъем на холм на классических болидах, встречи с легендами гонок и атмосфера праздника автомобильной истории.");

        articleStorage.put(f1.getId(),f1);
        articleStorage.put(rally.getId(),rally);
        articleStorage.put(nascar.getId(),nascar);
        articleStorage.put(drift.getId(),drift);
        articleStorage.put(lemans.getId(),lemans);
        articleStorage.put(moto.getId(),moto);
        articleStorage.put(karting.getId(),karting);
        articleStorage.put(gtClass.getId(),gtClass);
        articleStorage.put(electric.getId(),electric);
        articleStorage.put(historicle.getId(),historicle);
    }
}
