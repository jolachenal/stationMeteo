package model;

import java.io.*;

public class CPU implements TemperatureGenerationStrategy {
    @Override
    public float generateTemperature() throws IOException {
        File temp = new File("/sys/devices/virtual/thermal/thermal_zone0/temp");
        BufferedReader br = new BufferedReader(new FileReader(temp));
        return Float.parseFloat(br.readLine())/1000;
    }
}
