public enum SubjectName {
    MATHEMATICS("Mathematics"),
    ENGLISH("English"),
    SCIENCE("Science"),
    HISTORY("History"),
    GEOGRAPHY("Geography"),
    CHEMISTRY("Chemistry"),
    ART("Art"),
    MUSIC("Music");

    private final String name;

    SubjectName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
