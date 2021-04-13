package com.example.country_lottery

internal class Country(
        val name: String = "",
        val tips: Array<String> = arrayOf("")
) {

    fun getRandomCountry() = getArrayOfCountries().random()

    fun getArrayOfCountries(): Array<Country> {
        val germany =
            Country("Германия", arrayOf("Отличная экономика", "Отличные машины", "Сосиски и пиво"))
        val france = Country(
            "Франция",
            arrayOf("Поставщик гувернанток в 19 веке", "Родина полководца и торта", "Едят лягушек")
        )
        val greece =
            Country("Греция", arrayOf("Бедная, зато Европа", "Намудрили с религией", "Все есть"))
        val spain = Country("Испания", arrayOf("Всегда тепло", "Коррида", "Можно поспать в обед"))
        val britain = Country(
            "Великобритания",
            arrayOf("Остров", "Точка респауна российских бизнесменов", "Всегда дождь")
        )
        val israel = Country(
            "Израиль",
            arrayOf("Все служили в армии", "Выходные не как у людей", "Таки и що вы говорите")
        )
        val usa = Country(
            "США",
            arrayOf("Отличная экономика", "Много толстых людей", "Полицейские с пончиками")
        )
        val india =
            Country("Индия", arrayOf("Много людей", "Мало денег", "Вы не видели мою корову?"))
        val china = Country(
            "Китай",
            arrayOf("Много людей", "Много денег", "Все, что шевелится, считается съедобным")
        )
        val canada = Country("Канада", arrayOf("Большая", "Очень холодно", "Ничего не происходит"))

        return arrayOf(germany, france, greece, spain, britain, israel, usa, india, china, canada)
    }

}