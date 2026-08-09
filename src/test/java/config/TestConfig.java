package config;

public final class TestConfig {

    public static final String BASE_URL = System.getProperty("baseUrl", "https://osvaldovinelli.com.ar/");
    public static final String PROPERTY_DETAIL_URL = BASE_URL + "propiedad/526204";

    private TestConfig() {}
}
