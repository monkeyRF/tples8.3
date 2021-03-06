package com.bignerdranch.android.tples83

import kotlin.random.Random

data class Person(
    val id: Long,
    var fullName: String,
    val photoUrl: String,
    var like: Boolean = false
){
    companion object {
        fun getMockPersons() = listOf(
            Person(
                Random.nextLong(),
                "Пушкин А.С.",
                "https://upload.wikimedia.org/wikipedia/commons/5/56/Kiprensky_Pushkin.jpg"
            ),
            Person(
                Random.nextLong(),
                "Толстой Л.Н.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Leo_Tolstoy%2C_portrait.jpg/1024px-Leo_Tolstoy%2C_portrait.jpg"
            ),
            Person(
                Random.nextLong(),
                "Достоевский Ф.М.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Vasily_Perov_-_%D0%9F%D0%BE%D1%80%D1%82%D1%80%D0%B5%D1%82_%D0%A4.%D0%9C.%D0%94%D0%BE%D1%81%D1%82%D0%BE%D0%B5%D0%B2%D1%81%D0%BA%D0%BE%D0%B3%D0%BE_-_Google_Art_Project.jpg/1024px-Vasily_Perov_-_%D0%9F%D0%BE%D1%80%D1%82%D1%80%D0%B5%D1%82_%D0%A4.%D0%9C.%D0%94%D0%BE%D1%81%D1%82%D0%BE%D0%B5%D0%B2%D1%81%D0%BA%D0%BE%D0%B3%D0%BE_-_Google_Art_Project.jpg"
            ),
            Person(
                Random.nextLong(),
                "Гоголь Н.В.",
                "https://upload.wikimedia.org/wikipedia/commons/2/2d/Gogol_karandash.jpg"
            ),
            Person(
                Random.nextLong(),
                "Лермонтов М.Ю.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Mikhail_lermontov.jpg/1024px-Mikhail_lermontov.jpg"
            ),
            Person(
                Random.nextLong(),
                "Тургенев И.С.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/72/Turgenev_by_Repin.jpg/1024px-Turgenev_by_Repin.jpg"
            ),
            Person(
                Random.nextLong(),
                "Чехов А.П.",
                "https://upload.wikimedia.org/wikipedia/commons/9/93/Anton_Chekhov_1889.jpg"
            ),
            Person(
                Random.nextLong(),
                "Островский А.Н.",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Alexander_Ostrovsky_by_Vasily_Perov.jpg/1024px-Alexander_Ostrovsky_by_Vasily_Perov.jpg"
            ),
            Person(
                Random.nextLong(),
                "Гончаров И.А.",
                "https://upload.wikimedia.org/wikipedia/commons/e/e5/Ivan_Goncharov.jpg"
            )

        )
    }
}