package com.example.lab1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import kotlinx.android.synthetic.main.activity_movie_list.*

class ComixListActivity : AppCompatActivity(), ItemClick {

    override fun onItemClick(pos: Int) {
        val movieName = films[pos].name
        val countryName = films[pos].country
        val rating = films[pos].rating
        val image = films[pos].image
        val genre = films[pos].genre

        val intent = Intent(this, ComixActivity::class.java)
        intent.putExtra("name", movieName)
        intent.putExtra("country", countryName)
        intent.putExtra("rating", rating)
        intent.putExtra("image", image)
        intent.putExtra("genre", genre)
        startActivity(intent)
    }

    var films: ArrayList<Film> = ArrayList()
    var filterFilm: ArrayList<Film> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        var bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnNavigationItemSelectedListener(
            object : BottomNavigationView.OnNavigationItemSelectedListener {
                override fun onNavigationItemSelected(item: MenuItem): Boolean {
                    when (item.itemId) {
                        R.id.about -> {
                            val intent = Intent(this@ComixListActivity, AboutActivity::class.java)
                            startActivity(intent)
                        }
                        R.id.genre -> {
                            val intent = Intent(this@ComixListActivity, AuthorsActivity::class.java)
                            startActivity(intent)
                        }
                        R.id.favorite -> {
                            finish()
                        }
                    }
                    return false
                }
            })

        addMovies()
        val genre = intent.getStringExtra("genre")
        if (genre == null) {
            filterFilm = films
        } else {
            filterFilm = films.filter { s -> s.genre == genre } as ArrayList
        }
        moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        moviesRecyclerView.adapter = MoviesAdapter(filterFilm, this,this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.menu_top, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun addMovies() {
        films.add(Film("Капитан Марвел", "Мстителям понадобился свой человек в космосе, а Кэрол Денверс самый подходящий кандидат... Приключения Капитана Марвел в космосе начинаются!!!", "5$", "Стэн Ли", R.drawable.img1))
        films.add(Film("Люди икс. Гражданская война", "Комикс Люди Икс том 4: Вы не поверите, но иногда Росомаха не успевает быть везде и повсюду. И так уж сложились обстоятельства, что в один из таких моментов миру оказываются нужны Люди Икс... Встречайте: Роуг, Рэйчел Грей, Шторм, Китти Прайд, Псайлок и Джубили. Эта команда Людей Икс справится с любой угрозой!", "5$", "Стив Дитко", R.drawable.img2))
        films.add(Film("Железный человек", "Подполковник Джеймс «Роуди» Роудс – пилот американской армии и хороший друг Тони Старка – Непобедимого Железного Человека. Когда Старк оборудовал костюм Железного Человека тяжелым вооружением, Роуди стал героем Воителем… и когда Воитель вновь поступил на службу в интересах национальной безопасности Соединенных Штатов, он стал собственностью Министерства обороны...", "5$", "Стив Дитко", R.drawable.img3))
        films.add(Film("Каратель", "Комикс Каратель - Тигр: Эта история расскажет нам о юном Фрэнке Касле. В свои десять лет Фрэнк был смышленым и любопытным пареньком. Но уже тогда ему была уготована участь познать худшие стороны человеческой натуры и столкнуться лицом к лицом со своим тигром, созданием, сотворенным отнюдь не Богом...", "5$", "Стэн Ли", R.drawable.img4))
        films.add(Film("Америка", "Комикс Америка: В 2016 году Дональд Трамп был избран президентом Соединенных Штатов Америки. Это возмутило большую часть населения, которое боролось за толерантность и социальные ценности. И вот компания Marvel наняла юного (относительно) визионера Гэбби Риверу, которая должна была напомнить всем о том, какая Америка на самом деле...", "5$", "Стэн Ли", R.drawable.img5))
        films.add(Film("Исповедь", "Комикс Гражданская Война: Исповедь: Капитан Америка арестован! Что же его ждет теперь? Суд? Но до этого момента Кэпу придется иметь долгую беседу со своим старым другом, а теперь по совместительству и тюремщиком - Тони Старком! Почему же эти герои встали по разные стороны баррикад?", "5$", "Стэн Ли", R.drawable.img6))
        films.add(Film("Захватчики", "Империя Крии намерена завоевать вселенную используя оружие, которое может предоставить им армию норвежских богов. И только четыре героя объединные своим прошлым должны смотреть в будущее, чтобы спасти землю.", "4$", "Стив Дитко", R.drawable.img7))
        films.add(Film("Макс Пейн", "Комикс Макс Пейн том 1: Макс – герой-одиночка, не от хорошей жизни он стал таким, у него была своя «Американская мечта», но в один момент все пропало. Мертвы его маленькая дочка и любимая супруга, отныне, все что двигало Максом – это МЕСТЬ. По итогу все оказалось сложнее чем можно было подумать. Сам того не осознавая, Пэйн, детектив по профессии, стал центровой фигурой крупного заговора, и на него открылась охота не только со стороны бандитов, но и со стороны своих коллег.", "5$", "Мартин Гудмен", R.drawable.img8))
        films.add(Film("Новые Воины", "Комикс Новые Воины том 3: Годами малоизвестные суперзлодеи сбегали из Нью-Йорка. укрывшись от взоров супергероев большого яблока, они плели интриги, грабили, и терроризировали окружающих. Но более этому не бывать. Нет, по крайней мере если новым воинам будет, что им ответить.", "5$", "Мартин Гудмен", R.drawable.img9))
        films.add(Film("Стражи 3000", "Комикс Стражи 3000: Триумфальное возвращение Дэна Абнетта! В далёком 3014 году галактику захватила раса Бадунов. Стражи Галактики ведут ожесточенную войну, но силы не равны. Практический все разумные расы истреблены, последние очаги сопротивления разрознены. Стражи должны объединить лидеров некогда великих империй. Но успеют ли они?", "5$", "Мартин Гудмен", R.drawable.img10))
        films.add(Film("Чёрная Пантера", "Приключения чёрной пантеры", "5$", "Мартин Гудмен", R.drawable.img11))
        films.add(Film("Щит", "Всемирная организация S.H.I.E.L.D. - ЩИТ существовала в различные времена, во всём мире. Многие деятели различных наук являлись почётными членами этой организации. Кто стоял у истоков? Какова реальная цель организации? Комикс должен помочь читателю найти ответы ...", "5$", "Марк Миллар", R.drawable.img12))
        films.add(Film("Электра", "Когда юная Электра училась в Колумбийском университете, ее отец, посол Греции, погиб. Это толкнуло ее на путь убийцы. И теперь она ведет постоянную войну со своей темной стороной. И в этом ей помогают люди, встречающиеся ей на ее жизненном пути, такие как Росомаха, маг Доктор Стрендж, ее первая любовь Мэтт Мердок, учителя восточных единоборств Лао и Стюарт, подруга Нина и таинственный наставник Стик.", "5$", "Марк Миллар", R.drawable.img13))
        films.add(Film("Червяк Джим", "Комикс Червяк Джим - легендарная компьютерная игра, в жанре аркадного платформера, разработанная Shiny и изданная Virgin, Interplay был издателем третьей фейловой части, а также не менее эпичный главный герой этой игры. Известна абсурдным, доставляющим юмором, полным веществ и хорошим, годным геймплеем, из-за чего игра стала одной из лучших, когда-либо выходивших на Sega Mega Drive. Впоследствии, игра породила винрарный сиквел, фэйловый триквел, один спин-офф, один мультсериал, две серии комиксов и целую армию уже бородатых фагов, до сих пор на неё фапающих.", "5$", "Марк Миллар", R.drawable.img14))
        films.add(Film("Тор", "ТMarvel анонсировала новый поворот в истории Бога Грома — впервые в истории Мьёльнир достанется женщине. Выдохните, Тор не сделал пластическую операцию, просто издательство вводит некую таинственную девушку, которая станет главной героиней онгоинга Thor. Вот что сказала Голдберг во время анонса:", "5$", "Марк Миллар", R.drawable.img15))
        films.add(Film("Утка Говард", "Комикс Утка Говард том 3: Говард - утка, как вы, несомненно, поняли по названию комикса и обложке. Но! Он не простая утка! Он - утка, которая разговаривает и является ярким образцом здравого смысла в этом безумном мире!", "5$", "Комедия", R.drawable.img16))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.about -> {
                about()
                return true
            }
            R.id.genre -> {
                genres()
                return true
            }
            R.id.logout -> {
                logout()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    fun about() {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
    }

    fun genres() {
        val intent = Intent(this, AuthorsActivity::class.java)
        startActivity(intent)
    }

    fun logout() {
        finish()
    }


}
