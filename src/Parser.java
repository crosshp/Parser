import Hibernate.FactoryDAO;
import Hibernate.Ingridient;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Andrew on 26.06.2015.
 */
public class Parser {
    String[] exceptions = {"шт.","бутылка","бутылки","среднего","размера","бутылка","стебли",
            "около","Для крема:","Для начинки:","вкусу","средняя","крупный","большая",
            "пера","крупная","средние","кислые","жирная","соленая","сметана","Для теста:","Для теста"
            ,"Для начинки:","очень","для крема:","большой","коробочки","для бисквита:","крепкого","крепкий",
            "ч.л.","ст.","стакана","для","смазвания","формы","еще немного для цукатов формы","Для покрытия:",
            "жирностью","ирландский","стакана","банки","сладкий","вкусу","луковицы","любая","Для жженки",
            "(белок)","Для глазури:","молотого","молотой","мелкий","стакан","молотая","крепкий","пакетика",
            "кипяченой","плода","теплой","без","запаха","Для подачи:","любой","твердых","толченый","еще",
            "карамели","красный","для теста:","плитка","нежирных","обсыпки","(тертый)","куска","(свежий)",
            "щепотка","горсть","гашеная","(только белки)","(только желтки)","белки","желтки","замороженного",
            "растопленного","тонкий","толстый","сваренные","вкрутую","пучок","ломтик","топленого","сваренных"
            ,"подготовленных","отварной","желток","белок","холодная","Для чиабатты","светлого","Для шоколадного соуса:"
            ,"жарки","свежемолотый","Для блинчиков","зубчика","стебля","средних","зеленых","больших","бутоны",
            "упаковка","пачки","веточек","круглозерного","мелкая","крупный","сушеный вкусу","коричневая",
            "собственном","очищенные","тонких","ломтиков","подачи","большие","вареные","вареное","мороженый","зубчик"
            ,"Для соуса:","густая","пачка","Для теста:","для крема:","очень","смазывания","Для теста:","желанию",
            "примерно","крепких","несколько","кусочков","топленое","плюс","немного","сухая","Для","крема:","украшения"
            ,"нежирного","начинки:","начинки","основы:","основы","заправки:","Для","для","веточки","ледяная","теста:","ст.л."
            ,"крупное"};
    public void parseString(String nonParseString) {
        String[] parseMassive = nonParseString.split(",");
        for(String s: parseMassive){
           s = deleteUnnecessaryToken(s);
            try {
                FactoryDAO.getInstance().getImplementationDAO().addIngridient(new Ingridient(s));
            } catch (SQLException e) {
                e.printStackTrace();
            }
             System.out.println(s);
        }
    }

    private String deleteUnnecessaryToken(String nonParse) {
        String newString = "";
        String currentString;
        StringTokenizer stringTokenizer = new StringTokenizer(nonParse," ");
        while (stringTokenizer.hasMoreTokens()){
            currentString = stringTokenizer.nextToken();
           if((currentString.length()>2)&&(!containsInException(currentString))){
                newString+= currentString+" ";
            }

        }
        return newString;
    }

    public boolean containsInException(String str){
        for(String s: exceptions){
            if(s.equals(str)){
                return true;
            }
        }
        return false;
    }
}







