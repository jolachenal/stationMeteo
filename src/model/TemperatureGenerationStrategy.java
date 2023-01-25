package model;

import java.io.IOException;

public interface TemperatureGenerationStrategy {
    float generateTemperature() throws IOException;
}
