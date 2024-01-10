package project.modele;

public class Aeroport {
    private String pays;
    private String ville;
    private String codeIATA;
    private String nom;

    public Aeroport(String pays, String ville, String codeIATA, String nom) {
        this.pays = pays;
        this.ville = ville;
        this.codeIATA = codeIATA;
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public String getCodeIATA() {
        return codeIATA;
    }

    public String getNom() {
        return nom;
    }

    public static Aeroport[][] aeroportsListe(){
        Aeroport[][] aeroports = {
                {new Aeroport("Allemagne", "Berlin", "BER", "Willy Brandt")},
                {new Aeroport("Allemagne", "Francfort", "FRA", "Francfort-sur-le-Main")},
                {new Aeroport("Allemagne", "Munich", "MUC", "Franz Josef Strauss")},
                {new Aeroport("Belgique", "Buxelle", "BRU", "Brussels Airport")},
                {new Aeroport("France", "Paris", "CDG", "Paris-Charles-De-Gaulle")},
                {new Aeroport("Italie", "Rome", "FCO", "Rome-Fuimicino")},
                {new Aeroport("Royaume-Uni", "London", "LHR", "Heathrow Airport")},
                {new Aeroport("Luxembourg", "Luxembourg", "LUX", "Luxembourg")},
                {new Aeroport("Autriche", "Vienne", "VIE", "Schwechat")},
                {new Aeroport("Pologne", "Varsovie", "WAW", "Frédéric Chopin")},
                {new Aeroport("Croatie", "Zagreb", "ZAG", "Franjo Tudman")},
                {new Aeroport("Suisse", "Zurich", "ZRH", "Zurich Airport")}
        };
        
        return aeroports;
    }
}

