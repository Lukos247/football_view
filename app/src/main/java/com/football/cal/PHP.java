package com.football.cal;

import com.football.cal.model.BaseCalendar;
import com.football.cal.model.BaseMatch;
import com.football.cal.model.BaseModel;
import com.football.cal.model.BaseTeam;
import com.football.cal.model.BaseTitle;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class PHP {

    public static ArrayList<BaseModel> apl(){
        ArrayList<BaseModel> array = new ArrayList<>();
        array.add(new BaseMatch("23.11","Леганес",R.drawable.logo,"Барселона"));
        array.add(new BaseMatch("23.11","Вест Хэм",R.drawable.logo,"Тоттенхэм"));
        array.add(new BaseMatch("23.11","Аталанта",R.drawable.logo,"Ювентус"));
        array.add(new BaseMatch("23.11","Фортуна",R.drawable.logo,"Бавария"));
        array.add(new BaseMatch("23.11","Арсенал",R.drawable.logo,"Саутгемптон"));
        array.add(new BaseMatch("23.11","Реал Мадрид",R.drawable.logo,"Реал Сосьедад"));

        return array;
    }

    public static ArrayList<BaseModel> laliga(){
        ArrayList<BaseModel> array = new ArrayList<>();


        array.add(new BaseTitle(new GregorianCalendar(2019,11,23).getTime()));
        array.add(new BaseCalendar("Отвратительно и похабно». Медведев осудил фанатов, оскорблявших Дзю,","Генеральный директор «Зенита» Александр Медведев прокомментировал инцидент в матче 10-го тура отборочного этапа чемпионата Европы – 2020 между сборными России и Сан-Марино (5:0), в ходе которого болельщики национальной командой скандировали оскорбления в адрес нападающего Артёма Дзюбы.\n" +
                "\n" +
                "«Это отвратительно и похабно. Они в первую очередь опозорили себя и свой клуб. Уверен, что подобные выходки нормальными людьми расцениваются как акции против всей нашей сборной, которая отдала столько сил за выход на Евро.\n" +
                "\n" +
                "Говорят, что «мы их никого не знаем». Есть данные, что это была организованная группа, которая приехала двумя автобусами. Судя по откликам, я уверен, что армия наших болельщиков – и сборной, и футбольных клубов – не только осуждает, но и не приемлет такое ни на матчах сборных, ни на матчах клубных команд», — сказал Медведев\n" +
                "\n",R.drawable.news1));
        array.add(new BaseCalendar("Веретенников: не подойдя к трибуне, Дзюба показал, что он сильный человек\n","«К таким выкрикам болельщиков я отношусь крайне негативно. На поле были футболисты, представляющие нашу страну. Вне зависимости от клубных пристрастий нужно с уважением относиться к игрокам. Не важно, чьи болельщики выкрикивали эти выражения в адрес Дзюбы. Когда футболисты надевают майки национальной сборной, они представляют страну. Такое отношение к нашим игрокам не красит болельщиков. Прежде всего нужно уважать себя, с уважением относиться к игрокам, которые решили главную задачу выхода в финальную стадию чемпионата Европы. Любой болельщик не имеет никакого права так себя вести.\n" +
                "\n" +
                "Реакция Артёма на все эти выкрики понятна. Наверное, он из-за этого и не подошёл к трибуне. У нас в России принято бросаться из крайности в крайность. Самое главное, что Дзюба нашёл в себе силы не вступать с этими болельщиками в какие-то перепалки. Это говорит о том, что он достаточно сильный человек.",R.drawable.news1));


        array.add(new BaseCalendar("«Манчестер Сити» не будет исключён из Лиги чемпионов за нарушения ФФП","«Манчестер Сити» избежит строгого наказания за нарушения правил финансового фэйр-плей. Отчёт о проверке «горожан» будет опубликован в декабре, сообщает The Athletic.\n" +
                "\n" +
                "По информации издания, футбольный клуб будет наказан только денежным штрафом, несмотря на то что ему грозит отстранение от участия в Лиге чемпионов и Лиге Европы.\n" +
                "\n" +
                "Напомним, в 2018 году Der Spiegel раскрыл ряд документов, указывающих на финансовые махинации «Манчестер Сити». Вскоре УЕФА начал расследование в отношении манкунианцев.\n" +
                "\n" +
                "«Ман Сити» — действующий чемпионат английской Премьер-лиги. В нынешнем сезоне «горожане» занимают четвёртое место в турнирной таблице первенства страны. В Лиге чемпионов команда Хосепа Гвардиолы возглавляет группу C.",R.drawable.news2));



        return array;
    }

 //  public static ArrayList<BaseModel> seriea(){
 //      ArrayList<BaseModel> array = new ArrayList<>();
 //      array.add(new BaseTitle(new GregorianCalendar(2019,10,5).getTime()));
 //      array.add(new BaseMatch("16:00","Ufa",R.drawable.rpl1,"Terek Grozny",R.drawable.rpl2));
 //      array.add(new BaseMatch("16:00","Gazovik Orenburg",R.drawable.rpl3,"Dynamo Moscow",R.drawable.rpl4));
 //      array.add(new BaseMatch("16:00","Rubin Kazan",R.drawable.rpl5,"FC Tambov",R.drawable.rpl6));
 //      array.add(new BaseMatch("16:00","FC Sochi",R.drawable.rpl7,"Krylia Sovetov Samara",R.drawable.rpl8));
 //      array.add(new BaseTitle(new GregorianCalendar(2019,10,6).getTime()));
 //      array.add(new BaseMatch("16:00","Ural Yekaterinburg",R.drawable.rpl9,"Zenit St. Petersburg",R.drawable.rpl10));
 //      array.add(new BaseMatch("16:00","Lokomotiv Moscow",R.drawable.rpl11,"Arsenal Tula",R.drawable.rpl12));
 //      array.add(new BaseMatch("16:00","CSKA Moscow",R.drawable.rpl13,"FC Rostov",R.drawable.rpl14));
 //      array.add(new BaseMatch("16:00","Krasnodar",R.drawable.rpl15,"FC Spartak Moscow",R.drawable.rpl16));

 //      return array;
 //  }
}
