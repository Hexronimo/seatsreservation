package com.github.hexronimo.dbgenerator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    /* Заполнение тестовой БД начальными дынными. Пишет SQL команды в файл data.sql */
    public static void main(String[] args) {
        List<String> letters = new ArrayList<>(Arrays.asList(new String[] {"В", "Ч", "Ц", "А", "Ф", "Я", "Б", "Н", "Ж", "Й", "F", "E", "A", "B", "C", "H", "Y", "J", "N", "K"}));

        Random random = new Random();

        Path dataDBPath = Path.of("src/main/resources/data.sql");
        try (BufferedWriter bw = Files.newBufferedWriter(dataDBPath)) {

            bw.write("INSERT INTO ROOM (NAME, INFO) VALUES ('Зал № 1', 'Зал со звуком долби диджитал, и поддержкой формата  4D. Кресла оборудованы турбоподдувом.');\n");
            bw.write("INSERT INTO ROOM (NAME, INFO) VALUES ('Зал № 2', 'Зал с красным занавесом и полом с черно-белым паркетом. Однорукий человек, встретит вас у дверей.');\n");
            bw.write("INSERT INTO ROOM (NAME, INFO) VALUES ('Зал № 3', 'Зал-ретро. Чапаев в нем возможно не умирает.');\n");
            bw.write("INSERT INTO ROOM (NAME, INFO) VALUES ('Зал № 4', 'Зал с мягкими диванами для компаний. И местами у столиков.');\n");
            bw.write("INSERT INTO ROOM (NAME, INFO) VALUES ('Зал № 5', 'Зал с одним удобным креслом.');\n\n");

            bw.write("INSERT INTO EVENT (NAME, INFO) VALUES " +
                    "('Унесенные ветром', 'Могучие ветры Гражданской войны в один миг уносят беззаботную юность южанки Скарлетт О`Хара, когда привычный шум балов сменяется грохотом канонад на подступах к родному дому. Для молодой женщины, вынужденной бороться за новую жизнь на разоренной земле, испытания и лишения становятся шансом переосмыслить идеалы, обрести веру в себя и найти настоящую любовь.');\n\n");
            bw.write("INSERT INTO EVENT (NAME, INFO) VALUES " +
                    "('Крокодил Данди', 'Американская журналистка приезжает в глубинку Австралии, и охотник на крокодилов знакомит ее с местными достопримечательностями. Она же приглашает его в Нью-Йорк, и там отважный охотник попадает в неведомые ему джунгли…');\n\n");
            bw.write("INSERT INTO EVENT (NAME, INFO) VALUES " +
                    "('Люди под лестницей', 'Обыкновенный тринадцатилетний мальчик вступил в жуткое жилище. Тот кошмар, который пришлось испытать герою, невозможно описать словами.');\n\n");
            bw.write("INSERT INTO EVENT (NAME, INFO) VALUES " +
                    "('Ребенок Розмари', 'Однажды Розмари видит странное видение, будто она плывет на яхте с Гаем, который превращается в демона и насилует её. Через несколько дней девушка узнает, что беременна. Череда странных событий наталкивает Розмари на догадку, что их соседи — члены сатанинского культа.');\n\n");
            bw.write("INSERT INTO EVENT (NAME, INFO) VALUES " +
                    "('Выпускник', 'После окончания колледжа в дом своих родителей в Лос-Анджелесе возвращается Бенджамен Брэддок. Начинается бесконечная череда дружеских визитов. Все хотят посмотреть на выпускника! На одном из приемов Бен знакомится с приятельницей своих родителей, элегантной дамой бальзаковского возраста миссис Робинсон.');\n\n");
            bw.write("INSERT INTO EVENT (NAME, INFO) VALUES " +
                    "('Бонни и Клайд', 'Молодые и отчаянные любовники Бонни и Клайд легко и изящно грабят банки в 30-е годы XX века. Но их романтизм и «робингудство» довольно быстро перерастают в лужи и реки крови, в хаос и грязь смерти, а судьба пророчит им неудачу…');\n\n");

                        for(int i = 1; i < 5; i++){
                int seats = random.nextInt(100) + 30;
                for(int s = 1; s <= seats; s++) {
                    bw.write("INSERT INTO SEAT (ID_ROOM, NAME) " +
                            "VALUES ((SELECT ID_ROOM FROM ROOM WHERE NAME = 'Зал № " + i + "'), '" + (letters.get(random.nextInt(20)) + s) + "');\n");
                }
            }
            bw.write("INSERT INTO SEAT (ID_ROOM, NAME) " +
                    "VALUES ((SELECT ID_ROOM FROM ROOM WHERE NAME = 'Зал № 5'), 'A1');\n");

            for (int i = 1; i < 100; i++) {
                bw.write("INSERT INTO HAPPEN (ID_EVENT, ID_ROOM, DATE_START, TIME_START, DATE_END, TIME_END) " +
                        "VALUES (" + (random.nextInt(5) + 1) + ", " +
                        (random.nextInt(4) + 1) + ", '" +
                        LocalDate.now().plusDays(random.nextInt(30)) + "', '" +
                        LocalTime.now().plusHours(random.nextInt(10)) + "', '" +
                        LocalDate.now().plusDays(random.nextInt(30)) + "', '" +
                        LocalTime.now().plusHours(random.nextInt(10)) + "');\n"
                );

            }

        } catch (IOException e) {
            System.out.println("ERROR WHILE GENERATING DATABASE DATA");
            e.printStackTrace();
        }

    }
}
