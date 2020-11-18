package io.github.fjossinet.raspberry;

import com.pi4j.Pi4J;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.io.gpio.digital.PullResistance;
import javafx.scene.layout.HBox;

public class FXScreen extends HBox {

    private static final int PIN_LED = 22;
    private static final int PIN_BUTTON = 23;

    private static int pressCount = 0;

    public FXScreen() {
        try {
            var pi4j = Pi4J.newAutoContext();

            var ledConfig = DigitalOutput.newConfigBuilder(pi4j).id("led")
                    .name("LED Flasher")
                    .address(PIN_LED)
                    .shutdown(DigitalState.LOW)
                    .initial(DigitalState.LOW)
                    .provider("pigpio-digital-output");

            var led = pi4j.create(ledConfig);

            var buttonConfig = DigitalInput.newConfigBuilder(pi4j).id("button")
                    .name("Press Button")
                    .address(PIN_BUTTON)
                    .pull(PullResistance.PULL_DOWN)
                    .debounce(3000L)
                    .provider("pigpio-digital-input");

            var button = pi4j.create(buttonConfig);

            button.addListener(e -> {
                if (e.state() == DigitalState.LOW) {
                    pressCount++;
                    try {
                        if (led.equals(DigitalState.HIGH)) {
                            led.low();
                        } else {
                            led.high();
                        }
                        System.out.println("Button was pressed for the " + pressCount + "th time");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
