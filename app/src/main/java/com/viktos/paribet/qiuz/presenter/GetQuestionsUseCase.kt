package com.viktos.paribet.qiuz.presenter

import android.content.Context
import com.viktos.paribet.qiuz.R

class GetQuestionsUseCase(private val context: Context) {
    fun execute(): List<QuizModel> {
        return listOf(
            QuizModel(
                question = context.getString(R.string.q1),
                answers = listOf("Иокогама (Япония)", "Абу-Даби (ОАЭ)", "Лондон (Англия)", "Доха (Катар)"),
                correctAnswer = 4
            ),
            QuizModel(
                question = "2. Кто стал победителем ФИФА 2019?",
                answers = listOf("Фламенго (Франция)", "Бавария (Германия)", "Ливерпуль (Англия)", "Манчестер Юнайтед (Англия)"),
                correctAnswer = 3
            ),
            QuizModel(
                question = "3. Кто признан лучшим вратарём вы 2019 году по версии ФИФА?",
                answers = listOf("Алиссон из «Ливерпуля»", "Тибо Куртуа из «Реала»", "Ян Облак из «Атлетико»", "Давид де Хеа из «Манчестер Юнайтед»"),
                correctAnswer = 1
            ),
            QuizModel(
                question = "4. Кто является лучшим бомбардиром за всю историю сборной Португалии?",
                answers = listOf("Матийс де Лигт", "Криштиану Роналду", "Лионель Месси", "Вирджил ван Дейк"),
                correctAnswer = 2
            ),
            QuizModel(
                question = "5. В какой стране появился и начал развиваться футбол?",
                answers = listOf("Бразилия", "Англия", "Испания", "Португалия"),
                correctAnswer = 2
            ),
            QuizModel(
                question = "6. В какой стране впервые проходил Кубок мира ФИФА?",
                answers = listOf("Уругвай", "Франция", "Испания", "Англия"),
                correctAnswer = 1
            ),
            QuizModel(
                question = "7. Как называется гол, который футболист забил в свои ворота?",
                answers = listOf("Штрафной", "«Мертвый мяч»", "Автогол", "Ложный маневр"),
                correctAnswer = 3
            ),
            QuizModel(
                question = "8. Какое количество игроков одновременно находится на игровом поле с двух сторон?",
                answers = listOf("30 игроков", "24 игрока", "11 игроков", "22 игрока"),
                correctAnswer = 4
            ),
            QuizModel(
                question = "9. Команда из какой страны чаще всего становилась победителем чемпионата мира и сколько раз?",
                answers = listOf("Бразилия (5 побед)", "Англия (4 победы)", "Испания (4 победы)", "Германия (3 победы)"),
                correctAnswer = 1
            ),
            QuizModel(
                question = "10. Назовите правильные размеры стандартных футбольных ворот?",
                answers = listOf("7,22 на 2,45 метра", "6,9 на 2,11 метра", "7,11 на 2,33 метра", "7,32 на 2,44 метра+"),
                correctAnswer = 4
            ),
            QuizModel(
                question = "11. Как правильно расшифровывается аббревиатура УЕФА?",
                answers = listOf("Содружество европейских футбольных абсорбций", "Союз европейских футбольных ассоциаций", "Союз евроинтегрированных футбольных ассоциаций", "Собрание европейских футбольных ассоциаций."),
                correctAnswer = 2
            ),
            QuizModel(
                question = "12. Что оформил игрок, забивший 3 мяча за один матч?",
                answers = listOf("Трипл-сек", "Автогол", "Хет-трик", "Гандикап"),
                correctAnswer = 3
            ),
            QuizModel(
                question = "13. Сколько существует размеров футбольных мячей?",
                answers = listOf("5 размеров", "2 размера", "3 размер", "6 размеров"),
                correctAnswer = 1
            ),
            QuizModel(
                question = "14. Как называется самая почетная персональная награда для футболиста?",
                answers = listOf("Статуэтка чемпиона", "Золотой мяч", "Кубок чемпиона", "Золотая бутса"),
                correctAnswer = 2
            ),
            QuizModel(
                question = "15. Футбольный клуб какой страны в 20 веке 5 раз подряд становился победителем Лиги Чемпионов? Как он называется?",
                answers = listOf("Реал Мадрид (Испания)", "Ювентус (Италия)", "Манчестер Сити (Англия)", "Арсенал (Англия)"),
                correctAnswer = 1
            ),
            QuizModel(
                question = "16. Что такое финт в футболе?",
                answers = listOf("Определение местоположения мяча", "Название тайма", "Технический элемент, который выполняют, чтобы обмануть соперника", "Второе наименование полузащитника"),
                correctAnswer = 3
            ),
            QuizModel(
                question = "17. При каких условиях футболисты играют красным или желтым мячом?",
                answers = listOf("Если мяч вылетел за пределы поля", "Во втором тайме", "Когда начинается дополнительное время игры", "Во время неблагоприятных погодных условий – дождь, снег, туман"),
                correctAnswer = 4
            ),
            QuizModel(
                question = "18. Какое количество рефери необходимо для судейства одного футбольного матча?\n",
                answers = listOf("Трое", "Пятеро", "Двое", "Семеро"),
                correctAnswer = 1
            ),
            QuizModel(
                question = "19. Кто является атвором самого сильного удара в футболе, согласно данным на начало 2020 года?",
                answers = listOf("Дэвид Бекхэм", "Халк", "Роберто Карлос", "Лукас Подольски"),
                correctAnswer = 2
            ),
            QuizModel(
                question = "20. Сколько желтых карточек допускается получить игроку за одну игру?",
                answers = listOf("Одну", "Две", "Ни одной", "Три"),
                correctAnswer = 1
            ),
            QuizModel(
                question = "21. Какие цвета карточек существуют в футболе?",
                answers = listOf("Красная и желтая", "Зеленая, красная и желтая", "Черная и красная", "Синяя и красная"),
                correctAnswer = 1
            ),
            QuizModel(
                question = "22. Как называют игрока, который в соревновании забил больше всех голов?",
                answers = listOf("Лидер", "Голкипер", "Вице-чемпион", "Лучший бомбардир"),
                correctAnswer = 4
            ),
            QuizModel(
                question = "23. Чем сигнализирует нарушение боковой судья основному арбитру?",
                answers = listOf("Флагом", "Рукой", "Карточкой", "Свистком"),
                correctAnswer = 1
            ),
            QuizModel(
                question = "24. Как называется штрафной удар, который совершают по воротам на расстоянии 11 метров?",
                answers = listOf("Буллит", "Гол", "Пенальти", "Аут"),
                correctAnswer = 3
            ),
            QuizModel(
                question = "25. Что в переводе с английского означает слово «футбол»?",
                answers = listOf("«Ручной мяч»", "«Мяч для ноги»", "«Бей ногой»", "«Мячом и ступней»"),
                correctAnswer = 4
            )
        )
    }
}