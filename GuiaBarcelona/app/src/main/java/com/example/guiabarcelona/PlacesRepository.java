package com.example.guiabarcelona;

import java.util.Arrays;
import java.util.List;

public final class PlacesRepository {

    public static final int CATEGORY_MONUMENTS = 0;
    public static final int CATEGORY_RESTAURANTS = 1;
    public static final int CATEGORY_LEISURE = 2;

    private static final List<Place> MONUMENTS = Arrays.asList(
            new Place(
                    "Sagrada Família",
                    "La basílica inacabada de Gaudí, símbolo de Barcelona.",
                    "Obra maestra de Antoni Gaudí, cuya construcción comenzó en 1882 y continúa hoy en día. "
                            + "Combina elementos góticos y modernistas, con fachadas llenas de simbolismo y un interior que "
                            + "recuerda a un bosque de columnas y luz de colores. Es Patrimonio de la Humanidad de la UNESCO.",
                    "Carrer de Mallorca, 401, 08013 Barcelona",
                    "+34932080414",
                    "https://sagradafamilia.org",
                    41.4036,
                    2.1744,
                    R.drawable.img_sagrada_familia),
            new Place(
                    "Casa Batlló",
                    "Edificio modernista de Gaudí en el Passeig de Gràcia.",
                    "Reforma realizada por Gaudí entre 1904 y 1906. Su fachada ondulada, con balcones en "
                            + "forma de antifaz y un tejado que recuerda al lomo de un dragón, la convierte en una de las "
                            + "joyas de la llamada Manzana de la Discordia.",
                    "Passeig de Gràcia, 43, 08007 Barcelona",
                    "+34932160306",
                    "https://www.casabatllo.es",
                    41.3917,
                    2.1649,
                    R.drawable.img_casa_batllo),
            new Place(
                    "Park Güell",
                    "Parque con mosaicos y vistas panorámicas de la ciudad.",
                    "Parque público diseñado por Gaudí para el empresario Eusebi Güell. Destacan la famosa "
                            + "salamandra de mosaico, el banco ondulado de la plaza de la Naturaleza y las vistas de toda "
                            + "Barcelona hasta el mar. Es Patrimonio de la Humanidad de la UNESCO.",
                    "Carrer d'Olot, s/n, 08024 Barcelona",
                    "+34934091831",
                    "https://parkguell.barcelona",
                    41.4145,
                    2.1527,
                    R.drawable.img_park_guell)
    );

    private static final List<Place> RESTAURANTS = Arrays.asList(
            new Place(
                    "Cal Pep",
                    "Tapas y marisco de mercado junto a la Plaça de les Olles.",
                    "Bar de tapas muy popular en el barrio del Born. Se come de pie o en la barra, con "
                            + "producto fresco del día: gambas, calamares, tortilla y pescado frito. Conviene llegar pronto "
                            + "porque suele haber cola.",
                    "Plaça de les Olles, 8, 08003 Barcelona",
                    "+34933107961",
                    "https://www.calpep.com",
                    41.3837,
                    2.1838,
                    R.drawable.img_cal_pep),
            new Place(
                    "Can Culleretes",
                    "Uno de los restaurantes más antiguos de Barcelona (1786).",
                    "Fundado en 1786 en pleno Barrio Gótico, ofrece cocina catalana tradicional: "
                            + "escalivada, canelones, fideuà, butifarra con judías y crema catalana de postre.",
                    "Carrer d'en Quintana, 5, 08002 Barcelona",
                    "+34933173022",
                    "https://www.culleretes.com",
                    41.3805,
                    2.1757,
                    R.drawable.img_can_culleretes),
            new Place(
                    "Els Quatre Gats",
                    "Histórica cervecería modernista, punto de encuentro de artistas.",
                    "Abierta en 1897 en un edificio de Puig i Cadafalch, fue lugar de reunión de artistas "
                            + "como Picasso, Rusiñol y Casas. Hoy ofrece cocina catalana en un ambiente lleno de historia "
                            + "y decoración modernista.",
                    "Carrer de Montsió, 3, 08002 Barcelona",
                    "+34933024140",
                    "https://www.4gats.com",
                    41.3856,
                    2.1736,
                    R.drawable.img_quatre_gats)
    );

    private static final List<Place> LEISURE = Arrays.asList(
            new Place(
                    "Spotify Camp Nou",
                    "El estadio del FC Barcelona y su museo.",
                    "Hogar del FC Barcelona, uno de los estadios más grandes de Europa. Se puede visitar "
                            + "el estadio, el museo con los trofeos del club y la zona de vestuarios y túnel de salida al césped.",
                    "Carrer d'Arístides Maillol, 12, 08028 Barcelona",
                    "+34902189900",
                    "https://www.fcbarcelona.es",
                    41.3809,
                    2.1228,
                    R.drawable.img_camp_nou),
            new Place(
                    "Parque de Atracciones del Tibidabo",
                    "Parque centenario en lo alto de la sierra de Collserola.",
                    "Inaugurado en 1901, es uno de los parques de atracciones más antiguos del mundo. "
                            + "Se llega en tranvía azul y funicular, y desde su cima hay unas vistas espectaculares de "
                            + "Barcelona y del Mediterráneo.",
                    "Plaça del Tibidabo, 3-4, 08035 Barcelona",
                    "+34932117942",
                    "https://www.tibidabo.cat",
                    41.4225,
                    2.1187,
                    R.drawable.img_tibidabo),
            new Place(
                    "L'Aquàrium de Barcelona",
                    "Uno de los acuarios mediterráneos más grandes de Europa.",
                    "Situado en el Port Vell, cuenta con decenas de acuarios y un oceanario con túnel "
                            + "de cristal de 80 metros para ver tiburones, rayas y peces de todo el mundo. Ideal para "
                            + "visitar en familia.",
                    "Moll d'Espanya del Port Vell, s/n, 08039 Barcelona",
                    "+34932217474",
                    "https://www.aquariumbcn.com",
                    41.3764,
                    2.1855,
                    R.drawable.img_aquarium)
    );

    private PlacesRepository() {
    }

    public static List<Place> getPlaces(int category) {
        switch (category) {
            case CATEGORY_MONUMENTS:
                return MONUMENTS;
            case CATEGORY_RESTAURANTS:
                return RESTAURANTS;
            default:
                return LEISURE;
        }
    }
}
