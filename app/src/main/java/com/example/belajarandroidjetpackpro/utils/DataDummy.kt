package com.example.belajarandroidjetpackpro.utils

import com.example.belajarandroidjetpackpro.data.MovieEntity
import com.example.belajarandroidjetpackpro.data.TvEntity
import com.example.belajarandroidjetpackpro.data.source.remote.response.MovieResponse
import com.example.belajarandroidjetpackpro.data.source.remote.response.TvResponse

object DataDummy {
    fun generateDummyMovie(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                "1",
                "Alita: Battle Angel",
                "14/02/2019",
                "R.drawable.poster_alita",
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
            )
        )
        movies.add(
            MovieEntity(
                "2",
                "Serenity",
                "25/01/2019",
                "R.drawable.poster_serenity",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
            )
        )
        movies.add(
            MovieEntity(
                "3",
                "A Star Is Born",
                "05/10/2018",
                "R.drawable.poster_a_start_is_born",
                "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
            )
        )
        movies.add(
            MovieEntity(
                "4",
                "Aquaman",
                "21/12/2018",
                "R.drawable.poster_aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            )
        )
        movies.add(
            MovieEntity(
                "5",
                "Bohemian Rhapsody",
                "02/11/2018",
                "R.drawable.poster_bohemian",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            )
        )
        movies.add(
            MovieEntity(
                "6",
                "Cold Pursuit",
                "08/02/2019",
                "R.drawable.poster_cold_persuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            )
        )
        movies.add(
            MovieEntity(
                "7",
                "Glass",
                "18/01/2019",
                "R.drawable.poster_glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            )
        )
        movies.add(
            MovieEntity(
                "8",
                "Avengers: Infinity War",
                "27/04/2018",
                "R.drawable.poster_infinity_war",
                "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
            )
        )
        movies.add(
            MovieEntity(
                "9",
                "Overlord",
                "09/11/2018",
                "R.drawable.poster_overlord",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
            )
        )
        movies.add(
            MovieEntity(
                "10",
                "Robin Hood",
                "21/11/2018",
                "R.drawable.poster_robin_hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
            )
        )
        movies.add(
            MovieEntity(
                "11",
                "T-34",
                "27/12/2018",
                "R.drawable.poster_t34",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
            )
        )
        return movies
    }

    fun generateDummyTv(): List<TvEntity> {
        val tv = ArrayList<TvEntity>()
        tv.add(
            TvEntity(
                "1",
                "The Arrow",
                "10/10/2012",
                "R.drawable.poster_arrow",
                "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
            )
        )
        tv.add(
            TvEntity(
                "2",
                "Doom Patrol",
                "15/02/2019",
                "R.drawable.poster_doom_patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            )
        )
        tv.add(
            TvEntity(
                "4",
                "The Flash",
                "07/10/2014",
                "R.drawable.poster_flash",
                "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya \"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.",
            )
        )
        tv.add(
            TvEntity(
                "4",
                "Gotham",
                "22/09/2014",
                "R.drawable.poster_gotham",
                "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
            )
        )
        tv.add(
            TvEntity(
                "5",
                "Grey's Anatomy",
                "27/03/2005",
                "R.drawable.poster_grey_anatomy",
                "Ikuti kehidupan pribadi dan profesional sekelompok dokter di Rumah Sakit Gray Sloan Memorial di Seattle.",
            )
        )
        tv.add(
            TvEntity(
                "6",
                "Hanna",
                "28/03/2019",
                "R.drawable.poster_hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            )
        )
        tv.add(
            TvEntity(
                "7",
                "NCIS",
                "23/09/2003",
                "R.drawable.poster_ncis",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
            )
        )
        tv.add(
            TvEntity(
                "8",
                "Riverdale",
                "26/01/2017",
                "R.drawable.poster_riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            )
        )
        tv.add(
            TvEntity(
                "9",
                "Supergirl",
                "26/10/2015",
                "R.drawable.poster_supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
            )
        )
        tv.add(
            TvEntity(
                "10",
                "The Umbrella Academy",
                "15/02/2019",
                "R.drawable.poster_the_umbrella",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
            )
        )
        tv.add(
            TvEntity(
                "11",
                "The Walking Dead",
                "31/10/2010",
                "R.drawable.poster_the_walking_dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            )
        )
        return tv
    }

    fun generateDummyRemoteListMovie(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()
        movies.add(
            MovieResponse(
                "1",
                "Alita: Battle Angel",
                "14/02/2019",
                "R.drawable.poster_alita",
                "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
            )
        )
        movies.add(
            MovieResponse(
                "2",
                "Serenity",
                "25/01/2019",
                "R.drawable.poster_serenity",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
            )
        )
        movies.add(
            MovieResponse(
                "3",
                "A Star Is Born",
                "05/10/2018",
                "R.drawable.poster_a_start_is_born",
                "Seorang bintang musik country yang karirnya mulai memudar, Jackson Maine (Bradley Cooper) menemukan sebuah talenta yang sangat berbakat di dalam diri dari seorang musisi muda bernama Ally (Lady Gaga). Maine berhasil mengorbitkan Ally menjadi seorang bintang muda yang menjanjikan. Namun keduanya terlibat hubungan yang lebih jauh dari sekedar mentor dan anak didik. Seiring dengan meroketnya karir dari Ally dan dirinya, Maine mengalami dilema mengenai masalah ini.",
            )
        )
        movies.add(
            MovieResponse(
                "4",
                "Aquaman",
                "21/12/2018",
                "R.drawable.poster_aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            )
        )
        movies.add(
            MovieResponse(
                "5",
                "Bohemian Rhapsody",
                "02/11/2018",
                "R.drawable.poster_bohemian",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            )
        )
        movies.add(
            MovieResponse(
                "6",
                "Cold Pursuit",
                "08/02/2019",
                "R.drawable.poster_cold_persuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            )
        )
        movies.add(
            MovieResponse(
                "7",
                "Glass",
                "18/01/2019",
                "R.drawable.poster_glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            )
        )
        movies.add(
            MovieResponse(
                "8",
                "Avengers: Infinity War",
                "27/04/2018",
                "R.drawable.poster_infinity_war",
                "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
            )
        )
        movies.add(
            MovieResponse(
                "9",
                "Overlord",
                "09/11/2018",
                "R.drawable.poster_overlord",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
            )
        )
        movies.add(
            MovieResponse(
                "10",
                "Robin Hood",
                "21/11/2018",
                "R.drawable.poster_robin_hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
            )
        )
        movies.add(
            MovieResponse(
                "11",
                "T-34",
                "27/12/2018",
                "R.drawable.poster_t34",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
            )
        )
        return movies
    }

    fun generateDummyRemoteListTv(): List<TvResponse> {
        val tv = ArrayList<TvResponse>()
        tv.add(
            TvResponse(
                "1",
                "The Arrow",
                "10/10/2012",
                "R.drawable.poster_arrow",
                "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
            )
        )
        tv.add(
            TvResponse(
                "2",
                "Doom Patrol",
                "15/02/2019",
                "R.drawable.poster_doom_patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            )
        )
        tv.add(
            TvResponse(
                "4",
                "The Flash",
                "07/10/2014",
                "R.drawable.poster_flash",
                "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya \"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.",
            )
        )
        tv.add(
            TvResponse(
                "4",
                "Gotham",
                "22/09/2014",
                "R.drawable.poster_gotham",
                "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
            )
        )
        tv.add(
            TvResponse(
                "5",
                "Grey's Anatomy",
                "27/03/2005",
                "R.drawable.poster_grey_anatomy",
                "Ikuti kehidupan pribadi dan profesional sekelompok dokter di Rumah Sakit Gray Sloan Memorial di Seattle.",
            )
        )
        tv.add(
            TvResponse(
                "6",
                "Hanna",
                "28/03/2019",
                "R.drawable.poster_hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            )
        )
        tv.add(
            TvResponse(
                "7",
                "NCIS",
                "23/09/2003",
                "R.drawable.poster_ncis",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
            )
        )
        tv.add(
            TvResponse(
                "8",
                "Riverdale",
                "26/01/2017",
                "R.drawable.poster_riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            )
        )
        tv.add(
            TvResponse(
                "9",
                "Supergirl",
                "26/10/2015",
                "R.drawable.poster_supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
            )
        )
        tv.add(
            TvResponse(
                "10",
                "The Umbrella Academy",
                "15/02/2019",
                "R.drawable.poster_the_umbrella",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
            )
        )
        tv.add(
            TvResponse(
                "11",
                "The Walking Dead",
                "31/10/2010",
                "R.drawable.poster_the_walking_dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            )
        )
        return tv
    }
}