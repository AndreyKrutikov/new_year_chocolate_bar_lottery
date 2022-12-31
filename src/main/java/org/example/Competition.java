package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Competition extends TimerTask {
    private static final String DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_TIME_OF_COMPETITION_STR = "2022-12-31 23:59:59";
    private static final String WINNER_IS = "And the chocolate goes to ";
    private static final Random random = new Random();
    private final List<String> participants = List.of(
            //reposts: 28
            "Veronika Khamenia",
            "Artyom Savinovskiy",
            "Aleksandr Levchenko",
            "Maria Efimova",
            "Viktoryia Drazdovich",
            "Aleksandr Skubin",

            "Aleksey Krutikov",
            "Alexander Demin",
            "Daria Shavrina",
            "Alexey Kretov",
            "Vadim Khlybov",

            "Dauren Akhmetov",
            "Ilya Navumchyk",
            "Alexandr Lomako",
            "Denis Toropov",
            "Nikita Kurgan",

            "Nik Larkin",
            "Anton Smirnov",
            "Artem Khlevchuk",
            "Maria Vasileva",
            "Marina Savenko",

            "Stanislau Malchanau",
            "Jane Kazhamiakina",
            "Uladzimir Zagorny",
            "Alesya Giryat",
            "Svetlana Melekhova",

            "Kristina Zheleznyakova",
            "Denis Toropov",
            "Margarita Varno",

            //likes: 54
            "Veronika Khamenia",
            "Maria Efimova",
            "Alexandr Lomako",
            "Artem Khlevchuk",
            "Ilya Navumchyk",

            "Yauheni Miskevich",
            "Mikhail Kudinov",
            "Nikita Kurgan",
            "Polina Shanaieva",
            "Alesya Giryat",

            "Jane Kazhamiakina",
            "Uladzimir Zagorny",
            "Alina Shyla",
            "Angelina Chuprina",
            "Michael Jankins",

            "Artyom Shavinovskiy",
            "Anastasiya Silkova",
            "Alexey Pavlyuchenkov",
            "Olesia Zaitseva",
            "Natallia Pakalenka",

            "Zarina Kudelko",
            "Aida Gaynutdinova",
            "Olga Didyk",
            "Alexandr Osinskiy",
            "Aleksandr Skubin",

            "Aleksandra Orlova",
            "Polina Serebrenikova",
            "Dauren Akhmetov",
            "Aleksey Krutikov",
            "Alexander Demin",

            "Kristina Zheleznyakova",
            "Niyozbek Allaberdiyev",
            "Arthur Golitsyn",
            "Daria Shavrina",
            "Alexey Kretov",

            "Daniel Robins",
            "Vadim Khlybov",
            "Svetlana Melekhova",
            "Ihor Denesiuk",
            "Joao Afonso Gunza",

            "Dzianis Ralko",
            "Anna Pliavgo",
            "Viktoria Kudash",
            "Vasilina Kazachonak",
            "Maria Vasilieva",

            "Nikita Kozlov",
            "Nikita Lipatov",
            "Margarita Varno",
            "Nik Larkin",
            "Maksim Gusev",

            "Syed Massam Raza",
            "Govind Tayal",
            "Katsiaryna Zhylinskaya",
            "Maksim Zhuravel",

            //comments: 24 (28 total - 4 repeated)
            "Alexandr Lomako",
            "Denis Toporov",
            "Maria Efimova",
            "Ilya Navumchyk",
            "Veronika Khamenia",

            "Artem Khlevchuk",
            "Nikita Kurgan",
            "Polina Shanaieva",
            "Vadim Khlybov",
            "Daria Shavrina",

            "Maria Vasilieva",
            "Nik Larkin",
            "Maksim Gusev",
            "Alexander Demin",
            "Aleksandr Levchenko",

            "Aleksey Krutikov",
            "Aleksandr Skubin",
            "Stanislav M.",
            "Kristina Zheleznyakova",
            "Artyom Savinovskiy",

            "Svetlana Melekhova",
            "Olga Didyk",
            "Alexey Kretov",
            "Dauren Akhmetov"
    );

    public static void main(String[] args) throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat(DATE_TIME_FORMAT_STR);
        Date minuteBeforeNY = dateFormatter.parse(DATE_TIME_OF_COMPETITION_STR);

        Timer timer = new Timer();
        timer.schedule(new Competition(), minuteBeforeNY);
    }

    @Override
    public void run() {
        List<String> distinctParticipants = getDistinctParticipants(participants);
        String winner = findWinner(distinctParticipants);

        System.out.println(WINNER_IS + winner);

        System.exit(0);
    }

    private static String findWinner(List<String> participants) {
        return participants.get(random.nextInt(participants.size()));
    }

    private static List<String> getDistinctParticipants(List<String> allParticipants) {
        return allParticipants.stream()
                .distinct()
                .toList();
    }
}