module io.github.fjossinet.raspberry {

    requires kotlin.stdlib;

    requires com.pi4j;
    requires com.pi4j.plugin.pigpio;

    requires org.slf4j;
    requires org.slf4j.simple;

    requires javafx.controls;
    requires eu.hansolo.tilesfx;

    uses com.pi4j.extension.Extension;
    uses com.pi4j.provider.Provider;

    opens io.github.fjossinet.raspberry to javafx.graphics;
}