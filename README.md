Kinokülastaja veebriakendus



Rakenduse kirjeldus

Cinema APP on filmirakendus, mis kuvab kinokülastajale nädala kinokava ja võimaldab filme erinevate kellaaegade, žanrite, keele ja vanusepiirangu järgi filtreerida. Kui kinokülastaja on varem pileteid ostnud, soovitab kinoäpp kinokülastajale viimase nime sisestades ka filme. Seda tehes võtab rakendus arvesse viimasena vaadatud filmi žanrit ja kellaaega. Filtrid töötavad ka korraga.

Kui sobiv film on leitud, saab filmi nimele klõpsates liikuda edasi isetekohtade valimise leheküljele.
Rippmenüüst on võimalik valida soovitud piletite/istekohtade arv ja siis neid istmeplaanil valida. Tuleb meeles pidada, et keskmised istekohad võivad olla juba hõivatud. Samuti on rohkem hõivatud istekohti hilisematel ja vähem varasematel seanssidel. Kui kohad on välja valitud jääb üle vajutada “osta” nuppu ja piletid ongi soetatud.



Tehnilisest poolest

Kasutasin PostgreSQL andmebaasi, millesse lõin neli tabelit:

kõikide filmide tabel – Tabelist leiab kõikide filmi info. Nime, pikkuse, keele ja vanusepiirangu.
nädalaplaan – Nädaplaanist leiab info seansiaja kohta.
filmižanrite tabel – Et ühel filmil võib olla mitu žanrit on ka žanritel oma tabel.
kasutajate tabel – Siia talletasin kasutaja viimasena vaadatud filmi žanri ja seansiaja.

Kasutasin Spring Booti ja frontendis Reacti. Kõige keerulisem oligi Typescript ja React, sest nendega olen kõigem vähem kokku puutunud ja pidin omajagu internetist otsima ja lahendusi googeldama. Loomulikult leidsin infokilde ka Stackoverflowst. 

Kindlamini tundsin ennast Java ja Springiga toimetades. Seal ei olnud vaja kuigi palju googeldada. 

Ajakulu – ca nädal. Mõned päev pikemad, mõned lühemad. Backend valmis kiiremini aga vajas aegajalt kohendamist. Frontendis oli palju avastamist ja ajakulu, ning ühes selle avastamisega oli tihti tarvis ka backendis ja andmebaasides erinevaid muudatusi teha. 

Ei jõudnud lisada kasutaja autentimist. Mõistagi ei saa reaalelus sellisel moel kasutajat autentida.

Samuti ei pööranud erilist tähelepanu rakenduse välimusele. Keskendusin sellele, et asi toimiks.

Backend: https://github.com/andreshaaa/cinemademo
Frontend: https://github.com/andreshaaa/cinema-frontend 


